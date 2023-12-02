/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.juegodepreguntasrespuestas;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jose
 */
public class JuegoDePreguntasRespuestas {

    static JLabel pregunta = new JLabel();
    static JTextField respuesta = new JTextField();
    static JButton[] botones = new JButton[2];
    static JLabel contador = new JLabel(); 
    static String[] preguntas = {"¿Cuál es la capital de Francia?","¿En qué año se independizó Estados Unidos?","¿Cuántos continentes hay en el mundo?","¿Quién escribió \"Romeo y Julieta\"?","¿Cuál es el elemento más abundante en la corteza terrestre?","¿Cuál es el río más largo del mundo?","¿Qué planeta es conocido como \"el planeta rojo\"?","¿Cuál es la montaña más alta del mundo?","¿Quién fue el primer presidente de Estados Unidos?","¿En qué año se fundó la Organización de las Naciones Unidas (ONU)?","¿Cuál es el animal terrestre más grande?","¿Qué gas compone la mayor parte de la atmósfera de la Tierra?","¿Cuál es la velocidad de la luz en el vacío?","¿Quién pintó la Mona Lisa?","¿Cuál es la fórmula química del agua?"};
    static String[] respuestas = {"Paris","1776","7","William Shakespeare","Oxigeno","El rio Amazonas","Marte","El Monte Everest","George Washington","1945","El elefante africano","Nitrogeno","300000 kilometros por segundo","Leonardo da Vinci","H2O"};
    static String[] respuestas2 = {"Paris","1776","7","William Shakespeare","Oxigeno","Amazonas","Marte","Everest","George Washington","1945","elefante","Nitrogeno","300000 Km/s","Leonardo da Vinci","H2O"};

    static int respuectaCorrecta = 0;
            
    public static void main(String[] args) {
        JFrameJuego juego = new JFrameJuego();
        pregunta = juego.jLabel1;
        contador = juego.jLabel2;
        respuesta = juego.jTextField1;
        botones[0] = juego.jButton1;
        botones[1] = juego.jButton2;
        juego.setVisible(true);
    }
    
    public static void pregunata(){
        if (respuesta.getText().equalsIgnoreCase(respuestas[respuectaCorrecta])||respuesta.getText().equalsIgnoreCase(respuestas2[respuectaCorrecta])) {
            int indice=contador.getText().indexOf("/");
            contador.setText((Integer.parseInt(contador.getText().substring(0, indice))+1)+contador.getText().substring( indice,contador.getText().length()));
        }
        {
            int indice=contador.getText().indexOf("/");
            contador.setText(contador.getText().substring(0, indice+1)+(Integer.parseInt(contador.getText().substring( indice+1,contador.getText().length()))+1));
        }
        
        int numPreguntas=preguntas.length;
        for(String i:preguntas){
            numPreguntas=i==null?numPreguntas-1:numPreguntas;
        }
        
        int numrandom;
        do {
            numrandom = new Random().nextInt(0, preguntas.length-1);
        } while (preguntas[numrandom]==null&&numPreguntas>=2);
        
        if (numPreguntas==1) {
            pregunta.setText("Ya no hay mas preguntas");
            botones[0].setEnabled(false);
            botones[1].setEnabled(false);
            respuesta.setEnabled(false);
        }else{
            pregunta.setText(preguntas[numrandom]);
        }
        respuectaCorrecta=numrandom;
        preguntas[numrandom]=null;
        respuesta.setText("");
    }
    
    public static void empezarPasar(){
        if(botones[1].getText().equalsIgnoreCase("pasar")){
            int numRan;
            do {
            numRan = new Random().nextInt(0, preguntas.length-1);
            } while (preguntas[numRan]==null);
            pregunta.setText(preguntas[numRan]);
            respuectaCorrecta = numRan;
        }else{
            respuesta.setText("");
            botones[1].setText("Pasar");
            botones[0].setEnabled(true);
            int numRan = new Random().nextInt(0, preguntas.length-1);
            pregunta.setText(preguntas[numRan]);
            respuestas[numRan]=null;
            respuectaCorrecta = numRan;
        }
    }
}
