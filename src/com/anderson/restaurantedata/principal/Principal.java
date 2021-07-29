package com.anderson.restaurantedata.principal;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.anderson.restaurantedata.dao.impl.TipoRestauranteDAOImpl;
import com.anderson.restaurantedata.entity.TipoRestaurante;
import com.anderson.restaurantedata.myexceptions.RestauranteException;

/**
 * @author anderson Clase principal para probar la conexion a la base de datos.
 */
public class Principal {

	public static void main(String[] args) {

		TipoRestauranteDAOImpl tipoRestauranteDAOImpl = new TipoRestauranteDAOImpl();

		// ::::::::::::: PRUEBA DE INSERT :::::::::::::::

//		TipoRestaurante tipoRestaurante = new TipoRestaurante();
//		tipoRestaurante.setDescripcion("Español");
//		tipoRestaurante.setFechaCreacion(LocalDateTime.now()); // Obtiene fecha, hora y zona horaria actual
//		tipoRestaurante.setEstatus(true);
//		
//		try {
//			// Devuelve 1 si se guardó y 0 si no se guardó
//			int guardado = tipoRestauranteDAOImpl.guardar(tipoRestaurante);
//			
//			// Si el tipo de restaurante se guardó en la base de datos
//			if (guardado > 0) {
//				System.out.println("El tipo de restaurante " + tipoRestaurante.getDescripcion() + " fue guardado exitosamente");
//			} else {
//				System.out.println("Hubo un error al guardar el tipo de restaurante");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.err.println("Error: " + e.getMessage());
//		}

		// ::::::::::::: PRUEBA DE UPDATE :::::::::::::::

//		TipoRestaurante tipoRestaurante = new TipoRestaurante();
//		tipoRestaurante.setIdTipoRestaurante(7);
//		tipoRestaurante.setDescripcion("Español");
//		tipoRestaurante.setFechaModificacion(LocalDateTime.now()); 
//		tipoRestaurante.setEstatus(false);
//		
//		try {
//			// Devuelve 1 si se actualizó y 0 si no se actualizó
//			int actualizado = tipoRestauranteDAOImpl.actualizar(tipoRestaurante);
//			
//			// Si el tipo de restaurante se actuaizó en la base de datos
//			if (actualizado > 0) {
//				System.out.println("El tipo de restaurante " + tipoRestaurante.getDescripcion() + " fue actualizado exitosamente");
//			} else {
//				System.out.println("Hubo un error al actualizar el tipo de restaurante");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.err.println("Error: " + e.getMessage());
//		}

		// ::::::::::::: PRUEBA DE DELETE :::::::::::::::

//		TipoRestaurante tipoRestaurante = new TipoRestaurante();
//		tipoRestaurante.setIdTipoRestaurante(6);
//		tipoRestaurante.setDescripcion("Japonés");
//		
//		try {
//			// Devuelve 1 si se actualizó y 0 si no se actualizó
//			int eliminado = tipoRestauranteDAOImpl.eliminar(tipoRestaurante.getIdTipoRestaurante());
//			
//			// Si el tipo de restaurante se actuaizó en la base de datos
//			if (eliminado > 0) {
//				System.out.println("El tipo de restaurante " + tipoRestaurante.getDescripcion() + " fue eliminado exitosamente");
//			} else {
//				System.out.println("Hubo un error al eliminar el tipo de restaurante");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.err.println("Error: " + e.getMessage());
//		}

		// ::::::::::::: PRUEBA DE SELECT :::::::::::::::

//		try {
//				// Guardar en una lista lo obtenido
//				List<TipoRestaurante> tiposConsultados = tipoRestauranteDAOImpl.consultar();
//				
//				// Recorrer la lista tiposConsultados con un forEach, esta lista contiene elementos
//				// del tipo TipoRestaurante, por eso se almacena en una variable de ese tipo
//				for (TipoRestaurante tipoRestaurante : tiposConsultados) {
//					System.out.println("ID: " + tipoRestaurante.getIdTipoRestaurante());
//					System.out.println("DESCRIPCIÓN: " + tipoRestaurante.getDescripcion());
//					System.out.println("ESTATUS: " + tipoRestaurante.isEstatus() + "\n");
//				}
//			} catch (SQLException e) {
//				System.err.println("Error: " + e.getMessage());
//				e.printStackTrace();
//			}

		// ::::::::::::: PRUEBA DE SELECT POR ID :::::::::::::::

		try {
			// Guardar la respuesta objetida en un objeto del tipo TipoRestaurante 
			TipoRestaurante tipoConsultado = tipoRestauranteDAOImpl.consultarPorId(3);
			
			if( tipoConsultado != null ) {
				System.out.println("ID: " + tipoConsultado.getIdTipoRestaurante());
				System.out.println("DESCRIPCION: " + tipoConsultado.getDescripcion());
				System.out.println("ESTATUS: " + tipoConsultado.isEstatus());
			} else {
				System.err.println("No se encontró el tipo de restaurande buscado");
			}
			
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		} catch (RestauranteException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		}

	}
}
