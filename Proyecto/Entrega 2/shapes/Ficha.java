import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Ficha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Ficha
{
    /**
     * Mover las fichas del tablero
     * @param notation (Cadena que describe el movimiento que tendrá la ficha)
     */
    public abstract void move(ArrayList<Integer> posiciones, ArrayList<Rectangle> casillas);
    
    /**
     * Realizar el mejor movimiento posible para la ficha
     */
    public abstract void move();
    
    /**
     * Imprimir la representación dle tablero en forma de string
     * @return tablero (Devolver el tablero en forma de string como se visualiza en el problema de la maratón)
     */
    public abstract String move3();
    
    /**
     * Hacer visible la ficha en el tablero
     */
    public abstract void makeVisible();
    
    /**
     * Hacer invisible la ficha en el tablero
     */
    public abstract void makeInvisible();
    
    /**
     * Cambiar el color de la ficha
     * @param color (Nombre en ingles del color que desea
     */
    public abstract void changeColor(String color);
    
    /**
     * La posición que tendrá la ficha en el tablero
     * @param i (La fila donde se encuentra)
     * @param j (La columna donde se encuentra)
     */
    public abstract void setPosicionTablero(int i, int j);
    
    /**
     * Obtenemos la posición de la ficha en el tablero
     */
    public abstract int[] getPosicionTablero();
    
    /**
     * Le añadimos la nueva posición en Y
     * @param y (Posicion en y de la figura)
     */
    public abstract void setPosicionY(int y);
    
    /**
     * Le añadimos la nueva posición en X
     * @param x (Posicion en x de la figura)
     */
    public abstract void setPosicionX(int x);
    
    /**
     * Obtener la posición X de la figura
     */
    public abstract int getPosicionX();
    
    /**
     * Obtener la posicion Y de la figura
     */
    public abstract int getPosicionY();
}
