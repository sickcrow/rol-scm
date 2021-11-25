/*
 * @(#)AvisoPromocionDTOTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase AvisoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class AvisoPromocionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo AvisoPromocionDTO.
	 */
	@Test
	public void testConstructor() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"AvisoPromocionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setAviso y getAviso de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetAvisoMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		AvisoDTO aviso = new AvisoDTO();
		
		dto.setAviso(aviso);
		
		AvisoDTO tmp = dto.getAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setAviso\" o \"getAviso\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getAviso\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", aviso, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos PromocionDTO y getPromocion de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetPromocionMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		PromocionDTO promocion = new PromocionDTO();
		
		dto.setPromocion(promocion);
		
		PromocionDTO tmp = dto.getPromocion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"PromocionDTO\" o \"getPromocion\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPromocion\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", promocion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoSinIva y getMontoSinIva de la clase AvisoPromocionDTO. 
	 */
	@Test
	public void testSetAndGetMontoSinIvaMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		Double montoSinIva = 300.0;
		
		dto.setMontoSinIva(montoSinIva);
		
		Double tmp = dto.getMontoSinIva();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoSinIva\" o \"getMontoSinIva\" de la clase \"AvisoPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoSinIva\" de la clase \"AvisoPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", montoSinIva, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMontoConIva y getMontoConIva de la clase AvisoPromocionDTO. 
	 */
	@Test
	public void testSetAndGetMontoConIvaMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		Double montoConIva = 300.0;
		
		dto.setMontoConIva(montoConIva);
		
		Double tmp = dto.getMontoConIva();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMontoConIva\" o \"getMontoConIva\" de la clase \"AvisoPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMontoConIva\" de la clase \"AvisoPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", montoConIva, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPorcentaje y getPorcentaje de la clase AvisoPromocionDTO. 
	 */
	@Test
	public void testSetAndGetPorcentajeMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		Double porcentaje = 300.0;
		
		dto.setPorcentaje(porcentaje);
		
		Double tmp = dto.getPorcentaje();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPorcentaje\" o \"getPorcentaje\" de la clase \"AvisoPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPorcentaje\" de la clase \"AvisoPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", porcentaje, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setEsDescuento y getEsDescuento de la clase AvisoPromocionDTO. 
	 */
	@Test
	public void testSetAndGetEsDescuentoMethod() {
		AvisoPromocionDTO dto = new AvisoPromocionDTO();
		Boolean esDescuento = true;
		
		dto.setEsDescuento(esDescuento);
		
		Boolean tmp = dto.getEsDescuento();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setEsDescuento\" o \"getEsDescuento\" de la clase \"AvisoPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getEsDescuento\" de la clase \"AvisoPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", esDescuento, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase AvisoDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"AvisoPromocionDTO\".", tmp);
	}
}
