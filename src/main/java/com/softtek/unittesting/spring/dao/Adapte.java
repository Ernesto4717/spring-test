package com.softtek.unittesting.spring.dao;

import com.softtek.unittesting.spring.entity.UsuarioAttemp;

public class Adapte {
	
	public void showUserAttempt(UsuarioAttemp uA){
		System.out.println("Id: " + uA.getId() + " Counter: " + uA.getContador());
	}

}
