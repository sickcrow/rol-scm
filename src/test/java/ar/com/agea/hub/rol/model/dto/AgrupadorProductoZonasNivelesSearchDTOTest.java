/*
 * @(#)AgrupadorProductoZonasNivelesSearchDTOTest.java		1.0 02/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase AgrupadorProductoZonasNivelesSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 02/09/2013
 */
public class AgrupadorProductoZonasNivelesSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo AgrupadorProductoZonasNivelesSearchDTO.
	 */
	@Test
	public void testConstructor() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoClase y getCodigoClase de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClaseMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		String codigoClase = "CODIGO_CLASE";
		
		dto.setCodigoClase(codigoClase);
		
		String tmp = dto.getCodigoClase();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoClase\" o \"getCodigoClase\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoClase\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoClase, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoTipoOperacion y getCodigoTipoOperacion de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoOperacionMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		String codigoTipoOperacion = "CODIGO_TIPO_OPERACION";
		
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		
		String tmp = dto.getCodigoTipoOperacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoTipoOperacion\" o \"getCodigoTipoOperacion\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoTipoOperacion\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoOperacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoAgrupamientoProductoTecnico y getCodigoAgrupamientoProductoTecnico de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAgrupamientoProductoTecnicoMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		String codigoAgrupamientoProductoTecnico = "CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO";
		
		dto.setCodigoAgrupamientoProductoTecnico(codigoAgrupamientoProductoTecnico);
		
		String tmp = dto.getCodigoAgrupamientoProductoTecnico();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoAgrupamientoProductoTecnico\" o \"getCodigoAgrupamientoProductoTecnico\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoAgrupamientoProductoTecnico\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAgrupamientoProductoTecnico, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFechaVigencia y getFechaVigencia de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al m�todo \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();

		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoClase("CODIGO_CLASE");
		dto.setCodigoTipoOperacion("CODIGO_TIPO_OPERACION");
		dto.setCodigoAgrupamientoProductoTecnico("CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO");
		dto.setFechaVigencia(new Date());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".", tmp);
	}
}
