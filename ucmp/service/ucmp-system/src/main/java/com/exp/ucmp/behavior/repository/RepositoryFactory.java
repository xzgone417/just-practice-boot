package com.exp.ucmp.behavior.repository;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.exp.ucmp.behavior.repository.db.DbRepository;

@Component
public class RepositoryFactory implements ApplicationContextAware {
	public enum RepositoryType {
		db, mongodb;
	}

	@Value("${behavior.reposityory.type:db}")
	private String repositoryType;
	
	private ApplicationContext applicationContext;
	
    public IRepository getRepository(){
        if (RepositoryType.mongodb.name().equals(repositoryType)) {
            return null;
        } else {
        	return applicationContext.getBean(DbRepository.class);
        }
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
}
