
/**
 * Write a description of class Tablero here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tablero
{
    private Rectangle[][] tablero;
    //private Rectangle[][] tableroConfig;
    private int ancho;

    /**
     * Constructor for objects of class Tablero
     */
    public Tablero(int width)
    {
        ancho = width;
        tablero = new Rectangle[ancho][ancho];
        //tableroConfig = new Rectangle[ancho][ancho];
    }

    /**
     * Hacer visible el tablero
     */
    public void makeVisible()    {
        for(int i=0; i<ancho; i++){
            for(int j=0; j<ancho; j++){
                tablero[i][j].makeVisible();
            }
        }        
    }
    
    /**
     * Hacer invisible el tablero
     */
    public void makeInvisible()    {
        for(int i=0; i<ancho; i++){
            for(int j=0; j<ancho; j++){
                tablero[i][j].makeInvisible();
            }
        }        
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
        
    }
    /*
     * Crearemos el tablero de juego y configuración
     */
    private void crearTablero()
    {
        int columna = 0;
        //int columnaConfig = 0;
        int color = 0;
        //Rectangle casilla;
        //Rectangle casillaConfig;
        
        for(int i=0; i<ancho; i++)
        {      
            int fila = 0;
            int filaConfig = 40*(ancho)+20;
            
            for(int j=0; j<ancho; j++)
            {
                tablero[i][j] = new Rectangle();                
                tablero[i][j].moveHorizontal(fila);
                tablero[i][j].moveVertical(columna);
                //casilla = new Rectangle();
                //casilla.moveHorizontal(fila);
                //casilla.moveVertical(columna);
                fila += 40;
                //tableroConfig[i][j] = new Rectangle();
                //tableroConfig[i][j].moveHorizontal(filaConfig);
                //tableroConfig[i][j].moveVertical(columnaConfig);
                //casillaConfig = new Rectangle();
                //casillaConfig.moveHorizontal(filaConfig);
                //casillaConfig.moveVertical(columnaConfig);
                //filaConfig += 40;
                
                if(color == 0)
                {
                    tablero[i][j].changeColor("red");
                    //casilla.changeColor("red");
                    color = 1;
                    //casillaConfig.changeColor("red");
                    //tableroConfig[i][j].changeColor("red");
                }
                else
                {
                    tablero[i][j].changeColor("black");
                    //casilla.changeColor("black");
                    color = 0;
                    //casillaConfig.changeColor("black");
                    //tableroConfig[i][j].changeColor("black");
                }
                
                if(j == ancho-1)
                {
                    if (tablero[i][j].getColor() == "black")
                    //if(casilla.getColor() == "black" || casillaConfig.getColor() == "black")
                    {
                        color = 1;
                    }
                    else
                    {
                        color = 0;
                    }
                }

                //casilla.makeVisible();                
                //casillaConfig.makeVisible();
            }
            columna += 40;
            //columnaConfig += 40;
        }      
    }
}
