/**
 * 
 */
package com.anderson.restaurantedata.dao;

import java.sql.SQLException;
import java.util.List;

import com.anderson.restaurantedata.entity.TipoRestaurante;
import com.anderson.restaurantedata.myexceptions.RestauranteException;

/**
 * @author anderson
 * Interface que representa el CRUD de transaccion para la tabla tipo_restaurante
 */
public interface TipoRestauranteDAO {
	/**
	 * Metodo que permite actualizar registros de tipos de restaurantes.
	 * @param tipoRestaurante objeto a actualizar
	 * @return 1 o más en caso de ser exitoso, 0 en case de no guardarlo.
	 * @throws SQLException Excepcion generada en caso de error al ejecutar la sentencia SQL.
	 */
	int guardar(TipoRestaurante tipoRestaurante) throws SQLException;
	
	/**
	 * Metodo que permite actualizar registros de tipos de restaurantes.
	 * @param tipoRestaurante objeto a actualizar
	 * @return 1 0 más en caso de ser exitoso, 0 en caso de no actualizarlo.
	 * @throws SQLException Excepcion generada en caso de error al ejecutar la sentencia SQL.
	 */
	int actualizar(TipoRestaurante tipoRestaurante) throws SQLException;
	
	/**
	 * Metodo que permite eliminar registros de tipos de restaurantes.
	 * @param idTipoRestaurante identificador del tipo de restaurante.
	 * @return 1 o más en caso de ser exitoso, 0 en caso de no eliminarlo.
	 * @throws SQLException  Excepcion generada en caso de error al ejecutar la sentencia SQL.
	 */
	int eliminar(int idTipoRestaurante) throws SQLException;
	
	/**
	 * Meotodo que permite consultar los registros de tipos de restaurantes.
	 * @return lista de tipos de restaurantes o null.
	 * @throws SQLException Excepcion generada en caso de error al ejecutar la sentencia SQL.
	 */
	List<TipoRestaurante> consultar() throws SQLException;
	
	/**
	 * Metodo que permite consultar un registro de tipos de restaurantes por identificador.
	 * @param idTipoRestaurante identificador del tipo.
	 * @return tipo de restaurante consultado o null.
	 * @throws SQLException Excepcion generada en caso de error al ejecutar la sentencia SQL.
	 * @throws RestauranteException Excepcion personalizada que genera un mensaje más especifico
	 */
	TipoRestaurante consultarPorId(int idTipoRestaurante) throws SQLException, RestauranteException;
}
