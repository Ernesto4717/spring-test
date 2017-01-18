package com.softtek.unittesting.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.softtek.unittesting.spring.entity.UsuarioAttemp;

@Repository
public class UsuarioAttempDaoImpl implements UsuarioAttempDao {

	private JdbcTemplate JdbcTemplate;

	@Autowired
	UsuarioDao usuarioDao;

	@Autowired
	public int setDataSource(DataSource dataSource) {
		this.JdbcTemplate = new JdbcTemplate();
		this.JdbcTemplate.setDataSource(dataSource);
		return 0;
	}

	@Override
	public void addUsuarioAttemps(Long id) {
		this.JdbcTemplate.update("INSERT INTO USUARIO_ATTEMP VALUES(?,?)", id, 0);
	}

	@Override
	public UsuarioAttemp getUserAttempById(Long id) {
		try {
			final UsuarioAttemp usuario = this.JdbcTemplate.queryForObject(
					"select id, contador from USUARIO_ATTEMP where id = ?", new Object[] { id },

					new RowMapper<UsuarioAttemp>() {
						public UsuarioAttemp mapRow(ResultSet rs, int row_Num) throws SQLException {
							final UsuarioAttemp usuario = new UsuarioAttemp();
							usuario.setId(rs.getLong("id"));
							usuario.setContador(rs.getLong("contador"));
							return usuario;
						}
					});
			System.out.println("Usuario " + usuario);
			return usuario;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public void updateCounter(Long id) {
		this.JdbcTemplate.update("UPDATE USUARIO_ATTEMP SET contador=contador+1 WHERE id= ?", id);
	}

}
