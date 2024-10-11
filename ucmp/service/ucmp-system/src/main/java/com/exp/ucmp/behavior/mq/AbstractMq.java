package com.exp.ucmp.behavior.mq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import com.egrid.core.threadlocal.pool.TtlExecutors;
import com.exp.ucmp.behavior.dto.MessageDto;
import com.exp.ucmp.behavior.repository.IRepository;
import com.exp.ucmp.behavior.repository.RepositoryFactory;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

public abstract class AbstractMq implements IMq {
	final static RetryTemplate retryTemplate = new RetryTemplate();
	static {
		SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
		retryPolicy.setMaxAttempts(3);
		retryTemplate.setRetryPolicy(retryPolicy);
		ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(500L);
        backOffPolicy.setMultiplier(2);
        backOffPolicy.setMaxInterval(500L);
        retryTemplate.setBackOffPolicy(backOffPolicy);
	}

	public static class ThreadBehavior implements Runnable {
		private IRepository repository;
		private MessageDto messageDto;
		public ThreadBehavior(RepositoryFactory repoFactory, MessageDto messageDto){
	    	this.messageDto = messageDto;
	    	this.repository = repoFactory.getRepository();
	    }
	    @Override
	    public void run() {
	        insert();
	    }
	    
	    void insert() {
	    	try {
				retryTemplate.execute((RetryCallback<Boolean, Exception>) retryContext -> repository.saveBehavior(messageDto));
			} catch (Exception e) {
			}
	    }
 	}
	
	public static class ThreadBehaviorResponse implements Runnable {
		private IRepository repository;
		private MessageDto messageDto;
		
		public ThreadBehaviorResponse(RepositoryFactory repoFactory, MessageDto messageDto) {
			this.messageDto = messageDto;
	    	this.repository = repoFactory.getRepository();
		}

		@Override
		public void run() {
			update();
		}
		
		void update() {
	    	try {
				retryTemplate.execute((RetryCallback<Boolean, Exception>) retryContext -> repository.saveBehaviorResponse(messageDto));
			} catch (Exception e) {
			}
		}
	}
	
	protected static class Executor {

		private static class LazyHolder {
			private static Thread _ShutdownThread;
			static ExecutorService _Executor = null;
			static {
				ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("Behavior-runner-%d").build();
				ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(3, 16, 1000L, TimeUnit.MILLISECONDS,
						new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
				_Executor = TtlExecutors.getTtlExecutorService(taskExecutor);
				_ShutdownThread = new Thread(new Runnable() {
					public void run() {
						shutdownExecutorPool();
					}
				});
				Runtime.getRuntime().addShutdownHook(_ShutdownThread);
			}

			private static void shutdownExecutorPool() {
				if (_Executor != null) {
					_Executor.shutdown();
					if (_ShutdownThread != null) {
						try {
							Runtime.getRuntime().removeShutdownHook(_ShutdownThread);
						} catch (IllegalStateException ise) {
						}
					}
				}
			}
		}

		public static ExecutorService getExecutor() {
			return LazyHolder._Executor;
		}
	}

	protected static class ResponseExecutor {

		private static class LazyHolder {
			private static Thread _ShutdownThread;
			static ExecutorService _Executor = null;
			static {
				ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("BehaviorResponse-runner-%d").build();
				ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(6, Short.MAX_VALUE, 0L, TimeUnit.MILLISECONDS,
						new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
				_Executor = TtlExecutors.getTtlExecutorService(taskExecutor);
				_ShutdownThread = new Thread(new Runnable() {
					public void run() {
						shutdownExecutorPool();
					}
				});
				Runtime.getRuntime().addShutdownHook(_ShutdownThread);
			}

			private static void shutdownExecutorPool() {
				if (_Executor != null) {
					_Executor.shutdown();
					if (_ShutdownThread != null) {
						try {
							Runtime.getRuntime().removeShutdownHook(_ShutdownThread);
						} catch (IllegalStateException ise) {
						}
					}
				}
			}
		}

		public static ExecutorService getResponseExecutor() {
			return LazyHolder._Executor;
		}
	}
}
