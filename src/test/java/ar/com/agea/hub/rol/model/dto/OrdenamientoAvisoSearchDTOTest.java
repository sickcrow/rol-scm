/*
 * @(#)OrdenamientoAvisoSearchDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci?n para la clase OrdenamientoAvisoSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class OrdenamientoAvisoSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci?n de objeto de tipo OrdenamientoAvisoSearchDTO.
	 */
	@Test
	public void testConstructor() {
		OrdenamientoAvisoSearchDTO dto = new OrdenamientoAvisoSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creaci?n del objeto de tipo \"OrdenamientoAvisoSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci?n de m?todos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase OrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		OrdenamientoAvisoSearchDTO dto = new OrdenamientoAvisoSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al m?todo \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"OrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m?todo \"getCodigoCanalEntrada\" de la clase \"OrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecuci?n de m?todos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase OrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoNivelEstructuraMethod() {
		OrdenamientoAvisoSearchDTO dto = new OrdenamientoAvisoSearchDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m?todo \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"OrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m?todo \"getCodigoNivelEstructura\" de la clase \"OrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci?n de m?todos setCodigoAgrupamientoProductoTecnico y getCodigoAgrupamientoProductoTecnico de la clase OrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAgrupamientoProductoTecnicoMethod() {
		OrdenamientoAvisoSearchDTO dto = new OrdenamientoAvisoSearchDTO();
		String codigoAgrupamientoProductoTecnico = "CODIGO_AGRUPADOR_PRODUCTO_TECNICO";
		
		dto.setCodigoAgrupamientoProductoTecnico(codigoAgrupamientoProductoTecnico);
		
		String tmp = dto.getCodigoAgrupamientoProductoTecnico();
		
		Assert.assertNotNull("Ha fallado la llamada al m?todo \"setCodigoAgrupamientoProductoTecnico\" o \"getCodigoAgrupamientoProductoTecnico\" de la clase \"OrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m?todo \"getCodigoAgrupamientoProductoTecnico\" de la clase \"OrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAgrupamientoProductoTecnico, tmp);
	}
	
	/**
	 * Comprueba la ejecuci?n de m?todos setCodigoTipoOperacion y getCodigoTipoOperacion de la clase OrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoOperacionMethod() {
		OrdenamientoAvisoSearchDTO dto = new OrdenamientoAvisoSearchDTO();
		String codigoTipoOperacion = "CODIGO_TIPO_OPERACION";
		
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		
		String tmp = dto.getCodigoTipoOperacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m?todo \"setCodigoTipoOperacion\" o \"getCodigoTipoOperacion\" de la clase \"OrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m?todo \"getCodigoTipoOperacion\" de la clase \"OrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoOperacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci?n de m?todos setFechaVigencia y getFechaVigencia de la clase OrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		OrdenamientoAvisoSearchDTO dto = new OrdenamientoAvisoSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al m?todo \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"OrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m?todo \"getFechaVigencia\" de la clase \"OrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al m?todo \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"OrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m?todo \"getFechaVigencia\" de la clase \"OrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecuci?n de m?todos setCodigoIndividuo y getCodigoIndividuo de la clase OrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoIndividuoMethod() {
		OrdenamientoAvisoSearchDTO dto = new OrdenamientoAvisoSearchDTO();
		String codigoIndividuo = "CODIGO_INDIVIDUO";
		
		dto.setCodigoIndividuo(codigoIndividuo);
		
		String tmp = dto.getCodigoIndividuo();
		
		Assert.assertNotNull("Ha fallado la llamada al m?todo \"setCodigoIndividuo\" o \"getCodigoIndividuo\" de la clase \"OrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m?todo \"getCodigoIndividuo\" de la clase \"OrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoIndividuo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci?n de m?todos setCodigoClase y getCodigoClase de la clase OrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClaseMethod() {
		OrdenamientoAvisoSearchDTO dto = new OrdenamientoAvisoSearchDTO();
		String codigoClase = "CODIGO_CLASE";
		
		dto.setCodigoClase(codigoClase);
		
		String tmp = dto.getCodigoClase();
		
		Assert.assertNotNull("Ha fallado la llamada al m?todo \"setCodigoClase\" o \"getCodigoClase\" de la clase \"OrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m?todo \"getCodigoClase\" de la clase \"OrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoClase, tmp);
	}
	
	/**
	 * Comprueba la ejecuci?n de m?todo toString de la clase OrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		OrdenamientoAvisoSearchDTO dto = new OrdenamientoAvisoSearchDTO();
		
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setCodigoAgrupamientoProductoTecnico("CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO");
		dto.setCodigoTipoOperacion("CODIGO_TIPO_OPERACION");
		dto.setFechaVigencia(new Date());
		dto.setCodigoIndividuo("CODIGO_INDIVIDUO");
		dto.setCodigoClase("CODIGO_CLASE");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m?todo \"toString\" de la clase \"OrdenamientoAvisoSearchDTO\".", tmp);
	}
}
