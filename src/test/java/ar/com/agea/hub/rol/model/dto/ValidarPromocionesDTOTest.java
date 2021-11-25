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
 * Representa JUnit Tests de inicialización para la clase ValidarPromocionesDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 24/02/2014
 */
public class ValidarPromocionesDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ValidarPromocionesDTO.
	 */
	@Test
	public void testConstructor() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ValidarPromocionesDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setOrdenPublicacion y getOrdenPublicacion de la clase ValidarPromocionesDTO. 
	 */
	@Test
	public void testSetAndGetOrdenPublicacionMethod() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		OrdenPublicacionDTO ordenPublicacion = new OrdenPublicacionDTO();
		
		dto.setOrdenPublicacion(ordenPublicacion);
		
		OrdenPublicacionDTO tmp = dto.getOrdenPublicacion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setOrdenPublicacion\" o \"getOrdenPublicacion\" de la clase \"ValidarPromocionesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getOrdenPublicacion\" de la clase \"ValidarPromocionesDTO\""
				+ " no corresponde al valor enviado como argumento.", ordenPublicacion, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setPromocionesAplicables y getPromocionesAplicables de la clase ValidarPromocionesDTO. 
	 */
	@Test
	public void testSetAndGetPromocionesAplicablesMethod() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		List<PromocionDTO> promocionesAplicables = new ArrayList<PromocionDTO>();
		
		dto.setPromocionesAplicables(promocionesAplicables);
		
		List<PromocionDTO> tmp = dto.getPromocionesAplicables();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPromocionesAplicables\" o \"getPromocionesAplicables\" de la clase \"ValidarPromocionesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPromocionesAplicables\" de la clase \"ValidarPromocionesDTO\""
				+ " no corresponde al valor enviado como argumento.", promocionesAplicables, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCaptcha y getCaptcha de la clase ValidarPromocionesDTO. 
	 */
	@Test
	public void testSetAndGetCaptchaMethod() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		CaptchaDTO captcha = new CaptchaDTO();
		
		dto.setCaptcha(captcha);
		
		CaptchaDTO tmp = dto.getCaptcha();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCaptcha\" o \"getCaptcha\" de la clase \"ValidarPromocionesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCaptcha\" de la clase \"ValidarPromocionesDTO\""
				+ " no corresponde al valor enviado como argumento.", captcha, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCantidadIntentos y getCantidadIntentos de la clase ValidarPromocionesDTO. 
	 */
	@Test
	public void testSetAndGetCantidadIntentosMethod() {
		ValidarPromocionesDTO dto = new ValidarPromocionesDTO();
		Integer cantidadIntentos = 300;
		
		dto.setCantidadIntentos(cantidadIntentos);
		
		Integer tmp = dto.getCantidadIntentos();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCantidadIntentos\" o \"getCantidadIntentos\" de la clase \"ValidarPromocionesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCantidadIntentos\" de la clase \"ValidarPromocionesDTO\""
				+ " no corresponde al valor enviado como argumento.", cantidadIntentos, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ValidarPromocionesDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ValidarPromocionesDTO\".", tmp);
	}
}
