/*
 * @(#)ComparatorParameterTypeTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para el enum ComparatorParameterType.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class ComparatorParameterTypeTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ComparatorParameterType.
	 */
	@Test
	public void testPromocionRepiteSalidaConstructor() {
		ComparatorParameterType comparatorParameterType = ComparatorParameterType.PROMOCION_REPITE_SALIDA; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ComparatorParameterType\".",
				comparatorParameterType);
	}

	/**
	 * Comprueba la creación de objeto de tipo ComparatorParameterType.
	 */
	@Test
	public void testPrimerFechaTarifaConstructor() {
		ComparatorParameterType comparatorParameterType = ComparatorParameterType.PRIMER_FECHA_TARIFA; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ComparatorParameterType\".",
				comparatorParameterType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ComparatorParameterType.
	 */
	@Test
	public void testSegundaFechaTarifaConstructor() {
		ComparatorParameterType comparatorParameterType = ComparatorParameterType.SEGUNDA_FECHA_TARIFA; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ComparatorParameterType\".",
				comparatorParameterType);
	}
}
