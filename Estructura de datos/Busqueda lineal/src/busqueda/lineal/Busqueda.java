/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package busqueda.lineal;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Barnery
 */
public class Busqueda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
   int arreglo[]={45, 34,100, 4, 11, 172, 1, 9, 7, 2};
        int dato;
        boolean band=false;
         int opcion = 0;
    do{    
         opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menú de Opciones\n\n"
                        + "1. Mostrar datos\n"
                        + "2. Busacar dato\n"
                        + "3. Salir\n"
                      ));
      switch (opcion) {
          case 1 -> {
              Integer[] datos = {45, 34,100, 4, 11, 172, 1, 9, 7, 2};
              JOptionPane.showMessageDialog(null, datos);
            }
          
          
          case 2 -> {
                 dato=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a buscar"));
              int i=0;
              while(i<10 && band==false){
                  if(arreglo[i] == dato){
                      band=true;        
                  }
                  i++;
              }       
              if(band==false){
                  JOptionPane.showMessageDialog(null, "El numero ha sido encontrado y en la posición ");
              }
              else{
                  JOptionPane.showMessageDialog(null, "El numero ha sido encontrado y en la posición "+(i));
              }
          }
     case 3 -> opcion = 3;
                  
      }  
  
    }while  (opcion != 3);     
    }
    }
    

