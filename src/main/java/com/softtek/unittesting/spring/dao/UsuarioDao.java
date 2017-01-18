package com.softtek.unittesting.spring.dao;

import com.softtek.unittesting.spring.entity.Usuario;

public interface UsuarioDao {

	
	public int getUserCount();
	
	public Usuario getUserById(Long id);

	public void insertUser(Long id, String nombre, String apellido);
	}