/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Javi
 */
public class Vista extends Frame{
    private Logica log;
    private Image imagen1, imagen2, imagen3, imagen4;
    String RUTA="./../assets/";

    public Vista(Logica log) {
        this.log = log;
        start();
    }

    private void start() {       
        cargarImagenes();
        setSize(500,500);
        setVisible(true);
        this.addKeyListener(log);
        
    }
    
    
     @Override
    public void paint(Graphics g){
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 500, 500);
            g.setColor(Color.WHITE);
            if(log.esFin()){
                int fallos = log.getnumFallos()+1;
                switch (fallos) {
                    case 1:
                        dibujarImg1(g);
                        break;
                    case 2:
                        dibujarImg2(g);
                        break;
                    case 3:
                        dibujarImg3(g);
                        break;
                    default:
                        throw new AssertionError();
                }
                g.drawChars(log.getAdivinar(),0,log.getAdivinar().length, 250, 300);
                g.drawString("Aciertos: "+log.getnumAciertos(), 20, 100);
                g.drawString("Intentos: "+log.getnumIntent(), 20, 120);
                g.drawString("Fallos: "+log.getnumFallos(), 20, 140);
            } else{
                if(log.getnumFallos() != log.NUM_MAX_FALLOS){
                    g.drawString("ENHORABUENA GANASTE!!", 175, 270);
                } else {  
                    dibujarImg4(g);
                    g.drawString("Perdiste :(",220,300);
                    g.drawString("Vuelva a jugar",210,320);
                }
                log.tiempoFin();

            }
                            
    }
    
    //Cargar Imagenes
    
    private Image imgCargarFichero(String fichero){
        Image imagen=null;
        URL url=this.getClass().getResource(fichero);
        try {
            imagen=ImageIO.read(url);
        } catch (IOException ex) {
            System.out.println("Error al cargar imagen");
        }
        return imagen;
    }
    
    private void cargarImagenes(){
        imagen1=imgCargarFichero(RUTA+"ahorcado1.png");
        imagen2=imgCargarFichero(RUTA+"ahorcado2.png");
        imagen3=imgCargarFichero(RUTA+"ahorcado3.png");
        imagen4=imgCargarFichero(RUTA+"ahorcado4.png");
    }
    
    
    //Dibujar imagenes

    public void dibujarImg1(Graphics g){
        g.drawImage(imagen1, 200, 100,null);
    }
    
    public void dibujarImg2(Graphics g){
        g.drawImage(imagen2, 200, 100,null);
    }
    
    public void dibujarImg3(Graphics g){
        g.drawImage(imagen3, 200, 100,null);
    }
    
    public void dibujarImg4(Graphics g){
        g.drawImage(imagen4, 175, 100,null);
    }
   
}
