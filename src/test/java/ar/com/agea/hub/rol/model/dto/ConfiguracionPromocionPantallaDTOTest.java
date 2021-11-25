/*
 * @(#)ConfiguracionPromocionPantallaDTOTest.java		31/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ConfiguracionPromocionPantallaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 31/01/2014
 */
public class ConfiguracionPromocionPantallaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ConfiguracionPromocionPantallaDTO.
	 */
	@Test
	public void testConstructor() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ConfiguracionPromocionPantallaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setPantallaShow y getPantallaShow de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testSetAndGetPantallaShowMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		Integer pantallaShow = 300;
		
		dto.setPantallaShow(pantallaShow);
		
		Integer tmp = dto.getPantallaShow();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPantallaShow\" o \"getPantallaShow\" de la clase \"ConfiguracionPromocionPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPantallaShow\" de la clase \"ConfiguracionPromocionPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", pantallaShow, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPromocionDTO y getPromocionDTO de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testSetAndGetPosicionMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		PromocionDTO promocion = new PromocionDTO();
		
		dto.setPromocion(promocion);
		
		PromocionDTO tmp = dto.getPromocion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPromocionDTO\" o \"getPromocionDTO\" de la clase \"ConfiguracionPromocionPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPromocionDTO\" de la clase \"ConfiguracionPromocionPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", promocion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTrigger y getTrigger de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testSetAndGetTriggerMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		String trigger = "TRIGGER";
		
		dto.setTrigger(trigger);
		
		String tmp = dto.getTrigger();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTrigger\" o \"getTrigger\" de la clase \"ConfiguracionPromocionPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTrigger\" de la clase \"ConfiguracionPromocionPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", trigger, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDescripcion y getDescripcion de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDescripcion\" o \"getDescripcion\" de la clase \"ConfiguracionPromocionPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDescripcion\" de la clase \"ConfiguracionPromocionPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTitulo y getTitulo de la clase ConfiguracionPromocionPantallaDTO. 
	 */
	@Test
	public void testSetAndGetTituloMethod() {
		ConfiguracionPromocionPantallaDTO dto = new ConfiguracionPromocionPantallaDTO();
		String titulo = "DESCRIPCION";
		
		dto.setTitulo(titulo);
		
		String tmp = dto.getTitulo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTitulo\" o \"getTitulo\" de la clase \"ConfiguracionPromocionPantallaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTitulo\" de la clase \"ConfiguracionPromocionPantallaDTO\""
				+ " no corresponde al valor enviado como argumento.", titulo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ConfiguracionPromocionPantallaDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ConfiguracionPromocionPantallaDTO\".", tmp);
	}
}
