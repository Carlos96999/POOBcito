import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * Write a description of class Checkers here.
 *
 * @author Carlos Amorocho && Jairo Pulido
 * @version (06/02/2020)
 */
public class Checkers
{
    private int width;
    private int posFichaTomada;
    //private Rectangle[][] tablero;
    //private Rectangle[][] tableroConfig;
    private Tablero tablero;
    private Tablero tableroConfig;    
    private HashMap<String, int[]> posiciones; 
    private ArrayList<Circle> fichasNegras = new ArrayList<Circle>();
    private ArrayList<Circle> fichasBlancas = new ArrayList<Circle>();
    private ArrayList<Triangle> reyBlancas = new ArrayList<Triangle>();
    private ArrayList<Triangle> reyNegras = new ArrayList<Triangle>();
    private ArrayList<Circle> fichasNegrasConfig = new ArrayList<Circle>();
    private ArrayList<Circle> fichasBlancasConfig = new ArrayList<Circle>();
    private ArrayList<Triangle> reyBlancasConfig = new ArrayList<Triangle>();
    private ArrayList<Triangle> reyNegrasConfig = new ArrayList<Triangle>();
    //private Circle ficha;
    private Circle fichaTomada;
    private int contadorBlanco;
    private int contadorNegro;
    private boolean ok;

    /**
     * Constructor for objects of class Checkers
     */
    public Checkers(int width)
    {
        this.width = width;
        tablero = new Tablero(width);
        tableroConfig = new Tablero(width);
        posiciones = new HashMap<String, int[]>();
        hashMap();
        //tablero = new Rectangle[width][width];
        //tableroConfig = new Rectangle[width][width];
        ok = true;
        contadorBlanco = 0;
        contadorNegro = 0;
        //crearTablero();
        //crearFichas();        
        makeVisible();
    }
    
       
    /**
     * Hacer visibles los objetos
     */
    public void makeVisible(){
        /*for(int i=0; i<width; i++){
            for(int j=0; j<width; j++){
                tablero[i][j].makeVisible();
                tableroConfig[i][j].makeVisible();}}*/
        tablero.makeVisible();
        tableroConfig.makeVisible();
        
        for(int i=0; i<fichasNegras.size(); i++){
            fichasNegras.get(i).makeVisible();}
        for(int i=0; i<fichasBlancas.size(); i++){
            fichasBlancas.get(i).makeVisible();}
        for(int i=0; i<reyBlancas.size(); i++){
            reyBlancas.get(i).makeVisible();}
        for(int i=0; i<reyNegras.size(); i++){
            reyNegras.get(i).makeVisible();}
        for(int i=0; i<fichasNegrasConfig.size(); i++){
            fichasNegrasConfig.get(i).makeVisible();}
        for(int i=0; i<fichasBlancasConfig.size(); i++){
            fichasBlancasConfig.get(i).makeVisible();}
        for(int i=0; i<reyBlancasConfig.size(); i++){
            reyBlancasConfig.get(i).makeVisible();}
        for(int i=0; i<reyNegrasConfig.size(); i++){
            reyNegrasConfig.get(i).makeVisible();}
        ok = true;}
    
    /**
     * Hacer invisible los objetos
     */
    public void makeInvisible()
    {
        /*for(int i=0; i<width; i++){
            for(int j=0; j<width; j++){
                tablero[i][j].makeInvisible();
                tableroConfig[i][j].makeInvisible();}
        }*/
        tablero.makeInvisible();
        tableroConfig.makeInvisible();
        
        for(int i=0; i<fichasNegras.size(); i++){
            fichasNegras.get(i).makeInvisible();}
        for(int i=0; i<fichasBlancas.size(); i++){
            fichasBlancas.get(i).makeInvisible();}
        for(int i=0; i<reyBlancas.size(); i++){
            reyBlancas.get(i).makeInvisible();}
        for(int i=0; i<reyNegras.size(); i++){
            reyNegras.get(i).makeInvisible();}
        for(int i=0; i<fichasNegrasConfig.size(); i++){
            fichasNegrasConfig.get(i).makeInvisible();}
        for(int i=0; i<fichasBlancasConfig.size(); i++){
            fichasBlancasConfig.get(i).makeInvisible();}
        for(int i=0; i<reyBlancasConfig.size(); i++){
            reyBlancasConfig.get(i).makeInvisible();}
        for(int i=0; i<reyNegrasConfig.size(); i++){
            reyNegrasConfig.get(i).makeInvisible();}
        ok = true;
    }
    
    /**
     * Seleccionamos la fila y columna de la ficha a jugar
     * @param row (Fila donde se encuentra la ficha)
     * @param column (Columna donde se encuentra la ficha)
     */
    public void select(int row, int column)
    {       
        if (row < this.width && column < this.width){        
            for(int i=0; i<fichasNegras.size(); i++){
                int[] posicion = fichasNegras.get(i).getPosicionTablero();
                if(posicion[0] == row-1 && posicion[1] == column-1)                {
                    fichasNegras.get(i).changeColor("green");
                    posFichaTomada = i;
                    fichaTomada = fichasNegras.get(i);
                }
            }
            if (fichaTomada == null){ok=false;}
        }else{ok=false;}
    }
    
    /**
     * Mover las fichas del tablero
     */
    public void move(String notation)
    {
        int[] pos;
        int posXCasillaIni, posYCasillaIni;
        int posX = posiciones.get(notation)[0];
        int posY = posiciones.get(notation)[1];
        //int[] posicionesFila = {1,-1,1,-1};
        //int[] posicionesColumna = {1,1,-1,-1};
        //posXCasillaFin, posYCasillaFin;
        pos = fichaTomada.getPosicionTablero();        
        posXCasillaIni = tablero.getPosCasilla(pos[0]+posX,pos[1], 1);
        posYCasillaIni = tablero.getPosCasilla(pos[0]+posY,pos[1], 0);
        fichaTomada.setPosicionX(posXCasillaIni+3);
        fichaTomada.setPosicionY(posYCasillaIni+3);
        fichaTomada.setPosicionTablero(pos[0]+posX, pos[1]+posY);
        tablero.setOcupado(true, pos[0]+posX, pos[1]+posY);
        tablero.setOcupado(false,pos[0], pos[1]);
        if(notation == "di"){          
            if(puedeMoverse(notation) == true){
                //posXCasillaIni = tablero[pos[0]+1][pos[1]+1].getPosicionX();
                //posYCasillaIni = tablero[pos[0]+1][pos[1]+1].getPosicionY();
                //posXCasillaIni = tablero.getPosCasilla(pos[0],pos[1], 1);
                //posYCasillaIni = tablero.getPosCasilla(pos[0],pos[1], 0);
                //fichaTomada.setPosicionX(posXCasillaIni+3);
                //fichaTomada.setPosicionY(posYCasillaIni+3);
                //fichaTomada.setPosicionTablero(pos[0]+1, pos[1]+1);
                tablero[pos[0]+1][pos[1]+1].setOcupado(true);
                tablero[pos[0]][pos[1]].setOcupado(false);}}
        else if(notation == "ds"){
            if(puedeMoverse(notation) == true){
                posXCasillaIni = tablero[pos[0]-1][pos[1]+1].getPosicionX();
                posYCasillaIni = tablero[pos[0]-1][pos[1]+1].getPosicionY();
                fichaTomada.setPosicionX(posXCasillaIni+3);
                fichaTomada.setPosicionY(posYCasillaIni+3);
                fichaTomada.setPosicionTablero(pos[0]-1, pos[1]+1);
                tablero[pos[0]-1][pos[1]+1].setOcupado(true);
                tablero[pos[0]][pos[1]].setOcupado(false);
            }
        }
        else if(notation == "ii"){
            if(puedeMoverse(notation) == true){
                posXCasillaIni = tablero[pos[0]+1][pos[1]-1].getPosicionX();
                posYCasillaIni = tablero[pos[0]+1][pos[1]-1].getPosicionY();
                fichaTomada.setPosicionX(posXCasillaIni+3);
                fichaTomada.setPosicionY(posYCasillaIni+3);
                fichaTomada.setPosicionTablero(pos[0]+1, pos[1]-1);
                tablero[pos[0]-1][pos[1]+1].setOcupado(true);
                tablero[pos[0]][pos[1]].setOcupado(false);}}
        else if(notation == "is"){
            if(puedeMoverse(notation) == true){
                posXCasillaIni = tablero[pos[0]-1][pos[1]-1].getPosicionX();
                posYCasillaIni = tablero[pos[0]-1][pos[1]-1].getPosicionY();
                fichaTomada.setPosicionX(posXCasillaIni+3);
                fichaTomada.setPosicionY(posYCasillaIni+3);
                fichaTomada.setPosicionTablero(pos[0]-1, pos[1]-1);
                tablero[pos[0]-1][pos[1]+1].setOcupado(true);
                tablero[pos[0]][pos[1]].setOcupado(false);}}
        else{ok = false;
             JOptionPane.showMessageDialog(null,"No se puede realizar la operación", 
             "Movimiento erróneo", JOptionPane.WARNING_MESSAGE);}
    }
    
    /**
     * Consultar el numero de fichas en cada tablero
     * @return [numerofichastablero,numerofichastableroconfiguracion,numerofichastotal]
     */
    public int[] consult(){
        int piecesTablero = fichasNegras.size() + fichasBlancas.size() + reyBlancas.size() + reyNegras.size();
        int piecesTableroConfig = fichasNegrasConfig.size() + fichasBlancasConfig.size() + reyBlancasConfig.size() + reyNegrasConfig.size();
        int piecesTotal = piecesTablero + piecesTableroConfig;
       
                
        int [] numberpieces = {piecesTablero,piecesTableroConfig,piecesTotal};
        return numberpieces;}
    
    /**
     * Añadir un peón
     * @param white (Valor booleano que nos indica el tipo de ficha a añadir)
     * @param men (Matriz donde la longitud indica la cantidad de fichas a añadir
     *              y los datos dentro de cada subarreglo indican la posición)
     */
    public void add(boolean white, int[][] men){
        int posX;
        int posY;        
        if(white){
            for(int i=0; i<men.length; i++){
                posX = tableroConfig[men[i][0]-1][men[i][1]-1].getPosicionX()+3;
                posY = tableroConfig[men[i][0]-1][men[i][1]-1].getPosicionY()+3;
                fichasBlancasConfig.add(new Circle(posX, posY, "yellow"));
                fichasBlancasConfig.get(contadorBlanco).setPosicionTablero(men[i][0]-1, men[i][1]-1);
                contadorBlanco += 1;}
        }
        else{
            for(int i=0; i<men.length; i++){
                //System.out.println("Longitud de men "+i);
                posX = tableroConfig[men[i][0]][men[i][1]].getPosicionX()+3;
                posY = tableroConfig[men[i][0]][men[i][1]].getPosicionY()+3;
                fichasNegrasConfig.add(new Circle(posX, posY, "white")); 
                fichasNegrasConfig.get(contadorNegro).setPosicionTablero(men[i][0]-1, men[i][1]-1);
                contadorNegro += 1;}}    
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
        int posicion = reyBlancas.size()-1;
        
        if(king){
            posX = tableroConfig[row-1][column-1].getPosicionX()+19;
            posY = tableroConfig[row-1][column-1].getPosicionY()+3;
            reyBlancasConfig.add(new Triangle(posX, posY, "yellow"));
            posicion += 1;
            reyBlancasConfig.get(posicion).setPosicionTablero(posX, posY);}
        else{
            posX = tableroConfig[row-1][column-1].getPosicionX()+19;
            posY = tableroConfig[row-1][column-1].getPosicionY()+3;
            reyNegrasConfig.add(new Triangle(posX, posY, "white"));
            posicion += 1;
            reyNegrasConfig.get(posicion).setPosicionTablero(posX, posY);}
    }
    
    /**
     * Remover una ficha del tablero
     */
    public void remove(int row, int column){
        for(int i=0; i<fichasNegrasConfig.size(); i++){
            int[] pos = fichasNegrasConfig.get(i).getPosicionTablero();
            if(pos[0] == row-1 && pos[1] == column-1){
                fichasNegrasConfig.get(i).makeInvisible();
                fichasNegrasConfig.remove(i);}
        }
        for(int i=0; i<fichasBlancasConfig.size(); i++){
            int[] pos = fichasBlancasConfig.get(i).getPosicionTablero();
            if(pos[0] == row-1 && pos[1] == column-1){
                fichasBlancasConfig.get(i).makeInvisible();
                fichasBlancasConfig.remove(i);}
        }
        for(int i=0; i<reyNegrasConfig.size(); i++){
            int[] pos = reyNegrasConfig.get(i).getPosicionTablero();
            if(pos[0] == row-1 && pos[1] == column-1){
                reyNegrasConfig.get(i).makeInvisible();
                reyNegrasConfig.remove(i);}
        }
        for(int i=0; i<reyBlancasConfig.size(); i++){
            int[] pos = reyBlancasConfig.get(i).getPosicionTablero();
            if(pos[0] == row-1 && pos[1] == column-1){
                reyBlancasConfig.get(i).makeInvisible();
                reyBlancasConfig.remove(i);}
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
     * Verificamos que el movimiento sea valido
     */
    private boolean puedeMoverse(String direccion)
    {
        int[] pos = fichaTomada.getPosicionTablero();
        boolean valor = true;
        if (tablero[pos[0]+1][pos[1]+1].getOcupado() && direccion == "di")
        {
            valor = false;
        }
        else if(tablero[pos[0]-1][pos[1]+1].getOcupado() && direccion == "ds")
        {
            valor = false;
        }
        return valor;
    }
    
    /*
     * Le añadimos al Hash los datos para movernos con las indicaciones
     */
    private void hashMap(){
        int[] pos = {1,1};
        posiciones.put("di",pos);
        pos = new int[] {-1,1};
        posiciones.put("ds",pos);
        pos = new int[] {1,-1};
        posiciones.put("ii",pos);
        pos = new int[] {-1,-1};
        posiciones.put("is",pos);
    }
    /*
     * Crearemos las fichas que tendrá el tablero
     *
    private void crearFichas(int cantidad){
        
        if(width == 4){
            for(int i=0; i<width/2; i++){
                fichasNegras.add(new Circle());
                fichasBlancas.add(new Circle());
                fichasBlancas.get(i).changeColor("yellow");
            }
        }
        else if(width == 6){
            for(int i=0; i<width; i++){
                fichasNegras.add(new Circle());
                fichasBlancas.add(new Circle());
                fichasBlancas.get(i).changeColor("yellow");
            }
        }
        else{
            for(int i=0; i<width+(width/2); i++){
                fichasNegras.add(new Circle());
                fichasBlancas.add(new Circle());
                fichasBlancas.get(i).changeColor("yellow");
            }
        }        
        posicionarFicha();
    }*/
    
    /*
     * Posicionaremos las fichas para iniciar el juego
     *
    private void posicionarFicha()
    {
        int i = 0;
        int j = 0;
        int iFin = tablero.length-1;
        int jFin = tablero[0].length-1;
        int contador = 0;
        int posicionX;
        int posicionY;
        //System.out.println("Entro");
        
        while(contador <= fichasNegras.size()-1){
            if (tablero[i][j].getColor() == "black"){
                fichasNegras.get(contador).setPosicionTablero(i,j);
                fichasBlancas.get(contador).setPosicionTablero(iFin, jFin);
                posicionX = tablero[i][j].getPosicionX();
                posicionY = tablero[i][j].getPosicionY();
                fichasNegras.get(contador).setPosicionX(posicionX+3);
                fichasNegras.get(contador).setPosicionY(posicionY+3);
                tablero[i][j].setOcupado(true);
                posicionX = tablero[iFin][jFin].getPosicionX();
                posicionY = tablero[iFin][jFin].getPosicionY();
                fichasBlancas.get(contador).setPosicionX(posicionX+3);
                fichasBlancas.get(contador).setPosicionY(posicionY+3);
                tablero[iFin][jFin].setOcupado(true);
                contador += 1;                
            }
            
            j += 1;
            jFin -= 1;
            
            if(j == tablero[i].length)
            {
                j = 0;
                jFin = tablero[0].length-1;
                i += 1;
                iFin -= 1;
            }
        }
        
        
    }*/
    
    /*
     * Crearemos el tablero de juego y configuración
     *
    private void crearTablero()
    {
        int columna = 0;
        int columnaConfig = 0;
        int color = 0;
        //Rectangle casilla;
        //Rectangle casillaConfig;
        
        for(int i=0; i<width; i++)
        {      
            int fila = 0;
            int filaConfig = 40*(width)+20;
            
            for(int j=0; j<width; j++)
            {
                tablero[i][j] = new Rectangle();                
                tablero[i][j].moveHorizontal(fila);
                tablero[i][j].moveVertical(columna);
                //casilla = new Rectangle();
                //casilla.moveHorizontal(fila);
                //casilla.moveVertical(columna);
                fila += 40;
                tableroConfig[i][j] = new Rectangle();
                tableroConfig[i][j].moveHorizontal(filaConfig);
                tableroConfig[i][j].moveVertical(columnaConfig);
                //casillaConfig = new Rectangle();
                //casillaConfig.moveHorizontal(filaConfig);
                //casillaConfig.moveVertical(columnaConfig);
                filaConfig += 40;
                
                if(color == 0)
                {
                    tablero[i][j].changeColor("red");
                    //casilla.changeColor("red");
                    color = 1;
                    //casillaConfig.changeColor("red");
                    tableroConfig[i][j].changeColor("red");
                }
                else
                {
                    tablero[i][j].changeColor("black");
                    //casilla.changeColor("black");
                    color = 0;
                    //casillaConfig.changeColor("black");
                    tableroConfig[i][j].changeColor("black");
                }
                
                if(j == width-1)
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
            columnaConfig += 40;
        }        
    }*/
}
