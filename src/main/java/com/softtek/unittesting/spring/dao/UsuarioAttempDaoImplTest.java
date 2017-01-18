package com.softtek.unittesting.spring.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value={"/dataset/default.xml"}, connection = "dbUnitDatabaseConnection", type=DatabaseOperation.CLEAN_INSERT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class UsuarioAttempDaoImplTest {

	@Autowired
	UsuarioAttempDao usuarioAttempDao;
	
	@Autowired
	UsuarioDao usuarioDao;
	
	
	@Test
	@Ignore
	@DatabaseSetup(value="/dataset/scenario1.xml", connection = "dbUnitDatabaseConnection", type=DatabaseOperation.INSERT)
	public void testUserAttempService(){
		
	}
}
