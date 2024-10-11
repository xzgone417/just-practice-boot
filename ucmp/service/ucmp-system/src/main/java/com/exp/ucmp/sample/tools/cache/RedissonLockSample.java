package com.exp.ucmp.sample.tools.cache;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.redisson.api.RCountDownLatch;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egrid.cache.redisson.cache.RedissonCache;

@Service
public class RedissonLockSample {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedissonLockSample.class);
	
	@Autowired
    private RedissonCache redissonCache;
	
	public void lock(String type, String lockName) throws Exception {
		Thread thread1 = null;
		Thread thread2 = null;
		Thread thread3 = null;
		if (type.equals("reentrant")) {
			thread1 = new ReentrantLockThread(lockName, 20, 30 * 1000);
			thread2 = new ReentrantLockThread(lockName, 20, 15 * 1000);
			thread3 = new ReentrantLockThread(lockName, -1, 45 * 1000);
		} else if (type.equals("fair")) {
			thread1 = new FairLockThread(lockName, 20, 30 * 1000);
			thread2 = new FairLockThread(lockName, 20, 15 * 1000);
			thread3 = new FairLockThread(lockName, -1, 45 * 1000);
		} else if (type.equals("countdownlatch")) {
			Thread thread = new CountDownLatchMainThread(lockName);
			thread1 = new CountDownLatchThread(lockName, "9521", 30 * 1000);
			thread2 = new CountDownLatchThread(lockName, "7852", 15 * 1000);
			thread3 = new CountDownLatchThread(lockName, "8323", 45 * 1000);
			thread.start();
		}
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	/**
	 * 可重入锁
	 *
	 */
	class ReentrantLockThread extends Thread{
		private String lockName;
		private long leaseTime;
		private long sleeptime;
		ReentrantLockThread(String lockName, long leaseTime, long sleeptime) {
			this.lockName = "sample:lock:reentrant:" + lockName;
			this.leaseTime = leaseTime;
			this.sleeptime = sleeptime;
		}
        @Override
        public void run() {
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        	for (int i = 0; i < 5; i++) {
        		LOGGER.info("{}, 线程{}准备锁线程", sdf.format(new Date()), Thread.currentThread().getName());
            	RLock lock = redissonCache.getLock(lockName);
            	/**
            	 * lock.lock()，不设置自动解锁时间的情况下会启用看门狗机制：默认锁过期时间30s，通过定时任务，每过看门狗时间三分之一（也就是10s）续期到30s
            	 * lock.tryLock()，尝试获取锁，如果获取成功则返回true，如果未获取则返回false，这个适用于当资源被另外一个线程处理时需要走另外的逻辑
            	 */
            	if (leaseTime > 0) {
                	lock.lock(leaseTime, TimeUnit.SECONDS);
            	} else {
                	lock.lock();
            	}
            	try {
                    try {
                    	LOGGER.info("{}, 线程{}进入睡眠状态", sdf.format(new Date()), Thread.currentThread().getName());
                        Thread.currentThread().sleep(sleeptime);
                    } catch (InterruptedException e) {
                    }
            	} finally {
            		if (lock.isHeldByCurrentThread()) {
            			// 检查该锁是否被当前线程持有
            			lock.unlock();
            			LOGGER.info("{}, 线程{}主动释放锁", sdf.format(new Date()), Thread.currentThread().getName());
            		} else {
            			LOGGER.info("{}, 线程{}锁到期，已被自动释放", sdf.format(new Date()), Thread.currentThread().getName());
            		}
            	}
        	}
        }
    }
	
	/**
	 * 公平锁
	 *
	 */
	class FairLockThread extends Thread{
		private String lockName;
		private long leaseTime;
		private long sleeptime;
		FairLockThread(String lockName, long leaseTime, long sleeptime) {
			this.lockName = "sample:lock:fair:" + lockName;
			this.leaseTime = leaseTime;
			this.sleeptime = sleeptime;
		}
        @Override
        public void run() {
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        	for (int i = 0; i < 5; i++) {
        		LOGGER.info("{}, 线程{}准备锁线程", sdf.format(new Date()), Thread.currentThread().getName());
            	RLock lock = redissonCache.getFairLock(lockName);
            	/**
            	 * lock.lock()，不设置自动解锁时间的情况下会启用看门狗机制：默认锁过期时间30s，通过定时任务，每过看门狗时间三分之一（也就是10s）续期到30s
            	 * lock.tryLock()，尝试获取锁，如果获取成功则返回true，如果未获取则返回false，这个适用于当资源被另外一个线程处理时需要走另外的逻辑
            	 */
            	if (leaseTime > 0) {
                	lock.lock(leaseTime, TimeUnit.SECONDS);
            	} else {
                	lock.lock();
            	}
            	try {
                    try {
                    	LOGGER.info("{}, 线程{}进入睡眠状态", sdf.format(new Date()), Thread.currentThread().getName());
                        Thread.currentThread().sleep(sleeptime);
                    } catch (InterruptedException e) {
                    }
            	} finally {
            		if (lock.isHeldByCurrentThread()) {
            			// 检查该锁是否被当前线程持有
            			lock.unlock();
            			LOGGER.info("{}, 线程{}主动释放锁", sdf.format(new Date()), Thread.currentThread().getName());
            		} else {
            			LOGGER.info("{}, 线程{}锁到期，已被自动释放", sdf.format(new Date()), Thread.currentThread().getName());
            		}
            	}
        	}
        }
    }
	
	/**
	 * 闭锁
	 * 应用场景: 
     * 确保某个计算在其需要的所有资源都被初始化之后才执行
     * 确保某个服务在其依赖的所有其他服务都已经启动之后才启动
	 *
	 */
	class CountDownLatchMainThread extends Thread{
		private String lockName;
		CountDownLatchMainThread(String lockName) {
			this.lockName = "sample:lock:countdownlatch:" + lockName;
		}
        @Override
        public void run() {
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        	
        	LOGGER.info("{}, 线程{}创建了斗地主房间, 需要三个玩家进入", sdf.format(new Date()), Thread.currentThread().getName());
        	RCountDownLatch countDownLatch = redissonCache.getCountDownLatch(lockName);
        	/*需要满足3个事件发生*/
        	countDownLatch.trySetCount(3);
        	try {
				countDownLatch.await();
			} catch (InterruptedException e) {
			}
        	LOGGER.info("{}, 线程{}, 所有玩家已就绪，开始发牌", sdf.format(new Date()), Thread.currentThread().getName());
        }
    }
	class CountDownLatchThread extends Thread{
		private String lockName;
		private String name;
		private long sleeptime;
		CountDownLatchThread(String lockName, String name, long sleeptime) {
			this.lockName = "sample:lock:countdownlatch:" + lockName;
			this.name = name;
			this.sleeptime = sleeptime;
		}
        @Override
        public void run() {
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        	RCountDownLatch countDownLatch = redissonCache.getCountDownLatch(lockName);
        	try {
        		LOGGER.info("{}, 线程{}邀请玩家{}进入", sdf.format(new Date()), Thread.currentThread().getName(), name);
        		Thread.currentThread().sleep(sleeptime);
        		countDownLatch.countDown();
        		LOGGER.info("{}, 线程{}等了{}秒后，玩家{}进入了房间", sdf.format(new Date()), Thread.currentThread().getName(), sleeptime/1000, name);
			} catch (InterruptedException e) {
			}
        }
    }
}
