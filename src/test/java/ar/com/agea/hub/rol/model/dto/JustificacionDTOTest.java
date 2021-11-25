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
 * Representa JUnit Tests de inicializaci�n para la clase JustificacionDTO.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 06/06/2013
 */
public class JustificacionDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo JustificacionDTO.
	 */
	@Test
	public void testConstructor() {
		JustificacionDTO dto = new JustificacionDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"JustificacionDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProducto y getCodigoProducto de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String codigoProducto = "CODIGO_PRODUCTO";
		
		dto.setCodigoProducto(codigoProducto);
		
		String tmp = dto.getCodigoProducto();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProducto\" o \"getCodigoProducto\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProducto\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProducto, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProductoComercial y getCodigoProductoComercial de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoComercialMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String codigoProductoComercial = "CODIGO_PRODUCTO_COMERCIAL";
		
		dto.setCodigoProductoComercial(codigoProductoComercial);
		
		String tmp = dto.getCodigoProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProductoComercial\" o \"getCodigoProductoComercial\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProductoComercial\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProductoComercial, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoNivelEstructuraMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoNivelEstructura\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoTemplateDetallado y getCodigoTemplateDetallado de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTemplateDetalladoMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String codigoTemplateDetallado = "CODIGO_TEMPLATE_DETALLADO";
		
		dto.setCodigoTemplateDetallado(codigoTemplateDetallado);
		
		String tmp = dto.getCodigoTemplateDetallado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoTemplateDetallado\" o \"getCodigoTemplateDetallado\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoTemplateDetallado\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTemplateDetallado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setOrdenamientos y getOrdenamientos de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetOrdenamientosMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		List<OrdenamientoAvisoValorizadoDTO> ordenamientos = new ArrayList<OrdenamientoAvisoValorizadoDTO>();
		
		dto.setOrdenamientos(ordenamientos);
		
		List<OrdenamientoAvisoValorizadoDTO> tmp = dto.getOrdenamientos();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setOrdenamientos\" o \"getOrdenamientos\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getOrdenamientos\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", ordenamientos, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setImagen y getImagen de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetImagenMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String imagen = "IMAGEN";
		
		dto.setImagen(imagen);
		
		String tmp = dto.getImagen();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setImagen\" o \"getImagen\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getImagen\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", imagen, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCantidadLineas y getCantidadLineas de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCantidadLineasMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		Double cantidadLineas = 300.0;
		
		dto.setCantidadLineas(cantidadLineas);
		
		Double tmp = dto.getCantidadLineas();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCantidadLineas\" o \"getCantidadLineas\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCantidadLineas\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", cantidadLineas, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCantidadLineasPublicadas y getCantidadLineasPublicadas de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetCantidadLineasPublicadasMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		Integer cantidadLineasPublicadas = 300;
		
		dto.setCantidadLineasPublicadas(cantidadLineasPublicadas);
		
		Integer tmp = dto.getCantidadLineasPublicadas();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCantidadLineasPublicadas\" o \"getCantidadLineasPublicadas\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCantidadLineasPublicadas\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", cantidadLineasPublicadas, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTextoJustificado y getTextoJustificado de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetTextoJustificadoMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String textoJustificado = "TEXTO_JUSTIFICADO";
		
		dto.setTextoJustificado(textoJustificado);
		
		String tmp = dto.getTextoJustificado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTextoJustificado\" o \"getTextoJustificado\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTextoJustificado\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", textoJustificado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAlturaEstandar y getAlturaEstandar de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetAlturaEstandarMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		Float alturaEstandar = 300.0F;
		
		dto.setAlturaEstandar(alturaEstandar);
		
		Float tmp = dto.getAlturaEstandar();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAlturaEstandar\" o \"getAlturaEstandar\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAlturaEstandar\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", alturaEstandar, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPuntosLibres y getPuntosLibres de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetPuntosLibresMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		Double puntosLibres = 300.0;
		
		dto.setPuntosLibres(puntosLibres);
		
		Double tmp = dto.getPuntosLibres();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPuntosLibres\" o \"getPuntosLibres\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPuntosLibres\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", puntosLibres, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTextoLibre y getTextoLibre de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetTextoLibreMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String textoLibre = "TEXTO_LIBRE";
		
		dto.setTextoLibre(textoLibre);
		
		String tmp = dto.getTextoLibre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTextoLibre\" o \"getTextoLibre\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTextoLibre\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", textoLibre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTextoLibreJustificado y getTextoLibreJustificado de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetTextoLibreJustificadoMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String textoLibreJustificado = "TEXTO_LIBRE_JUSTIFICADO";
		
		dto.setTextoLibreJustificado(textoLibreJustificado);
		
		String tmp = dto.getTextoLibreJustificado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTextoLibreJustificado\" o \"getTextoLibreJustificado\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTextoLibreJustificado\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", textoLibreJustificado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNombreImagen y getNombreImagen de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetNombreImagenMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String nombreImagen = "NOMBRE_IMAGEN";
		
		dto.setNombreImagen(nombreImagen);
		
		String tmp = dto.getNombreImagen();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNombreImagen\" o \"getNombreImagen\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNombreImagen\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", nombreImagen, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNombreLibreriaImagen y getNombreLibreriaImagen de la clase JustificacionDTO. 
	 */
	@Test
	public void testSetAndGetNombreLibreriaImagenMethod() {
		JustificacionDTO dto = new JustificacionDTO();
		String nombreLibreriaImagen = "NOMBRE_IMAGEN";
		
		dto.setNombreLibreriaImagen(nombreLibreriaImagen);
		
		String tmp = dto.getNombreLibreriaImagen();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNombreLibreriaImagen\" o \"getNombreLibreriaImagen\" de la clase \"JustificacionDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNombreLibreriaImagen\" de la clase \"JustificacionDTO\""
				+ " no corresponde al valor enviado como argumento.", nombreLibreriaImagen, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase JustificacionDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"JustificacionDTO\".", tmp);
	}
}
