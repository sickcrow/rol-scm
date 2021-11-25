/*
 * @(#)ViewNamingName.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

/**
 * Representa los nombres de las vistas ROL.
 * <p>
 * Estos nombres son utilizados por la clase ROLController para que
 * Spring Web MVC direccione a la página jsp relacionada. 
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public enum ViewNamingName {

	CREAR_AVISO("crearAviso"),
	MIS_AVISOS("misAvisos"),
	INTERNAL_ERROR("internalError"),
	EXTERNAL_ERROR("externalError"),
	LOGIN("login"),
	LOGOUT("logout"),
	VERSION("version"),
	REGISTRARME("registrarme"),
	DATOS_PERSONALES("datosPersonales"),
	PAGINA_NO_ENCONTRADA("paginaNoEncontrada"),
	TERMINOS("terminos"),
	PREGUNTAS("preguntasFrecuentes"),
	ACTUALIZA_NAVEGADOR("actualizaNavegador");
	
	private String name;
	
	private ViewNamingName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el nombre de la página jsp representado por su nombre.
	 * 
	 * @return Página jsp direccionada.
	 */
	public String getName() {
		return name;
	}
}
