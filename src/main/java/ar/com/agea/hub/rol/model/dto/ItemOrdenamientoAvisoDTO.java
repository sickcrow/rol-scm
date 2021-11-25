/*
 * @(#)ItemOrdenamientoAvisoDTO.java		1.0 09/08/2013
 */

package ar.com.agea.hub.rol.model.dto;


/**
 * Representa un objeto Data Transfer Object para transferir datos de items ordenamientos aviso.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 09/08/2013
 */
public class ItemOrdenamientoAvisoDTO implements JSONDTO {
	
	private static final long serialVersionUID = -4791877451057918771L;
	
	private Long id;
	private String codigo;
	private String valor;
	private Boolean ingresoManual;
	private String codigoBusqueda;
	private Long idOrdenamientoAviso;
	private Long idPadre;
	private String descripcion;
	
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
	 * Obtiene el objeto código de este DTO. 
	 * 
	 * @return Objeto código de este DTO.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Setea el objeto código de este DTO.
	 * 
	 * @param id Objeto código de este DTO.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene el objeto valor de este DTO. 
	 * 
	 * @return Objeto valor de este DTO.
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Setea el objeto valor de este DTO.
	 * 
	 * @param id Objeto valor de este DTO.
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * Obtiene el objeto ingreso manual de este DTO. 
	 * 
	 * @return Objeto ingreso manual de este DTO.
	 */
	public Boolean getIngresoManual() {
		return ingresoManual;
	}

	/**
	 * Setea el objeto ingreso manual de este DTO.
	 * 
	 * @param id Objeto ingreso manual de este DTO.
	 */
	public void setIngresoManual(Boolean ingresoManual) {
		this.ingresoManual = ingresoManual;
	}

	/**
	 * Obtiene el objeto código búsqueda de este DTO. 
	 * 
	 * @return Objeto código búsqueda de este DTO.
	 */
	public String getCodigoBusqueda() {
		return codigoBusqueda;
	}

	/**
	 * Setea el objeto código búsqueda de este DTO.
	 * 
	 * @param id Objeto código búsqueda de este DTO.
	 */
	public void setCodigoBusqueda(String codigoBusqueda) {
		this.codigoBusqueda = codigoBusqueda;
	}

	/**
	 * Obtiene el objeto id ordenamiento aviso de este DTO. 
	 * 
	 * @return Objeto id ordenamiento aviso de este DTO.
	 */
	public Long getIdOrdenamientoAviso() {
		return idOrdenamientoAviso;
	}

	/**
	 * Setea el objeto id ordenamiento aviso de este DTO.
	 * 
	 * @param id Objeto id ordenamiento aviso de este DTO.
	 */
	public void setIdOrdenamientoAviso(Long idOrdenamientoAviso) {
		this.idOrdenamientoAviso = idOrdenamientoAviso;
	}

	/**
	 * Obtiene el objeto id padre de este DTO. 
	 * 
	 * @return Objeto id padre de este DTO.
	 */
	public Long getIdPadre() {
		return idPadre;
	}

	/**
	 * Setea el objeto id padre de este DTO.
	 * 
	 * @param id Objeto id padre de este DTO.
	 */
	public void setIdPadre(Long idPadre) {
		this.idPadre = idPadre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", codigo: ").append(codigo);
		description.append(", valor: ").append(valor);
		description.append(", ingresoManual: ").append(ingresoManual);
		description.append(", codigoBusqueda: ").append(codigoBusqueda);
		description.append(", idOrdenamientoAviso: ").append(idOrdenamientoAviso);
		description.append(", idPadre: ").append(idPadre);
		description.append(", descripcion: ").append(descripcion);
		
		return description.toString();
	}
}
