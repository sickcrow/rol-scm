/*
 * @(#)ProductoComercialTemplateDTOTest.java		1.0 30/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ProductoComercialTemplateDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 30/01/2014
 */
public class ProductoComercialTemplateDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ProductoComercialTemplateDTO.
	 */
	@Test
	public void testConstructor() {
		ProductoComercialTemplateDTO dto = new ProductoComercialTemplateDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ProductoComercialTemplateDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setTemplateDetallado y getTemplateDetallado de la clase ProductoComercialTemplateDTO. 
	 */
	@Test
	public void testSetAndGetTemplateDetalladoMethod() {
		ProductoComercialTemplateDTO dto = new ProductoComercialTemplateDTO();
		TemplateDetalladoDTO templateDetalladoDTO = new TemplateDetalladoDTO();
		
		dto.setTemplateDetallado(templateDetalladoDTO);
		
		TemplateDetalladoDTO tmp = dto.getTemplateDetallado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTemplateDetallado\" o \"getTemplateDetalladoTO\" de la clase \"ProductoComercialTemplateDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTemplateDetallado\" de la clase \"ProductoComercialTemplateDTO\""
				+ " no corresponde al valor enviado como argumento.", templateDetalladoDTO, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoProductoComercial y getCodigoProductoComercial de la clase ProductoComercialTemplateDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoComercialMethod() {
		ProductoComercialTemplateDTO dto = new ProductoComercialTemplateDTO();
		String codigoProductoComercial = "CODIGO_PRODUCTO_COMERCIAL";
		
		dto.setCodigoProductoComercial(codigoProductoComercial);
		
		String tmp = dto.getCodigoProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoProductoComercial\" o \"getCodigoProductoComercial\" de la clase \"ProductoComercialTemplateDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoProductoComercial\" de la clase \"ProductoComercialTemplateDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProductoComercial, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ProductoComercialTemplateDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ProductoComercialTemplateDTO dto = new ProductoComercialTemplateDTO();
		
		dto.setTemplateDetallado(new TemplateDetalladoDTO());
		dto.setCodigoProductoComercial("CODIGO_PRODUCTO_COMERCIAL");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ProductoComercialTemplateDTO\".", tmp);
	}
}
