/*
 * @(#)ProductoTecnicoDTOTest.java		1.0 03/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ProductoTecnicoDTO.Tipo;

/**
 * Representa JUnit Tests de inicialización para la clase ProductoTecnicoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 03/09/2013
 */
public class ProductoTecnicoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ProductoTecnicoDTO.
	 */
	@Test
	public void testConstructor() {
		ProductoTecnicoDTO dto = new ProductoTecnicoDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ProductoTecnicoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setTipo y getTipo de la clase ProductoTecnicoDTO. 
	 */
	@Test
	public void testSetAndGetTipoMethod() {
		ProductoTecnicoDTO dto = new ProductoTecnicoDTO();
		Tipo tipo = Tipo.PAPEL;
		
		dto.setTipo(tipo);
		
		Tipo tmp = dto.getTipo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTipo\" o \"getTipo\" de la clase \"ProductoTecnicoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTipo\" de la clase \"ProductoTecnicoDTO\""
				+ " no corresponde al valor enviado como argumento.", tipo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigo y getCodigo de la clase ProductoTecnicoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		ProductoTecnicoDTO dto = new ProductoTecnicoDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigo\" o \"getCodigo\" de la clase \"ProductoTecnicoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigo\" de la clase \"ProductoTecnicoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setDescripcion y getDescripcion de la clase ProductoTecnicoDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		ProductoTecnicoDTO dto = new ProductoTecnicoDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDescripcion\" o \"getDescripcion\" de la clase \"ProductoTecnicoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDescripcion\" de la clase \"ProductoTecnicoDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ProductoTecnicoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ProductoTecnicoDTO dto = new ProductoTecnicoDTO();
		
		dto.setTipo(Tipo.PAPEL);
		dto.setCodigo("CODIGO");
		dto.setDescripcion("DESCRIPCION");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ProductoTecnicoDTO\".", tmp);
	}
}
