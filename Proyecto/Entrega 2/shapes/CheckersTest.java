

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CheckersTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CheckersTest
{
    @Test
    public void deberiaRemover()
    {
       Checkers checkersprueba = new Checkers(8);
       checkersprueba.add(false, 1,2);
       checkersprueba.remove(1,2);
       assertEquals(true, checkersprueba.ok());
    }
    
    
    @Test
     public void noDeberiaAdicionar()
    {
       Checkers checkersprueba = new Checkers(8);
       checkersprueba.add(false, 1,2);
       checkersprueba.add(true,1,2);
       
       assertEquals(false, checkersprueba.ok());
    }
    @Test
    public void deberiaAdicionar(){
       Checkers checkprueba = new Checkers(8);
       checkprueba.add(true,4,5);
       assertEquals(true,checkprueba.ok());
    }
    @Test
    public void deberiaSeleccionar()
{
    Checkers checkersprueba = new Checkers(8);
    checkersprueba.add(false, 2, 3);
    checkersprueba.swap();
    checkersprueba.select(1, 2);
    assertEquals(true, checkersprueba.ok());
   
}
    @Test
    public void noDeberiaSeleccionar(){
        Checkers checkersprueba = new Checkers(8);
        checkersprueba.add(false, 2, 3);
        checkersprueba.swap();
        checkersprueba.select(2, 3);
        assertEquals(false, checkersprueba.ok());
    }
}