/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Javi
 */
public class Logica implements KeyListener{
public static int NUM_MAX_FALLOS = 3;
private String[] palabras={"baloncesto", "balonmano", "tenis"};
private final String PALABRA;
private Vista vista;
private int numIntent=0;
private int numAciertos=0;
private int numFallos=0;
private char[] adivinar, adivinado;
private boolean fin=true;

    public Logica() {        
        PALABRA=elegirPalabra();
        adivinado = PALABRA.toCharArray();
        adivinar=new char[PALABRA.length()];
        for(int i=0;i<adivinar.length;i++){
            adivinar[i]='*';
        }
        vista=new Vista(this);
    }
    public String elegirPalabra(){
        int numero=(int)(Math.random()*palabras.length);
        return palabras[numero];
    }
    
    public void jugar(char letra){
        int posicion=0;
        boolean encontrado=false;
        do{
            posicion=PALABRA.indexOf(letra,posicion);
            if(posicion!=-1){               
                adivinar[posicion]=letra;
                posicion++;
                encontrado=true;
            }            
        }while(posicion!=-1);
        numIntent++;
        if (encontrado){
            numAciertos++;
        }else{
            numFallos++;
        } 
        comprobarFin();       
    }
    
    private void comprobarFin(){
        boolean acabado=true;
        for (int i=0; i<adivinar.length; i++){
            if (adivinar[i]=='*') {
                acabado=false;
                break;
            }    
        }
        if (acabado){
            fin=true;
        }
        if (numFallos==NUM_MAX_FALLOS) {
            fin=true;       
        }
    }

    boolean esFin() {
        if(numFallos==NUM_MAX_FALLOS || numAciertos==PALABRA.length() || comprobarLetrasRepetidas()){
            fin=false;            
        }   
        return fin;
    }
    
    public boolean comprobarLetrasRepetidas(){
        boolean encontrado = true;
        for (int i = 0; i < adivinar.length; i++) {
            if(adivinar[i]=='*'){
                encontrado = false;
            }
        }
        return encontrado;
    }
    
    
    //GETTERS
    public int getnumIntent() {
        return numIntent;
    }

    public int getnumAciertos() {
        return numAciertos;
    }

    public int getnumFallos() {
        return numFallos;
    }
    public char[] getAdivinar() {
        return adivinar;
    }
    
    //KEYLISTENER

    @Override
    public void keyTyped(KeyEvent e) {
       jugar(e.getKeyChar());
       vista.repaint();
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println();
    }

    void tiempoFin() {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1010000; j++) {
                for (int k = 0; k < 10; k++) {
                    
                }
            }    
        }
        System.exit(0);
    }
    
}
