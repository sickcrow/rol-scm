/*
 * @(#)JSONFactoryTest.java		1.0 21/08/2013
 */

package ar.com.agea.hub.rol.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;

import ar.com.agea.hub.rol.common.GenericTestException;
import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.TemplateDetalladoDTO;

/**
 * Representa JUnit Tests de inicializaci�n para la clase JSONFactory.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 21/08/2013
 */
public class JSONFactoryTest extends InstantiationTest {

	/**
	 * Comprueba la ejecuci�n de m�todo createJSONObjectAsString de la clase JSONFactory. 
	 */
	@Test
	public void testCreateJSONObjectAsStringMethod() {
		String output = null;
		
		TemplateDetalladoDTO input = new TemplateDetalladoDTO();
		input.setCodigo("CODIGO");
		
		try {
			output = JSONFactory.createJSONObjectAsString(input);
		} catch (IOException e) {
			throw new GenericTestException("Se produjo un error al ejecutar el m�todo acceder createJSONObjectAsString de la clase JSONFactory.", e);
		}
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createJSONObjectAsString\" de la clase \"JSONFactory\".",
				output);
		Assert.assertTrue("Ha fallado la llamada al m�todo \"createJSONObjectAsString\" de la clase \"JSONFactory\".",
				output.contains("CODIGO"));
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo CreateObject de la clase JSONFactory. 
	 */
	@Test
	public void testFirstCreateObjectMethod() {
		TemplateDetalladoDTO output = null;
		
		String input = "{\"codigo\":\"CODIGO\"}";
		
		try {
			output = JSONFactory.createObject(input, TemplateDetalladoDTO.class);
		} catch (IOException e) {
			throw new GenericTestException("Se produjo un error al ejecutar el m�todo acceder CreateObject de la clase JSONFactory.", e);
		}
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"CreateObject\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"CreateObject\" de la clase \"JSONFactory\".",
				output.getCodigo());
		Assert.assertTrue("Ha fallado la llamada al m�todo \"CreateObject\" de la clase \"JSONFactory\".",
				output.getCodigo().equals("CODIGO"));
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo CreateObject de la clase JSONFactory. 
	 */
	@Test
	public void testSecondCreateObjectMethod() {
		List<TemplateDetalladoDTO> output = null;
		
		String input = "[{\"codigo\":\"CODIGO\"},{\"codigo\":\"VALOR\"},{\"codigo\":\"DATO\"}]";
		
		try {
			output = JSONFactory.createObject(input, new TypeReference<List<TemplateDetalladoDTO>>(){});
		} catch (IOException e) {
			throw new GenericTestException("Se produjo un error al ejecutar el m�todo acceder CreateObject de la clase JSONFactory.", e);
		}
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"CreateObject\" de la clase \"JSONFactory\".",
				output);
		Assert.assertTrue("Ha fallado la llamada al m�todo \"CreateObject\" de la clase \"JSONFactory\".",
				!output.isEmpty());
		Assert.assertTrue("Ha fallado la llamada al m�todo \"CreateObject\" de la clase \"JSONFactory\".",
				output.size() == 3);
		
		List<String> codigos = new ArrayList<String>();
		
		for (TemplateDetalladoDTO templateDetallado : output) {
			codigos.add(templateDetallado.getCodigo());
		}
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"CreateObject\" de la clase \"JSONFactory\".",
				codigos.contains(("CODIGO")));
		Assert.assertTrue("Ha fallado la llamada al m�todo \"CreateObject\" de la clase \"JSONFactory\".",
				codigos.contains(("VALOR")));
		Assert.assertTrue("Ha fallado la llamada al m�todo \"CreateObject\" de la clase \"JSONFactory\".",
				codigos.contains(("DATO")));
	}
}
