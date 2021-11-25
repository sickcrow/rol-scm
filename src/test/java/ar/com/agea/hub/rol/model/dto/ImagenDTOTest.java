/*
 * @(#)ImagenDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ImagenDTO.Tipo;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ImagenDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ImagenDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ProductoDTO.
	 */
	@Test
	public void testConstructor() {
		ImagenDTO dto = new ImagenDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ImagenDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		ImagenDTO dto = new ImagenDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTipo y getTipo de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetTipoMethod() {
		ImagenDTO dto = new ImagenDTO();
		Tipo tipo =Tipo.IMAGEN;
		
		dto.setTipo(tipo);
		
		Tipo tmp = dto.getTipo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipo\" o \"getTipo\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipo\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", tipo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		ImagenDTO dto = new ImagenDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setContenido y getContenido de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetContenidoMethod() {
		ImagenDTO dto = new ImagenDTO();
		String contenido = "CONTENIDO";
		
		dto.setContenido(contenido);
		
		String tmp = dto.getContenido();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setContenido\" o \"getContenido\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getContenido\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", contenido, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPathImagen y getPathImagen de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetPathImagenMethod() {
		ImagenDTO dto = new ImagenDTO();
		String pathImagen = "PATH_IMAGEN";
		
		dto.setPathImagen(pathImagen);
		
		String tmp = dto.getPathImagen();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPathImagen\" o \"getPathImagen\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPathImagen\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", pathImagen, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPathThumbnail y getPathThumbnail de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetPathThumbnailMethod() {
		ImagenDTO dto = new ImagenDTO();
		String pathThumbnail = "PATH_THUMBNAIL";
		
		dto.setPathThumbnail(pathThumbnail);
		
		String tmp = dto.getPathThumbnail();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPathThumbnail\" o \"getPathThumbnail\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPathThumbnail\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", pathThumbnail, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAltura y getAltura de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetAlturaMethod() {
		ImagenDTO dto = new ImagenDTO();
		Integer altura = 300;
		
		dto.setAltura(altura);
		
		Integer tmp = dto.getAltura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAltura\" o \"getAltura\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAltura\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", altura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAncho y getAncho de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetAnchoMethod() {
		ImagenDTO dto = new ImagenDTO();
		Integer ancho = 300;
		
		dto.setAncho(ancho);
		
		Integer tmp = dto.getAncho();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAncho\" o \"getAncho\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAncho\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", ancho, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTamanio y getTamanio de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetTamanioMethod() {
		ImagenDTO dto = new ImagenDTO();
		Long tamanio = 300L;
		
		dto.setTamanio(tamanio);
		
		Long tmp = dto.getTamanio();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTamanio\" o \"getTamanio\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTamanio\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", tamanio, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setRepo y getRepo de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetRepoMethod() {
		ImagenDTO dto = new ImagenDTO();
		String repo = "REPO";
		
		dto.setRepo(repo);
		
		String tmp = dto.getRepo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setRepo\" o \"getRepo\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getRepo\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", repo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setExtension y getExtension de la clase ImagenDTO. 
	 */
	@Test
	public void testSetAndGetExtensionMethod() {
		ImagenDTO dto = new ImagenDTO();
		String extension = "EXTENSION";
		
		dto.setExtension(extension);
		
		String tmp = dto.getExtension();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setExtension\" o \"getExtension\" de la clase \"ImagenDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getExtension\" de la clase \"ImagenDTO\""
				+ " no corresponde al valor enviado como argumento.", extension, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ImagenDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ImagenDTO dto = new ImagenDTO();
		
		dto.setId(300L);
		dto.setTipo(Tipo.IMAGEN);
		dto.setCodigo("CODIGO");
		dto.setContenido("CONTENIDO");
		dto.setPathImagen("PATH_IMAGEN");
		dto.setPathThumbnail("PATH_THUMBNAIL");
		dto.setAltura(300);
		dto.setAncho(300);
		dto.setTamanio(300L);
		dto.setRepo("REPO");
		dto.setExtension("EXTENSION");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ImagenDTO\".", tmp);
	}
}
