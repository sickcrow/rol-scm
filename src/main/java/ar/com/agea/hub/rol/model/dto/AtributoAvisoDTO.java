/*
 * @(#)AtributoAvisoDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de atributos de avisos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class AtributoAvisoDTO implements JSONDTO {

	private static final long serialVersionUID = 3916792373265710678L;

	
	/**
	 * Identifica al atributo aviso web publicación.
	 */
	public static final String CAMPO_TARJETA_CLARIN_365 = "tarjetaCLARIN365";
	
	/**
	 * Identifica al atributo aviso web publicación.
	 */
	public static final String CAMPO_WEB_PUBLICACION = "webPublicacion";
	
	/**
	 * Identifica al atributo aviso domicilio publicación.
	 */
	public static final String CAMPO_DOMICILIO_PUBLICACION = "domicilioPublicacion";
	
	/**
	 * Identifica al atributo aviso telefono publicación.
	 */
	public static final String CAMPO_TELEFONO_PUBLICACION = "telefonoPublicacion";
	
	/**
	 * Identifica al atributo aviso observación.
	 */
	public static final String CAMPO_OBSERVACION = "observacion";
	
	/**
	 * Identifica al atributo aviso título aviso.
	 */
	public static final String CAMPO_TITULO_AVISO = "tituloAviso";
	
	/**
	 * Identifica al atributo aviso mail.
	 */
	public static final String CAMPO_MAIL = "mail";
	
	/**
	 * Identifica al atributo aviso canje.
	 */
	public static final String CAMPO_CANJE = "canje";
	
	/**
	 * Identifica al atributo aviso precio publicación.
	 */
	public static final String CAMPO_PRECIO_PUBLICACION = "precioPublicacion";
	
	/**
	 * Identifica al atributo aviso tipo color.
	 */
	public static final String CAMPO_TIPO_COLOR = "tipoColor";
	
	/**
	 * Identifica al atributo aviso código enriquecimiento.
	 */
	public static final String CAMPO_CODIGO_ENRIQUECIMIENTO = "codigoEnriquecimiento";
	
	/**
	 * Identifica al atributo aviso forma medio de pago.
	 */
	public static final String CAMPO_FORMA_MEDIO_PAGO = "formaMedioPago";
	
	/**
	 * Identifica al atributo aviso aviso abierto.
	 */
	public static final String CAMPO_AVISO_ABIERTO = "avisoAbierto";
	
	/**
	 * Identifica al atributo aviso tipo moneda.
	 */
	public static final String CAMPO_TIPO_MONEDA = "tipoMoneda";
	
	private String codigo;
	private String valor;
		
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
	 * @param valor Objeto valor de este DTO.
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigo: ").append(codigo);
		description.append(", valor: ").append(valor);
		
		return description.toString();
	}
}
