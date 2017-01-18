package com.softtek.unittesting.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtek.unittesting.spring.dao.Adapte;
import com.softtek.unittesting.spring.dao.UsuarioAttempDao;
import com.softtek.unittesting.spring.dao.UsuarioDao;
import com.softtek.unittesting.spring.entity.Usuario;

public class UsuarioAttemptService {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	@Autowired
	UsuarioAttempDao usuarioAttempDao;
	
	@Autowired
	Adapte adapter;

	
	
	public void usuarioAttemps(Long id, String nombre, String apellido) {
		Usuario user;
		user = usuarioDao.getUserById(id);
		if(user==null){
			usuarioDao.insertUser(id, nombre, apellido);
			usuarioAttempDao.addUsuarioAttemps(id);
			adapter.showUserAttempt(usuarioAttempDao.getUserAttempById(id));
		}else {
			usuarioAttempDao.updateCounter(id);
			adapter.showUserAttempt(usuarioAttempDao.getUserAttempById(id));
			}
	}
	

}
