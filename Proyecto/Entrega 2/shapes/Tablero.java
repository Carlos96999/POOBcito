import java.util.ArrayList;
import java.util.HashMap;

/**
 * Write a description of class Tablero here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tablero
{
    private Rectangle[][] tablero;
    //private HashMap<String, Rectangle[]> tablero;
    private int ancho;
    private boolean esDeConfig;
    private boolean esVisible;

    /**
     * Constructor for objects of class Tablero
     */
    public Tablero(int width, boolean tipo)
    {
        ancho = width;
        tablero = new Rectangle[ancho][ancho];
        //tablero = new HashMap<String, Rectangle[]>();
        //tablero.put("CR", new Rectangle[ancho]);
        //tablero.put("CN", new Rectangle[ancho]);
        esDeConfig = tipo;
        esVisible = false;
        crearTablero();
    }

    /**
     * Hacer visible el tablero
     */
    public void makeVisible(){
        /*if(!esVisible){
            for(int i=0; i<ancho*(ancho/2); i++){
                tablero.get("CR")[i].makeVisible();
                tablero.get("CN")[i].makeVisible();
            }
            esVisible = true;
        }*/
        
        if(!esVisible){
            for(int i=0; i<tablero.length; i++){
                for(int j=0; j<tablero[i].length; j++){
                    tablero[i][j].makeVisible();
                }
            }
            esVisible = true;}
    }
    
    /**
     * Hacer invisible el tablero
     */
    public void makeInvisible(){
        /*if(!esVisible){
            for(int i=0; i<ancho*(ancho/2); i++){
                tablero.get("CR")[i].makeInvisible();
                tablero.get("CN")[i].makeInvisible();
            }
            esVisible = true;
        }*/
        if(esVisible){
            for(int i=0; i<tablero.length; i++){
                for(int j=0; j<tablero[i].length; j++){
                    tablero[i][j].makeInvisible();
                }
            }
            esVisible = false;}
    }
    
    /**
     * Obtener la posición x o y de la casilla
     * @param fila (Fila donde encontraremos la casilla)
     * @param columna (Columna donde encontraremos la casilla)
     * @param guia (1 si debemos conocer la posicón x, 0 si debemos conocer la posición y)
     */
    public int getPosCasilla(int fila, int columna, int guia){
        int posicion = 0;
        
        if(guia == 1){posicion = tablero[fila][columna].getPosicionX();}
        else{posicion = tablero[fila][columna].getPosicionY();}

        return posicion;
    }
    
    /**
     * Actualizar la casilla si esta ocupada o no
     * @param ocupado (Booleano que nos actualiza la casilla)
     * @param fila (Fila de la casilla a actualizar)
     * @param columna (Columna de la casilla a actualizar)
     */
    public void setOcupado(boolean ocupado, int fila, int columna){
        tablero[fila][columna].setOcupado(ocupado);
    }
    
    /**
     * Nos dice si está ocupada la casilla
     */
    public boolean getOcupado(int fila, int columna){
        return tablero[fila][columna].getOcupado();
    }
    
    /**
     * Nos devolverá las casillas que necesitamos para trabajar
     * @param identificadores (Una lista de los identificadores de las casillas que necesitamos)
     * @return casillas (Una lista con las casillas que necesitamos)
     */
    public ArrayList<Rectangle> obtenerCasilla(ArrayList<Integer> identificadores){
        ArrayList<Rectangle> casillas = new ArrayList<Rectangle>();
        int indice = 0;
        int i = 0;
        int j = 0;
        int guia = 0;
        while(indice != identificadores.size()){
            if(identificadores.get(indice) == tablero[i][j].getNumeroCasilla()){
                casillas.add(tablero[i][j]);
                indice += 1;
                guia = 0;
            }
            j += 1;
            if(j>=tablero[i].length){i += 1; j = 0;}
            if(indice-1 > 0 && indice < identificadores.size() && guia == 0 && identificadores.get(indice-1) > identificadores.get(indice)){
                i = 0; j = 0; guia = 1;
            }
        }
        return casillas;
    }
    
    /*
     * Crearemos el tablero de juego y configuración
     */
    private void crearTablero(){
        int columna = 0;
        int fila = 0;
        int color = 0;
        int contador = 0;
        Rectangle casilla;
        for(int i=0; i<ancho; i++){   
            if(esDeConfig){fila = 40*(ancho)+20;}
            else{fila = 0;}            
            for(int j=0; j<ancho; j++){
                tablero[i][j] = new Rectangle();                
                tablero[i][j].moveHorizontal(fila);
                tablero[i][j].moveVertical(columna);
                //casilla = new Rectangle();
                //casilla.moveHorizontal(fila);
                //casilla.moveVertical(columna);
                fila += 40;                
                if(color == 0){
                    tablero[i][j].changeColor("red");
                    //tablero.get("CR")[j] = casilla;
                    color = 1;}
                else{
                    tablero[i][j].changeColor("black");
                    //casilla.setNumeroCasilla(contador += 1);
                    //tablero.get("CN")[j] = casilla;
                    color = 0;
                    tablero[i][j].setNumeroCasilla(contador += 1);                    
                }                
                if(j == ancho-1){
                    if (tablero[i][j].getColor() == "black"){color = 1;}
                    else{color = 0;}
                }
            }
            columna += 40;
        }      
    }
}
