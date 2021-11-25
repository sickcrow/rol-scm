/*
 * @(#)OrdenamientoAvisoDTO.java		1.0 22/07/2013
 */

package ar.com.agea.hub.rol.model.dto;


/**
 * Representa un objeto Data Transfer Object para transferir datos de ordenamientos aviso.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 22/07/2013
 */
public class OrdenamientoAvisoDTO implements JSONDTO {
	
	private static final long serialVersionUID = 6662603886275813499L;
	
	private Long id;
	private String codigo;
	private String tipoDato;
	private Boolean obligatorio;
	private Long orden;
	private String formato;
	private Boolean muestraDefault;
	private Boolean ocultarValorUnico;
	private String validacion;
	private String descValidacion;
	private Long idPadre;
	private Long idSubrubro;
	private String descAyuda;

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
	 * @param codigo Objeto código de este DTO.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene el objeto tipo dato de este DTO. 
	 * 
	 * @return Objeto tipo dato de este DTO.
	 */
	public String getTipoDato() {
		return tipoDato;
	}

	/**
	 * Setea el objeto tipo dato de este DTO.
	 * 
	 * @param tipoDato Objeto tipo dato de este DTO.
	 */
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}

	/**
	 * Obtiene el objeto obligatorio de este DTO. 
	 * 
	 * @return Objeto obligatorio de este DTO.
	 */
	public Boolean getObligatorio() {
		return obligatorio;
	}

	/**
	 * Setea el objeto obligatorio de este DTO.
	 * 
	 * @param obligatorio Objeto obligatorio de este DTO.
	 */
	public void setObligatorio(Boolean obligatorio) {
		this.obligatorio = obligatorio;
	}

	/**
	 * Obtiene el objeto orden de este DTO. 
	 * 
	 * @return Objeto orden de este DTO.
	 */
	public Long getOrden() {
		return orden;
	}

	/**
	 * Setea el objeto orden de este DTO.
	 * 
	 * @param orden Objeto orden de este DTO.
	 */
	public void setOrden(Long orden) {
		this.orden = orden;
	}

	/**
	 * Obtiene el objeto formato de este DTO. 
	 * 
	 * @return Objeto formato de este DTO.
	 */
	public String getFormato() {
		return formato;
	}

	/**
	 * Setea el objeto formato de este DTO.
	 * 
	 * @param formato Objeto formato de este DTO.
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}

	/**
	 * Obtiene el objeto muestra default de este DTO. 
	 * 
	 * @return Objeto muestra default de este DTO.
	 */
	public Boolean getMuestraDefault() {
		return muestraDefault;
	}

	/**
	 * Setea el objeto muestra default de este DTO.
	 * 
	 * @param muestraDefault Objeto muestra default de este DTO.
	 */
	public void setMuestraDefault(Boolean muestraDefault) {
		this.muestraDefault = muestraDefault;
	}

	/**
	 * Obtiene el objeto ocultar valor único de este DTO. 
	 * 
	 * @return Objeto ocultar valor único de este DTO.
	 */
	public Boolean getOcultarValorUnico() {
		return ocultarValorUnico;
	}

	/**
	 * Setea el objeto ocultar valor único de este DTO.
	 * 
	 * @param ocultarValorUnico Objeto ocultar valor único de este DTO.
	 */
	public void setOcultarValorUnico(Boolean ocultarValorUnico) {
		this.ocultarValorUnico = ocultarValorUnico;
	}

	/**
	 * Obtiene el objeto validación de este DTO. 
	 * 
	 * @return Objeto validación de este DTO.
	 */
	public String getValidacion() {
		return validacion;
	}

	/**
	 * Setea el objeto validación de este DTO.
	 * 
	 * @param validacion Objeto validación de este DTO.
	 */
	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	/**
	 * Obtiene el objeto descripción validación de este DTO. 
	 * 
	 * @return Objeto descripción validación de este DTO.
	 */
	public String getDescValidacion() {
		return descValidacion;
	}

	/**
	 * Setea el objeto descripción validación de este DTO.
	 * 
	 * @param descValidacion Objeto descripción validación de este DTO.
	 */
	public void setDescValidacion(String descValidacion) {
		this.descValidacion = descValidacion;
	}

	/**
	 * Obtiene el objeto id ordenamiento padre de este DTO. 
	 * 
	 * @return Objeto id ordenamiento padre de este DTO.
	 */
	public Long getIdPadre() {
		return idPadre;
	}

	/**
	 * Setea el objeto id ordenamiento padre de este DTO.
	 * 
	 * @param idPadre Objeto id ordenamiento padre de este DTO.
	 */
	public void setIdPadre(Long idPadre) {
		this.idPadre = idPadre;
	}

	/**
	 * Obtiene el objeto id subrubro de este DTO. 
	 * 
	 * @return Objeto id subrubro de este DTO.
	 */
	public Long getIdSubrubro() {
		return idSubrubro;
	}

	/**
	 * Setea el objeto id subrubro de este DTO.
	 * 
	 * @param idSubrubro Objeto id subrubro de este DTO.
	 */
	public void setIdSubrubro(Long idSubrubro) {
		this.idSubrubro = idSubrubro;
	}

	/**
	 * Obtiene el objeto descripción ayuda de este DTO. 
	 * 
	 * @return Objeto descripción ayuda de este DTO.
	 */
	public String getDescAyuda() {
		return descAyuda;
	}

	/**
	 * Setea el objeto descripción ayuda de este DTO.
	 * 
	 * @param id Objeto descripción ayuda de este DTO.
	 */
	public void setDescAyuda(String descAyuda) {
		this.descAyuda = descAyuda;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", codigo: ").append(codigo);
		description.append(", tipoDato: ").append(tipoDato);
		description.append(", obligatorio: ").append(obligatorio);
		description.append(", orden: ").append(orden);
		description.append(", formato: ").append(formato);
		description.append(", muestraDefault: ").append(muestraDefault);
		description.append(", ocultarValorUnico: ").append(ocultarValorUnico);
		description.append(", validacion: ").append(validacion);
		description.append(", descValidacion: ").append(descValidacion);
		description.append(", idPadre: ").append(idPadre);
		description.append(", idSubrubro: ").append(idSubrubro);
		description.append(", descAyuda: ").append(descAyuda);
		
		return description.toString();
	}
}
