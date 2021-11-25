/*
 * @(#)ProductoComercialDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de productos comerciales.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ProductoComercialDTO implements JSONDTO {
	
	private static final long serialVersionUID = -5240378209026998150L;

	/**
	 * Identifica el tipo de este DTO.
	 * 
	 * @author      Eduardo Barrera
	 * @version		1.0 06/06/2013
	 */
	public static enum Tipo {PAPEL, WEB;};
	
	private Tipo tipo;
	private String codigo;
	private ProductoDTO producto;
	private ProductoTecnicoDTO productoTecnico;
	
	private Long id;
	
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
	 * @param codigo Objeto tipo de este DTO.
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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
	 * Obtiene el objeto producto de este DTO. 
	 * 
	 * @return Objeto producto de este DTO.
	 */
	public ProductoDTO getProducto() {
		return producto;
	}

	/**
	 * Setea el objeto producto de este DTO.
	 * 
	 * @param codigo Objeto producto de este DTO.
	 */
	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	/**
	 * Obtiene el objeto producto técnico de este DTO. 
	 * 
	 * @return Objeto producto técnico de este DTO.
	 */
	public ProductoTecnicoDTO getProductoTecnico() {
		return productoTecnico;
	}

	/**
	 * Setea el objeto producto técnico de este DTO.
	 * 
	 * @param productoTecnico Objeto producto técnico de este DTO.
	 */
	public void setProductoTecnico(ProductoTecnicoDTO productoTecnico) {
		this.productoTecnico = productoTecnico;
	}

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("tipo: [").append(tipo).append("]");
		description.append(", codigo: ").append(codigo);
		description.append(", producto: [").append(producto).append("]");
		description.append(", productoTecnico: [").append(productoTecnico).append("]");
		
		return description.toString();
	}
}
