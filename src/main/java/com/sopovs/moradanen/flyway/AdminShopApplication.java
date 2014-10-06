package com.sopovs.moradanen.flyway;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import com.sopovs.moradanen.flyway.domain.TestEntity;
import com.sopovs.moradanen.flyway.repositories.TestEntityRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableTransactionManagement
public class AdminShopApplication implements CommandLineRunner {

	@Autowired
	private EntityManagerFactory emf;
	@Autowired
	private TestEntityRepository testEntityRepository;

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(emf);
	}

	@Bean
	public TransactionTemplate transactionTemplate() {
		return new TransactionTemplate(transactionManager());
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AdminShopApplication.class);
		app.setAdditionalProfiles("bootstrap");
		app.run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		TestEntity foo = new TestEntity("James Bond");
		foo = testEntityRepository.save(foo);
		System.out.println(foo.getId());
	}

}
