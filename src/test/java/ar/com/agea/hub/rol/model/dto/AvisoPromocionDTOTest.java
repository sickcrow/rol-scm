/*
 * @(#)AvisoPromocionDTOTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase AvisoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class AvisoPromocionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo AvisoPromocionDTO.
	 */
	@Test
	public void testConstructor() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"AvisoPromocionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setAviso y getAviso de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetAvisoMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		AvisoDTO aviso = new AvisoDTO();
		
		dto.setAviso(aviso);
		
		AvisoDTO tmp = dto.getAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAviso\" o \"getAviso\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAviso\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", aviso, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos PromocionDTO y getPromocion de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetPromocionMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		PromocionDTO promocion = new PromocionDTO();
		
		dto.setPromocion(promocion);
		
		PromocionDTO tmp = dto.getPromocion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"PromocionDTO\" o \"getPromocion\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPromocion\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", promocion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMontoSinIva y getMontoSinIva de la clase AvisoPromocionDTO. 
	 */
	@Test
	public void testSetAndGetMontoSinIvaMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		Double montoSinIva = 300.0;
		
		dto.setMontoSinIva(montoSinIva);
		
		Double tmp = dto.getMontoSinIva();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMontoSinIva\" o \"getMontoSinIva\" de la clase \"AvisoPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMontoSinIva\" de la clase \"AvisoPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", montoSinIva, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMontoConIva y getMontoConIva de la clase AvisoPromocionDTO. 
	 */
	@Test
	public void testSetAndGetMontoConIvaMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		Double montoConIva = 300.0;
		
		dto.setMontoConIva(montoConIva);
		
		Double tmp = dto.getMontoConIva();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMontoConIva\" o \"getMontoConIva\" de la clase \"AvisoPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMontoConIva\" de la clase \"AvisoPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", montoConIva, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPorcentaje y getPorcentaje de la clase AvisoPromocionDTO. 
	 */
	@Test
	public void testSetAndGetPorcentajeMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		Double porcentaje = 300.0;
		
		dto.setPorcentaje(porcentaje);
		
		Double tmp = dto.getPorcentaje();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPorcentaje\" o \"getPorcentaje\" de la clase \"AvisoPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPorcentaje\" de la clase \"AvisoPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", porcentaje, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setEsDescuento y getEsDescuento de la clase AvisoPromocionDTO. 
	 */
	@Test
	public void testSetAndGetEsDescuentoMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		Boolean esDescuento = true;
		
		dto.setEsDescuento(esDescuento);
		
		Boolean tmp = dto.getEsDescuento();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setEsDescuento\" o \"getEsDescuento\" de la clase \"AvisoPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getEsDescuento\" de la clase \"AvisoPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", esDescuento, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase AvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		
		dto.setAviso(new AvisoDTO());
		dto.setPromocion(new PromocionDTO());
		dto.setMontoSinIva(300.0);
		dto.setMontoConIva(300.0);
		dto.setPorcentaje(300.0);
		dto.setEsDescuento(true);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"AvisoPromocionDTO\".", tmp);
	}
}
