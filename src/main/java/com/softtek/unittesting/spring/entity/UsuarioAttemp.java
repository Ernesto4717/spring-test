package com.softtek.unittesting.spring.entity;

public class UsuarioAttemp {
	
	private Long id;
	private Long contador;
	

	@Override
	public String toString() {
		return "UsuarioAttemp [id=" + id + ", contador=" + contador + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getContador() {
		return contador;
	}
	public void setContador(Long contador) {
		this.contador = contador;
	}
	

}
