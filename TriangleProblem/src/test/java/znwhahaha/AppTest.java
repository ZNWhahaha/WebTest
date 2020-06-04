package znwhahaha;

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
    public void shouldAnswerWithTrue() throws Exception {
        assertEquals( true,App.triangle(3,3.5f,4));
        assertEquals( false,App.triangle(-1,1,2));
        assertEquals( false,App.triangle(1,-1,2));
        assertEquals( false,App.triangle(1,2,-1));
        assertEquals( false,App.triangle(1,2,3));
        assertEquals( false,App.triangle(1,3,2));
        assertEquals( false,App.triangle(3,1,2));
        assertEquals( true,App.triangle(2,2,3));
        assertEquals( true,App.triangle(3,2,2));
        assertEquals( true,App.triangle(2,3,2));
        assertEquals( true,App.triangle(3,4,5));
        assertEquals( true,App.triangle(2,2,2));


    }
}
