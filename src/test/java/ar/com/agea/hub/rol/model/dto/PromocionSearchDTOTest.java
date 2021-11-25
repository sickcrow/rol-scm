/*
 * @(#)PromocionSearchDTOTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase PromocionSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class PromocionSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo PromocionSearchDTO.
	 */
	@Test
	public void testConstructor() {
		PromocionSearchDTO dto = new PromocionSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"PromocionSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase PromocionSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		PromocionSearchDTO dto = new PromocionSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"PromocionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"PromocionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProductoComercial y getCodigoProductoComercial de la clase PromocionSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoComercialMethod() {
		PromocionSearchDTO dto = new PromocionSearchDTO();
		String codigoProductoComercial = "CODIGO_PRODUCTO_COMERCIAL";
		
		dto.setCodigoProductoComercial(codigoProductoComercial);
		
		String tmp = dto.getCodigoProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProductoComercial\" o \"getCodigoProductoComercial\" de la clase \"PromocionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProductoComercial\" de la clase \"PromocionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProductoComercial, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase PromocionSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoNivelEstructuraMethod() {
		PromocionSearchDTO dto = new PromocionSearchDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"PromocionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoNivelEstructura\" de la clase \"PromocionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoZonasComercializacion y getCodigoZonasComercializacion de la clase PromocionSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoZonasComercializacionMethod() {
		PromocionSearchDTO dto = new PromocionSearchDTO();
		List<String> codigoZonasComercializacion = new ArrayList<String>();
		
		dto.setCodigoZonasComercializacion(codigoZonasComercializacion);
		
		List<String> tmp = dto.getCodigoZonasComercializacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoZonasComercializacion\" o \"getCodigoZonasComercializacion\" de la clase \"PromocionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoZonasComercializacion\" de la clase \"PromocionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoZonasComercializacion, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setFechaVigencia y getFechaVigencia de la clase PromocionSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		PromocionSearchDTO dto = new PromocionSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al m�todo \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"PromocionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"PromocionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"PromocionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"PromocionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase PromocionSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		PromocionSearchDTO dto = new PromocionSearchDTO();
		
		List<String> codigosZonaComercializacion = new ArrayList<String>();
		codigosZonaComercializacion.add("CODIGO_ZONA_COMERCIALIZACION");
		codigosZonaComercializacion.add("ANOTHER_CODIGO_ZONA_COMERCIALIZACION");
		codigosZonaComercializacion.add("UNKNOWN_CODIGO_ZONA_COMERCIALIZACION");
		
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoProductoComercial("CODIGO_PRODUCTO_COMERCIAL");
		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setCodigoZonasComercializacion(codigosZonaComercializacion);
		dto.setFechaVigencia(new Date());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"PromocionSearchDTO\".", tmp);
	}
}
