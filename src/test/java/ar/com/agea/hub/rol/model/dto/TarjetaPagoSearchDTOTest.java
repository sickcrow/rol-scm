/*
 * @(#)TarjetaPagoSearchDTOTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase TarjetaPagoSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class TarjetaPagoSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo TarjetaPagoSearchDTO.
	 */
	@Test
	public void testConstructor() {
		TarjetaPagoSearchDTO dto = new TarjetaPagoSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TarjetaPagoSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase TarjetaPagoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		TarjetaPagoSearchDTO dto = new TarjetaPagoSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"TarjetaPagoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCanalEntrada\" de la clase \"TarjetaPagoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase TarjetaPagoSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TarjetaPagoSearchDTO dto = new TarjetaPagoSearchDTO();
		
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"TarjetaPagoSearchDTO\".", tmp);
	}
}
