
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * Write a description of class Checkers here.
 *
 * @author Carlos Amorocho && Jairo Pulido
 * @version (28/02/2020)
 */
public class Checkers
{
    private int width;
    private int posFichaTomada;
    private int fila;
    private int columna;
    private Tablero tablero;
    private Tablero tableroConfig;
    private HashMap<String, int[]> posiciones;
    private HashMap<String, ArrayList<Ficha>> fichas;
    private Ficha fichaTomada;
    private boolean ok;

    /**
     * Constructor for objects of class Checkers
     */
    public Checkers(int width)
    {
        this.width = width;
        fila = 0;
        columna = 0;
        tablero = new Tablero(width, false);
        tableroConfig = new Tablero(width, true);
        posiciones = new HashMap<String, int[]>();
        fichas = new HashMap<String, ArrayList<Ficha>>();
        fichas.put("yellow", new ArrayList<Ficha>());
        fichas.put("white", new ArrayList<Ficha>());
        //hashMap();
        ok = true;       
        tablero.makeVisible();
        tableroConfig.makeVisible();
    }
    
       
    /**
     * Hacer visibles los objetos
     */
    public void makeVisible(){
        
        for(int i=0; i<fichas.get("yellow").size(); i++){
            fichas.get("yellow").get(i).makeVisible();}
        for(int i=0; i<fichas.get("white").size(); i++){
            fichas.get("white").get(i).makeVisible();}
        ok = true;
    }
    
    /**
     * Hacer invisible los objetos
     */
    public void makeInvisible()
    {        
        for(int i=0; i<fichas.get("white").size(); i++){
            fichas.get("white").get(i).makeVisible();}
        for(int i=0; i<fichas.get("yellow").size(); i++){
            fichas.get("yellow").get(i).makeVisible();}
        ok = true;
    }
    
    /**
     * Seleccionamos la fila y columna de la ficha a jugar
     * @param row (Fila donde se encuentra la ficha)
     * @param column (Columna donde se encuentra la ficha)
     */
    public void select(int row, int column)
    {
        fila = row; columna = column;
        int posX; int posXCasilla = tablero.getPosCasilla(row-1, column-1, 1);
        int posY; int posYCasilla = tablero.getPosCasilla(row-1, column-1, 0);
        if (row < this.width && column < this.width){        
            for(int i=0; i<fichas.get("white").size(); i++){
                posX = fichas.get("white").get(i).getPosicionX();
                posY = fichas.get("white").get(i).getPosicionY();
                //posXCasilla = tablero.getPosCasilla(row-1, column-1, 1);
                //posyCasilla = tablero.getPosCasilla(row-1, column-1, 0);
                //int[] pos = fichas.get("white").get(i).getPosicionTablero();
                //if(pos[0] == row-1 && pos[1] == column-1){
                if(posX-3 == posXCasilla && posY-3 == posYCasilla ){
                    fichas.get("white").get(i).changeColor("green");
                    posFichaTomada = i;
                    fichaTomada = fichas.get("white").get(i);
                }
            }
            ok=true;
            
            if (fichaTomada == null){ok=false;}
        }else{ok=false;}
    }
    
    /*
     * Mover las fichas del tablero
     * @param notation (Cadena que describe el movimiento que tendrá la ficha)
     */
    public void move(String notation)
    {
        ArrayList<Integer> posiciones = leerCadena(notation);
        ArrayList<Rectangle> casillas = tablero.obtenerCasilla(posiciones);
        fichaTomada.move(posiciones, casillas);
        /*
        int[] pos; int indice = 0; int guia = 1; int posXCasilla, posYCasilla; ArrayList<Integer> posiciones = leerCadena(notation);
        ArrayList<Rectangle> casillas = tablero.obtenerCasilla(posiciones);
        posXCasilla = casillas.get(0).getPosicionX();
        posYCasilla = casillas.get(0).getPosicionY();       
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
        pos = fichaTomada.getPosicionTablero();
        for(int i=1; i<posiciones.size(); i++){
            posXCasilla = casillas.get(i).getPosicionX();
            posYCasilla = casillas.get(i).getPosicionY();
            fichaTomada.setPosicionX(posXCasilla+3);
            fichaTomada.setPosicionY(posYCasilla+3);
        }
        tablero.setOcupado(false,pos[0], pos[1]);*/
    }
    
    
    /**
     * Realizar el mejor movimiento posible para la ficha
     */
    public void move(){
        //if(tablero.existeFicha(fila, columna)){}
        fichaTomada.move();        
    }
    
    
    
    /*
     * Imprimir la representación dle tablero en forma de string
     * @return tablero (Devolver el tablero en forma de string como se visualiza en el problema de la maratón)
     *
    public String move(){
        return "";
    }*/
    
    /**
     * Consultar el numero de fichas en cada tablero
     * @return [numerofichastablero,numerofichastableroconfiguracion,numerofichastotal]
     */
    public int[] consult(){
        int []piecesTablero = {fichas.get("white").size(),fichas.get("yellow").size(),fichas.get("white").size() + fichas.get("yellow").size()};
        //int piecesTablero = fichasNegras.size() + fichasBlancas.size() + reyBlancas.size() + reyNegras.size();
        //int piecesTableroConfig = fichasNegrasConfig.size() + fichasBlancasConfig.size() + reyBlancasConfig.size() + reyNegrasConfig.size();
        //int piecesTotal = piecesTablero + piecesTableroConfig;               
        //int [] numberpieces = {piecesTablero,piecesTableroConfig,piecesTotal};
        return piecesTablero;
    }
    
    /**
     * Añadir un peón
     * @param white (Valor booleano que nos indica el tipo de ficha a añadir)
     * @param men (Matriz donde la longitud indica la cantidad de fichas a añadir
     *              y los datos dentro de cada subarreglo indican la posición)
     */
    public void add(boolean white, int[][] men){
               if(white){
            for(int i=0; i<men.length; i++){
                crearFicha("yellow", men[i][0]-1, men[i][1]-1, false);
            }
        }
        else{
            for(int i=0; i<men.length; i++){
                crearFicha("white", men[i][0]-1, men[i][1]-1, false);
            }}    
    }
    
    /**
     * Añadir un rey
     * @param king (Booleano para identificar que tipo de ficha rey se pondrá)
     * @param row (Fila donde pondremos al rey)
     * @param column (Columna donde pondremos al rey)
     */
    public void add(boolean king, int row, int column)
    {
        int posX;
        int posY;
        if(king){
            crearFicha("yellow", row-1, column-1, true);
        }
        else{
            crearFicha("white", row-1, column-1, true);
        }
  
}
    
    /**
     * Remover una ficha del tablero
     */
    public void remove(int row, int column){        
        for(int i=0; i<fichas.get("white").size(); i++){
            int[] pos = fichas.get("white").get(i).getPosicionTablero();
            if(pos[0] == row-1 && pos[1] == column-1){
                fichas.get("white").get(i).makeInvisible();
                fichas.get("white").remove(i);}
        }
        for(int i=0; i<fichas.get("yellow").size(); i++){
            int[] pos = fichas.get("yellow").get(i).getPosicionTablero();
            if(pos[0] == row-1 && pos[1] == column-1){
                fichas.get("yellow").get(i).makeInvisible();
                fichas.get("yellow").remove(i);}
        }        
    }
    
    /**
     * Intercambiar los tableros de configuración y juego
     */
    public void swap(){
        Ficha ficha;int posX;int posY;
        int espacio = tableroConfig.getPosCasilla(0, 0, 1) - tablero.getPosCasilla(0, 0, 1);
        //int[] pos;
        int indicador = tablero.getPosCasilla(width-1, width-1, 1);        
        
        for(int i=0; i<fichas.get("white").size(); i++)
        {            
            ficha = fichas.get("white").get(i);
            ficha.makeInvisible();
            //pos = ficha.getPosicionTablero();          
            if(indicador < ficha.getPosicionX()){
                posX = ficha.getPosicionX() - espacio;
                posY = ficha.getPosicionY();
                //posX = tablero.getPosCasilla(pos[0], pos[1], 1)+3;
                //posY = tablero.getPosCasilla(pos[0], pos[1], 0)+3;
            }
            else
            {
                posX = ficha.getPosicionX() + espacio;
                posY = ficha.getPosicionY();
                //posX = tableroConfig.getPosCasilla(pos[0], pos[1], 1)+3;
                //posY = tableroConfig.getPosCasilla(pos[0], pos[1], 0)+3;
            }
            ficha.setPosicionX(posX);
            ficha.setPosicionY(posY);
            ficha.makeVisible();
        }        
    }
    
    /**
     * Revisamos que la última acción se haya realizado
     */
    public boolean ok()
    { return ok;}
    
    /**
     * Finaliza el programa
     */
    public void finish(){
        System.exit(0);        
    }
    
    /*
     * Saber si existen fichas alrededor de la seleccionada
     */
    private boolean existeFicha(){
        
        return true;
    }
    
    /*
     * Leemos la cadena para extraer sus datos
     * @param movimiento (Cadena de caracteres que nos dice en que casilla se realiza el movimiento)
     * @return casillas (Las casillas en forma de enteros)
     */
    private ArrayList<Integer> leerCadena(String movimiento){      
        ArrayList<Integer> casillas = new ArrayList<Integer>();
        String numero = "";
        for(int i=0; i<movimiento.length(); i++){
            if(movimiento.charAt(i) != 'x'){
                numero += movimiento.charAt(i);}
            if(movimiento.charAt(i) == 'x' || i == movimiento.length()-1){
                int num = Integer.parseInt(numero);
                casillas.add(num);
                numero = "";
            }
        }
        return casillas;
    }
    
    /*
     * Creamos las fichas según las especificaciones
     * @param color (Color de la ficha a crear)
     * @param cantidad (Cantidad de fichas a crear)
     * @param tipo (True si es rey, false si es peón)
     */
    private void crearFicha(String color, int fila, int columna, boolean tipo){
        int posX;
        int posY;
        ArrayList<Ficha>ficha = new ArrayList<Ficha>();
        posX = tableroConfig.getPosCasilla(fila, columna, 1)+3;
        posY = tableroConfig.getPosCasilla(fila, columna, 0)+3;
        ficha = fichas.get(color);
        if (tableroConfig.getOcupado(fila,columna)){
            JOptionPane.showMessageDialog(null,"La casilla está ocupada");        
            ok=false;
        }
        else{
            if(!tipo){
            ficha.add(new Peon(posX, posY, color));
            ficha.get(ficha.size()-1).setPosicionTablero(fila, columna);
        }
        else{
            ficha.add(new Rey(posX, posY, color));
            ficha.get(ficha.size()-1).setPosicionTablero(fila, columna);
        }
        tableroConfig.setOcupado(true, fila, columna);
        ok=true;
        }
    }
    
    /*
     * Verificamos que el movimiento sea valido
     */
    private boolean puedeMoverse(String direccion)
    {
        int[] pos = fichaTomada.getPosicionTablero();
        boolean valor = true;
        if(tablero.getOcupado(pos[0]+1, pos[1]+1) && direccion == "di")
        {
            valor = false;
        }
        else if(tablero.getOcupado(pos[0]-1, pos[1]+1) && direccion == "ds")
        {
            valor = false;
        }
        return valor;
    }
    
    /*
     * Le añadimos al Hash los datos para movernos con las indicaciones
     *
    private void hashMap(){
        int[] pos = {1,1};
        posiciones.put("di",pos);
        pos = new int[] {-1,1};
        posiciones.put("ds",pos);
        pos = new int[] {1,-1};
        posiciones.put("ii",pos);
        pos = new int[] {-1,-1};
        posiciones.put("is",pos);
    }*/
}
