package com.sopovs.moradanen.flyway;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sopovs.moradanen.flyway.domain.TestEntity;
import com.sopovs.moradanen.flyway.repositories.TestEntityRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdminShopApplication.class)
public class TestEntityRepositoryTest {

	@Autowired
	private TestEntityRepository testEntityRepository;

	@Test
	public void dummy() {
		TestEntity foo = new TestEntity("James Bond");
		foo = testEntityRepository.save(foo);
		assertNotNull(foo.getId());
	}
}
