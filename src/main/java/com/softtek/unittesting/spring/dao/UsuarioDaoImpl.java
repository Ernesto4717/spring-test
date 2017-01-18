package com.softtek.unittesting.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.softtek.unittesting.spring.entity.Usuario;


@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	private JdbcTemplate JdbcTemplate;
	
	@Autowired
	public int setDataSource(DataSource dataSource) {
		this.JdbcTemplate = new JdbcTemplate();
		this.JdbcTemplate.setDataSource(dataSource);
		return 0;
	}

	@Override
	public int getUserCount() {
		final int rowCount = this.JdbcTemplate.queryForObject("SELECT COUNT(*) FROM USUARIO", Integer.class);
		System.out.println("Resultado " + rowCount);
		return rowCount;
	}

	@Override
	public Usuario getUserById(Long id) {
		try {
		final Usuario usuario = this.JdbcTemplate.queryForObject("select name, apellido, id from USUARIO where id = ?", new Object[] {id},
		
		
		new RowMapper<Usuario>(){
			public Usuario mapRow(ResultSet rs, int row_Num) throws SQLException{
				final Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setName(rs.getString("name"));
				usuario.setApellido(rs.getString("apellido"));
				return usuario;
			}
		}
				);
		System.out.println("Usuario " + usuario);
		return usuario;}
		catch(EmptyResultDataAccessException e){
			return null;
		}
		
	}
	
	public void insertUser(Long id, String nombre, String apellido){
		if(this.getUserById(id) == null){
	this.JdbcTemplate.update("INSERT INTO USUARIO VALUES(?,?,?)", id, nombre, apellido);
		}else{
			return;
		}
	}
	
	
	

}
