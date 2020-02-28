import java.awt.Color;

/**
 * Write a description of class Ficha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Ficha
{
    //private Object ficha;

    /**
     * Constructor for objects of class Ficha
     * @param posX (Posicion en X de la ficha)
     * @param posY (Posició en Y de la ficha)
     * @param color (Color de la ficha)
     *
    public Ficha(int posX, int posY, String color)
    {
        Circle ficha;
        ficha = new Circle(posX, posY, color);        
    }

    /**
     * Constructor d ela ficha rey
     * @param color (Color de la ficha)
     * @param posX (Posicion en X de la ficha)
     * @param posY (Posició en Y de la ficha)
     *
    public Ficha(String color, int posX, int posY)
    {
        Triangle ficha;
        ficha = new Triangle(posX, posY, color);
    }/
    
    /**
     * Hacer visible la ficha en el tablero
     */
    abstract void makeVisible();
    
    /**
     * Hacer invisible la ficha en el tablero
     */
    abstract void makeInvisible();
    
    /**
     * Cambiar el color de la ficha
     * @param color (Nombre en ingles del color que desea
     */
    abstract void changeColor(String color);
    
    /**
     * La posición que tendrá la ficha en el tablero
     * @param i (La fila donde se encuentra)
     * @param j (La columna donde se encuentra)
     */
    abstract void setPosicionTablero(int i, int j);
    
    /**
     * Obtenemos la posición de la ficha en el tablero
     */
    abstract int[] getPosicionTablero();
    
    /**
     * Le añadimos la nueva posición en Y
     * @param y (Posicion en y de la figura)
     */
    abstract void setPosicionY(int y);
    
    /**
     * Le añadimos la nueva posición en X
     * @param x (Posicion en x de la figura)
     */
    abstract void setPosicionX(int x);
    
    /**
     * Obtener la posición X de la figura
     */
    abstract int getPosicionX();
    
    /**
     * Obtener la posicion Y de la figura
     */
    abstract int getPosicionY();
}
