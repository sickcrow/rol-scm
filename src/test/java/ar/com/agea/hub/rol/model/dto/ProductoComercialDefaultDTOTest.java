/*
 * @(#)ProductoComercialDefaultDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ProductoComercialDefaultDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ProductoComercialDefaultDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ProductoComercialDefaultDTO.
	 */
	@Test
	public void testConstructor() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ProductoComercialDefaultDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCanalEntrada\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoAgrupamientoProductoTecnico y getCodigoAgrupamientoProductoTecnico de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAgrupamientoProductoTecnicoMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoAgrupamientoProductoTecnico = "CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO";
		
		dto.setCodigoAgrupamientoProductoTecnico(codigoAgrupamientoProductoTecnico);
		
		String tmp = dto.getCodigoAgrupamientoProductoTecnico();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoAgrupamientoProductoTecnico\" o \"getCodigoAgrupamientoProductoTecnico\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoAgrupamientoProductoTecnico\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAgrupamientoProductoTecnico, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoOperacion y getCodigoTipoOperacion de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoOperacionMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoTipoOperacion = "CODIGO_TIPO_OPERACION";
		
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		
		String tmp = dto.getCodigoTipoOperacion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoOperacion\" o \"getCodigoTipoOperacion\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTipoOperacion\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoOperacion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoNivelEstructuraMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoNivelEstructura\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoProductoComercial y getCodigoProductoComercial de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoComercialMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoProductoComercial = "CODIGO_PRODUCTO_COMERCIAL";
		
		dto.setCodigoProductoComercial(codigoProductoComercial);
		
		String tmp = dto.getCodigoProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoProductoComercial\" o \"getCodigoProductoComercial\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoProductoComercial\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProductoComercial, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTemplate y getCodigoTemplate de la clase ProductoComercialDefaultDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTemplateMethod() {
		ProductoComercialDefaultDTO dto = new ProductoComercialDefaultDTO();
		String codigoTemplate = "CODIGO_TEMPLATE";
		
		dto.setCodigoTemplate(codigoTemplate);
		
		String tmp = dto.getCodigoTemplate();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTemplate\" o \"getCodigoTemplate\" de la clase \"ProductoComercialDefaultDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTemplate\" de la clase \"ProductoComercialDefaultDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTemplate, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ProductoComercialDefaultDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ProductoComercialDefaultDTO\".", tmp);
	}
}
