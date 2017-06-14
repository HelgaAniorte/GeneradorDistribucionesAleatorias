
package com.aleph5.RandomVariableGenerator;

import com.conciencia.PseudorandomGenerator.PseudorandomNumber;

/**
 * Clase que contiene métodos estáticos para la generación de variables
 * aleatorias de las siguientes distribuciones:
 * 
 * 
 * @author Ernesto Cantú
 * Versión 1.0
 * 19 de Noviembre 2015
 */
public class GeneradorDistribucionesAleatorias {
 
    /**
     * Constructor privado para evitar creacion de instancias.
     */
    private GeneradorDistribucionesAleatorias(){}
    
    
    /**
     * Método estático para generar valores de una variabl aleatoria 
     * con distribución exponencial por medio del método de Transformada Inversa.
     * 
     * @param lambda Parámetro de la distribución exponencial.
     * @return valor para la variable aleatoria con dist. exponencial
     */
    public static Double generadorDistribucionExponencial(double lambda){
        
        double random = PseudorandomNumber.generateNextRandomNumber(true);
        
        double exponencial = ((Math.log(random)/lambda) * (-1));
        
        return exponencial;
    }
    
    /**
     * Método estático para generar valores de una variable aleatoria
     * con distribución uniforme entre a y b por médio del método de Transformada
     * Inversa.
     * 
     * @param a parámetro a de la distribución uniforme.
     * @param b parámetro b de la distribución uniforme.
     * @return valor para la variable aleatoria con dist. uniforme.
     * 
     * Caso especial: Uniforme(0:1)
     */
    public static Double generadorDistribucionUniformeAB(double a, double b){
        
        double random = PseudorandomNumber.generateNextRandomNumber(true);
        
        double uniformeAB = a + ((b - a) * random);
        
        return uniformeAB;
    }
    
    /**
     * Método de rechazo implementado para generar valores de una variable aleatoria
     * con distribución triangular.
     * 
     * @param a Parámetro a de la variable aleatoria con distribución triangular
     * @param b Parámetro b de la variable aleatoria con distribución triangular
     * @param c Parámetro c de la variable aleatoria con distribución triangular
     * @return valor para la variable aleatoria con distribución triangular
     */
    public static Double generadorDistribucionTriangularMetodoRechazo(double a, double b, double c){
    
        boolean returnToTop = true;
        double random1 = PseudorandomNumber.generateNextRandomNumber(true);
        double random2 = PseudorandomNumber.generateNextRandomNumber(true);
        double maximo = 2/(c-a);
        double fDeX = 0.0;
        double x = 0.0;
        
        do{
            x = a + ((c-a) * random1);    
        
            if(x < b){
                fDeX = 2*random1 / (b-a);
            }else{
                fDeX= 2 * (1-random1)/(c-b);
            }
            
            if(random2 < (fDeX/maximo)){
                returnToTop=false;
            }
            
        }while(returnToTop);
        
        
        return x;
    }
    
    /**
     * Método estático para generar valores de una variable aleatoria
     * con distribución triangular por médio del método de Transformada
     * Inversa.
     * 
     * @param a Parámetro a de la variable aleatoria con distribución triangular
     * @param b Parámetro b de la variable aleatoria con distribución triangular
     * @param c Parámetro c de la variable aleatoria con distribución triangular
     * @return valor para la variable aleatoria con distribución triangular
     */
    public static Double generadorDistribucionTriangular(double a, double b, double c){
    
        double random = PseudorandomNumber.generateNextRandomNumber(true);
        double x;
        double aux;
        
        if( random <= ((b-a)/c-a) ){
            
            aux = Math.sqrt(((c-a)*(b-a)*random));
            
            x = a + aux;
        }else{
            aux = Math.sqrt((c-a)*(c-b)*(1-random));
            
            x = c - aux;
        }
        
        return x;
    }
    
    /**
     * Método estático para generar valores de una variable aleatoria
     * con distribución Poisson por médio del método de Transformada
     * Inversa.
     * 
     * @param lambda Parámetro Lambda de la distribución Poisson.
     * @return valor de la variable aleatoria con distribución Poisson.
     */
    public static Double generadorDistribucionPoisson(double lambda){
        
        double random = PseudorandomNumber.generateNextRandomNumber(true);
        
        double x = Math.log(1/random) / lambda;
        
        return x;
    }
    
    
}
