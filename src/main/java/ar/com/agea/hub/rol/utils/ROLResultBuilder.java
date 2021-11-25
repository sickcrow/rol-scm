/*
 * @(#)ROLResultBuilder.java		1.0 21/11/2013
 */

package ar.com.agea.hub.rol.utils;

import ar.com.agea.hub.rol.model.result.ROLResult;

/**
 * Construye un objeto ROLResult a partir datos.
 * <p>
 * Construye un objeto ROLResult a partir datos que se proveen como argumentos
 * a los métodos build.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 21/11/2013
 */
public abstract class ROLResultBuilder {
	
	protected ROLResult rolResult;
	
	/**
	 * Instancia un objeto de tipo ROLResultBuilder.
	 */
	protected ROLResultBuilder() {}
	
	/**
	 * Construye un objeto ROLResult.
	 */
	public void buildROLResult() {
		rolResult = new ROLResult();
	}
	
	/**
	 * Obtiene el objeto ROLResult creado.
	 * @return Objeto ROLResult creado.
	 */
	public ROLResult getResult() {
		return rolResult;
	}
}
