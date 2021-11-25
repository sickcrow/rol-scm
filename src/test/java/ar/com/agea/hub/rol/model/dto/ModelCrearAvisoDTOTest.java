/*
 * @(#)ModelCrearAvisoDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ModelCrearAvisoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ModelCrearAvisoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ModelCrearAvisoDTO.
	 */
	@Test
	public void testConstructor() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ModelCrearAvisoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setRedirectURL y getRedirectURL de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetRedirectURLMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String redirectURL = "REDIRECT_URL";
		
		dto.setRedirectURL(redirectURL);
		
		String tmp = dto.getRedirectURL();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setRedirectURL\" o \"getRedirectURL\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getRedirectURL\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", redirectURL, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setOrdenPublicacion y getOrdenPublicacion de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetOrdenPublicacionMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		OrdenPublicacionDTO ordenPublicacion = new OrdenPublicacionDTO();
		
		dto.setOrdenPublicacion(ordenPublicacion);
		
		OrdenPublicacionDTO tmp = dto.getOrdenPublicacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setOrdenPublicacion\" o \"getOrdenPublicacion\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getOrdenPublicacion\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", ordenPublicacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setStep y getStep de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetStepMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		Long step = 300L;
		
		dto.setStep(step);
		
		Long tmp = dto.getStep();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setStep\" o \"getStep\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getStep\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", step, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoNivelEstructuraMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoNivelEstructura\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoAgrupamientoProductoTecnico y getCodigoAgrupamientoProductoTecnico de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAgrupamientoProductoTecnicoMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String codigoAgrupamientoProductoTecnico = "CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO";
		
		dto.setCodigoAgrupamientoProductoTecnico(codigoAgrupamientoProductoTecnico);
		
		String tmp = dto.getCodigoAgrupamientoProductoTecnico();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoAgrupamientoProductoTecnico\" o \"getCodigoAgrupamientoProductoTecnico\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoAgrupamientoProductoTecnico\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAgrupamientoProductoTecnico, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTipoOperacion y getTipoOperacion de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetTipoOperacionMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		TipoOperacionDTO tipoOperacion = new TipoOperacionDTO();
		
		dto.setTipoOperacion(tipoOperacion);
		
		TipoOperacionDTO tmp = dto.getTipoOperacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipoOperacion\" o \"getTipoOperacion\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipoOperacion\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", tipoOperacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProducto y getCodigoProducto de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String codigoProducto = "CODIGO_PRODUCTO";
		
		dto.setCodigoProducto(codigoProducto);
		
		String tmp = dto.getCodigoProducto();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProducto\" o \"getCodigoProducto\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProducto\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProducto, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProductoComercial y getCodigoProductoComercial de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoComercialMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String codigoProductoComercial = "CODIGO_PRODUCTO_COMERCIAL";
		
		dto.setCodigoProductoComercial(codigoProductoComercial);
		
		String tmp = dto.getCodigoProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProductoComercial\" o \"getCodigoProductoComercial\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProductoComercial\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProductoComercial, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoTemplateDetallado y getCodigoTemplateDetallado de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTemplateDetalladoMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String codigoTemplateDetallado = "CODIGO_TEMPLATE_DETALLADO";
		
		dto.setCodigoTemplateDetallado(codigoTemplateDetallado);
		
		String tmp = dto.getCodigoTemplateDetallado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoTemplateDetallado\" o \"getCodigoTemplateDetallado\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoTemplateDetallado\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTemplateDetallado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFamilia y getFamilia de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetFamiliaMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		ClaseDTO familia = new ClaseDTO();
		
		dto.setFamilia(familia);
		
		ClaseDTO tmp = dto.getFamilia();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFamilia\" o \"getFamilia\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFamilia\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", familia, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setClase y getClase de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetClaseMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		ClaseDTO clase = new ClaseDTO();
		
		dto.setClase(clase);
		
		ClaseDTO tmp = dto.getClase();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setClase\" o \"getClase\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getClase\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", clase, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setZonasComercializacion y getZonasComercializacion de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetZonasComercializacionMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		List<ZonaComercializacionDTO> zonasComercializacion = new ArrayList<ZonaComercializacionDTO>();
		
		dto.setZonasComercializacion(zonasComercializacion);
		
		List<ZonaComercializacionDTO> tmp = dto.getZonasComercializacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setZonasComercializacion\" o \"getZonasComercializacion\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getZonasComercializacion\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", zonasComercializacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setSelectedDates y getSelectedDates de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetSelectedDatesMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		List<Date> selectedDates = new ArrayList<Date>();
		
		dto.setSelectedDates(selectedDates);
		
		List<Date> tmp = dto.getSelectedDates();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setSelectedDates\" o \"getSelectedDates\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getSelectedDates\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", selectedDates, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMapItemsOrdenamientoCombo y getMapItemsOrdenamientoCombo de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetMapItemsOrdenamientoComboMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		Map<String, List<ItemOrdenamientoAvisoDTO>> mapItemsOrdenamientoCombo = new HashMap<String, List<ItemOrdenamientoAvisoDTO>>();
		
		dto.setMapItemsOrdenamientoCombo(mapItemsOrdenamientoCombo);
		
		Map<String, List<ItemOrdenamientoAvisoDTO>> tmp = dto.getMapItemsOrdenamientoCombo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMapItemsOrdenamientoCombo\" o \"getMapItemsOrdenamientoCombo\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMapItemsOrdenamientoCombo\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", mapItemsOrdenamientoCombo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPalabrasProhibidas y getPalabrasProhibidas de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetPalabrasProhibidasMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		List<String> palabrasProhibidas = new ArrayList<String>();
		
		dto.setPalabrasProhibidas(palabrasProhibidas);
		
		List<String> tmp = dto.getPalabrasProhibidas();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPalabrasProhibidas\" o \"getPalabrasProhibidas\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPalabrasProhibidas\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", palabrasProhibidas, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setOrdenamientos y getOrdenamientos de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetOrdenamientosMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		List<OrdenamientoAvisoValorizadoDTO> ordenamientos = new ArrayList<OrdenamientoAvisoValorizadoDTO>();
		
		dto.setOrdenamientos(ordenamientos);
		
		List<OrdenamientoAvisoValorizadoDTO> tmp = dto.getOrdenamientos();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setOrdenamientos\" o \"getOrdenamientos\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getOrdenamientos\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", ordenamientos, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setConfiguracionOrdenamientoPantalla y getConfiguracionOrdenamientoPantalla de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetConfiguracionOrdenamientoPantallaMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		List<ConfiguracionOrdenamientoPantallaDTO> configuracionOrdenamientoPantalla = new ArrayList<ConfiguracionOrdenamientoPantallaDTO>();
		
		dto.setConfiguracionOrdenamientoPantalla(configuracionOrdenamientoPantalla);
		
		List<ConfiguracionOrdenamientoPantallaDTO> tmp = dto.getConfiguracionOrdenamientoPantalla();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setConfiguracionOrdenamientoPantalla\" o \"getConfiguracionOrdenamientoPantalla\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getConfiguracionOrdenamientoPantalla\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", configuracionOrdenamientoPantalla, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPrevisualizo y getPrevisualizo de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetPrevisualizoMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		Boolean previsualizo = true;
		
		dto.setPrevisualizo(previsualizo);
		
		Boolean tmp = dto.getPrevisualizo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPrevisualizo\" o \"getPrevisualizo\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPrevisualizo\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", previsualizo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTemplatesDetallado y getTemplatesDetallado de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetTemplatesDetalladoMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		List<ProductoComercialTemplateDTO> templatesDetallado = new ArrayList<ProductoComercialTemplateDTO>();
		
		dto.setTemplatesDetallado(templatesDetallado);
		
		List<ProductoComercialTemplateDTO> tmp = dto.getTemplatesDetallado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTemplatesDetallado\" o \"getTemplatesDetallado\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTemplatesDetallado\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", templatesDetallado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setOrdenDepublicacionHistory y getOrdenDepublicacionHistory de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetOrdenDepublicacionHistoryMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		OrdenPublicacionDTO ordenDepublicacionHistory = new OrdenPublicacionDTO();
		
		dto.setOrdenDepublicacionHistory(ordenDepublicacionHistory);
		
		OrdenPublicacionDTO tmp = dto.getOrdenDepublicacionHistory();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setOrdenDepublicacionHistory\" o \"getOrdenDepublicacionHistory\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getOrdenDepublicacionHistory\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", ordenDepublicacionHistory, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoTemplateDestaqueSeleccionado y getCodigoTemplateDestaqueSeleccionado de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTemplateDestaqueSeleccionadoMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String codigoTemplateDestaqueSeleccionado = "CODIGO_TEMPLATE_DESTAQUE_SELECCIONADO";
		
		dto.setCodigoTemplateDestaqueSeleccionado(codigoTemplateDestaqueSeleccionado);
		
		String tmp = dto.getCodigoTemplateDestaqueSeleccionado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoTemplateDestaqueSeleccionado\" o \"getCodigoTemplateDestaqueSeleccionado\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoTemplateDestaqueSeleccionado\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTemplateDestaqueSeleccionado, tmp);
	}
	
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoImagenDestaqueSeleccionada y getCodigoImagenDestaqueSeleccionada de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoImagenDestaqueSeleccionadaMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String codigoImagenDestaqueSeleccionada = "CODIGO_IMAGEN_DESTAQUE_SELECCIONADA";
		
		dto.setCodigoImagenDestaqueSeleccionada(codigoImagenDestaqueSeleccionada);
		
		String tmp = dto.getCodigoImagenDestaqueSeleccionada();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoImagenDestaqueSeleccionada\" o \"getCodigoImagenDestaqueSeleccionada\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoImagenDestaqueSeleccionada\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoImagenDestaqueSeleccionada, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setRepoImagenDestaqueSeleccionada y getRepoImagenDestaqueSeleccionada de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetRepoImagenDestaqueSeleccionadaMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String repoImagenDestaqueSeleccionada = "REPO_IMAGEN_DESTAQUE_SELECCIONADA";
		
		dto.setRepoImagenDestaqueSeleccionada(repoImagenDestaqueSeleccionada);
		
		String tmp = dto.getRepoImagenDestaqueSeleccionada();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setRepoImagenDestaqueSeleccionada\" o \"getRepoImagenDestaqueSeleccionada\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getRepoImagenDestaqueSeleccionada\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", repoImagenDestaqueSeleccionada, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProductoComercialDestaque y getCodigoProductoComercialDestaque de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoComercialDestaqueMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		String codigoProductoComercialDestaque = "REPO_IMAGEN_DESTAQUE_SELECCIONADA";
		
		dto.setCodigoProductoComercialDestaque(codigoProductoComercialDestaque);
		
		String tmp = dto.getCodigoProductoComercialDestaque();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProductoComercialDestaque\" o \"getCodigoProductoComercialDestaque\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProductoComercialDestaque\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProductoComercialDestaque, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setConfiguracionesPromocionPantalla y getConfiguracionesPromocionPantalla de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetConfiguracionesPromocionPantallaMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		List<ConfiguracionPromocionPantallaDTO> configuracionesPromocionPantalla = new ArrayList<ConfiguracionPromocionPantallaDTO>();
		
		dto.setConfiguracionesPromocionPantalla(configuracionesPromocionPantalla);
		
		List<ConfiguracionPromocionPantallaDTO> tmp = dto.getConfiguracionesPromocionPantalla();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setConfiguracionesPromocionPantalla\" o \"getConfiguracionesPromocionPantalla\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getConfiguracionesPromocionPantalla\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", configuracionesPromocionPantalla, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAgrupadoresAtributoAviso y getAgrupadoresAtributoAviso de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetAgrupadoresAtributoAvisoMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		List<AgrupadorAtributoAvisoDTO> agrupadoresAtributoAviso = new ArrayList<AgrupadorAtributoAvisoDTO>();
		
		dto.setAgrupadoresAtributoAviso(agrupadoresAtributoAviso);
		
		List<AgrupadorAtributoAvisoDTO> tmp = dto.getAgrupadoresAtributoAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAgrupadoresAtributoAviso\" o \"getAgrupadoresAtributoAviso\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAgrupadoresAtributoAviso\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", agrupadoresAtributoAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPromociones y getPromociones de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testSetAndGetPromocionesMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();
		List<PromocionDTO> promociones = new ArrayList<PromocionDTO>();
		
		dto.setPromociones(promociones);
		
		List<PromocionDTO> tmp = dto.getPromociones();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPromociones\" o \"getPromociones\" de la clase \"ModelCrearAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPromociones\" de la clase \"ModelCrearAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", promociones, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ModelCrearAvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ModelCrearAvisoDTO dto = new ModelCrearAvisoDTO();

		List<ZonaComercializacionDTO> zonasComercializacion = new ArrayList<ZonaComercializacionDTO>();
		zonasComercializacion.add(new ZonaComercializacionDTO());
		zonasComercializacion.add(new ZonaComercializacionDTO());
		zonasComercializacion.add(new ZonaComercializacionDTO());
		
		List<Date> selectedDates = new ArrayList<Date>();
		selectedDates.add(new Date());
		selectedDates.add(new Date());
		selectedDates.add(new Date());
		
		Map<String, List<ItemOrdenamientoAvisoDTO>> itemsOrdenamientoCombo = new HashMap<String, List<ItemOrdenamientoAvisoDTO>>();
		
		List<ItemOrdenamientoAvisoDTO> itemsOrdenamientoAviso = new ArrayList<ItemOrdenamientoAvisoDTO>();
		itemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		itemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		itemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		
		List<ItemOrdenamientoAvisoDTO> anotherTtemsOrdenamientoAviso = new ArrayList<ItemOrdenamientoAvisoDTO>();
		anotherTtemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		anotherTtemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		anotherTtemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		
		List<ItemOrdenamientoAvisoDTO> unknownItemsOrdenamientoAviso = new ArrayList<ItemOrdenamientoAvisoDTO>();
		unknownItemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		unknownItemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		unknownItemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		
		itemsOrdenamientoCombo.put("ITEM_ORDENAMIENTO_AVISO", itemsOrdenamientoAviso);
		itemsOrdenamientoCombo.put("ANOTHER_ITEM_ORDENAMIENTO_AVISO", anotherTtemsOrdenamientoAviso);
		itemsOrdenamientoCombo.put("UNKNOWN_ITEM_ORDENAMIENTO_AVISO", unknownItemsOrdenamientoAviso);
		
		List<String> palabrasProhibidas = new ArrayList<String>();
		palabrasProhibidas.add("PALABRA_PROHIBIDA");
		palabrasProhibidas.add("ANOTHER_PALABRA_PROHIBIDA");
		palabrasProhibidas.add("UNKNOWN_PALABRA_PROHIBIDA");
		
		List<OrdenamientoAvisoValorizadoDTO> ordenamientos = new ArrayList<OrdenamientoAvisoValorizadoDTO>();
		ordenamientos.add(new OrdenamientoAvisoValorizadoDTO());
		ordenamientos.add(new OrdenamientoAvisoValorizadoDTO());
		ordenamientos.add(new OrdenamientoAvisoValorizadoDTO());
		
		List<ConfiguracionOrdenamientoPantallaDTO> configuracionesOrdenamientoPantalla = new ArrayList<ConfiguracionOrdenamientoPantallaDTO>();
		configuracionesOrdenamientoPantalla.add(new ConfiguracionOrdenamientoPantallaDTO());
		configuracionesOrdenamientoPantalla.add(new ConfiguracionOrdenamientoPantallaDTO());
		configuracionesOrdenamientoPantalla.add(new ConfiguracionOrdenamientoPantallaDTO());
		
		List<ProductoComercialTemplateDTO> productosComercialTemplate = new ArrayList<ProductoComercialTemplateDTO>();
		productosComercialTemplate.add(new ProductoComercialTemplateDTO());
		productosComercialTemplate.add(new ProductoComercialTemplateDTO());
		productosComercialTemplate.add(new ProductoComercialTemplateDTO());
		
		List<ConfiguracionPromocionPantallaDTO> configuracionesPromocionPantalla = new ArrayList<ConfiguracionPromocionPantallaDTO>();
		configuracionesPromocionPantalla.add(new ConfiguracionPromocionPantallaDTO());
		configuracionesPromocionPantalla.add(new ConfiguracionPromocionPantallaDTO());
		configuracionesPromocionPantalla.add(new ConfiguracionPromocionPantallaDTO());
		
		List<AgrupadorAtributoAvisoDTO> agrupadoresAtributoAviso = new ArrayList<AgrupadorAtributoAvisoDTO>();
		agrupadoresAtributoAviso.add(new AgrupadorAtributoAvisoDTO());
		agrupadoresAtributoAviso.add(new AgrupadorAtributoAvisoDTO());
		agrupadoresAtributoAviso.add(new AgrupadorAtributoAvisoDTO());
		
		List<PromocionDTO> promociones = new ArrayList<PromocionDTO>();
		promociones.add(new PromocionDTO());
		promociones.add(new PromocionDTO());
		promociones.add(new PromocionDTO());
		
		dto.setOrdenPublicacion(new OrdenPublicacionDTO());
		dto.setStep(300L);
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setCodigoAgrupamientoProductoTecnico("CODIGO_AGRUPAMIENTO_PRODUCTO_TECNICO");
		dto.setTipoOperacion(new TipoOperacionDTO());
		dto.setCodigoProducto("CODIGO_PRODUCTO");
		dto.setCodigoProductoComercial("CODIGO_PRODUCTO_COMERCIAL");
		dto.setCodigoTemplateDetallado("CODIGO_TEMPLATE_DETALLADO");
		dto.setFamilia(new ClaseDTO());
		dto.setClase(new ClaseDTO()); 
		dto.setZonasComercializacion(zonasComercializacion);
		dto.setSelectedDates(selectedDates);
		dto.setMapItemsOrdenamientoCombo(itemsOrdenamientoCombo);
		dto.setPalabrasProhibidas(palabrasProhibidas);
		dto.setOrdenamientos(ordenamientos);
		dto.setConfiguracionOrdenamientoPantalla(configuracionesOrdenamientoPantalla);
		dto.setPrevisualizo(true);
		dto.setTemplatesDetallado(productosComercialTemplate);
		dto.setOrdenDepublicacionHistory(new OrdenPublicacionDTO());
		dto.setCodigoTemplateDestaqueSeleccionado("CODIGO_TEMPLATE_DESTAQUE_SELECCIONADO");
		dto.setCodigoImagenDestaqueSeleccionada("CODIGO_IMAGEN_DESTAQUESELECCIONADA");
		dto.setRepoImagenDestaqueSeleccionada("REPO_IMAGEN_DESTAQUE_SELECCIONADA");
		dto.setCodigoProductoComercialDestaque("CODIGO_PRODUCTO_COMERCIAL_DESTAQUE");
		dto.setConfiguracionesPromocionPantalla(configuracionesPromocionPantalla);
		dto.setAgrupadoresAtributoAviso(agrupadoresAtributoAviso);
		dto.setPromociones(promociones);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ModelCrearAvisoDTO\".", tmp);
	}
}
