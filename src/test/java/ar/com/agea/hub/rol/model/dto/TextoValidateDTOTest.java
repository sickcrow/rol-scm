/*
 * @(#)TextoValidateDTOTest.java		1.0 20/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase TextoValidateDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 20/08/2013
 */
public class TextoValidateDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo TextoValidateDTO.
	 */
	@Test
	public void testConstructor() {
		TextoValidateDTO dto = new TextoValidateDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"TextoValidateDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setTexto y getTexto de la clase TextoValidateDTO. 
	 */
	@Test
	public void testSetAndGetTextoMethod() {
		TextoValidateDTO dto = new TextoValidateDTO();
		String texto = "TEXTO";
		
		dto.setTexto(texto);
		
		String tmp = dto.getTexto();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTexto\" o \"getTexto\" de la clase \"TextoValidateDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTexto\" de la clase \"TextoValidateDTO\""
				+ " no corresponde al valor enviado como argumento.", texto, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase TextoValidateDTO. 
	 */
	@Test
	public void testSetAndGetCodigoNivelEstructuraMethod() {
		TextoValidateDTO dto = new TextoValidateDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"TextoValidateDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoNivelEstructura\" de la clase \"TextoValidateDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase TextoValidateDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TextoValidateDTO dto = new TextoValidateDTO();
		
		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setTexto("TEXTO");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"TextoValidateDTO\".", tmp);
	}
}
