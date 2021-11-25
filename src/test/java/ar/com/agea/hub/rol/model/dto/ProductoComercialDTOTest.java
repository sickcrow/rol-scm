/*
 * @(#)ProductoComercialDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDTO.Tipo;

/**
 * Representa JUnit Tests de inicialización para la clase ProductoComercialDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ProductoComercialDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ProductoComercialDTO.
	 */
	@Test
	public void testConstructor() {
		ProductoComercialDTO dto = new ProductoComercialDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ProductoComercialDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setTipo y getTipo de la clase ProductoComercialDTO. 
	 */
	@Test
	public void testSetAndGetTipoMethod() {
		ProductoComercialDTO dto = new ProductoComercialDTO();
		Tipo tipo = Tipo.PAPEL;
		
		dto.setTipo(tipo);
		
		Tipo tmp = dto.getTipo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTipo\" o \"getTipo\" de la clase \"ProductoComercialDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTipo\" de la clase \"ProductoComercialDTO\""
				+ " no corresponde al valor enviado como argumento.", tipo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigo y getCodigo de la clase ProductoComercialDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		ProductoComercialDTO dto = new ProductoComercialDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigo\" o \"getCodigo\" de la clase \"ProductoComercialDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigo\" de la clase \"ProductoComercialDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setProducto y getProducto de la clase ProductoComercialDTO. 
	 */
	@Test
	public void testSetAndGetProductoMethod() {
		ProductoComercialDTO dto = new ProductoComercialDTO();
		ProductoDTO producto = new ProductoDTO();
		
		dto.setProducto(producto);
		
		ProductoDTO tmp = dto.getProducto();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setProducto\" o \"getProducto\" de la clase \"ProductoComercialDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getProducto\" de la clase \"ProductoComercialDTO\""
				+ " no corresponde al valor enviado como argumento.", producto, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setProductoTecnico y getProductoTecnico de la clase ProductoComercialDTO. 
	 */
	@Test
	public void testSetAndGetProductoTecnicoMethod() {
		ProductoComercialDTO dto = new ProductoComercialDTO();
		ProductoTecnicoDTO productoTecnico = new ProductoTecnicoDTO();
		
		dto.setProductoTecnico(productoTecnico);
		
		ProductoTecnicoDTO tmp = dto.getProductoTecnico();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setProductoTecnico\" o \"getProductoTecnico\" de la clase \"ProductoComercialDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getProductoTecnico\" de la clase \"ProductoComercialDTO\""
				+ " no corresponde al valor enviado como argumento.", productoTecnico, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ProductoComercialDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ProductoComercialDTO dto = new ProductoComercialDTO();
		
		dto.setTipo(Tipo.PAPEL);
		dto.setCodigo("CODIGO");
		dto.setProducto(new ProductoDTO());
		dto.setProductoTecnico(new ProductoTecnicoDTO());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ProductoComercialDTO\".", tmp);
	}
}
