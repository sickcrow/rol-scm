/*
 * @(#)TipoIVADTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase TipoIVADTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class TipoIVADTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo TipoIVADTO.
	 */
	@Test
	public void testConstructor() {
		TipoIVADTO dto = new TipoIVADTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"TipoIVADTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase TipoIVADTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		TipoIVADTO dto = new TipoIVADTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"TipoIVADTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"TipoIVADTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase TipoIVADTO. 
	 */
	@Test
	public void testToStringMethod() {
		TipoIVADTO dto = new TipoIVADTO();
		
		dto.setCodigo("CODIGO");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"TipoIVADTO\".", tmp);
	}
}
