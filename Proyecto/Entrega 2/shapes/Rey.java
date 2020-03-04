import java.util.ArrayList;

/**
 * Write a description of class Rey here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rey extends Ficha
{
    private Triangle ficha;

    /**
     * Constructor for objects of class Rey
     */
    public Rey(int posicionX, int posicionY, String color)
    {
        ficha = new Triangle(posicionX, posicionY, color);
    }
    
    /**
     * Mover las fichas del tablero
     * @param notation (Cadena que describe el movimiento que tendrá la ficha)
     */
    public void move(ArrayList<Integer> posiciones, ArrayList<Rectangle> casillas){
        //int[] pos; int indice = 0; int guia = 1; 
        int posXCasilla, posYCasilla; 
        //ArrayList<Integer> posiciones = leerCadena(notation);
        //ArrayList<Rectangle> casillas = tablero.obtenerCasilla(posiciones);
        //posXCasilla = casillas.get(0).getPosicionX();
        //posYCasilla = casillas.get(0).getPosicionY();        
        /*
        while(guia != 0){
            int posX = fichas.get("white").get(indice).getPosicionX()-3;
            int posY = fichas.get("white").get(indice).getPosicionY()-3;
            if(posXCasilla == posX && posYCasilla == posY){
                int[] i = fichas.get("white").get(indice).getPosicionTablero();
                select(i[0], i[1]);
                guia = 0;
            }
            indice += 1;
        }
        pos = fichaTomada.getPosicionTablero();*/
        for(int i=1; i<posiciones.size(); i++){
            posXCasilla = casillas.get(i).getPosicionX();
            posYCasilla = casillas.get(i).getPosicionY();
            setPosicionX(posXCasilla+3);
            setPosicionY(posYCasilla+3);
        }
        //tablero.setOcupado(false,pos[0], pos[1]);
    }
    
    /**
     * Realizar el mejor movimiento posible para la ficha
     */
    public void move(){}
    
    /**
     * Imprimir la representación dle tablero en forma de string
     * @return tablero (Devolver el tablero en forma de string como se visualiza en el problema de la maratón)
     */
    public String move3(){
        return "";
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