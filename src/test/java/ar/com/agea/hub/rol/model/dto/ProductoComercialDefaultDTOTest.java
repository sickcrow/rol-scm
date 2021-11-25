/*
 * @(#)ProductoComercialDefaultDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ProductoComercialDefaultDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ProductoComercialDefaultDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ProductoComercialDefaultDTO.
	 */
	@Test
	public void testConstructor() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ProductoComercialDefaultDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoAgrupamientoProductoTecnico y getCodigoAgrupamientoProductoTecnico de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAgrupamientoProductoTecnicoMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoAgrupamientoProductoTecnico = "CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO";
		
		dto.setCodigoAgrupamientoProductoTecnico(codigoAgrupamientoProductoTecnico);
		
		String tmp = dto.getCodigoAgrupamientoProductoTecnico();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoAgrupamientoProductoTecnico\" o \"getCodigoAgrupamientoProductoTecnico\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoAgrupamientoProductoTecnico\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAgrupamientoProductoTecnico, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoTipoOperacion y getCodigoTipoOperacion de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoOperacionMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoTipoOperacion = "CODIGO_TIPO_OPERACION";
		
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		
		String tmp = dto.getCodigoTipoOperacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoTipoOperacion\" o \"getCodigoTipoOperacion\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoTipoOperacion\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoOperacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoNivelEstructuraMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoNivelEstructura\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProductoComercial y getCodigoProductoComercial de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoComercialMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoProductoComercial = "CODIGO_PRODUCTO_COMERCIAL";
		
		dto.setCodigoProductoComercial(codigoProductoComercial);
		
		String tmp = dto.getCodigoProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProductoComercial\" o \"getCodigoProductoComercial\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProductoComercial\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProductoComercial, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoTemplate y getCodigoTemplate de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTemplateMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoTemplate = "CODIGO_TEMPLATE";
		
		dto.setCodigoTemplate(codigoTemplate);
		
		String tmp = dto.getCodigoTemplate();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoTemplate\" o \"getCodigoTemplate\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoTemplate\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTemplate, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoAgrupamientoProductoTecnico("CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO");
		dto.setCodigoTipoOperacion("CODIGO_TIPO_OPERACION");
		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setCodigoProductoComercial("CODIGO_PRODUCTO_COMERCIAL");
		dto.setCodigoTemplate("CODIGO_TEMPLATE");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ProductoComercialDefaultDTO\".", tmp);
	}
}
