/**
 * 
 */
package com.anderson.restaurantedata.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anderson.restaurantedata.connection.ConnectionFactory;
import com.anderson.restaurantedata.dao.TipoRestauranteDAO;
import com.anderson.restaurantedata.entity.TipoRestaurante;
import com.anderson.restaurantedata.enums.CodigoEnum;
import com.anderson.restaurantedata.myexceptions.RestauranteException;

/**
 * @author anderson
 * Clase que implementa el CRUD y otros metodos personalizados de transacciones a la base de datos
 * en la tabla tipo_restaurante.
 */
public class TipoRestauranteDAOImpl implements TipoRestauranteDAO {

	// Bloque de codigo STATIC, esto se ejecuta luego de instanciar la clase
	{
		try {
			ConnectionFactory.conectar();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.err.println("Error de Base de datos: " + e.getMessage());
		}
	}
	
	@Override
	public int guardar(TipoRestaurante tipoRestaurante) throws SQLException {
		
		String sql = "INSERT INTO tipo_restaurante (descripcion, fechaCreacion, estatus) VALUES ('" + tipoRestaurante.getDescripcion() + "', '" + tipoRestaurante.getFechaCreacion() + "', " + tipoRestaurante.isEstatus() + ");";
		
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		
		return ejecutado;
	}

	@Override
	public int actualizar(TipoRestaurante tipoRestaurante) throws SQLException {

		String sql = "UPDATE tipo_restaurante SET descripcion = '" + tipoRestaurante.getDescripcion() + "', fechaModificacion = '" + tipoRestaurante.getFechaModificacion() + "', estatus = " + tipoRestaurante.isEstatus() + " "
				+ "		WHERE idTipoRestaurante = '" + tipoRestaurante.getIdTipoRestaurante() + "' ;";
		
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		
		return ejecutado;
	}

	@Override
	public int eliminar(int idTipoRestaurante) throws SQLException {

		String sql = "DELETE from tipo_restaurante WHERE idTipoRestaurante = " + idTipoRestaurante + ";";
		
		int ejecutado = ConnectionFactory.ejecutarSQL(sql);
		
		return ejecutado;
	}

	@Override
	public List<TipoRestaurante> consultar() throws SQLException {
		
		String sql = "SELECT * FROM tipo_restaurante ORDER BY descripcion;";
		
		// Devuelve un objeto del tipo ResultSet con la lista de tipoRestaurantes
		ResultSet rs = ConnectionFactory.ejecutarSQLSelect(sql);
		
		// Lista donde se guardarán los valores obtenidos
		List <TipoRestaurante> tiposRestaurante = new ArrayList<TipoRestaurante>();
		
		if( rs!= null ) {
			
			// Mientras el objeto rs contenga informacion, asignar cada valor a la lista de tiposRestaurantes
			while (rs.next()) {
				TipoRestaurante tipoRestaurante = new TipoRestaurante();
				tipoRestaurante.setIdTipoRestaurante(rs.getInt("idTipoRestaurante")); //Entre parentesis el nombre del campo 
				tipoRestaurante.setDescripcion(rs.getString("descripcion"));
				tipoRestaurante.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime()); // convertir a LocalDateTime
				tipoRestaurante.setFechaModificacion(rs.getTimestamp("fechaCreacion") != null ? rs.getTimestamp("fechaCreacion").toLocalDateTime() : null);
				tipoRestaurante.setEstatus(rs.getBoolean("estatus"));
				
				// Añadir los objetos creados a la lista de tiposRestaurante
				tiposRestaurante.add(tipoRestaurante);
			}
		}
		
		// Retornar la lista de tipRestaurante
		return tiposRestaurante;
	}

	@Override
	public TipoRestaurante consultarPorId(int idTipoRestaurante) throws SQLException, RestauranteException {

		String sql = "SELECT * FROM tipo_restaurante WHERE idTipoRestaurante = " + idTipoRestaurante + ";";
		
		ResultSet rs = null;
		
		try {
			// Devuelve un objeto del tipo ResultSet con la lista de tipoRestaurantes
			rs = ConnectionFactory.ejecutarSQLSelect(sql);
		} catch (Exception e) {
			if(e.getClass().getName().contains("SQLSyntaxErrorException")) {
				throw new RestauranteException("Error de sintaxis en la sentencia " + sql, CodigoEnum.SINTAXIS_SQL_ERROR_CODE);
			}
		}
		
		
		// Inicializar el objeto del tipo TipoRestaurante donde se guardara lo obtenido
		TipoRestaurante tipoRestaurante = null; 
		
		if( rs!= null ) {
			
			// Mientras el objeto rs contenga informacion, asignar cada valor a la lista de tiposRestaurantes
			if (rs.next()) {
				tipoRestaurante = new TipoRestaurante();
				tipoRestaurante.setIdTipoRestaurante(rs.getInt("idTipoRestaurante")); //Entre parentesis el nombre del campo 
				tipoRestaurante.setDescripcion(rs.getString("descripcion"));
				tipoRestaurante.setFechaCreacion(rs.getTimestamp("fechaCreacion").toLocalDateTime()); // convertir a LocalDateTime
				tipoRestaurante.setFechaModificacion(rs.getTimestamp("fechaCreacion") != null ? rs.getTimestamp("fechaCreacion").toLocalDateTime() : null);
				tipoRestaurante.setEstatus(rs.getBoolean("estatus"));
			}
		}
		
		// Retornar el objeto tipoRestaurante
		return tipoRestaurante;
	}

}
