/*
 * @(#)TemplatePrecargaSearchDTOTest.java		1.0 07/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase TemplatePrecargaSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 07/01/2014
 */
public class TemplatePrecargaSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo TemplatePrecargaSearchDTO.
	 */
	@Test
	public void testConstructor() {
		TemplatePrecargaSearchDTO dto = new TemplatePrecargaSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"TemplatePrecargaSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase TemplatePrecargaSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		TemplatePrecargaSearchDTO dto = new TemplatePrecargaSearchDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"TemplatePrecargaSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"TemplatePrecargaSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase TemplatePrecargaSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TemplatePrecargaSearchDTO dto = new TemplatePrecargaSearchDTO();
		
		dto.setCodigo("CODIGO");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"TemplatePrecargaSearchDTO\".", tmp);
	}
}
