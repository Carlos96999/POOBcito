import java.util.ArrayList;

/**
 * Write a description of class Peon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Peon extends Ficha
{
    private Circle ficha;

    /**
     * Constructor for objects of class Peon
     */
    public Peon(int posicionX, int posicionY, String color)
    {
        ficha = new Circle(posicionX, posicionY, color);
    }
    
    /**
     * Mover las fichas del tablero
     * @param notation (Cadena que describe el movimiento que tendrá la ficha)
     */
    public void move(ArrayList<Integer> posiciones, ArrayList<Rectangle> casillas){
        int posXCasilla, posYCasilla;
        
        for(int i=1; i<posiciones.size(); i++){
            posXCasilla = casillas.get(i).getPosicionX();
            posYCasilla = casillas.get(i).getPosicionY();
            setPosicionX(posXCasilla+3);
            setPosicionY(posYCasilla+3);
        }
        casillas.get(0).setOcupado(false);
        casillas.get(casillas.size()-1).setOcupado(true);
    }
    
    /**
     * Realizar el mejor movimiento posible para la ficha
     */
    public void move(){
    }
        
    /**
     * Imprimir la representación dle tablero en forma de string
     * @return tablero (Devolver el tablero en forma de string como se visualiza en el problema de la maratón)
     */
    public String move3(){    
        String tablero = "(";
        return tablero;
    }
    
    /**
     * Hacer visible la ficha en el tablero
     */
    public void makeVisible(){
        ficha.makeVisible();
    }
    
    /**
     * Hacer invisible la ficha en el tablero
     */
    public void makeInvisible(){
        ficha.makeInvisible();
    }
    
    /**
     * Cambiar el color de la ficha
     * @param color (Nombre en ingles del color que desea
     */
    public void changeColor(String color){
        ficha.changeColor(color);
    }
    
    /**
     * La posición que tendrá la ficha en el tablero
     * @param i (La fila donde se encuentra)
     * @param j (La columna donde se encuentra)
     */
    public void setPosicionTablero(int i, int j){
        ficha.setPosicionTablero(i, j);
    }
    
    /**
     * Obtenemos la posición de la ficha en el tablero
     */
    public int[] getPosicionTablero(){
        return ficha.getPosicionTablero();
    }
    
    /**
     * Le añadimos la nueva posición en Y
     * @param y (Posicion en y de la figura)
     */
    public void setPosicionY(int y){
        ficha.setPosicionY(y);
    }
    
    /**
     * Le añadimos la nueva posición en X
     * @param x (Posicion en x de la figura)
     */
    public void setPosicionX(int x){
        ficha.setPosicionX(x);
    }
    
    /**
     * Obtener la posición X de la figura
     */
    public int getPosicionX(){
        return ficha.getPosicionX();
    }
    
    /**
     * Obtener la posicion Y de la figura
     */
    public int getPosicionY(){
        return ficha.getPosicionY();
    }
}
