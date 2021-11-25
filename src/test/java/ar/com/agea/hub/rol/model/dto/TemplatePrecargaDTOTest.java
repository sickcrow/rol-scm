/*
 * @(#)TemplatePrecargaDTOTest.java		1.0 08/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase TemplatePrecargaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 08/01/2014
 */
public class TemplatePrecargaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo TemplatePrecargaDTO.
	 */
	@Test
	public void testConstructor() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"TemplatePrecargaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNombre y getNombre de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetNombreMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		String nombre = "NOMBRE";
		
		dto.setNombre(nombre);
		
		String tmp = dto.getNombre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNombre\" o \"getNombre\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNombre\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", nombre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDescripcion y getDescripcion de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDescripcion\" o \"getDescripcion\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDescripcion\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTemplate y getTemplate de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetTemplateMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		String template = "TEMPLATE";
		
		dto.setTemplate(template);
		
		String tmp = dto.getTemplate();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTemplate\" o \"getTemplate\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTemplate\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", template, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFechaCaducidad y getFechaCaducidad de la clase TemplatePrecargaDTO. 
	 */
	@Test
	public void testSetAndGetFechaCaducidadMethod() {
		TemplatePrecargaDTO dto = new TemplatePrecargaDTO();
		Date fechaCaducidad = null;
		
		dto.setFechaCaducidad(fechaCaducidad);
		
		Date tmp = dto.getFechaCaducidad();
		
		Assert.assertNull("Ha fallado la llamada al m�todo \"setFechaCaducidad\" o \"getFechaCaducidad\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaCaducidad\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaCaducidad, tmp);
		
		fechaCaducidad = new Date();
		
		dto.setFechaCaducidad(fechaCaducidad);
		
		tmp = dto.getFechaCaducidad();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFechaCaducidad\" o \"getFechaCaducidad\" de la clase \"TemplatePrecargaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaCaducidad\" de la clase \"TemplatePrecargaDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaCaducidad, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase TemplatePrecargaDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"TemplatePrecargaDTO\".", tmp);
	}
}
