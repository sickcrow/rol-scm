/*
 * @(#)InstantiationTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.common;

/**
 * Brinda una intefaz unificada a todos los JUnit Tests para la instanciación
 * de objetos.
 * <p>
 * Todos los JUnit Tests relacionados con tests de instanciación de objetos
 * (DTOs, Excepcions, etc.) deben extender de esta clase para heredar y
 * utilizar sus prestaciones.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public abstract class InstantiationTest extends SpringContextTest {
}
