/*
 * @(#)CalendarioSearchDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase CalendarioSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class CalendarioSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo CalendarioSearchDTO.
	 */
	@Test
	public void testConstructor() {
		CalendarioSearchDTO dto = new CalendarioSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"CalendarioSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setNivelEstructura y getNivelEstructura de la clase CalendarioSearchDTO. 
	 */
	@Test
	public void testSetAndGetNivelEstructuraMethod() {
		CalendarioSearchDTO dto = new CalendarioSearchDTO();
		String nivelEstructura = "NIVEL_ESTRUCTURA";
		
		dto.setNivelEstructura(nivelEstructura);
		
		String tmp = dto.getNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNivelEstructura\" o \"getNivelEstructura\" de la clase \"CalendarioSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNivelEstructura\" de la clase \"CalendarioSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", nivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFechaVigencia y getFechaVigencia de la clase CalendarioSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		CalendarioSearchDTO dto = new CalendarioSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al m�todo \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"CalendarioSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"CalendarioSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"CalendarioSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"CalendarioSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setControlarHorarioCierre y getControlarHorarioCierre de la clase CalendarioSearchDTO. 
	 */
	@Test
	public void testSetAndGetControlarHorarioCierreMethod() {
		CalendarioSearchDTO dto = new CalendarioSearchDTO();
		Boolean controlarHorarioCierre = true;
		
		dto.setControlarHorarioCierre(controlarHorarioCierre);
		
		Boolean tmp = dto.getControlarHorarioCierre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setControlarHorarioCierre\" o \"getControlarHorarioCierre\" de la clase \"CalendarioSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getControlarHorarioCierre\" de la clase \"CalendarioSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", controlarHorarioCierre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setZonasComercializacion y getZonasComercializacion de la clase CalendarioSearchDTO. 
	 */
	@Test
	public void testSetAndGetZonasComercializacionMethod() {
		CalendarioSearchDTO dto = new CalendarioSearchDTO();
		List<String> zonasComercializacion = new ArrayList<String>();
		
		dto.setZonasComercializacion(zonasComercializacion);
		
		List<String> tmp = dto.getZonasComercializacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setZonasComercializacion\" o \"getZonasComercializacion\" de la clase \"CalendarioSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getZonasComercializacion\" de la clase \"CalendarioSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", zonasComercializacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIdItemPromocion y getIdItemPromocion de la clase CalendarioSearchDTO. 
	 */
	@Test
	public void testSetAndGetIdItemPromocionMethod() {
		CalendarioSearchDTO dto = new CalendarioSearchDTO();
		Long idItemPromocion = 300L;
		
		dto.setIdItemPromocion(idItemPromocion);
		
		Long tmp = dto.getIdItemPromocion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIdItemPromocion\" o \"getIdItemPromocion\" de la clase \"CalendarioSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIdItemPromocion\" de la clase \"CalendarioSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", idItemPromocion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase CalendarioSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		CalendarioSearchDTO dto = new CalendarioSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"CalendarioSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"CalendarioSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase CalendarioSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		CalendarioSearchDTO dto = new CalendarioSearchDTO();
		
		List<String> zonasComercializacion = new ArrayList<String>();
		zonasComercializacion.add("ZONA_COMERCIALIZACION");
		zonasComercializacion.add("ANOTHER_ZONA_COMERCIALIZACION");
		zonasComercializacion.add("UNKNOWN_ZONA_COMERCIALIZACION");
		
		dto.setNivelEstructura("NIVEL_ESTRUCTURA");
		dto.setFechaVigencia(new Date());
		dto.setControlarHorarioCierre(true);
		dto.setZonasComercializacion(zonasComercializacion);
		dto.setIdItemPromocion(300L);
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"CalendarioSearchDTO\".", tmp);
	}
}
