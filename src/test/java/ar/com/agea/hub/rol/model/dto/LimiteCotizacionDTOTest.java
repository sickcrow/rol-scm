/*
 * @(#)LimiteCotizacionDTOTest.java		1.0 16/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase LimiteCotizacionDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class LimiteCotizacionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo LimiteCotizacionDTO.
	 */
	@Test
	public void testConstructor() {
		LimiteCotizacionDTO dto = new LimiteCotizacionDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"LimiteCotizacionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMontoAviso y getMontoAviso de la clase LimiteCotizacionDTO. 
	 */
	@Test
	public void testSetAndGetMontoAvisoMethod() {
		LimiteCotizacionDTO dto = new LimiteCotizacionDTO();
		Double montoAviso = 300.0;
		
		dto.setMontoAviso(montoAviso);
		
		Double tmp = dto.getMontoAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMontoAviso\" o \"getMontoAviso\" de la clase \"LimiteCotizacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMontoAviso\" de la clase \"LimiteCotizacionDTO\""
				+ " no corresponde al valor enviado como argumento.", montoAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase LimiteCotizacionDTO. 
	 */
	@Test
	public void testToStringMethod() {
		LimiteCotizacionDTO dto = new LimiteCotizacionDTO();
		
		dto.setMontoAviso(300.0);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"LimiteCotizacionDTO\".", tmp);
	}
}
