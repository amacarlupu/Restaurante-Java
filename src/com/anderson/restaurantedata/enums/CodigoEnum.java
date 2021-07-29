/**
 * 
 */
package com.anderson.restaurantedata.enums;

/**
 * @author anderson
 * Enumeracion que contiene los codigos de error del aplicativo
 */
public enum CodigoEnum {
 
	/**
	 * Constante con el codigo de error de sintaxis.
	 * Variable estatica, es del tipo final.
	 */
	SINTAXIS_SQL_ERROR_CODE(1064);
	
	/**
	 * Codigo del error
	 */
	private int code;

	/**
	 * Constructor privado default de la enumercacion, siempre es privado.
	 * @param code codigo del error generado.
	 */
	private CodigoEnum(int code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
