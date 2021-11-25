package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir el dato de un atributo 
 * de Configuración de Interfaz Dinamica.
 * Contiene el nombre del atributo y los permisos asociados.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación.
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 10/06/2015
 */
public class AtributoCIDDTO implements JSONDTO {

	private String nombre;
	private PermisoAtributoDTO permisoAtributo;
	
	/**
	 * Obtiene el valor del atributo nombre de este DTO.
	 * 
	 * @return El valor del atributo nombre de este DTO.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setea el valor del atributo nombre de este DTO.
	 * 
	 * @param nombre El valor del atributo nombre de este DTO.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el valor del atributo permisoAtributo de este DTO.
	 * 
	 * @return El valor del atributo permiso atributo de este DTO.
	 */
	public PermisoAtributoDTO getPermisoAtributo() {
		return permisoAtributo;
	}

	/**
	 * Setea el valor del atributo permisoAtributo de este DTO.
	 * 
	 * @param permisoAtributo El valor del atributo permiso atributo de este DTO.
	 */
	public void setPermisoAtributo(PermisoAtributoDTO permisoAtributo) {
		this.permisoAtributo = permisoAtributo;
	}
	
}
