/*
 * @(#)ModelCrearAvisoDTO.java		1.0 15/10/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



/**
 * Representa un objeto Data Transfer Object para transferir datos del modelo de crear aviso.
 * <p>
 * Estos objetos son utilizados por front-end y la capa middleware de la aplicación.
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 15/10/2013
 */
public class ModelCrearAvisoDTO extends ModelDTO {

	private static final long serialVersionUID = 106314186476415756L;
		
	private OrdenPublicacionDTO ordenPublicacion;
	private Long step;	
	private String codigoCanalEntrada;
	private String codigoNivelEstructura;
	private String codigoAgrupamientoProductoTecnico;
	private TipoOperacionDTO tipoOperacion;
	private String codigoProducto;
	private String codigoProductoComercial;
	private String codigoTemplateDetallado;
	private ClaseDTO familia;
	private ClaseDTO clase; 
	private List<ZonaComercializacionDTO> zonasComercializacion;
	private List<Date> selectedDates;
			
	// TODO renombrar nombres sin map, porque indica la implementacion.
	private Map<String, List<ItemOrdenamientoAvisoDTO>> mapItemsOrdenamientoCombo;
	private List<String> palabrasProhibidas;
	private List<OrdenamientoAvisoValorizadoDTO> ordenamientos;
	
	// TODO renombrar nombre configuracion por configuraciones, es una lista no un solo objeto.
	private List<ConfiguracionOrdenamientoPantallaDTO> configuracionOrdenamientoPantalla;
	private Boolean previsualizo;
	private List<ProductoComercialTemplateDTO> templatesDetallado;
	private OrdenPublicacionDTO ordenDepublicacionHistory;
	private String codigoTemplateDestaqueSeleccionado;
	private String codigoImagenDestaqueSeleccionada;
	private String repoImagenDestaqueSeleccionada;
	private String codigoProductoComercialDestaque;
	private String codigoNivelEstructuraDestaque;
	
	private Boolean tienePictoSeleccionado;
	private Boolean tieneFondoColor;
	private Boolean tieneMaterial;
	
	private List<ConfiguracionPromocionPantallaDTO> configuracionesPromocionPantalla;
	private List<AgrupadorAtributoAvisoDTO> agrupadoresAtributoAviso;
	private List<PromocionDTO> promociones;
		
	/**
	 * Instancia un objeto de tipo ModelCrearAvisoDTO.
	 */
	public ModelCrearAvisoDTO() {
		zonasComercializacion = new ArrayList<ZonaComercializacionDTO>();
		selectedDates = new ArrayList<Date>();
		mapItemsOrdenamientoCombo = new HashMap<String, List<ItemOrdenamientoAvisoDTO>>();
		palabrasProhibidas = new ArrayList<String>();
		ordenamientos = new ArrayList<OrdenamientoAvisoValorizadoDTO>();
		configuracionOrdenamientoPantalla = new ArrayList<ConfiguracionOrdenamientoPantallaDTO>();
		templatesDetallado = new ArrayList<ProductoComercialTemplateDTO>();
		configuracionesPromocionPantalla = new ArrayList<ConfiguracionPromocionPantallaDTO>();
		agrupadoresAtributoAviso = new ArrayList<AgrupadorAtributoAvisoDTO>();
		promociones = new ArrayList<PromocionDTO>();		
	}	

	/**
	 * Obtiene los objetos configuracion ordenamiento pantalla de este DTO.
	 * 
	 * @return Objetos configuracion ordenamiento pantalla de este DTO.
	 */	
	public List<ConfiguracionOrdenamientoPantallaDTO> getConfiguracionOrdenamientoPantalla() {
		return configuracionOrdenamientoPantalla;
	}
	
	/**
	 * Setea los objetos configuracion ordenamiento pantalla de este DTO.
	 * 
	 * @param configuracionOrdenamientoPantalla Objetos configuracion ordenamiento pantalla de este DTO.
	 */
	public void setConfiguracionOrdenamientoPantalla(
			List<ConfiguracionOrdenamientoPantallaDTO> configuracionOrdenamientoPantalla) {
		this.configuracionOrdenamientoPantalla = configuracionOrdenamientoPantalla;
	}

	/**
	 * Obtiene los objetos ordenamientos aviso valorizados de este DTO.
	 * 
	 * @return Objetos ordenamientos aviso valorizados de este DTO.
	 */	
	public List<OrdenamientoAvisoValorizadoDTO> getOrdenamientos() {
		return ordenamientos;
	}

	/**
	 * Setea los objetos ordenamientos de este DTO.
	 * 
	 * @param ordenamientos Objetos ordenamientos de este DTO.
	 */
	public void setOrdenamientos(List<OrdenamientoAvisoValorizadoDTO> ordenamientos) {
		this.ordenamientos = ordenamientos;
	}

	/**
	 * Obtiene el objeto orden publicacion de este DTO.
	 * 
	 * @return Objeto orden publicacion de este DTO.
	 */	
	public OrdenPublicacionDTO getOrdenPublicacion() {
		return ordenPublicacion;
	}

	/**
	 * Setea el objeto orden publicacion de este DTO.
	 * 
	 * @param ordenPublicacion Objeto orden publicacion de este DTO.
	 */
	public void setOrdenPublicacion(OrdenPublicacionDTO ordenPublicacion) {
		this.ordenPublicacion = ordenPublicacion;
	}

	/**
	 * Obtiene el objeto step de este DTO.
	 * 
	 * @return Objeto step de este DTO.
	 */	
	public Long getStep() {
		return step;
	}

	/**
	 * Setea el objeto step de este DTO.
	 * 
	 * @param step Objeto step de este DTO.
	 */
	public void setStep(Long step) {
		this.step = step;
	}
		
	/**
	 * Obtiene el objeto codigo canal de entrada de este DTO.
	 * 
	 * @return Objeto codigo canal de entrada de este DTO.
	 */	
	public String getCodigoCanalEntrada() {
		return codigoCanalEntrada;
	}

	/**
	 * Setea el objeto código canal entrada de este DTO.
	 * 
	 * @param codigoCanalEntrada Objeto código canal entrada de este DTO.
	 */
	public void setCodigoCanalEntrada(String codigoCanalEntrada) {
		this.codigoCanalEntrada = codigoCanalEntrada;
	}

	/**
	 * Obtiene el objeto codigo nivel estructura de este DTO.
	 * 
	 * @return Objeto codigo nivel estructura de este DTO.
	 */	
	public String getCodigoNivelEstructura() {
		return codigoNivelEstructura;
	}

	/**
	 * Setea el objeto código nivel estructura de este DTO.
	 * 
	 * @param codigoNivelEstructura Objeto código nivel estructura de este DTO.
	 */
	public void setCodigoNivelEstructura(String codigoNivelEstructura) {
		this.codigoNivelEstructura = codigoNivelEstructura;
	}

	/**
	 * Obtiene el objeto codigo agrupamiento producto tecnico de este DTO.
	 * 
	 * @return Objeto codigo agrupamiento producto tecnico de este DTO.
	 */	
	public String getCodigoAgrupamientoProductoTecnico() {
		return codigoAgrupamientoProductoTecnico;
	}

	/**
	 * Setea el objeto código agrupamiento producto tecnico de este DTO.
	 * 
	 * @param codigoNivelEstructura Objeto código nivel estructura de este DTO.
	 */
	public void setCodigoAgrupamientoProductoTecnico(
			String codigoAgrupamientoProductoTecnico) {
		this.codigoAgrupamientoProductoTecnico = codigoAgrupamientoProductoTecnico;
	}

	/**
	 * Obtiene el objeto tipo operación de este DTO.
	 * 
	 * @return Objeto tipo operación de este DTO.
	 */	
	public TipoOperacionDTO getTipoOperacion() {
		return tipoOperacion;
	}

	/**
	 * Setea el objeto tipo operación producto tecnico de este DTO.
	 * 
	 * @param tipoOperacion Objeto tipo operación de este DTO.
	 */
	public void setTipoOperacion(TipoOperacionDTO tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	/**
	 * Obtiene el objeto codigo producto de este DTO.
	 * 
	 * @return Objeto codigo producto de este DTO.
	 */	
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * Setea el objeto código producto de este DTO.
	 * 
	 * @param codigoProducto Objeto código producto de este DTO.
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * Obtiene el objeto codigo producto comercial de este DTO.
	 * 
	 * @return Objeto codigo producto comercial de este DTO.
	 */	
	public String getCodigoProductoComercial() {
		return codigoProductoComercial;
	}

	/**
	 * Setea el objeto código producto comercial de este DTO.
	 * 
	 * @param codigoProductoComercial Objeto código producto comercial de este DTO.
	 */
	public void setCodigoProductoComercial(String codigoProductoComercial) {
		this.codigoProductoComercial = codigoProductoComercial;
	}

	/**
	 * Obtiene el objeto codigo template detallado de este DTO.
	 * 
	 * @return Objeto codigo template detallado de este DTO.
	 */	
	public String getCodigoTemplateDetallado() {
		return codigoTemplateDetallado;
	}

	/**
	 * Setea el objeto código template detallado de este DTO.
	 * 
	 * @param codigoTemplateDetallado Objeto código template detallado de este DTO.
	 */
	public void setCodigoTemplateDetallado(String codigoTemplateDetallado) {
		this.codigoTemplateDetallado = codigoTemplateDetallado;
	}

	/**
	 * Obtiene el objeto familia de este DTO.
	 * 
	 * @return Objeto familia de este DTO.
	 */	
	public ClaseDTO getFamilia() {
		return familia;
	}

	/**
	 * Setea el objeto familia de este DTO.
	 * 
	 * @param familia Objeto familia de este DTO.
	 */
	public void setFamilia(ClaseDTO familia) {
		this.familia = familia;
	}

	/**
	 * Obtiene el objeto clase de este DTO.
	 * 
	 * @return Objeto clase de este DTO.
	 */	
	public ClaseDTO getClase() {
		return clase;
	}

	/**
	 * Setea el objeto clase de este DTO.
	 * 
	 * @param clase Objeto clase de este DTO.
	 */
	public void setClase(ClaseDTO clase) {
		this.clase = clase;
	}

	/**
	 * Obtiene los objetos zonas comercializacion de este DTO.
	 * 
	 * @return Objetos zonas comercializacion de este DTO.
	 */	
	public List<ZonaComercializacionDTO> getZonasComercializacion() {
		return zonasComercializacion;
	}

	/**
	 * Setea los objetos zonas comercializacion de este DTO.
	 * 
	 * @param zonasComercializacion Objetos zonas comercialización de este DTO.
	 */
	public void setZonasComercializacion(
			List<ZonaComercializacionDTO> zonasComercializacion) {
		this.zonasComercializacion = zonasComercializacion;
	}

	/**
	 * Obtiene los objetos selected dates de este DTO.
	 * 
	 * @return Objeto uuid de este DTO.
	 */	
	public List<Date> getSelectedDates() {
		return selectedDates;
	}

	/**
	 * Setea los objetos selected dates de este DTO.
	 * 
	 * @param selectedDates Objetos selected dates de este DTO.
	 */
	public void setSelectedDates(List<Date> selectedDates) {
		this.selectedDates = selectedDates;
	}

	/**
	 * Obtiene los objetos map items ordenamiento combo de este DTO.
	 * 
	 * @return Objetos map items ordenamiento combo de este DTO.
	 */	
	// TODO renombrar nombres sin map, porque indica la implementacion.
	public Map<String, List<ItemOrdenamientoAvisoDTO>> getMapItemsOrdenamientoCombo() {
		return mapItemsOrdenamientoCombo;
	}

	/**
	 * Setea los objetos map items ordenamiento combo de este DTO.
	 * 
	 * @param mapItemsOrdenamientoCombo Objetos map items ordenamiento combo de este DTO.
	 */
	// TODO renombrar nombres sin map, porque indica la implementacion.
	public void setMapItemsOrdenamientoCombo(Map<String, List<ItemOrdenamientoAvisoDTO>> mapItemsOrdenamientoCombo) {
		this.mapItemsOrdenamientoCombo = mapItemsOrdenamientoCombo;
	}

	/**
	 * Obtiene los objetos palabras prohibidas de este DTO.
	 * 
	 * @return Objetos palabras prohibidas de este DTO.
	 */	
	public List<String> getPalabrasProhibidas() {
		return palabrasProhibidas;
	}

	/**
	 * Setea los objetos palabras prohibidas de este DTO.
	 * 
	 * @param palabrasProhibidas Objetos palabras prohibidas de este DTO.
	 */
	public void setPalabrasProhibidas(List<String> palabrasProhibidas) {
		this.palabrasProhibidas = palabrasProhibidas;
	}

	/**
	 * Obtiene el objeto previsualizo de este DTO.
	 * 
	 * @return Objeto previsualizo de este DTO.
	 */
	public Boolean getPrevisualizo() {
		return previsualizo;
	}

	/**
	 * Setea el objeto previsualizo de este DTO.
	 * 
	 * @param previsualizo Objeto previsualizo de este DTO.
	 */
	public void setPrevisualizo(Boolean previsualizo) {
		this.previsualizo = previsualizo;
	}

	/**
	 * Obtiene el objeto producto comercial template de este DTO.
	 * 
	 * @return Objeto producto comercial template de este DTO.
	 */
	public List<ProductoComercialTemplateDTO> getTemplatesDetallado() {
		return templatesDetallado;
	}

	/**
	 * Setea el objeto producto comercial template de este DTO.
	 * 
	 * @param previsualizo Objeto producto comercial template de este DTO.
	 */
	public void setTemplatesDetallado(List<ProductoComercialTemplateDTO> templatesDetallado) {
		this.templatesDetallado = templatesDetallado;
	}

	/**
	 * Obtiene el objeto orden publicacion history de este DTO.
	 * 
	 * @return Objeto orden publicacion history de este DTO.
	 */
	public OrdenPublicacionDTO getOrdenDepublicacionHistory() {
		return ordenDepublicacionHistory;
	}

	/**
	 * Setea el objeto orden publicacion history de este DTO.
	 * 
	 * @param previsualizo Objeto orden publicacion history de este DTO.
	 */
	public void setOrdenDepublicacionHistory(OrdenPublicacionDTO ordenDepublicacionHistory) {
		this.ordenDepublicacionHistory = ordenDepublicacionHistory;
	}

	/**
	 * Obtiene el objeto código template destaque seleccionado de este DTO.
	 * 
	 * @return Objeto código template destaque seleccionado de este DTO.
	 */
	public String getCodigoTemplateDestaqueSeleccionado() {
		return codigoTemplateDestaqueSeleccionado;
	}

	/**
	 * Setea el objeto código template destaque seleccionado de este DTO.
	 * 
	 * @param previsualizo Objeto código template destaque seleccionado de este DTO.
	 */
	public void setCodigoTemplateDestaqueSeleccionado(String codigoTemplateDestaqueSeleccionado) {
		this.codigoTemplateDestaqueSeleccionado = codigoTemplateDestaqueSeleccionado;
	}

	/**
	 * Obtiene el objeto código imagen destaque seleccionada de este DTO.
	 * 
	 * @return Objeto código imagen destaque seleccionada de este DTO.
	 */
	public String getCodigoImagenDestaqueSeleccionada() {
		return codigoImagenDestaqueSeleccionada;
	}

	/**
	 * Setea el objeto código imagen destaque seleccionada de este DTO.
	 * 
	 * @param previsualizo Objeto código imagen destaque seleccionada de este DTO.
	 */
	public void setCodigoImagenDestaqueSeleccionada(String codigoImagenDestaqueSeleccionada) {
		this.codigoImagenDestaqueSeleccionada = codigoImagenDestaqueSeleccionada;
	}

	/**
	 * Obtiene el objeto repo imagen destaque seleccionada de este DTO.
	 * 
	 * @return Objeto repo imagen destaque seleccionada de este DTO.
	 */
	public String getRepoImagenDestaqueSeleccionada() {
		return repoImagenDestaqueSeleccionada;
	}

	/**
	 * Setea el objeto repo imagen destaque seleccionada de este DTO.
	 * 
	 * @param previsualizo Objeto repo imagen destaque seleccionada de este DTO.
	 */
	public void setRepoImagenDestaqueSeleccionada(String repoImagenDestaqueSeleccionada) {
		this.repoImagenDestaqueSeleccionada = repoImagenDestaqueSeleccionada;
	}

	/**
	 * Obtiene el objeto código producto comercial destaque de este DTO.
	 * 
	 * @return Objeto código producto comercial destaque de este DTO.
	 */
	public String getCodigoProductoComercialDestaque() {
		return codigoProductoComercialDestaque;
	}

	/**
	 * Setea el objeto código producto comercial destaque de este DTO.
	 * 
	 * @param previsualizo Objeto código producto comercial destaque de este DTO.
	 */
	public void setCodigoProductoComercialDestaque(String codigoProductoComercialDestaque) {
		this.codigoProductoComercialDestaque = codigoProductoComercialDestaque;
	}
	
	/**
	 * Obtiene el objeto tienePictoSeleccionado de este DTO.
	 * 
	 * @return Objeto tienePictoSeleccionado de este DTO.
	 */
	public Boolean getTienePictoSeleccionado() {
		return tienePictoSeleccionado;
	}

	/**
	 * Setea el objeto tienePictoSeleccionado de este DTO.
	 * 
	 * @param tienePictoSeleccionado Objeto tiene fondo color de este DTO.
	 */
	public void setTienePictoSeleccionado(Boolean tienePictoSeleccionado) {
		this.tienePictoSeleccionado = tienePictoSeleccionado;
	}
	
	/**
	 * Obtiene el objeto tiene fondo color de este DTO.
	 * 
	 * @return Objeto tiene fondo color de este DTO.
	 */
	public Boolean getTieneFondoColor() {
		return tieneFondoColor;
	}

	/**
	 * Setea el objeto tiene fondo color de este DTO.
	 * 
	 * @param tieneFondoColor Objeto tiene fondo color de este DTO.
	 */
	public void setTieneFondoColor(Boolean tieneFondoColor) {
		this.tieneFondoColor = tieneFondoColor;
	}
	
	/**
	 * Obtiene el objeto tieneMaterial de este DTO.
	 * 
	 * @return Objeto tieneMaterial de este DTO.
	 */
	public Boolean getTieneMaterial() {
		return tieneMaterial;
	}

	/**
	 * Setea el objeto tieneMaterial de este DTO.
	 * 
	 * @param tieneMaterial Objeto tiene fondo color de este DTO.
	 */
	public void setTieneMaterial(Boolean tieneMaterial) {
		this.tieneMaterial = tieneMaterial;
	}

	/**
	 * Obtiene los objetos configuraciones promoción pantalla de este DTO. 
	 * 
	 * @return Objetos configuraciones promoción pantalla de este DTO.
	 */
	public List<ConfiguracionPromocionPantallaDTO> getConfiguracionesPromocionPantalla() {
		return configuracionesPromocionPantalla;
	}

	/**
	 * Setea los objetos configuraciones promoción pantalla de este DTO.
	 * 
	 * @param conceptosVendibles Objeto configuraciones promoción pantalla de este DTO.
	 */
	public void setConfiguracionesPromocionPantalla(List<ConfiguracionPromocionPantallaDTO> configuracionesPromocionPantalla) {
		this.configuracionesPromocionPantalla = configuracionesPromocionPantalla;
	}

	/**
	 * Obtiene los objetos agrupadores atributo aviso de este DTO. 
	 * 
	 * @return Objetos agrupadores atributo aviso de este DTO.
	 */
	public List<AgrupadorAtributoAvisoDTO> getAgrupadoresAtributoAviso() {
		return agrupadoresAtributoAviso;
	}

	/**
	 * Setea los objetos agrupadores atributo aviso de este DTO.
	 * 
	 * @param conceptosVendibles Objeto agrupadores atributo aviso de este DTO.
	 */
	public void setAgrupadoresAtributoAviso(List<AgrupadorAtributoAvisoDTO> agrupadoresAtributoAviso) {
		this.agrupadoresAtributoAviso = agrupadoresAtributoAviso;
	}

	/**
	 * Obtiene los objetos promociones de este DTO. 
	 * 
	 * @return Objetos promociones de este DTO.
	 */
	public List<PromocionDTO> getPromociones() {
		return promociones;
	}

	/**
	 * Setea los objetos promociones de este DTO.
	 * 
	 * @param conceptosVendibles Objeto promociones de este DTO.
	 */
	public void setPromociones(List<PromocionDTO> promociones) {
		this.promociones = promociones;
	}

	/**
	 * Obtiene los objeto codigo nivel estructura de este DTO. 
	 * 
	 * @return Objetos codigo nivel estructura de este DTO.
	 */
	public String getCodigoNivelEstructuraDestaque() {
		return codigoNivelEstructuraDestaque;
	}

	/**
	 * Setea el objeto codigo nivel estructura de este DTO.
	 * 
	 * @param codigoNivelEstructuraDestaque Objeto codigo nivel estructura de este DTO.
	 */
	public void setCodigoNivelEstructuraDestaque(
			String codigoNivelEstructuraDestaque) {
		this.codigoNivelEstructuraDestaque = codigoNivelEstructuraDestaque;
	}
			
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();

		description.append(super.toString());
		description.append("ordenPublicacion: [").append(ordenPublicacion).append("]");
		description.append(", step: ").append(step);
		description.append(", codigoCanalEntrada: ").append(codigoCanalEntrada);
		description.append(", codigoNivelEstructura: ").append(codigoNivelEstructura);
		description.append(", codigoAgrupamientoProductoTecnico: ").append(codigoAgrupamientoProductoTecnico);
		description.append(", tipoOperacion: [").append(tipoOperacion).append("]");
		description.append(", codigoProducto: ").append(codigoProducto);
		description.append(", codigoProductoComercial: ").append(codigoProductoComercial);
		description.append(", codigoTemplateDetallado: ").append(codigoTemplateDetallado);
		description.append(", familia: [").append(familia).append("]");
		description.append(", clase: [").append(clase).append("]");
		description.append(", zonasComercializacion: [").append(toString(zonasComercializacion)).append("]");
		description.append(", selectedDates: [").append(toString(selectedDates)).append("]");
		description.append(", mapItemsOrdenamientoCombo: [").append(toString(mapItemsOrdenamientoCombo)).append("]");
		description.append(", palabrasProhibidas: ").append(toString(palabrasProhibidas)).append("]");
		description.append(", ordenamientos: [").append(toString(ordenamientos)).append("]");
		description.append(", configuracionOrdenamientoPantalla: [").append(toString(configuracionOrdenamientoPantalla)).append("]");
		description.append(", previsualizo: ").append(previsualizo);
		description.append(", templatesDetallado: [").append(toString(templatesDetallado)).append("]");
		description.append(", ordenDepublicacionHistory: [").append(ordenDepublicacionHistory).append("]");
		description.append(", codigoTemplateDestaqueSeleccionado: ").append(codigoTemplateDestaqueSeleccionado);
		description.append(", codigoImagenDestaqueSeleccionada: ").append(codigoImagenDestaqueSeleccionada);
		description.append(", repoImagenDestaqueSeleccionada: ").append(repoImagenDestaqueSeleccionada);
		description.append(", codigoProductoComercialDestaque: ").append(codigoProductoComercialDestaque);
		description.append(", tieneFondoColor: ").append(tieneFondoColor);
		description.append(", configuracionesPromocionPantalla: [").append(toString(configuracionesPromocionPantalla)).append("]");
		description.append(", agrupadoresAtributoAviso: [").append(toString(agrupadoresAtributoAviso)).append("]");
		description.append(", promociones: [").append(toString(promociones)).append("]");
		return description.toString();
	}
	
	private String toString(List<?> collection) {
		StringBuilder description = new StringBuilder();
		
		Iterator<?> iterator = collection.iterator();
		
		while (iterator.hasNext()) {
			description.append(iterator.next());
			
			if (iterator.hasNext()) {
				description.append(", ");
			}
		}
		
		return description.toString();
	}
	
	private String toString(Map<?, ?> collection) {
		StringBuilder description = new StringBuilder();
		
		Iterator<?> keyIterator = collection.entrySet().iterator();
		
		while (keyIterator.hasNext()) {
			Entry<?, ?> entry = (Entry<?, ?>) keyIterator.next();
			
			description.append(entry.getKey());
			description.append(": ");
			description.append(entry.getValue());
			
			if (keyIterator.hasNext()) {
				description.append(", ");
			}
		}
		
		return description.toString();
	}
}
