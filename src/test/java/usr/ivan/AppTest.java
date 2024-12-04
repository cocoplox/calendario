package usr.ivan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );

    }
    @Test
    public void HelloWorldTests(){
        String esperado = "Hola Mundo";
        App app = new App();
        String resultado = app.Hola();
        assertEquals(esperado,resultado);
    }
}
