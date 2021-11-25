/*
 * @(#)AgrupadorProductoComercialNivelDTOTest.java		1.0 30/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

public class AgrupadorProductoComercialNivelDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo AgrupadorProductoComercialNivelDTO.
	 */
	@Test
	public void testConstructor() {
		AgrupadorProductoComercialNivelDTO dto = new AgrupadorProductoComercialNivelDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"AgrupadorProductoComercialNivelDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecución de métodos setProductoComercial y getProductoComercial de la clase AgrupadorProductoComercialNivelDTO. 
	 */
	@Test
	public void testSetAndGetProductoComercialMethod() {
		AgrupadorProductoComercialNivelDTO dto = new AgrupadorProductoComercialNivelDTO();
		ProductoComercialDTO productoComercial = new ProductoComercialDTO();
		
		dto.setProductoComercial(productoComercial);
		
		ProductoComercialDTO tmp = dto.getProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setProductoComercial\" o \"getProductoComercial\" de la clase \"AgrupadorProductoComercialNivelDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getProductoComercial\" de la clase \"AgrupadorProductoComercialNivelDTO\""
				+ " no corresponde al valor enviado como argumento.", productoComercial, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setNivelEstructura y getNivelEstructura de la clase AgrupadorProductoComercialNivelDTO. 
	 */
	@Test
	public void testSetAndGetNivelEstructuraMethod() {
		AgrupadorProductoComercialNivelDTO dto = new AgrupadorProductoComercialNivelDTO();
		NivelEstructuraDTO nivelEstructura = new NivelEstructuraDTO();
		
		dto.setNivelEstructura(nivelEstructura);
		
		NivelEstructuraDTO tmp = dto.getNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNivelEstructura\" o \"getNivelEstructura\" de la clase \"AgrupadorProductoComercialNivelDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNivelEstructura\" de la clase \"AgrupadorProductoComercialNivelDTO\""
				+ " no corresponde al valor enviado como argumento.", nivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase AgrupadorProductoComercialNivelDTO. 
	 */
	@Test
	public void testToStringMethod() {
		AgrupadorProductoComercialNivelDTO dto = new AgrupadorProductoComercialNivelDTO();
		
		dto.setProductoComercial(new ProductoComercialDTO());
		dto.setNivelEstructura(new NivelEstructuraDTO());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"AgrupadorProductoComercialNivelDTO\".", tmp);
	}
}
