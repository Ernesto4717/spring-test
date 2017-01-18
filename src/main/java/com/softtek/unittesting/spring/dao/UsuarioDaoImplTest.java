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
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.softtek.unittesting.spring.entity.Usuario;
import com.softtek.unittesting.spring.services.UsuarioAttemptService;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value={"/dataset/default.xml"}, connection = "dbUnitDatabaseConnection", type=DatabaseOperation.CLEAN_INSERT)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
public class UsuarioDaoImplTest {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	UsuarioAttemptService usuarioAttemptService;

	@Test
	@Ignore
	@DatabaseSetup(value="/dataset/scenario1.xml", connection = "dbUnitDatabaseConnection", type=DatabaseOperation.INSERT)
	public void testCount(){
		int currentUsers = usuarioDao.getUserCount();
		Assert.assertTrue(currentUsers==2);
	}

	
	@Test
	@Ignore
	@DatabaseSetup(value="/dataset/scenario1.xml", connection = "dbUnitDatabaseConnection", type=DatabaseOperation.INSERT)
	public void testGetUserById(){
		Usuario user = usuarioDao.getUserById(9L);
		System.out.println("current User" + user);
		Assert.assertTrue("Jose".equals(user.getName()));
	}
	
	
	@Test
	@Ignore
	@DatabaseSetup(value="/dataset/scenario1.xml", connection = "dbUnitDatabaseConnection", type=DatabaseOperation.INSERT)
	public void testInsertUser(){
		Long id = 1L;
		String nombre="Jose";
		String apellido="Bal";
		usuarioDao.insertUser(id,nombre,apellido);
		Assert.assertNotNull(usuarioDao.getUserById(1L));
	}
	
	@Test
	@ExpectedDatabase("/dataset/scenario1.xml")
	public void testInsertExpected(){
		Long id = 3L;
		String nombre="Fernanda";
		String apellido="Ballesteros";
		usuarioAttemptService.usuarioAttemps(id, nombre, apellido);
		usuarioAttemptService.usuarioAttemps(id, nombre, apellido);
	}
	
	
	
}
