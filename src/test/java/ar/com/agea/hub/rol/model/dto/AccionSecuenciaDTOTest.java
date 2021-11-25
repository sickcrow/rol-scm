/*
 * @(#)AccionSecuenciaDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase AccionSecuenciaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class AccionSecuenciaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo AccionSecuenciaDTO.
	 */
	@Test
	public void testConstructor() {
		AccionSecuenciaDTO dto = new AccionSecuenciaDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"AccionSecuenciaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setNumero y getNumero de la clase Error. 
	 */
	@Test
	public void testSetAndGetNumeroMethod() {
		AccionSecuenciaDTO dto = new AccionSecuenciaDTO();
		Long numero = 300L;
		
		dto.setNumero(numero);
		
		Long tmp = dto.getNumero();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNumero\" o \"getNumero\" de la clase \"AccionSecuenciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNumero\" de la clase \"AccionSecuenciaDTO\""
				+ " no corresponde al valor enviado como argumento.", numero, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAccion y getAccion de la clase AccionSecuenciaDTO. 
	 */
	@Test
	public void testSetAndGetAccionMethod() {
		AccionSecuenciaDTO dto = new AccionSecuenciaDTO();
		String accion = "ACCION";
		
		dto.setAccion(accion);
		
		String tmp = dto.getAccion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAccion\" o \"getAccion\" de la clase \"AccionSecuenciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAccion\" de la clase \"AccionSecuenciaDTO\""
				+ " no corresponde al valor enviado como argumento.", accion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase AccionSecuenciaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		AccionSecuenciaDTO dto = new AccionSecuenciaDTO();
		
		dto.setNumero(300L);
		dto.setAccion("ACCION");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"AccionSecuenciaDTO\".", tmp);
	}
}
