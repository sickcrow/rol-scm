/*
 * @(#)AvisoDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * Representa un objeto Data Transfer Object para transferir datos de avisos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class AvisoDTO implements JSONDTO {

	private static final long serialVersionUID = -1242644709151419595L;

	/**
	 * Identifica el tipo de este DTO.
	 * 
	 * @author      Eduardo Barrera
	 * @version		1.0 06/06/2013
	 */
	public static enum Tipo {LINEAL, WEB}; 
	
	private Long id;
	private Tipo tipo;
	private Date fechaPedidoPublicacion;
	private Boolean incompleto;
	private Boolean bloqueado;
	private Boolean facturable;
	private String textoLibre;
	private String textoLibreTemplate;
	private String estado;
	private List<AccionSecuenciaDTO> acciones;
	private TipoOperacionDTO tipoOperacion;
	private ProductoComercialDTO productoComercial;
	private List<AvisoPromocionDTO> avisoPromocion;
	private TemplateDetalladoDTO templateDetallado;
	private List<ImagenDTO> materiales;
	private String codigoClase;
	private List<AtributoAvisoDTO> atributosAviso;
	private NivelEstructuraDTO nivelEstructura;
	private Integer lineasPublicadas;
	private Double lineasFacturadas;
	private String textoJustificado;
	private String textoLibreJustificado;
	private Long avisoRepublicado;
	private String idNUP;
	private ImagenDTO preview;
	private Float altoPuntosTipograficos;	
	private List<ZonaComercializacionDTO> zonasComercializacion;
	private List<OrdenamientoAvisoValorizadoDTO> ordenamientos;
	
	/**
	 * Instancia un objeto de tipo AvisoDTO.
	 */
	public AvisoDTO() {
		acciones = new ArrayList<AccionSecuenciaDTO>();
		avisoPromocion = new ArrayList<AvisoPromocionDTO>();
		materiales = new ArrayList<ImagenDTO>();
		atributosAviso = new ArrayList<AtributoAvisoDTO>();
		zonasComercializacion = new ArrayList<ZonaComercializacionDTO>();
		ordenamientos = new ArrayList<OrdenamientoAvisoValorizadoDTO>();
	}

	/**
	 * Obtiene el objeto id de este DTO. 
	 * 
	 * @return Objeto id de este DTO.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setea el objeto id de este DTO.
	 * 
	 * @param id Objeto id de este DTO.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el objeto tipo de este DTO. 
	 * 
	 * @return Objeto tipo de este DTO.
	 */
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * Setea el objeto tipo de este DTO.
	 * 
	 * @param tipo Objeto tipo de este DTO.
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene el objeto fecha pedido publicación de este DTO. 
	 * 
	 * @return Objeto fecha pedido publicación de este DTO.
	 */
	public Date getFechaPedidoPublicacion() {
		Date result = null;
		
		if (fechaPedidoPublicacion != null) {
			result = (Date) fechaPedidoPublicacion.clone();
		}
		
		return result;
	}

	/**
	 * Setea el objeto fecha pedido publicación de este DTO.
	 * 
	 * @param fechaPedidoPublicacion Objeto fecha pedido publicación de este DTO.
	 */
	public void setFechaPedidoPublicacion(Date fechaPedidoPublicacion) {
		if (fechaPedidoPublicacion != null) {
			this.fechaPedidoPublicacion = new Date(fechaPedidoPublicacion.getTime());
		} else {
			this.fechaPedidoPublicacion = fechaPedidoPublicacion; 
		}
	}

	/**
	 * Obtiene el objeto incompleto de este DTO. 
	 * 
	 * @return Objeto incompleto de este DTO.
	 */
	public Boolean getIncompleto() {
		return incompleto;
	}

	/**
	 * Setea el objeto incompleto de este DTO.
	 * 
	 * @param incompleto Objeto incompleto de este DTO.
	 */
	public void setIncompleto(Boolean incompleto) {
		this.incompleto = incompleto;
	}

	/**
	 * Obtiene el objeto bloqueado de este DTO. 
	 * 
	 * @return Objeto bloqueado de este DTO.
	 */
	public Boolean getBloqueado() {
		return bloqueado;
	}

	/**
	 * Setea el objeto bloqueado de este DTO.
	 * 
	 * @param bloqueado Objeto bloqueado de este DTO.
	 */
	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	/**
	 * Obtiene el objeto facturable de este DTO. 
	 * 
	 * @return Objeto facturable de este DTO.
	 */
	public Boolean getFacturable() {
		return facturable;
	}

	/**
	 * Setea el objeto facturable de este DTO.
	 * 
	 * @param facturable Objeto facturable de este DTO.
	 */
	public void setFacturable(Boolean facturable) {
		this.facturable = facturable;
	}

	/**
	 * Obtiene el objeto texto libre de este DTO. 
	 * 
	 * @return Objeto texto libre de este DTO.
	 */
	public String getTextoLibre() {
		return textoLibre;
	}

	/**
	 * Setea el objeto texto libre de este DTO.
	 * 
	 * @param textoLibre Objeto texto libre de este DTO.
	 */
	public void setTextoLibre(String textoLibre) {
		this.textoLibre = textoLibre;
	}

	/**
	 * Obtiene el objeto texto libre template de este DTO. 
	 * 
	 * @return Objeto texto libre template de este DTO.
	 */	
	public String getTextoLibreTemplate() {
		return textoLibreTemplate;
	}

	/**
	 * Setea el objeto texto libre template de este DTO.
	 * 
	 * @param textoLibreTemplate Objeto texto libre template de este DTO.
	 */
	public void setTextoLibreTemplate(String textoLibreTemplate) {
		this.textoLibreTemplate = textoLibreTemplate;
	}

	/**
	 * Obtiene el objeto estado de este DTO. 
	 * 
	 * @return Objeto estado de este DTO.
	 */	
	public String getEstado() {
		return estado;
	}

	/**
	 * Setea el objeto estado de este DTO.
	 * 
	 * @param estado Objeto estado de este DTO.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene los objetos acciones secuencias de este DTO. 
	 * 
	 * @return Objeto acciones secuencias de este DTO.
	 */
	public List<AccionSecuenciaDTO> getAcciones() {
		return acciones;
	}

	/**
	 * Setea el objeto acciones secuencias de este DTO.
	 * 
	 * @param acciones Objeto acciones secuencias de este DTO.
	 */
	public void setAcciones(List<AccionSecuenciaDTO> acciones) {
		this.acciones = acciones;
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
	 * Setea el objeto tipo operación de este DTO.
	 * 
	 * @param tipoOperacion Objeto tipo operación de este DTO.
	 */
	public void setTipoOperacion(TipoOperacionDTO tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	/**
	 * Obtiene el objeto producto comercial de este DTO. 
	 * 
	 * @return Objeto producto comercial de este DTO.
	 */
	public ProductoComercialDTO getProductoComercial() {
		return productoComercial;
	}

	/**
	 * Setea el objeto producto comercial de este DTO.
	 * 
	 * @param productoComercial Objeto producto comercial de este DTO.
	 */
	public void setProductoComercial(ProductoComercialDTO productoComercial) {
		this.productoComercial = productoComercial;
	}

	/**
	 * Obtiene los objetos promociones de este DTO. 
	 * 
	 * @return Objetos promociones de este DTO.
	 */
	public List<AvisoPromocionDTO> getAvisoPromocion() {
		return avisoPromocion;
	}

	/**
	 * Setea el objeto promociones de este DTO.
	 * 
	 * @param promociones Objeto promociones de este DTO.
	 */
	public void setAvisoPromocion(List<AvisoPromocionDTO> avisoPromocion) {
		this.avisoPromocion = avisoPromocion;
	}

	/**
	 * Obtiene el objeto template detallado de este DTO. 
	 * 
	 * @return Objeto template detallado de este DTO.
	 */
	public TemplateDetalladoDTO getTemplateDetallado() {
		return templateDetallado;
	}

	/**
	 * Setea el objeto template detallado de este DTO.
	 * 
	 * @param templateDetallado Objeto template detallado de este DTO.
	 */
	public void setTemplateDetallado(TemplateDetalladoDTO templateDetallado) {
		this.templateDetallado = templateDetallado;
	}

	/**
	 * Obtiene el objeto materiales de este DTO. 
	 * 
	 * @return Objeto materiales de este DTO.
	 */
	public List<ImagenDTO> getMateriales() {
		return materiales;
	}

	/**
	 * Setea el objeto materiales de este DTO.
	 * 
	 * @param materiales Objeto materiales de este DTO.
	 */
	public void setMateriales(List<ImagenDTO> materiales) {
		this.materiales = materiales;
	}

	/**
	 * Obtiene el objeto código clase de este DTO. 
	 * 
	 * @return Objeto código clase de este DTO.
	 */
	public String getCodigoClase() {
		return codigoClase;
	}

	/**
	 * Setea el objeto código clase de este DTO.
	 * 
	 * @param codigoClase Objeto código clase de este DTO.
	 */
	public void setCodigoClase(String codigoClase) {
		this.codigoClase = codigoClase;
	}

	/**
	 * Obtiene los objetos atributos de aviso de este DTO. 
	 * 
	 * @return Objetos atributos de aviso de este DTO.
	 */
	public List<AtributoAvisoDTO> getAtributosAviso() {
		return atributosAviso;
	}

	/**
	 * Setea los objetos atributos de aviso de este DTO.
	 * 
	 * @param atributosAviso Objetos atributos de aviso de este DTO.
	 */
	public void setAtributosAviso(List<AtributoAvisoDTO> atributosAviso) {
		this.atributosAviso = atributosAviso;
	}

	/**
	 * Obtiene el objeto nivel estructura de este DTO. 
	 * 
	 * @return Objeto nivel estructura de este DTO.
	 */
	public NivelEstructuraDTO getNivelEstructura() {
		return nivelEstructura;
	}

	/**
	 * Setea el objeto nivel estructura de este DTO.
	 * 
	 * @param nivelEstructura Objeto nivel estructura de este DTO.
	 */
	public void setNivelEstructura(
			NivelEstructuraDTO nivelEstructura) {
		this.nivelEstructura = nivelEstructura;
	}

	/**
	 * Obtiene el objeto líneas publicadas de este DTO. 
	 * 
	 * @return Objeto líneas publicadas de este DTO.
	 */
	public Integer getLineasPublicadas() {
		return lineasPublicadas;
	}

	/**
	 * Setea el objeto líneas justificadas de este DTO.
	 * 
	 * @param lineasPublicadas Objeto líneas justificadas de este DTO.
	 */
	public void setLineasPublicadas(Integer lineasPublicadas) {
		this.lineasPublicadas = lineasPublicadas;
	}

	/**
	 * Obtiene el objeto líneas facturadas de este DTO. 
	 * 
	 * @return Objeto líneas facturadas de este DTO.
	 */
	public Double getLineasFacturadas() {
		return lineasFacturadas;
	}

	/**
	 * Setea el objeto líneas facturadas de este DTO.
	 * 
	 * @param lineasFacturadas Objeto líneas facturadas de este DTO.
	 */
	public void setLineasFacturadas(Double lineasFacturadas) {
		this.lineasFacturadas = lineasFacturadas;
	}

	/**
	 * Obtiene el objeto texto justificado de este DTO. 
	 * 
	 * @return Objeto texto justificado de este DTO.
	 */
	public String getTextoJustificado() {
		return textoJustificado;
	}

	/**
	 * Setea el objeto texto justificado de este DTO.
	 * 
	 * @param textoJustificado Objeto texto justificado de este DTO.
	 */
	public void setTextoJustificado(String textoJustificado) {
		this.textoJustificado = textoJustificado;
	}

	/**
	 * Obtiene el objeto texto libre justificado de este DTO. 
	 * 
	 * @return Objeto texto libre justificado de este DTO.
	 */
	public String getTextoLibreJustificado() {
		return textoLibreJustificado;
	}

	/**
	 * Setea el objeto texto libre justificado de este DTO.
	 * 
	 * @param textoLibreJustificado Objeto texto libre justificado de este DTO.
	 */
	public void setTextoLibreJustificado(String textoLibreJustificado) {
		this.textoLibreJustificado = textoLibreJustificado;
	}

	/**
	 * Obtiene el objeto aviso republicado de este DTO
	 * 
	 * @return Objeto aviso republicado de este DTO
	 */
	public Long getAvisoRepublicado() {
		return avisoRepublicado;
	}

	/**
	 * Setea el objeto aviso republicado de este DTO
	 * 
	 * @param avisoRepublicado Objeto aviso republicado de este DTO
	 */
	public void setAvisoRepublicado(Long avisoRepublicado) {
		this.avisoRepublicado = avisoRepublicado;
	}

	/**
	 * Obtiene el objeto id NUP de este DTO. 
	 * 
	 * @return Objeto id NUP de este DTO.
	 */
	public String getIdNUP() {
		return idNUP;
	}

	/**
	 * Setea el objeto id NUP de este DTO.
	 * 
	 * @param idNUP Objeto id NUP de este DTO.
	 */
	public void setIdNUP(String idNUP) {
		this.idNUP = idNUP;
	}

	/**
	 * Obtiene el objeto preview de este DTO. 
	 * 
	 * @return Objeto preview de este DTO.
	 */
	public ImagenDTO getPreview() {
		return preview;
	}

	/**
	 * Setea el objeto preview de este DTO.
	 * 
	 * @param preview Objeto preview de este DTO.
	 */
	public void setPreview(ImagenDTO preview) {
		this.preview = preview;
	}

	/**
	 * Obtiene el objeto alto puntos tipográficos de este DTO. 
	 * 
	 * @return Objeto alto puntos tipográficos de este DTO.
	 */
	public Float getAltoPuntosTipograficos() {
		return altoPuntosTipograficos;
	}

	/**
	 * Setea el objeto alto puntos tipográficos de este DTO.
	 * 
	 * @param altoPuntosTipograficos Objeto alto puntos tipográficos de este DTO.
	 */
	public void setAltoPuntosTipograficos(Float altoPuntosTipograficos) {
		this.altoPuntosTipograficos = altoPuntosTipograficos;
	}
	
	/**
	 * Obtiene los objetos zonas comercialización de este DTO. 
	 * 
	 * @return Objetos zonas comercialización de este DTO.
	 */
	public List<ZonaComercializacionDTO> getZonasComercializacion() {
		return zonasComercializacion;
	}

	/**
	 * Setea los objetos zonas comercialización de este DTO.
	 * 
	 * @param zonasComercializacion Objetos zonas comercialización de este DTO.
	 */
	public void setZonasComercializacion(
			List<ZonaComercializacionDTO> zonasComercializacion) {
		this.zonasComercializacion = zonasComercializacion;
	}

	/**
	 * Obtiene los objetos ordenamientos aviso valorizado de este DTO. 
	 * 
	 * @return Objetos ordenamientos aviso valorizado de este DTO.
	 */
	public List<OrdenamientoAvisoValorizadoDTO> getOrdenamientos() {
		return ordenamientos;
	}

	/**
	 * Setea los objetos ordenamientos aviso valorizado de este DTO.
	 * 
	 * @param ordenamientos Objetos ordenamientos aviso valorizado de este DTO.
	 */
	public void setOrdenamientos(List<OrdenamientoAvisoValorizadoDTO> ordenamientos) {
		this.ordenamientos = ordenamientos;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", tipo: [").append(tipo).append("]");
		description.append(", fechaPedidoPublicacion: ").append(fechaPedidoPublicacion);
		description.append(", incompleto: ").append(incompleto);
		description.append(", bloqueado: ").append(bloqueado);
		description.append(", facturable: ").append(facturable);
		description.append(", textoLibre: ").append(textoLibre);
		description.append(", textoLibreTemplate: ").append(textoLibreTemplate);
		description.append(", estado: ").append(estado);
		description.append(", acciones: [").append(toString(acciones)).append("]");
		description.append(", tipoOperacion: [").append(tipoOperacion).append("]");
		description.append(", productoComercial: [").append(productoComercial).append("]");
		description.append(", avisoPromocion: [").append(avisoPromocion).append("]");
		description.append(", templateDetallado: [").append(templateDetallado).append("]");
		description.append(", materiales: [").append(toString(materiales)).append("]");
		description.append(", codigoClase: ").append( codigoClase);
		description.append(", atributosAviso: [").append(toString(atributosAviso)).append("]");
		description.append(", nivelEstructura: [").append(nivelEstructura).append("]");
		description.append(", lineasPublicadas: ").append(lineasPublicadas);
		description.append(", lineasFacturadas: ").append(lineasFacturadas);
		description.append(", textoJustificado: ").append(textoJustificado);
		description.append(", textoLibreJustificado: ").append(textoLibreJustificado);
		description.append(", idNUP: ").append(idNUP);
		description.append(", preview: [").append(preview).append("]");
		description.append(", altoPuntosTipograficos: ").append(altoPuntosTipograficos);
		description.append(", zonasComercializacion: [").append(toString(zonasComercializacion)).append("]");
		description.append(", ordenamientos: [").append(toString(ordenamientos)).append("]");
		
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
}
