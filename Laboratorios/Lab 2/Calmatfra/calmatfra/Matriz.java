/**
 * @author ECI, 2019
 *
 */
public class Matriz{

    private Fraccionario [][] matriz;
    
    /**
     * Retorna una matriz dados sus elementos. Los fraccionarios se representan como {numerador, denominador}
     */
    
    public static boolean esMatriz (int [][][] elementos){
        return false;
    }
    
    /**
     * Crea una matriz dado los elementos para crear el fraccionario
     * @param elementos (Dato donde encontraremos los fraccionarios, la tercer casilla
     *                   es donde encontraremos los datos del fraccionario a crear {{{1,2},{2,3}}}
     */
    public Matriz (int [][][] elementos) {
        matriz = new Fraccionario[elementos.length][elementos[0].length];
        
        for(int i=0; i<elementos.length; i++)
        {            
            for(int j=0; j<elementos[i].length; j++)
            {
                matriz[i][j] = new Fraccionario(elementos[i][j][0], elementos[i][j][1]);
            }
        }
    }    
    
    /**
     * Retorna una matriz dados sus elementos.
     * @param elementos  (Matriz llena de objetos de tipo fraccionario
     */
    public Matriz (Fraccionario  elementos[][]) {
        matriz = new Fraccionario[elementos.length][elementos[0].length];

        for(int i=0; i<elementos.length; i++)
        {            
            for(int j=0; j<elementos[i].length; j++)
            {
                matriz[i][j] = elementos[i][j];
            }
        }
    }   
    
     /**
     * Retorna una matriz dada su diagonal. 
     * @param d  (Lista llena de objetos de tipo fraccionario)
     */    
    public Matriz (Fraccionario d []){
        matriz = new Fraccionario[d.length][d.length];

        for(int i=0; i<d.length; i++)
        {            
            for(int j=0; j<d.length; j++)
            {
                if(j == i){matriz[i][j] = d[i];}
                else{matriz[i][j] = new Fraccionario(0);};
            }
        }
    }    

    /**
     * Retorna una matriz de un numero repetido dada su dimension. 
     * @param e  (El elemento a añadir a la matriz)
     * @param f  (La cantidad de filas)
     * @param c  (La cantidad de columnas)
     */
    public Matriz (Fraccionario e, int f, int c) {
        matriz = new Fraccionario[f][c];

        for(int i=0; i<f; i++)
        {
            for(int j=0; j<c; j++)
            {
                matriz[i][j] = e;
            }
        }
    }
    
    /**
     * Retorna una matriz identidad dada su dimension. 
     * @param n   (la dimensión de la matriz)
     */
    public Matriz (int n) {
        matriz = new Fraccionario[n][n];
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(j == i){matriz[i][j] = new Fraccionario(1);}
                else{matriz[i][j] = new Fraccionario(0);}
            }
        }
    }
    
    /**
     * Retorna la dimensión de la matriz
     */
    public int dimension(){
        return matriz.length*matriz[0].length;
    }
    
    /**
     * Nos da el fraccionario en esa posición
     * @param f  (La fila donde queremos buscar)
     * @param c  (La columna donde queremos buscar)
     */
    public Fraccionario get(int f, int c){
        return matriz[f][c];
    }
    
    /**
     * Compara esta matriz con otra
     * @param otra  (La otra matriz que deseamos comparar)
     */
    public boolean equals (Matriz otra) {
        boolean respuesta = false;
        
        if(matriz.equals(otra)){respuesta = true;}
        
        return respuesta;
    }

    /** 
     * Compara esta matriz con otra
     * @param otra  (El otro objeto que deseamos comparar)
     */
    @Override
    public boolean equals(Object otra) {
        boolean respuesta = false;
        
        if(matriz.equals(otra)){respuesta = true;}
        
        return false;
    }    
    
    /** 
     * Retorna una cadena con los datos de la matriz alineado a derecha por columna
     * 
    */
    @Override
    public String toString () {
        String s = "";
        
        for(int i=0; i<matriz.length; i++)
        {
            for(int j=0; j<matriz[i].length; j++)
            {
                s += matriz[i][j]+", ";
            }
        }
        
        return s;
    }   
    
    //Retorna la matriz con el numero de filas o columnas
    public int[][] sume(Matriz m){
        /*int[][] respuesta = new int[matriz.length][matriz[0].length];
        
        for(int i=0; i<matriz.length; i++)
        {
            for(int j=0; j<matriz[i].length; j++)
            {
                respuesta[i][j] = matriz[i][j].sume(m[i][j]);
            }
        }
        
        return respuesta;*/
        return null;
    }
    
 
}
