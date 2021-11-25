/*
 * @(#)TipoMonedaDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase TipoMonedaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class TipoMonedaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo TipoMonedaDTO.
	 */
	@Test
	public void testConstructor() {
		TipoMonedaDTO dto = new TipoMonedaDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TipoMonedaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigo y getCodigo de la clase TipoMonedaDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		TipoMonedaDTO dto = new TipoMonedaDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigo\" o \"getCodigo\" de la clase \"TipoMonedaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigo\" de la clase \"TipoMonedaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase TipoMonedaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TipoMonedaDTO dto = new TipoMonedaDTO();
		
		dto.setCodigo("CODIGO");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"TipoMonedaDTO\".", tmp);
	}
}
