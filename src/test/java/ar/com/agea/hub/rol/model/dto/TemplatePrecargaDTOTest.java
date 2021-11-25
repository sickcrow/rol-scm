/*
 * @(#)TemplatePrecargaDTOTest.java		1.0 08/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase TemplatePrecargaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 08/01/2014
 */
public class TemplatePrecargaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo TemplatePrecargaDTO.
	 */
	@Test
	public void testConstructor() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TemplatePrecargaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setId y getId de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setId\" o \"getId\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getId\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigo y getCodigo de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigo\" o \"getCodigo\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigo\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNombre y getNombre de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetNombreMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		String nombre = "NOMBRE";
		
		dto.setNombre(nombre);
		
		String tmp = dto.getNombre();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNombre\" o \"getNombre\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNombre\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", nombre, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDescripcion y getDescripcion de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDescripcion\" o \"getDescripcion\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDescripcion\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTemplate y getTemplate de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetTemplateMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		String template = "TEMPLATE";
		
		dto.setTemplate(template);
		
		String tmp = dto.getTemplate();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTemplate\" o \"getTemplate\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTemplate\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", template, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaCaducidad y getFechaCaducidad de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetFechaCaducidadMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		Date fechaCaducidad = null;
		
		dto.setFechaCaducidad(fechaCaducidad);
		
		Date tmp = dto.getFechaCaducidad();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaCaducidad\" o \"getFechaCaducidad\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaCaducidad\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaCaducidad, tmp);
		
		fechaCaducidad = new Date();
		
		dto.setFechaCaducidad(fechaCaducidad);
		
		tmp = dto.getFechaCaducidad();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaCaducidad\" o \"getFechaCaducidad\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaCaducidad\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaCaducidad, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();

		dto.setId(300L);
		dto.setCodigo("CODIGO");
		dto.setNombre("NOMBRE");
		dto.setDescripcion("DESCRIPCION");
		dto.setTemplate("TEMPLATE");
		dto.setFechaCaducidad(new Date());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"TemplatePrecargaDTO\".", tmp);
	}
}
