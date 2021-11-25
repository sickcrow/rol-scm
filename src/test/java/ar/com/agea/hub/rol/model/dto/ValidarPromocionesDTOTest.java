/*
 * @(#)ValidarPromocionesDTOTest.java		1.0 24/02/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ValidarPromocionesDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 24/02/2014
 */
public class ValidarPromocionesDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ValidarPromocionesDTO.
	 */
	@Test
	public void testConstructor() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ValidarPromocionesDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setOrdenPublicacion y getOrdenPublicacion de la clase ValidarPromocionesDTO. 
	 */
	@Test
	public void testSetAndGetOrdenPublicacionMethod() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		OrdenPublicacionDTO ordenPublicacion = new OrdenPublicacionDTO();
		
		dto.setOrdenPublicacion(ordenPublicacion);
		
		OrdenPublicacionDTO tmp = dto.getOrdenPublicacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setOrdenPublicacion\" o \"getOrdenPublicacion\" de la clase \"ValidarPromocionesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getOrdenPublicacion\" de la clase \"ValidarPromocionesDTO\""
				+ " no corresponde al valor enviado como argumento.", ordenPublicacion, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setPromocionesAplicables y getPromocionesAplicables de la clase ValidarPromocionesDTO. 
	 */
	@Test
	public void testSetAndGetPromocionesAplicablesMethod() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		List<PromocionDTO> promocionesAplicables = new ArrayList<PromocionDTO>();
		
		dto.setPromocionesAplicables(promocionesAplicables);
		
		List<PromocionDTO> tmp = dto.getPromocionesAplicables();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPromocionesAplicables\" o \"getPromocionesAplicables\" de la clase \"ValidarPromocionesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPromocionesAplicables\" de la clase \"ValidarPromocionesDTO\""
				+ " no corresponde al valor enviado como argumento.", promocionesAplicables, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCaptcha y getCaptcha de la clase ValidarPromocionesDTO. 
	 */
	@Test
	public void testSetAndGetCaptchaMethod() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		CaptchaDTO captcha = new CaptchaDTO();
		
		dto.setCaptcha(captcha);
		
		CaptchaDTO tmp = dto.getCaptcha();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCaptcha\" o \"getCaptcha\" de la clase \"ValidarPromocionesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCaptcha\" de la clase \"ValidarPromocionesDTO\""
				+ " no corresponde al valor enviado como argumento.", captcha, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCantidadIntentos y getCantidadIntentos de la clase ValidarPromocionesDTO. 
	 */
	@Test
	public void testSetAndGetCantidadIntentosMethod() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		Integer cantidadIntentos = 300;
		
		dto.setCantidadIntentos(cantidadIntentos);
		
		Integer tmp = dto.getCantidadIntentos();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCantidadIntentos\" o \"getCantidadIntentos\" de la clase \"ValidarPromocionesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCantidadIntentos\" de la clase \"ValidarPromocionesDTO\""
				+ " no corresponde al valor enviado como argumento.", cantidadIntentos, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ValidarPromocionesDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		
		List<PromocionDTO> promociones = new ArrayList<PromocionDTO>();
		promociones.add(new PromocionDTO());
		promociones.add(new PromocionDTO());
		promociones.add(new PromocionDTO());
		
		dto.setOrdenPublicacion(new OrdenPublicacionDTO());
		dto.setPromocionesAplicables(promociones);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ValidarPromocionesDTO\".", tmp);
	}
}
