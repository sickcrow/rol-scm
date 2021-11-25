package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de domicilios.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Juan Martin Lichowski
 * @version		1.0 13/11/2013
 */
public class DomicilioDTO implements JSONDTO {
	
	private static final long serialVersionUID = 6337905048770241647L;
	
	private TipoDomicilioDTO tipoDomicilio;
	private String calle;
	private String puerta;
	private String piso;
	private String depto;
	private String codPostal;
	private String localidad;
	private String provincia;
	private String pais;
	
	private Long id;


	/**
	 * Obtiene el objeto tipo domicilio de este DTO. 
	 * 
	 * @return Objeto tipo domicilio de este DTO.
	 */
	public TipoDomicilioDTO getTipoDomicilio() {
		return tipoDomicilio;
	}

	/**
	 * Setea el objeto tipo domicilio de este DTO.
	 * 
	 * @param tipoDomicilio Objeto tipo domicilio de este DTO.
	 */
	public void setTipoDomicilio(TipoDomicilioDTO tipoDomicilio) {
		this.tipoDomicilio = tipoDomicilio;
	}

	/**
	 * Obtiene el objeto calle de este DTO. 
	 * 
	 * @return Objeto calle de este DTO.
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * Setea el objeto calle de este DTO.
	 * 
	 * @param calle Objeto calle de este DTO.
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * Obtiene el objeto puerta de este DTO. 
	 * 
	 * @return Objeto puerta de este DTO.
	 */
	public String getPuerta() {
		return puerta;
	}

	/**
	 * Setea el objeto puerta de este DTO.
	 * 
	 * @param puerta Objeto puerta de este DTO.
	 */
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	/**
	 * Obtiene el objeto piso de este DTO. 
	 * 
	 * @return Objeto piso de este DTO.
	 */
	public String getPiso() {
		return piso;
	}

	/**
	 * Setea el objeto piso de este DTO.
	 * 
	 * @param piso Objeto piso de este DTO.
	 */
	public void setPiso(String piso) {
		this.piso = piso;
	}

	/**
	 * Obtiene el objeto departamento de este DTO. 
	 * 
	 * @return Objeto departamento de este DTO.
	 */
	public String getDepto() {
		return depto;
	}

	/**
	 * Setea el objeto departamento de este DTO.
	 * 
	 * @param depto Objeto departamento de este DTO.
	 */
	public void setDepto(String depto) {
		this.depto = depto;
	}

	/**
	 * Obtiene el objeto código postal de este DTO. 
	 * 
	 * @return Objeto código postal de este DTO.
	 */
	public String getCodPostal() {
		return codPostal;
	}

	/**
	 * Setea el objeto código postal de este DTO.
	 * 
	 * @param codPostal Objeto código postal de este DTO.
	 */
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	
	/**
	 * Obtiene el objeto localidad de este DTO. 
	 * 
	 * @return Objeto localidad de este DTO.
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * Setea el objeto localidad de este DTO.
	 * 
	 * @param localidad Objeto localidad de este DTO.
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * Obtiene el objeto provincia de este DTO. 
	 * 
	 * @return Objeto provincia de este DTO.
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * Setea el objeto provincia de este DTO.
	 * 
	 * @param provincia Objeto provincia de este DTO.
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * Obtiene el objeto país de este DTO. 
	 * 
	 * @return Objeto país de este DTO.
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Setea el objeto país de este DTO.
	 * 
	 * @param pais Objeto país de este DTO.
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
	/**
	 * Obtiene el objeto apellido de este DTO. 
	 * 
	 * @return Objeto apellido de este DTO.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setea el objeto apellido de este DTO.
	 * 
	 * @param apellido Objeto apellido de este DTO.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("tipoDomicilio: [").append(tipoDomicilio).append("]");
		description.append(", calle: ").append(calle);
		description.append(", puerta: ").append(puerta);
		description.append(", piso: ").append(piso);
		description.append(", depto: ").append(depto);
		description.append(", codPostal: ").append(codPostal);
		description.append(", localidad: ").append(localidad);
		description.append(", provincia: ").append(provincia);
		description.append(", pais: ").append(pais);
		
		return description.toString();
	}
}
