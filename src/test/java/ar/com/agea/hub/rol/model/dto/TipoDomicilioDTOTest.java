/*
 * @(#)TipoDomicilioDTOTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase TipoDomicilioDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class TipoDomicilioDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo TipoDomicilioDTO.
	 */
	@Test
	public void testConstructor() {
		TipoDomicilioDTO dto = new TipoDomicilioDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"TipoDomicilioDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase TipoDomicilioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		TipoDomicilioDTO dto = new TipoDomicilioDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"TipoDomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"TipoDomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDescripcion y getDescripcion de la clase TipoDomicilioDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		TipoDomicilioDTO dto = new TipoDomicilioDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDescripcion\" o \"getDescripcion\" de la clase \"TipoDomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDescripcion\" de la clase \"TipoDomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase TipoDomicilioDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TipoDomicilioDTO dto = new TipoDomicilioDTO();
		
		dto.setCodigo("CODIGO");
		dto.setDescripcion("DESCRIPCION");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"TipoDomicilioDTO\".", tmp);
	}
}
