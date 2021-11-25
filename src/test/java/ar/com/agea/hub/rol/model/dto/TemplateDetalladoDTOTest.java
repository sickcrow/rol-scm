/*
 * @(#)TemplateDetalladoDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase TemplateDetalladoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class TemplateDetalladoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo TemplateDetalladoDTO.
	 */
	@Test
	public void testConstructor() {
		TemplateDetalladoDTO dto = new TemplateDetalladoDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TemplateDetalladoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigo y getCodigo de la clase TemplateDetalladoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		TemplateDetalladoDTO dto = new TemplateDetalladoDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigo\" o \"getCodigo\" de la clase \"TemplateDetalladoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigo\" de la clase \"TemplateDetalladoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDescripcion y getDescripcion de la clase TemplateDetalladoDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		TemplateDetalladoDTO dto = new TemplateDetalladoDTO();
		String descripcion = "CODIGO";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDescripcion\" o \"getDescripcion\" de la clase \"TemplateDetalladoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDescripcion\" de la clase \"TemplateDetalladoDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTieneImagenesPrediseniadas y getTieneImagenesPrediseniadas de la clase TemplateDetalladoDTO. 
	 */
	@Test
	public void testSetAndGetTieneImagenesPrediseniadasMethod() {
		TemplateDetalladoDTO dto = new TemplateDetalladoDTO();
		Boolean tieneImagenesPrediseniadas = true;
		
		dto.setTieneImagenesPrediseniadas(tieneImagenesPrediseniadas);
		
		Boolean tmp = dto.getTieneImagenesPrediseniadas();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTieneImagenesPrediseniadas\" o \"getTieneImagenesPrediseniadas\" de la clase \"TemplateDetalladoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTieneImagenesPrediseniadas\" de la clase \"TemplateDetalladoDTO\""
				+ " no corresponde al valor enviado como argumento.", tieneImagenesPrediseniadas, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase TemplateDetalladoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TemplateDetalladoDTO dto = new TemplateDetalladoDTO();
		
		dto.setCodigo("CODIGO");
		dto.setDescripcion("DESCRIPCION");
		dto.setTieneImagenesPrediseniadas(true);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"TemplateDetalladoDTO\".", tmp);
	}
}
