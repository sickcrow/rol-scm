/*
 * @(#)AgrupadorProductoZonasNivelesDTOTest.java		1.0 30/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

public class AgrupadorProductoZonasNivelesDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo AgrupadorProductoZonasNivelesDTO.
	 */
	@Test
	public void testConstructor() {
		AgrupadorProductoZonasNivelesDTO dto = new AgrupadorProductoZonasNivelesDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"AgrupadorProductoZonasNivelesDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecución de métodos setProducto y getProducto de la clase AgrupadorProductoZonasNivelesDTO. 
	 */
	@Test
	public void testSetAndGetProductoMethod() {
		AgrupadorProductoZonasNivelesDTO dto = new AgrupadorProductoZonasNivelesDTO();
		ProductoDTO producto = new ProductoDTO();
		
		dto.setProducto(producto);
		
		ProductoDTO tmp = dto.getProducto();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setProducto\" o \"getProducto\" de la clase \"AgrupadorProductoZonasNivelesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getProducto\" de la clase \"AgrupadorProductoZonasNivelesDTO\""
				+ " no corresponde al valor enviado como argumento.", producto, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setZonasComercializacion y getZonasComercializacion de la clase AgrupadorProductoZonasNivelesDTO. 
	 */
	@Test
	public void testSetAndGetZonaComercializacionMethod() {
		AgrupadorProductoZonasNivelesDTO dto = new AgrupadorProductoZonasNivelesDTO();
		List<ZonaComercializacionDTO> zonasComercializacion = new ArrayList<ZonaComercializacionDTO>();
		
		dto.setZonasComercializacion(zonasComercializacion);
		
		List<ZonaComercializacionDTO> tmp = dto.getZonasComercializacion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setZonasComercializacion\" o \"getZonasComercializacion\" de la clase \"AgrupadorProductoZonasNivelesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getZonasComercializacion\" de la clase \"AgrupadorProductoZonasNivelesDTO\""
				+ " no corresponde al valor enviado como argumento.", zonasComercializacion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNivelesEstructura y getNivelesEstructura de la clase AgrupadorProductoZonasNivelesDTO. 
	 */
	@Test
	public void testSetAndGetNivelesEstructuraMethod() {
		AgrupadorProductoZonasNivelesDTO dto = new AgrupadorProductoZonasNivelesDTO();
		List<AgrupadorProductoComercialNivelDTO> agrupadoresProductoComercialNivel = new ArrayList<AgrupadorProductoComercialNivelDTO>();
		
		dto.setAgrupadoresProductoComercialNivel(agrupadoresProductoComercialNivel);
		
		List<AgrupadorProductoComercialNivelDTO> tmp = dto.getAgrupadoresProductoComercialNivel();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNivelesEstructura\" o \"getNivelesEstructura\" de la clase \"AgrupadorProductoZonasNivelesDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNivelesEstructura\" de la clase \"AgrupadorProductoZonasNivelesDTO\""
				+ " no corresponde al valor enviado como argumento.", agrupadoresProductoComercialNivel, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase AgrupadorProductoZonasNivelesDTO. 
	 */
	@Test
	public void testToStringMethod() {
		AgrupadorProductoZonasNivelesDTO dto = new AgrupadorProductoZonasNivelesDTO();
		
		List<ZonaComercializacionDTO> zonasComercializacion = new ArrayList<ZonaComercializacionDTO>();
		zonasComercializacion.add(new ZonaComercializacionDTO());
		zonasComercializacion.add(new ZonaComercializacionDTO());
		zonasComercializacion.add(new ZonaComercializacionDTO());
		
		List<AgrupadorProductoComercialNivelDTO> agrupadoresProductoComercialNivel = new ArrayList<AgrupadorProductoComercialNivelDTO>();
		agrupadoresProductoComercialNivel.add(new AgrupadorProductoComercialNivelDTO());
		agrupadoresProductoComercialNivel.add(new AgrupadorProductoComercialNivelDTO());
		agrupadoresProductoComercialNivel.add(new AgrupadorProductoComercialNivelDTO());
		
		dto.setProducto(new ProductoDTO());
		dto.setZonasComercializacion(zonasComercializacion);
		dto.setAgrupadoresProductoComercialNivel(agrupadoresProductoComercialNivel);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"AgrupadorProductoZonasNivelesDTO\".", tmp);
	}
}
