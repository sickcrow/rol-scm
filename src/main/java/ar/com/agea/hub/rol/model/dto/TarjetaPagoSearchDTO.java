/*
 * @(#)TarjetaPagoSearchDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de niveles de estructuras.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Mauro Mosconi
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class TarjetaPagoSearchDTO implements JSONDTO {

	private static final long serialVersionUID = -8983105979294660122L;
	
	private String codigoCanalEntrada;

	/**
	 * Obtiene el objeto código canal entrada de este DTO. 
	 * 
	 * @return Objeto código canal entrada de este DTO.
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

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoCanalEntrada: ").append(codigoCanalEntrada);
		
		return description.toString();
	}
}
