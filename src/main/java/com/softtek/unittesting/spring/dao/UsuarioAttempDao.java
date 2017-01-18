package com.softtek.unittesting.spring.dao;

import com.softtek.unittesting.spring.entity.UsuarioAttemp;

public interface UsuarioAttempDao {

	void addUsuarioAttemps(Long id);
	UsuarioAttemp getUserAttempById(Long id);
	void updateCounter(Long id);
}
