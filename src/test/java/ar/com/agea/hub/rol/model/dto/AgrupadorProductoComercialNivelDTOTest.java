/*
 * @(#)AgrupadorProductoComercialNivelDTOTest.java		1.0 30/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

public class AgrupadorProductoComercialNivelDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo AgrupadorProductoComercialNivelDTO.
	 */
	@Test
	public void testConstructor() {
		AgrupadorProductoComercialNivelDTO dto = new AgrupadorProductoComercialNivelDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"AgrupadorProductoComercialNivelDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setProductoComercial y getProductoComercial de la clase AgrupadorProductoComercialNivelDTO. 
	 */
	@Test
	public void testSetAndGetProductoComercialMethod() {
		AgrupadorProductoComercialNivelDTO dto = new AgrupadorProductoComercialNivelDTO();
		ProductoComercialDTO productoComercial = new ProductoComercialDTO();
		
		dto.setProductoComercial(productoComercial);
		
		ProductoComercialDTO tmp = dto.getProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setProductoComercial\" o \"getProductoComercial\" de la clase \"AgrupadorProductoComercialNivelDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getProductoComercial\" de la clase \"AgrupadorProductoComercialNivelDTO\""
				+ " no corresponde al valor enviado como argumento.", productoComercial, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setNivelEstructura y getNivelEstructura de la clase AgrupadorProductoComercialNivelDTO. 
	 */
	@Test
	public void testSetAndGetNivelEstructuraMethod() {
		AgrupadorProductoComercialNivelDTO dto = new AgrupadorProductoComercialNivelDTO();
		NivelEstructuraDTO nivelEstructura = new NivelEstructuraDTO();
		
		dto.setNivelEstructura(nivelEstructura);
		
		NivelEstructuraDTO tmp = dto.getNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNivelEstructura\" o \"getNivelEstructura\" de la clase \"AgrupadorProductoComercialNivelDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNivelEstructura\" de la clase \"AgrupadorProductoComercialNivelDTO\""
				+ " no corresponde al valor enviado como argumento.", nivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase AgrupadorProductoComercialNivelDTO. 
	 */
	@Test
	public void testToStringMethod() {
		AgrupadorProductoComercialNivelDTO dto = new AgrupadorProductoComercialNivelDTO();
		
		dto.setProductoComercial(new ProductoComercialDTO());
		dto.setNivelEstructura(new NivelEstructuraDTO());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"AgrupadorProductoComercialNivelDTO\".", tmp);
	}
}
