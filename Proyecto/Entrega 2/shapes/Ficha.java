import java.awt.Color;

/**
 * Write a description of class Ficha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ficha
{
    private Circle ficha;

    /**
     * Constructor for objects of class Ficha
     */
    public Ficha(int posX, int posY, String color)
    {
        ficha = new Circle(posX, posY, color);        
    }

    /**
     * La posición que tendrá la ficha en el tablero
     * @param i (La fila donde se encuentra)
     * @param j (La columna donde se encuentra)
     */
    public void setPosicionTablero(int i, int j)
    {
        ficha.setPosicionTablero(i, j);
        //this.i = i;
        //this.j = j;
    }
}
