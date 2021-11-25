/*
 * @(#)ROLFieldNameTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.result;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para el enum ROLFieldName.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class ROLFieldNameTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ROLFieldName.
	 */
	@Test
	public void testUIDValueConstructor() {
		ROLFieldName fieldName = ROLFieldName.UID; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLFieldName\".",
				fieldName);
	}

	/**
	 * Comprueba la creación de objeto de tipo ROLFieldName.
	 */
	@Test
	public void testApellidoValueConstructor() {
		ROLFieldName fieldName = ROLFieldName.APELLIDO; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLFieldName\".",
				fieldName);
	}

	/**
	 * Comprueba la creación de objeto de tipo ROLFieldName.
	 */
	@Test
	public void testNombreValueConstructor() {
		ROLFieldName fieldName = ROLFieldName.NOMBRE; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLFieldName\".",
				fieldName);
	}

	/**
	 * Comprueba la creación de objeto de tipo ROLFieldName.
	 */
	@Test
	public void testGeneroValueConstructor() {
		ROLFieldName fieldName = ROLFieldName.GENERO; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLFieldName\".",
				fieldName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ROLFieldName.
	 */
	@Test
	public void testFechaNacimientoValueConstructor() {
		ROLFieldName fieldName = ROLFieldName.FECHA_NACIMIENTO; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLFieldName\".",
				fieldName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ROLFieldName.
	 */
	@Test
	public void testEmailValueConstructor() {
		ROLFieldName fieldName = ROLFieldName.EMAIL; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLFieldName\".",
				fieldName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ROLFieldName.
	 */
	@Test
	public void testContraseniaValueConstructor() {
		ROLFieldName fieldName = ROLFieldName.CONTRASENIA; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLFieldName\".",
				fieldName);
	}
}
