/*
 * @(#)TemplateDetalladoSearchDTOTest.java		1.0 30/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase TemplateDetalladoSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 30/01/2014
 */
public class TemplateDetalladoSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo TemplateDetalladoSearchDTO.
	 */
	@Test
	public void testConstructor() {
		TemplateDetalladoSearchDTO dto = new TemplateDetalladoSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"TemplateDetalladoSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase TemplateDetalladoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoNivelEstructuraMethod() {
		TemplateDetalladoSearchDTO dto = new TemplateDetalladoSearchDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"TemplateDetalladoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoNivelEstructura\" de la clase \"TemplateDetalladoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase TemplateDetalladoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		TemplateDetalladoSearchDTO dto = new TemplateDetalladoSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"TemplateDetalladoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"TemplateDetalladoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoAgrupamientoProductoTecnico y getCodigoAgrupamientoProductoTecnico de la clase TemplateDetalladoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAgrupamientoProductoTecnicoMethod() {
		TemplateDetalladoSearchDTO dto = new TemplateDetalladoSearchDTO();
		String codigoAgrupamientoProductoTecnico = "CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO";
		
		dto.setCodigoAgrupamientoProductoTecnico(codigoAgrupamientoProductoTecnico);
		
		String tmp = dto.getCodigoAgrupamientoProductoTecnico();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoAgrupamientoProductoTecnico\" o \"getCodigoAgrupamientoProductoTecnico\" de la clase \"TemplateDetalladoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoAgrupamientoProductoTecnico\" de la clase \"TemplateDetalladoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAgrupamientoProductoTecnico, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoTipoOperacion y getCodigoTipoOperacion de la clase TemplateDetalladoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoOperacionMethod() {
		TemplateDetalladoSearchDTO dto = new TemplateDetalladoSearchDTO();
		String codigoTipoOperacion = "CODIGO_TIPO_OPERACION";
		
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		
		String tmp = dto.getCodigoTipoOperacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoTipoOperacion\" o \"getCodigoTipoOperacion\" de la clase \"TemplateDetalladoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoTipoOperacion\" de la clase \"TemplateDetalladoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoOperacion, tmp);
	}
	
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFechaVigencia y getFechaVigencia de la clase TemplateDetalladoSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		TemplateDetalladoSearchDTO dto = new TemplateDetalladoSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al m�todo \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"TemplateDetalladoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"TemplateDetalladoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"TemplateDetalladoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"TemplateDetalladoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase TemplateDetalladoSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TemplateDetalladoSearchDTO dto = new TemplateDetalladoSearchDTO();
		
		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setCodigoAgrupamientoProductoTecnico("CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO");
		dto.setCodigoTipoOperacion("CODIGO_TIPO_OPERACION");
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setFechaVigencia(new Date());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"TemplateDetalladoSearchDTO\".", tmp);
	}
}
