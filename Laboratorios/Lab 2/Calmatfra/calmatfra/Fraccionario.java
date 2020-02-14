
/**
 * Fraccionario
 * Esta clase implementa el tipo de dato Fraccionario; es decir, un n�mero racional que se pueden escribir de la forma p/q, donde p y q son enteros, con q <> 0
 * La implemantacion se hace mediante objetos inmutables
 * INV: El fraccionario se encuentra representado en forma irreductible.
 * @author E.C.I.
 *
 */
public class Fraccionario {
    private int numerador;
    private int denominador;
    private int parteEntera;
    private int signoN = 1;
    private int signoD = 1;
    private int numeradorTemporal;
    private int denominadorTemporal;
    
    /**Calcula el maximo comun divisor de dos enteros
     * Lo implementaremos mediante el algoritmo recursivo
     * @param a primer entero
     * @param b segundo entero
     * @return el Maximo Comun Divisor de a y b
     */
  
    public static int mcd(int a,int b){
        a = Math.abs(a);
        b = Math.abs(b);
        if(b == 0)
        {
            return a;
        }
        else
        {
            return mcd(b, a%b);
        }
    }    
    
    /**Crea un nuevo fraccionario, dado el numerador y el denominador
     * @param numerador
     * @param denominador. denominador <> 0
     */
    public Fraccionario (int numerador, int denominador) {
        if(numerador < 0){signoN = -1;}
        if(denominador < 0){signoD = -1;}  
        //System.out.println("Llego a normal");
        //this.numerador = numerador*signoN;
        //this.denominador = denominador*signoD;
        this.numerador = numerador;
        this.denominador = denominador;
        cuadrarSigno();
        numeradorTemporal = this.numerador;
        denominadorTemporal = this.denominador;        
        
        if(this.numerador == 0)
        {
            this.numerador = 0;
            this.denominador = 0;
        }
        if(denominador == 0)
        {
            System.out.println("El denominador no puede ser cero");
        }        
    }
    
    /**Crea un fraccionario correspondiente a un entero
     * @param entero el entero a crear
     */
    public Fraccionario (int entero) {
        if(entero < 0){signoN = -1;}
        
        //numerador = entero*signoN;
        numerador = entero;
        denominador = 1;
        cuadrarSigno();
        numeradorTemporal = entero;
        denominadorTemporal = 1;
        
        if(entero == 0)
        {
            this.numerador = 0;
            this.denominador = 0;
        }
    }

     /**Crea un fraccionario, a partir de su representacion mixta. 
     * El numero creado es enteroMixto + numeradorMixto/denominadorMixto
     * @param enteroMixto la parte entera del numero
     * @param numeradorMixto el numerador de la parte fraccionaria
     * @param denominadorMixto el denominador de la parte fraccionaria. denominadorMixto<>0
     */
    public Fraccionario (int enteroMixto, int numeradorMixto, int denominadorMixto) {
        if(numeradorMixto < 0){signoN = -1;}
        if(denominadorMixto < 0){signoD = -1;}
        
        parteEntera = enteroMixto;
        //numerador = numeradorMixto*signoN;
        //denominador = denominadorMixto*signoD;
        numerador = numeradorMixto;
        denominador = denominadorMixto;
        cuadrarSigno();
        numeradorTemporal = numeradorMixto;
        denominadorTemporal = denominadorMixto;
        
        if(enteroMixto == 0 || numeradorMixto == 0)
        {
            parteEntera = 0;
            this.numerador = 0;
            this.denominador = 0;
        }
    }

    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return El numerador simplificado del fraccionario
     */
    public int numerador() {
        simplificarFraccion();       
        return getNumeradorSimplificado();
    }
    
    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero Positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return el denominador simplificado del fraccionario
     */
    public int denominador() {
        simplificarFraccion();
        return getDenominadorSimplificado();
    }
    
    /**Suma este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario sume (Fraccionario otro) {
        int numeradorSuma = numerador*otro.getDenominador() + otro.getNumerador()*denominador;
        int denominadorSuma = denominador*otro.getDenominador();
        return new Fraccionario(numeradorSuma, denominadorSuma);
    }
    
    /**Resta este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario reste (Fraccionario otro) {
        int numeradorResta = numerador*otro.getDenominador() - otro.getNumerador()*denominador;
        int denominadorResta = denominador*otro.getDenominador();
        return new Fraccionario(numeradorResta, denominadorResta);
    }
    
    /**Multiplica este fraccionario con otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario multiplique (Fraccionario otro) {
        int numeradorProducto = numerador*otro.getNumerador();
        int denominadorProducto = denominador*otro.getDenominador();
        return new Fraccionario(numeradorProducto, denominadorProducto);
    }    
    
    /*Eleva  este fraccionario 
     * @param fraccionario
     * @return este ^ otro
     
    public Fraccionario eleve (Fraccionario otro) {
        se hace dentro de un ciclo?
        int numeradorProducto = numerador*otro.getNumerador();
        int denominadorProducto = denominador*otro.getDenominador();
        return new Fraccionario(numeradorProducto, denominadorProducto);
    }    
    */
    /**Divide este fraccionario sobre otro fraccionario
     * @param otro El otro fraccionario
     * @return este / otro
     */
    public Fraccionario divida (Fraccionario otro) {
        int dividendo= numerador / otro.getNumerador();
        int divisor= denominador / otro.getDenominador();
        return new Fraccionario(dividendo,divisor);
    }    
    
    @Override
    public boolean equals(Object obj) {
        return equals((Fraccionario)obj);
    }    
    
    /**Compara este fraccionario con otro fraccionario
     * @param otro eL otro fraccionario
     * @return true si este fraccionario es igual matem�ticamente al otro fraccionario, False d.l.c.
     */
    public boolean equals (Fraccionario otro) {
        boolean respuesta = false;
        //System.out.println("Numerador propio "+numerador);
        //System.out.println("Denominador propio "+denominador);
        //System.out.println("Numerador otro "+otro.getNumerador());
        //System.out.println("Denominador otro "+otro.getDenominador());
        if(Math.abs(numerador) == Math.abs(otro.getNumerador()) && Math.abs(denominador) == Math.abs(otro.getDenominador()))
        {respuesta = true;}
        
        return respuesta;
    }


    /** Calcula la representacion en cadena de un fraccionario en formato mixto simplificado
     * @see java.lang.Object#toString(java.lang.Object)
     */
    @Override
    public String toString() {
        simplificarFraccion();
        return numeradorTemporal+"/"+denominadorTemporal;
    }
    
    /**
     * Obtener el numerador de la fracción
     */
    public int getNumerador()
    {
        return numerador;
    }
    
    /**
     * Obtener el denominador de la fracción
     */
    public int getDenominador()
    {
        return denominador;
    }
    
    /**
     * Colocar un denominador diferent de 0 
     * @param denominador (El nuevo denominador de la fracción)
     */
    public void setDenominador(int denominador)
    {
        this.denominador = denominador;
    }
    
    /*
     * Cuadrar los signos del fraccionario
     */
    private void cuadrarSigno()
    {
        //System.out.println("llego");
        //System.out.println("El numerador "+numerador);
        //System.out.println("El denominador "+denominador);
        if((numerador < 0 && denominador < 0) || (numerador > 0 && denominador < 0))
        {
            //System.out.println("Entro 1");
            numerador *= -1;
            denominador *= -1;
            //numeradorTemporal *= -1;
            //denominadorTemporal *= -1;
        }
        /**
        else if(numerador > 0 && denominador < 0)
        {
            System.out.println("Entro 2");
            numerador *= -1;
            denominador *= -1;
            //numeradorTemporal *= -1;
            //denominadorTemporal *= -1;
        }*/
        //System.out.println("El numerador después de operación "+numerador);
        //System.out.println("El denominador después de operación "+denominador);
    }
    
    /*
     * Obtener el numerador simplificado
     */
    private int getNumeradorSimplificado()
    {
        return numeradorTemporal;
    }
    
    /*
     * Obtener el denominador simplificado
     */
    private int getDenominadorSimplificado()
    {
        return denominadorTemporal;
    }
    
    /*
     * Simplificar la fracción
     */
    private void simplificarFraccion()
    {
        int divisor = 2;
        //int numeradorTemporal = numerador;
        //int denominadorTemporal = denominador;
        int respuesta;
        //int signoN = 1;
        //int signoD = 1;
        
        //if(numerador < 0){
        //    numeradorTemporal = numerador*-1;
        //    signoN = -1;}
        //if(denominador < 0){
        //    denominadorTemporal = denominador*-1;
        //    signoD = -1;
        //}    
        
        while(divisor <= (Math.abs(numeradorTemporal)) && divisor <= (Math.abs(denominadorTemporal)))
        {
            if((numeradorTemporal % divisor == 0) && (denominadorTemporal % divisor == 0))
            {
                numeradorTemporal /= divisor;
                denominadorTemporal /= divisor;
            }            
            else
            {
                divisor += 1;
                
            }            
        }
        
        //if(guia == 1){respuesta = numeradorTemporal*signoN;}
        //else{respuesta = denominadorTemporal*signoD;}
        
        //return respuesta;
    }
}
