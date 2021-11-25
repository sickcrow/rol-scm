/*
 * @(#)ZonaComercializacionDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ZonaComercializacionDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ZonaComercializacionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ZonaComercializacionDTO.
	 */
	@Test
	public void testConstructor() {
		ZonaComercializacionDTO dto = new ZonaComercializacionDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ZonaComercializacionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigo y getCodigo de la clase ZonaComercializacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		ZonaComercializacionDTO dto = new ZonaComercializacionDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();

		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigo\" o \"getCodigo\" de la clase \"ZonaComercializacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigo\" de la clase \"ZonaComercializacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDescripcion y getDescripcion de la clase ZonaComercializacionDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		ZonaComercializacionDTO dto = new ZonaComercializacionDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDescripcion\" o \"getDescripcion\" de la clase \"ZonaComercializacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDescripcion\" de la clase \"ZonaComercializacionDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}

	/**
	 * Comprueba la ejecución de método toString de la clase ZonaComercializacionDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ZonaComercializacionDTO dto = new ZonaComercializacionDTO();
		
		dto.setCodigo("CODIGO");
		dto.setDescripcion("DESCRIPCION");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ZonaComercializacionDTO\".", tmp);
	}
}
