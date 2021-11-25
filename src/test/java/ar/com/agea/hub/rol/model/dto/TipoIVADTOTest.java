/*
 * @(#)TipoIVADTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase TipoIVADTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class TipoIVADTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo TipoIVADTO.
	 */
	@Test
	public void testConstructor() {
		TipoIVADTO dto = new TipoIVADTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TipoIVADTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigo y getCodigo de la clase TipoIVADTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		TipoIVADTO dto = new TipoIVADTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigo\" o \"getCodigo\" de la clase \"TipoIVADTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigo\" de la clase \"TipoIVADTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase TipoIVADTO. 
	 */
	@Test
	public void testToStringMethod() {
		TipoIVADTO dto = new TipoIVADTO();
		
		dto.setCodigo("CODIGO");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"TipoIVADTO\".", tmp);
	}
}
