/** Calculadora.java
 * Representa una calculadora de matrices de fraccionarios
 * @author Andres Amorocho && Jairo Pulido
 */

import java.util.HashMap;
public class Calmatfra{

    private HashMap<String, Matriz> variables;
    private boolean ok;
    //Consultar en el API Java la clase HashMap
    /**
     * Constructor
     */
    public Calmatfra(){
        variables = new HashMap<String, Matriz> ();
        ok = false;
    }

    /**
     * Asigna una matriz a una variable especificada
     * @param variable nombre de la variable
     * @param matriz    matriz a asignar
     */
    public void asigne(String variable, int [][][] matriz){  
        
        Matriz amorochozky= new Matriz(matriz);
        variables.put(variable, amorochozky);
    }

    /**
     * Realiza la operacion especificada
     * @param respuesta variable a la que se le asigna el resultado de la operacion
     * @param operando1 un operando que se le realizara una operacion
     * @param operacion operacion que se realizara entre operandos
     * @param operando2 operando con que se ejecutara la operacion al operando1
     */
    // Los operadores binarios : + (suma), - (resta),  * (multiplique matricial), / (divida)
    public void opere(String respuesta, String operando1, char operacion, String operando2){
        Fraccionario total;
        int[][][] acumulado = new int[variables.get(operando1).dimension()]
        [variables.get(operando1).dimension()][2];
        if(operacion == '+'){
            for(int i = 0; i<variables.get(operando1).dimension();i++){
                for(int j=0;j<variables.get(operando2).dimension();j++){
                total=variables.get(operando1).get(i,j).sume(variables.get(operando2).get(i,j));
                int [] temp = new int[]{total.numerador(),total.denominador()};
                acumulado[i][j]= temp;
                }
            }
            asigne(respuesta,acumulado);
            ok = true;
        }
        
        if(operacion == '-'){
            for(int i = 0; i<variables.get(operando1).dimension();i++){
                for(int j=0;j<variables.get(operando2).dimension();j++){
                total=variables.get(operando1).get(i,j).reste(variables.get(operando2).get(i,j));
                int [] temp = new int[]{total.numerador(),total.denominador()};
                acumulado[i][j]= temp;}}
            asigne(respuesta,acumulado);
            ok = true;
        }
        
        if(operacion == '*'){
            for(int i = 0; i<variables.get(operando1).dimension();i++){
                for(int j=0;j<variables.get(operando2).dimension();j++){
                total=variables.get(operando1).get(i,j).multiplique(variables.get(operando2).get(i,j));
                int [] temp = new int[]{total.numerador(),total.denominador()};
                acumulado[i][j]= temp;}}
            asigne(respuesta,acumulado);
            ok = true;
        }
        
        if(operacion == '/'){
            for(int i = 0; i<variables.get(operando1).dimension();i++){
                for(int j=0;j<variables.get(operando2).dimension();j++){
                total=variables.get(operando1).get(i,j).divida(variables.get(operando2).get(i,j));
                int [] temp = new int[]{total.numerador(),total.denominador()};
                acumulado[i][j]= temp;}}
            asigne(respuesta,acumulado);
            ok = true;
        }
    }
    
    /**
     * Consulta ??
     * @param variable a consultar
     */
    public String consulta(String variable){   
        return variables.get(variable).toString();}
        
    /**
     * Retorna el estado de la ultima accion realizada 
     */
    public boolean ok(){
        return ok;
    }
}
    



