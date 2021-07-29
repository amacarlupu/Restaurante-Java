/**
 * 
 */
package com.anderson.restaurantedata.myexceptions;

import com.anderson.restaurantedata.enums.CodigoEnum;

/**
 * @author anderson
 * Excepcion personalizada para los errores ocasionados en restaurante
 */
public class RestauranteException extends Exception {
	
	/**
	 * Codigo de error generado por la excepcion
	 */
	private int errorCode;


	/**
	 * Constructor default
	 */
	public RestauranteException() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructo sobrecargado que muestra el codigo y mensaje de error
	 * Con super, se le envía el mensaje a la clase padre Exception
	 * @param mensaje mensaje a mostrar al usuario
	 * @param codigoEnum codigo de error de la enumeracion
	 */
	public RestauranteException(String mensaje, CodigoEnum codigoEnum) {
		super(mensaje);
		this.errorCode = codigoEnum.getCode();
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
