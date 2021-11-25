/*
 * @(#)JustificacionDTOTest.java		1.0 22/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase JustificacionDTO.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 06/06/2013
 */
public class JustificacionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo JustificacionDTO.
	 */
	@Test
	public void testConstructor() {
		JustificacionDTO dto = new JustificacionDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"JustificacionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoProducto y getCodigoProducto de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String codigoProducto = "CODIGO_PRODUCTO";
		
		dto.setCodigoProducto(codigoProducto);
		
		String tmp = dto.getCodigoProducto();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoProducto\" o \"getCodigoProducto\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoProducto\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProducto, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoProductoComercial y getCodigoProductoComercial de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoComercialMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String codigoProductoComercial = "CODIGO_PRODUCTO_COMERCIAL";
		
		dto.setCodigoProductoComercial(codigoProductoComercial);
		
		String tmp = dto.getCodigoProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoProductoComercial\" o \"getCodigoProductoComercial\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoProductoComercial\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProductoComercial, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoNivelEstructuraMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoNivelEstructura\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTemplateDetallado y getCodigoTemplateDetallado de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTemplateDetalladoMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String codigoTemplateDetallado = "CODIGO_TEMPLATE_DETALLADO";
		
		dto.setCodigoTemplateDetallado(codigoTemplateDetallado);
		
		String tmp = dto.getCodigoTemplateDetallado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTemplateDetallado\" o \"getCodigoTemplateDetallado\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTemplateDetallado\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTemplateDetallado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setOrdenamientos y getOrdenamientos de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetOrdenamientosMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		List<OrdenamientoAvisoValorizadoDTO> ordenamientos = new ArrayList<OrdenamientoAvisoValorizadoDTO>();
		
		dto.setOrdenamientos(ordenamientos);
		
		List<OrdenamientoAvisoValorizadoDTO> tmp = dto.getOrdenamientos();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setOrdenamientos\" o \"getOrdenamientos\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getOrdenamientos\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", ordenamientos, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setImagen y getImagen de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetImagenMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String imagen = "IMAGEN";
		
		dto.setImagen(imagen);
		
		String tmp = dto.getImagen();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setImagen\" o \"getImagen\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getImagen\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", imagen, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCantidadLineas y getCantidadLineas de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCantidadLineasMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		Double cantidadLineas = 300.0;
		
		dto.setCantidadLineas(cantidadLineas);
		
		Double tmp = dto.getCantidadLineas();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCantidadLineas\" o \"getCantidadLineas\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCantidadLineas\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", cantidadLineas, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCantidadLineasPublicadas y getCantidadLineasPublicadas de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCantidadLineasPublicadasMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		Integer cantidadLineasPublicadas = 300;
		
		dto.setCantidadLineasPublicadas(cantidadLineasPublicadas);
		
		Integer tmp = dto.getCantidadLineasPublicadas();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCantidadLineasPublicadas\" o \"getCantidadLineasPublicadas\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCantidadLineasPublicadas\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", cantidadLineasPublicadas, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTextoJustificado y getTextoJustificado de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetTextoJustificadoMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String textoJustificado = "TEXTO_JUSTIFICADO";
		
		dto.setTextoJustificado(textoJustificado);
		
		String tmp = dto.getTextoJustificado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTextoJustificado\" o \"getTextoJustificado\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTextoJustificado\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", textoJustificado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setAlturaEstandar y getAlturaEstandar de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetAlturaEstandarMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		Float alturaEstandar = 300.0F;
		
		dto.setAlturaEstandar(alturaEstandar);
		
		Float tmp = dto.getAlturaEstandar();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setAlturaEstandar\" o \"getAlturaEstandar\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getAlturaEstandar\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", alturaEstandar, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPuntosLibres y getPuntosLibres de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetPuntosLibresMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		Double puntosLibres = 300.0;
		
		dto.setPuntosLibres(puntosLibres);
		
		Double tmp = dto.getPuntosLibres();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPuntosLibres\" o \"getPuntosLibres\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPuntosLibres\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", puntosLibres, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTextoLibre y getTextoLibre de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetTextoLibreMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String textoLibre = "TEXTO_LIBRE";
		
		dto.setTextoLibre(textoLibre);
		
		String tmp = dto.getTextoLibre();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTextoLibre\" o \"getTextoLibre\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTextoLibre\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", textoLibre, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setTextoLibreJustificado y getTextoLibreJustificado de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetTextoLibreJustificadoMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String textoLibreJustificado = "TEXTO_LIBRE_JUSTIFICADO";
		
		dto.setTextoLibreJustificado(textoLibreJustificado);
		
		String tmp = dto.getTextoLibreJustificado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTextoLibreJustificado\" o \"getTextoLibreJustificado\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTextoLibreJustificado\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", textoLibreJustificado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNombreImagen y getNombreImagen de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetNombreImagenMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String nombreImagen = "NOMBRE_IMAGEN";
		
		dto.setNombreImagen(nombreImagen);
		
		String tmp = dto.getNombreImagen();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNombreImagen\" o \"getNombreImagen\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNombreImagen\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", nombreImagen, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNombreLibreriaImagen y getNombreLibreriaImagen de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetNombreLibreriaImagenMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String nombreLibreriaImagen = "NOMBRE_IMAGEN";
		
		dto.setNombreLibreriaImagen(nombreLibreriaImagen);
		
		String tmp = dto.getNombreLibreriaImagen();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNombreLibreriaImagen\" o \"getNombreLibreriaImagen\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNombreLibreriaImagen\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", nombreLibreriaImagen, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase JustificacionDTO. 
	 */
	@Test
	public void testToStringMethod() {
		JustificacionDTO dto = new JustificacionDTO();

		List<OrdenamientoAvisoValorizadoDTO> ordenamientosAvisoValorizado = new ArrayList<OrdenamientoAvisoValorizadoDTO>();
		ordenamientosAvisoValorizado.add(new OrdenamientoAvisoValorizadoDTO());
		ordenamientosAvisoValorizado.add(new OrdenamientoAvisoValorizadoDTO());
		ordenamientosAvisoValorizado.add(new OrdenamientoAvisoValorizadoDTO());
		
		dto.setCodigoProducto("CODIGO_PRODUCTO");
		dto.setCodigoProductoComercial("CODIGO_PRODUCTO_COMERCIAL");
		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setCodigoTemplateDetallado("CODIGO_TEMPLATE_DETALLADO");
		dto.setOrdenamientos(ordenamientosAvisoValorizado);
		dto.setImagen("IMAGEN");
		dto.setCantidadLineas(300.0);
		dto.setCantidadLineasPublicadas(300);
		dto.setTextoJustificado("TEXTO_JUSTIFICADO");
		dto.setAlturaEstandar(300.0F);
		dto.setPuntosLibres(300.0);
		dto.setTextoLibre("TEXTO_LIBRE");
		dto.setTextoLibreJustificado("TEXTO_LIBRE_JUSTIFICADO");
		dto.setNombreImagen("NOMBRE_IMAGEN");
		dto.setNombreLibreriaImagen("NOMBRE_LIBRERIA_IMAGEN");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"JustificacionDTO\".", tmp);
	}
}
