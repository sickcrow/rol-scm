/*
 * @(#)TipoOperacionDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase TipoOperacionDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class TipoOperacionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo TipoOperacionDTO.
	 */
	@Test
	public void testConstructor() {
		TipoOperacionDTO dto = new TipoOperacionDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TipoOperacionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigo y getCodigo de la clase TipoOperacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		TipoOperacionDTO dto = new TipoOperacionDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigo\" o \"getCodigo\" de la clase \"TipoOperacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigo\" de la clase \"TipoOperacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDescripcion y getDescripcion de la clase TipoOperacionDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		TipoOperacionDTO dto = new TipoOperacionDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDescripcion\" o \"getDescripcion\" de la clase \"TipoOperacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDescripcion\" de la clase \"TipoOperacionDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase TipoOperacionDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TipoOperacionDTO dto = new TipoOperacionDTO();
		
		dto.setCodigo("CODIGO");
		dto.setDescripcion("DESCRIPCION");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"TipoOperacionDTO\".", tmp);
	}
}
