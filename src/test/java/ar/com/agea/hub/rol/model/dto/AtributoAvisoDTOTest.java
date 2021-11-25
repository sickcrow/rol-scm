/*
 * @(#)AtributoAvisoDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase AtributoAvisoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class AtributoAvisoDTOTest extends InstantiationTest {

	/**
	 * Comprueba el contenido de la constante CAMPO_WEB_PUBLICACION.
	 */
	@Test
	public void testCampoWebPublicacionConstant() {
		String constant = AtributoAvisoDTO.CAMPO_WEB_PUBLICACION; 
		String tmp = "webPublicacion";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_WEB_PUBLICACION\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_DOMICILIO_PUBLICACION.
	 */
	@Test
	public void testCampoDomicilioPublicacionConstant() {
		String constant = AtributoAvisoDTO.CAMPO_DOMICILIO_PUBLICACION; 
		String tmp = "domicilioPublicacion";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_DOMICILIO_PUBLICACION\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_TELEFONO_PUBLICACION.
	 */
	@Test
	public void testCampoTelefonoPublicacionConstant() {
		String constant = AtributoAvisoDTO.CAMPO_TELEFONO_PUBLICACION; 
		String tmp = "telefonoPublicacion";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_TELEFONO_PUBLICACION\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_OBSERVACION.
	 */
	@Test
	public void testCampoObservacionConstant() {
		String constant = AtributoAvisoDTO.CAMPO_OBSERVACION; 
		String tmp = "observacion";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_OBSERVACION\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_TITULO_AVISO.
	 */
	@Test
	public void testCampoTituloAvisoConstant() {
		String constant = AtributoAvisoDTO.CAMPO_TITULO_AVISO; 
		String tmp = "tituloAviso";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_TITULO_AVISO\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_MAIL.
	 */
	@Test
	public void testCampoMailConstant() {
		String constant = AtributoAvisoDTO.CAMPO_MAIL; 
		String tmp = "mail";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_MAIL\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_CANJE.
	 */
	@Test
	public void testCampoCanjeConstant() {
		String constant = AtributoAvisoDTO.CAMPO_CANJE; 
		String tmp = "canje";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_CANJE\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_PRECIO_PUBLICACION.
	 */
	@Test
	public void testCampoPrecioPublicacionConstant() {
		String constant = AtributoAvisoDTO.CAMPO_PRECIO_PUBLICACION; 
		String tmp = "precioPublicacion";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_PRECIO_PUBLICACION\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_TIPO_COLOR.
	 */
	@Test
	public void testCampoTipoColorConstant() {
		String constant = AtributoAvisoDTO.CAMPO_TIPO_COLOR; 
		String tmp = "tipoColor";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_TIPO_COLOR\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_CODIGO_ENRIQUECIMIENTO.
	 */
	@Test
	public void testCampoCodigoEnriquecimientoConstant() {
		String constant = AtributoAvisoDTO.CAMPO_CODIGO_ENRIQUECIMIENTO; 
		String tmp = "codigoEnriquecimiento";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_CODIGO_ENRIQUECIMIENTO\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_FORMA_MEDIO_PAGO.
	 */
	@Test
	public void testCampoFormaMedioPagoConstant() {
		String constant = AtributoAvisoDTO.CAMPO_FORMA_MEDIO_PAGO; 
		String tmp = "formaMedioPago";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_FORMA_MEDIO_PAGO\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_AVISO_ABIERTO.
	 */
	@Test
	public void testCampoAvisoAbiertoConstant() {
		String constant = AtributoAvisoDTO.CAMPO_AVISO_ABIERTO; 
		String tmp = "avisoAbierto";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_AVISO_ABIERTO\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba el contenido de la constante CAMPO_TIPO_MONEDA.
	 */
	@Test
	public void testCampoTipoMonedaConstant() {
		String constant = AtributoAvisoDTO.CAMPO_TIPO_MONEDA; 
		String tmp = "tipoMoneda";
		
		Assert.assertEquals("El valor contenido por la constante \"CAMPO_TIPO_MONEDA\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde con el valor esperado.", constant, tmp);
	}
	
	/**
	 * Comprueba la creaci�n de objeto de tipo AtributoAvisoDTO.
	 */
	@Test
	public void testConstructor() {
		AtributoAvisoDTO dto = new AtributoAvisoDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"AtributoAvisoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase AtributoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		AtributoAvisoDTO dto = new AtributoAvisoDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"AtributoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setValor y getValor de la clase AtributoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetValorMethod() {
		AtributoAvisoDTO dto = new AtributoAvisoDTO();
		String valor = "VALOR";
		
		dto.setValor(valor);
		
		String tmp = dto.getValor();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setValor\" o \"getValor\" de la clase \"AtributoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getValor\" de la clase \"AtributoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", valor, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase AtributoAvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		AtributoAvisoDTO dto = new AtributoAvisoDTO();
		
		dto.setCodigo("CODIGO");
		dto.setValor("VALOR");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"AtributoAvisoDTO\".", tmp);
	}
}
