/*
 * @(#)ValidacionPromocionDTOTest.java		1.0 30/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ValidacionPromocionDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 30/01/2014
 */
public class ValidacionPromocionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ValidacionPromocionDTO.
	 */
	@Test
	public void testConstructor() {
		ValidacionPromocionDTO dto = new ValidacionPromocionDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ValidacionPromocionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setIdProductoComercial y getIdProductoComercial de la clase ValidacionPromocionDTO. 
	 */
	@Test
	public void testSetAndGetIdProductoComercialMethod() {
		ValidacionPromocionDTO dto = new ValidacionPromocionDTO();
		Long idProductoComercial = 300L;
		
		dto.setIdProductoComercial(idProductoComercial);
		
		Long tmp = dto.getIdProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setIdProductoComercial\" o \"getIdProductoComercial\" de la clase \"ValidacionPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getIdProductoComercial\" de la clase \"ValidacionPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", idProductoComercial, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setFechaPublicacion y getFechaPublicacion de la clase ValidacionPromocionDTO. 
	 */
	@Test
	public void testSetAndGetFechaAltaMethod() {
		ValidacionPromocionDTO dto = new ValidacionPromocionDTO();
		Date fechaPublicacion = null;
		
		dto.setFechaPublicacion(fechaPublicacion);
		
		Date tmp = dto.getFechaPublicacion();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaPublicacion\" o \"getFechaPublicacion\" de la clase \"ValidacionPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaPublicacion\" de la clase \"ValidacionPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaPublicacion, tmp);
		
		fechaPublicacion = new Date();
		
		dto.setFechaPublicacion(fechaPublicacion);
		
		tmp = dto.getFechaPublicacion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaPublicacion\" o \"getFechaPublicacion\" de la clase \"ValidacionPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaPublicacion\" de la clase \"ValidacionPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaPublicacion, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setValida y getValida de la clase ValidacionPromocionDTO. 
	 */
	@Test
	public void testSetAndGetValidaMethod() {
		ValidacionPromocionDTO dto = new ValidacionPromocionDTO();
		Boolean valida = true;
		
		dto.setValida(valida);
		
		Boolean tmp = dto.getValida();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setValida\" o \"getValida\" de la clase \"ValidacionPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getValida\" de la clase \"ValidacionPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", valida, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMotivoInvalidez y getMotivoInvalidez de la clase ValidacionPromocionDTO. 
	 */
	@Test
	public void testSetAndGetMotivoInvalidezMethod() {
		ValidacionPromocionDTO dto = new ValidacionPromocionDTO();
		String motivoInvalidez = "MOTIVO_INVALIDEZ";
		
		dto.setMotivoInvalidez(motivoInvalidez);
		
		String tmp = dto.getMotivoInvalidez();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMotivoInvalidez\" o \"getMotivoInvalidez\" de la clase \"ValidacionPromocionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMotivoInvalidez\" de la clase \"ValidacionPromocionDTO\""
				+ " no corresponde al valor enviado como argumento.", motivoInvalidez, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ValidacionPromocionDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ValidacionPromocionDTO dto = new ValidacionPromocionDTO();
		
		dto.setIdProductoComercial(300L);
		dto.setFechaPublicacion(new Date());
		dto.setValida(true);
		dto.setMotivoInvalidez("MOTIVO_INVALIDEZ");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ValidacionPromocionDTO\".", tmp);
	}
}
