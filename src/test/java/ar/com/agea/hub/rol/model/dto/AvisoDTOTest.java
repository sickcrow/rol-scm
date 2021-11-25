/*
 * @(#)AvisoDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.AvisoDTO.Tipo;

/**
 * Representa JUnit Tests de inicializaci�n para la clase AvisoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class AvisoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo AvisoDTO.
	 */
	@Test
	public void testConstructor() {
		AvisoDTO dto = new AvisoDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"AvisoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		AvisoDTO dto = new AvisoDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTipo y getTipo de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetTipoMethod() {
		AvisoDTO dto = new AvisoDTO();
		Tipo tipo = Tipo.LINEAL;
		
		dto.setTipo(tipo);
		
		Tipo tmp = dto.getTipo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipo\" o \"getTipo\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipo\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", tipo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFechaPedidoPublicacion y getFechaPedidoPublicacion de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetFechaPedidoPublicacionMethod() {
		AvisoDTO dto = new AvisoDTO();
		Date fechaPedidoPublicacion = null;
		
		dto.setFechaPedidoPublicacion(fechaPedidoPublicacion);
		
		Date tmp = dto.getFechaPedidoPublicacion();
		
		Assert.assertNull("Ha fallado la llamada al m�todo \"setFechaPedidoPublicacion\" o \"getFechaPedidoPublicacion\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaPedidoPublicacion\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaPedidoPublicacion, tmp);
		
		fechaPedidoPublicacion = new Date();
		
		dto.setFechaPedidoPublicacion(fechaPedidoPublicacion);
		
		tmp = dto.getFechaPedidoPublicacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFechaPedidoPublicacion\" o \"getFechaPedidoPublicacion\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaPedidoPublicacion\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaPedidoPublicacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIncompleto y getIncompleto de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetIncompletoMethod() {
		AvisoDTO dto = new AvisoDTO();
		Boolean incompleto = true;
		
		dto.setIncompleto(incompleto);
		
		Boolean tmp = dto.getIncompleto();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIncompleto\" o \"getIncompleto\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIncompleto\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", incompleto, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setBloqueado y getBloqueado de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetBloqueadoMethod() {
		AvisoDTO dto = new AvisoDTO();
		Boolean bloqueado = true;
		
		dto.setBloqueado(bloqueado);
		
		Boolean tmp = dto.getBloqueado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setBloqueado\" o \"getBloqueado\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getBloqueado\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", bloqueado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFacturable y getFacturable de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetFacturableMethod() {
		AvisoDTO dto = new AvisoDTO();
		Boolean facturable = true;
		
		dto.setFacturable(facturable);
		
		Boolean tmp = dto.getFacturable();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFacturable\" o \"getFacturable\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFacturable\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", facturable, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTextoLibre y getTextoLibre de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetTextoLibreMethod() {
		AvisoDTO dto = new AvisoDTO();
		String textoLibre = "TEXTO_LIBRE";
		
		dto.setTextoLibre(textoLibre);
		
		String tmp = dto.getTextoLibre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTextoLibre\" o \"getTextoLibre\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTextoLibre\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", textoLibre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTextoLibreTemplate y getTextoLibreTemplate de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetTextoLibreTemplateMethod() {
		AvisoDTO dto = new AvisoDTO();
		String textoLibreTemplate = "TEXTO_LIBRE_TEMPLATE";
		
		dto.setTextoLibreTemplate(textoLibreTemplate);
		
		String tmp = dto.getTextoLibreTemplate();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTextoLibreTemplate\" o \"getTextoLibreTemplate\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTextoLibreTemplate\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", textoLibreTemplate, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setEstado y getEstado de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetEstadoMethod() {
		AvisoDTO dto = new AvisoDTO();
		String estado = "ESTADO";
		
		dto.setEstado(estado);
		
		String tmp = dto.getEstado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setEstado\" o \"getEstado\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getEstado\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", estado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAcciones y getAcciones de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetAccionesMethod() {
		AvisoDTO dto = new AvisoDTO();
		List<AccionSecuenciaDTO> acciones = new ArrayList<AccionSecuenciaDTO>();
		
		dto.setAcciones(acciones);
		
		List<AccionSecuenciaDTO> tmp = dto.getAcciones();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAcciones\" o \"getAcciones\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAcciones\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", acciones, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTipoOperacion y getTipoOperacion de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetTipoOperacionMethod() {
		AvisoDTO dto = new AvisoDTO();
		TipoOperacionDTO tipoOperacion = new TipoOperacionDTO();
		
		dto.setTipoOperacion(tipoOperacion);
		
		TipoOperacionDTO tmp = dto.getTipoOperacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipoOperacion\" o \"getTipoOperacion\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipoOperacion\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", tipoOperacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setProductoComercial y getProductoComercial de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetProductoComercialMethod() {
		AvisoDTO dto = new AvisoDTO();
		ProductoComercialDTO productoComercial = new ProductoComercialDTO();
		
		dto.setProductoComercial(productoComercial);
		
		ProductoComercialDTO tmp = dto.getProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setProductoComercial\" o \"getProductoComercial\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getProductoComercial\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", productoComercial, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPromociones y getPromociones de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetPromocionesMethod() {
		AvisoDTO dto = new AvisoDTO();
		List<AvisoPromocionDTO> avisosPromocion = new ArrayList<AvisoPromocionDTO>();
		
		dto.setAvisoPromocion(avisosPromocion);
		
		List<AvisoPromocionDTO> tmp = dto.getAvisoPromocion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPromociones\" o \"getPromociones\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPromociones\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", avisosPromocion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTemplateDetallado y getTemplateDetallado de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetTemplateDetalladoMethod() {
		AvisoDTO dto = new AvisoDTO();
		TemplateDetalladoDTO templateDetallado = new TemplateDetalladoDTO();
		
		dto.setTemplateDetallado(templateDetallado);
		
		TemplateDetalladoDTO tmp = dto.getTemplateDetallado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTemplateDetallado\" o \"getTemplateDetallado\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTemplateDetallado\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", templateDetallado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMateriales y getMateriales de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetMaterialesMethod() {
		AvisoDTO dto = new AvisoDTO();
		List<ImagenDTO> materiales = new ArrayList<ImagenDTO>();
		
		dto.setMateriales(materiales);
		
		List<ImagenDTO> tmp = dto.getMateriales();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMateriales\" o \"getMateriales\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMateriales\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", materiales, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoClase y getCodigoClase de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClaseMethod() {
		AvisoDTO dto = new AvisoDTO();
		String codigoClase = "CODIGO_CLASE";
		
		dto.setCodigoClase(codigoClase);
		
		String tmp = dto.getCodigoClase();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoClase\" o \"getCodigoClase\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoClase\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoClase, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAtributosAviso y getAtributosAviso de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetAtributosAvisoMethod() {
		AvisoDTO dto = new AvisoDTO();
		List<AtributoAvisoDTO> atributosAviso = new ArrayList<AtributoAvisoDTO>();
		
		dto.setAtributosAviso(atributosAviso);
		
		List<AtributoAvisoDTO> tmp = dto.getAtributosAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAtributosAviso\" o \"getAtributosAviso\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAtributosAviso\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", atributosAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNivelEstructura y getNivelEstructura de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetNivelEstructuraMethod() {
		AvisoDTO dto = new AvisoDTO();
		NivelEstructuraDTO nivelEstructura = new NivelEstructuraDTO();
		
		dto.setNivelEstructura(nivelEstructura);
		
		NivelEstructuraDTO tmp = dto.getNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNivelEstructura\" o \"getNivelEstructura\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNivelEstructura\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", nivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setLineasPublicadas y getLineasPublicadas de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetLineasPublicadasMethod() {
		AvisoDTO dto = new AvisoDTO();
		Integer lineasPublicadas = 300;
		
		dto.setLineasPublicadas(lineasPublicadas);
		
		Integer tmp = dto.getLineasPublicadas();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setLineasPublicadas\" o \"getLineasPublicadas\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getLineasPublicadas\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", lineasPublicadas, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setLineasFacturadas y getLineasFacturadas de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetLineasfacturadasMethod() {
		AvisoDTO dto = new AvisoDTO();
		Double lineasFacturadas = 300.0;
		
		dto.setLineasFacturadas(lineasFacturadas);
		
		Double tmp = dto.getLineasFacturadas();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setLineasFacturadas\" o \"getLineasFacturadas\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getLineasFacturadas\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", lineasFacturadas, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTextoJustificado y getTextoJustificado de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetTextoJustificadoMethod() {
		AvisoDTO dto = new AvisoDTO();
		String textoJustificado = "TEXTO_JUSTIFICADO";
		
		dto.setTextoJustificado(textoJustificado);
		
		String tmp = dto.getTextoJustificado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTextoJustificado\" o \"getTextoJustificado\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTextoJustificado\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", textoJustificado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTextoLibreJustificado y getTextoLibreJustificado de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetTextoLibreJustificadoMethod() {
		AvisoDTO dto = new AvisoDTO();
		String textoLibreJustificado = "TEXTO_LIBRE_JUSTIFICADO";
		
		dto.setTextoLibreJustificado(textoLibreJustificado);
		
		String tmp = dto.getTextoLibreJustificado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTextoLibreJustificado\" o \"getTextoLibreJustificado\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTextoLibreJustificado\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", textoLibreJustificado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAvisoRepublicado y getAvisoRepublicado de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetAvisoRepublicadoMethod() {
		AvisoDTO dto = new AvisoDTO();
		Long avisoRepublicado = 300L;
		
		dto.setAvisoRepublicado(avisoRepublicado);
		
		Long tmp = dto.getAvisoRepublicado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAvisoRepublicado\" o \"getAvisoRepublicado\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAvisoRepublicado\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", avisoRepublicado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIdNUP y getIdNUP de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdNUPMethod() {
		AvisoDTO dto = new AvisoDTO();
		String idNUP = "ID_NUP";
		
		dto.setIdNUP(idNUP);
		
		String tmp = dto.getIdNUP();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIdNUP\" o \"getIdNUP\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIdNUP\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", idNUP, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPreview y getPreview de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetPreviewMethod() {
		AvisoDTO dto = new AvisoDTO();
		ImagenDTO preview = new ImagenDTO();
		
		dto.setPreview(preview);
		
		ImagenDTO tmp = dto.getPreview();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPreview\" o \"getPreview\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPreview\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", preview, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAltoPuntosTipograficos y getAltoPuntosTipograficos de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetAltoPuntosTipograficosMethod() {
		AvisoDTO dto = new AvisoDTO();
		Float altoPuntosTipograficos = 300F;
		
		dto.setAltoPuntosTipograficos(altoPuntosTipograficos);
		
		Float tmp = dto.getAltoPuntosTipograficos();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAltoPuntosTipograficos\" o \"getAltoPuntosTipograficos\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAltoPuntosTipograficos\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", altoPuntosTipograficos, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setZonasComercializacion y getZonasComercializacion de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetZonasComercializacionMethod() {
		AvisoDTO dto = new AvisoDTO();
		List<ZonaComercializacionDTO> zonasComercializacion = new ArrayList<ZonaComercializacionDTO>();
		
		dto.setZonasComercializacion(zonasComercializacion);
		
		List<ZonaComercializacionDTO> tmp = dto.getZonasComercializacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setZonasComercializacion\" o \"getZonasComercializacion\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getZonasComercializacion\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", zonasComercializacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setOrdenamientos y getOrdenamientos de la clase AvisoDTO. 
	 */
	@Test
	public void testSetAndGetOrdenamientosMethod() {
		AvisoDTO dto = new AvisoDTO();
		List<OrdenamientoAvisoValorizadoDTO> ordenamientos = new ArrayList<OrdenamientoAvisoValorizadoDTO>();
		
		dto.setOrdenamientos(ordenamientos);
		
		List<OrdenamientoAvisoValorizadoDTO> tmp = dto.getOrdenamientos();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setOrdenamientos\" o \"getOrdenamientos\" de la clase \"AvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getOrdenamientos\" de la clase \"AvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", ordenamientos, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase AvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		AvisoDTO dto = new AvisoDTO();
		
		List<AccionSecuenciaDTO> accionesSecuencia = new ArrayList<AccionSecuenciaDTO>();
		accionesSecuencia.add(new AccionSecuenciaDTO());
		accionesSecuencia.add(new AccionSecuenciaDTO());
		accionesSecuencia.add(new AccionSecuenciaDTO());
		
		List<AvisoPromocionDTO> avisosPromocion = new ArrayList<AvisoPromocionDTO>();
		avisosPromocion.add(new AvisoPromocionDTO());
		avisosPromocion.add(new AvisoPromocionDTO());
		avisosPromocion.add(new AvisoPromocionDTO());
		
		List<ImagenDTO> imagenes = new ArrayList<ImagenDTO>();
		imagenes.add(new ImagenDTO());
		imagenes.add(new ImagenDTO());
		imagenes.add(new ImagenDTO());
		
		List<AtributoAvisoDTO> atributosAviso = new ArrayList<AtributoAvisoDTO>();
		atributosAviso.add(new AtributoAvisoDTO());
		atributosAviso.add(new AtributoAvisoDTO());
		atributosAviso.add(new AtributoAvisoDTO());
		
		List<ZonaComercializacionDTO> zonasComercializacion = new ArrayList<ZonaComercializacionDTO>();
		zonasComercializacion.add(new ZonaComercializacionDTO());
		zonasComercializacion.add(new ZonaComercializacionDTO());
		zonasComercializacion.add(new ZonaComercializacionDTO());
		
		List<OrdenamientoAvisoValorizadoDTO> ordenamientosAvisoValorizado = new ArrayList<OrdenamientoAvisoValorizadoDTO>();
		ordenamientosAvisoValorizado.add(new OrdenamientoAvisoValorizadoDTO());
		ordenamientosAvisoValorizado.add(new OrdenamientoAvisoValorizadoDTO());
		ordenamientosAvisoValorizado.add(new OrdenamientoAvisoValorizadoDTO());
		
		dto.setId(300L);
		dto.setTipo(Tipo.LINEAL);
		dto.setFechaPedidoPublicacion(new Date());
		dto.setIncompleto(true);
		dto.setBloqueado(true);
		dto.setFacturable(true);
		dto.setTextoLibre("TEXTO_LIBRE");
		dto.setTextoLibreTemplate("TEXTO_LIBRE_TEMPLATE");
		dto.setEstado("ESTADO");
		dto.setAcciones(accionesSecuencia);
		dto.setTipoOperacion(new TipoOperacionDTO());
		dto.setProductoComercial(new ProductoComercialDTO());
		dto.setAvisoPromocion(avisosPromocion);
		dto.setTemplateDetallado(new TemplateDetalladoDTO());
		dto.setMateriales(imagenes);
		dto.setCodigoClase("CODIGO_CLASE");
		dto.setAtributosAviso(atributosAviso);
		dto.setNivelEstructura(new NivelEstructuraDTO());
		dto.setLineasPublicadas(300);
		dto.setLineasFacturadas(300.0);
		dto.setTextoJustificado("TEXTO_JUSTIFICADO");
		dto.setTextoLibreJustificado("TEXTO_LIBRE_JUSTIFICADO");
		dto.setAvisoRepublicado(300L);
		dto.setIdNUP("ID_NUP");
		dto.setPreview(new ImagenDTO());
		dto.setAltoPuntosTipograficos(300.0F);
		dto.setZonasComercializacion(zonasComercializacion);
		dto.setOrdenamientos(ordenamientosAvisoValorizado);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"AvisoDTO\".", tmp);
	}
}
