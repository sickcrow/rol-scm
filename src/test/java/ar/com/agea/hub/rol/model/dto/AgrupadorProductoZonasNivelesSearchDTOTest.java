/*
 * @(#)AgrupadorProductoZonasNivelesSearchDTOTest.java		1.0 02/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase AgrupadorProductoZonasNivelesSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 02/09/2013
 */
public class AgrupadorProductoZonasNivelesSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo AgrupadorProductoZonasNivelesSearchDTO.
	 */
	@Test
	public void testConstructor() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCanalEntrada\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoClase y getCodigoClase de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClaseMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		String codigoClase = "CODIGO_CLASE";
		
		dto.setCodigoClase(codigoClase);
		
		String tmp = dto.getCodigoClase();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoClase\" o \"getCodigoClase\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoClase\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoClase, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoOperacion y getCodigoTipoOperacion de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoOperacionMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		String codigoTipoOperacion = "CODIGO_TIPO_OPERACION";
		
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		
		String tmp = dto.getCodigoTipoOperacion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoOperacion\" o \"getCodigoTipoOperacion\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTipoOperacion\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoOperacion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoAgrupamientoProductoTecnico y getCodigoAgrupamientoProductoTecnico de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAgrupamientoProductoTecnicoMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		String codigoAgrupamientoProductoTecnico = "CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO";
		
		dto.setCodigoAgrupamientoProductoTecnico(codigoAgrupamientoProductoTecnico);
		
		String tmp = dto.getCodigoAgrupamientoProductoTecnico();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoAgrupamientoProductoTecnico\" o \"getCodigoAgrupamientoProductoTecnico\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoAgrupamientoProductoTecnico\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAgrupamientoProductoTecnico, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaVigencia y getFechaVigencia de la clase AgrupadorProductoZonasNivelesSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		AgrupadorProductoZonasNivelesSearchDTO dto = new AgrupadorProductoZonasNivelesSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase AgrupadorProductoZonasNivelesSearchDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"AgrupadorProductoZonasNivelesSearchDTO\".", tmp);
	}
}
