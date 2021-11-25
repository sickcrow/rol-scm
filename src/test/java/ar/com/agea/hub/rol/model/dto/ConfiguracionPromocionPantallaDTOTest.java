/*
 * @(#)ConfiguracionPromocionPantallaDTOTest.java		31/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ConfiguracionPromocionPantallaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 31/01/2014
 */
public class ConfiguracionPromocionPantallaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ConfiguracionPromocionPantallaDTO.
	 */
	@Test
	public void testConstructor() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ConfiguracionPromocionPantallaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setPantallaShow y getPantallaShow de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testSetAndGetPantallaShowMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		Integer pantallaShow = 300;
		
		dto.setPantallaShow(pantallaShow);
		
		Integer tmp = dto.getPantallaShow();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPantallaShow\" o \"getPantallaShow\" de la clase \"ConfiguracionPromocionPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPantallaShow\" de la clase \"ConfiguracionPromocionPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", pantallaShow, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPromocionDTO y getPromocionDTO de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testSetAndGetPosicionMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		PromocionDTO promocion = new PromocionDTO();
		
		dto.setPromocion(promocion);
		
		PromocionDTO tmp = dto.getPromocion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPromocionDTO\" o \"getPromocionDTO\" de la clase \"ConfiguracionPromocionPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPromocionDTO\" de la clase \"ConfiguracionPromocionPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", promocion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTrigger y getTrigger de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testSetAndGetTriggerMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		String trigger = "TRIGGER";
		
		dto.setTrigger(trigger);
		
		String tmp = dto.getTrigger();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTrigger\" o \"getTrigger\" de la clase \"ConfiguracionPromocionPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTrigger\" de la clase \"ConfiguracionPromocionPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", trigger, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDescripcion y getDescripcion de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDescripcion\" o \"getDescripcion\" de la clase \"ConfiguracionPromocionPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDescripcion\" de la clase \"ConfiguracionPromocionPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTitulo y getTitulo de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testSetAndGetTituloMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		String titulo = "DESCRIPCION";
		
		dto.setTitulo(titulo);
		
		String tmp = dto.getTitulo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTitulo\" o \"getTitulo\" de la clase \"ConfiguracionPromocionPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTitulo\" de la clase \"ConfiguracionPromocionPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", titulo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		
		dto.setPantallaShow(300);
		dto.setPromocion(new PromocionDTO());
		dto.setTrigger("TRIGGER");
		dto.setDescripcion("DESCRIPCION");
		dto.setTitulo("TITULO");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ConfiguracionPromocionPantallaDTO\".", tmp);
	}
}
