/*
 * @(#)PropiedadDefaultDTOTest.java		1.0 26/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase PropiedadDefaultDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class PropiedadDefaultDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo PropiedadDefaultDTO.
	 */
	@Test
	public void testConstructor() {
		PropiedadDefaultDTO dto = new PropiedadDefaultDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"PropiedadDefaultDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase PropiedadDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		PropiedadDefaultDTO dto = new PropiedadDefaultDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"PropiedadDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"PropiedadDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setValor y getValor de la clase PropiedadDefaultDTO. 
	 */
	@Test
	public void testSetAndGetValorMethod() {
		PropiedadDefaultDTO dto = new PropiedadDefaultDTO();
		String valor = "VALOR";
		
		dto.setValor(valor);
		
		String tmp = dto.getValor();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setValor\" o \"getValor\" de la clase \"PropiedadDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getValor\" de la clase \"PropiedadDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", valor, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase PropiedadDefaultDTO. 
	 */
	@Test
	public void testToStringMethod() {
		PropiedadDefaultDTO dto = new PropiedadDefaultDTO();
		
		dto.setCodigo("CODIGO");
		dto.setValor("VALOR");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"PropiedadDefaultDTO\".", tmp);
	}
}
