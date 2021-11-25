/*
 * @(#)OrdenamientoAvisoDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase OrdenamientoAvisoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class OrdenamientoAvisoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo OrdenamientoAvisoDTO.
	 */
	@Test
	public void testConstructor() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"OrdenamientoAvisoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"OrdenamientoAvisoDTO\"" 
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setTipoDato y getTipoDato de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetTipoDatoMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		String tipoDato = "TIPO_DATO";
		
		dto.setTipoDato(tipoDato);
		
		String tmp = dto.getTipoDato();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipoDato\" o \"getTipoDato\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipoDato\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", tipoDato, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setObligatorio y getObligatorio de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetObligatorioMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		Boolean obligatorio = true;
		
		dto.setObligatorio(obligatorio);
		
		Boolean tmp = dto.getObligatorio();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObligatorio\" o \"getObligatorio\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getObligatorio\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", obligatorio, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setOrden y getOrden de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetOrdenMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		Long orden = 300L;
		
		dto.setOrden(orden);
		
		Long tmp = dto.getOrden();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setOrden\" o \"getOrden\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getOrden\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", orden, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFormato y getFormato de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetFormatoMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		String formato = "FORMATO";
		
		dto.setFormato(formato);
		
		String tmp = dto.getFormato();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFormato\" o \"getFormato\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFormato\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", formato, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMuestraDefault y getMuestraDefault de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetMuestraDefaultMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		Boolean muestraDefault = true;
		
		dto.setMuestraDefault(muestraDefault);
		
		Boolean tmp = dto.getMuestraDefault();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMuestraDefault\" o \"getMuestraDefault\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMuestraDefault\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", muestraDefault, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setOcultarValorUnico y getOcultarValorUnico de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetOcultarValorUnicoMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		Boolean ocultarValorUnico = true;
		
		dto.setOcultarValorUnico(ocultarValorUnico);
		
		Boolean tmp = dto.getOcultarValorUnico();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setOcultarValorUnico\" o \"getOcultarValorUnico\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getOcultarValorUnico\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", ocultarValorUnico, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setValidacion y getValidacion de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetValidacionMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		String validacion = "VALIDACION";
		
		dto.setValidacion(validacion);
		
		String tmp = dto.getValidacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setValidacion\" o \"getValidacion\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getValidacion\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", validacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDescValidacion y getDescValidacion de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetDescValidacionMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		String descValidacion = "DESC_VALIDACION";
		
		dto.setDescValidacion(descValidacion);
		
		String tmp = dto.getDescValidacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDescValidacion\" o \"getDescValidacion\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDescValidacion\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", descValidacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIdPadre y getIdPadre de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdPadreMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		Long idPadre = 300L;
		
		dto.setIdPadre(idPadre);
		
		Long tmp = dto.getIdPadre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIdPadre\" o \"getIdPadre\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIdPadre\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", idPadre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setIdSubrubro y getIdSubrubro de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdSubrubroMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		Long idSubrubro = 300L;
		
		dto.setIdSubrubro(idSubrubro);
		
		Long tmp = dto.getIdSubrubro();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIdSubrubro\" o \"getIdSubrubro\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIdSubrubro\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", idSubrubro, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDescAyuda y getDescAyuda de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetDescAyudaMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		String descAyuda = "DESC_AYUDA";
		
		dto.setDescAyuda(descAyuda);
		
		String tmp = dto.getDescAyuda();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDescAyuda\" o \"getDescAyuda\" de la clase \"OrdenamientoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDescAyuda\" de la clase \"OrdenamientoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", descAyuda, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase OrdenamientoAvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		OrdenamientoAvisoDTO dto = new OrdenamientoAvisoDTO();
		
		dto.setId(300L);
		dto.setCodigo("CODIGO");
		dto.setTipoDato("TIPO_DATO");
		dto.setObligatorio(true);
		dto.setOrden(300L);
		dto.setFormato("FORMATO");
		dto.setMuestraDefault(true);
		dto.setOcultarValorUnico(true);
		dto.setValidacion("VALIDACION");
		dto.setDescValidacion("DESC_VALIDACION");
		dto.setIdPadre(300L);
		dto.setIdSubrubro(300L);
		dto.setDescAyuda("DESC_AYUDA");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"OrdenamientoAvisoDTO\".", tmp);
	}
}
