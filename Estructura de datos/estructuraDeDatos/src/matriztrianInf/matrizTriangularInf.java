/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matriztrianInf;
 import javax.swing.JOptionPane;
/**
 *
 * @author Yael
 */
public class matrizTriangularInf {
   

        public static void main(String[] args) {
                int filas=Integer.parseInt(JOptionPane.showInputDialog("Digita las filas de la matriz"));
                int columnas=Integer.parseInt(JOptionPane.showInputDialog("Digita las columnas de la matriz"));
                int matriz[][]=new int[filas][columnas];
                if(matriz.length==matriz[0].length){
                        for(int i=0;i<filas;i++){
                        for(int j=0;j<columnas;j++){
                                matriz[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Digita un número para la posición: a["+i+"]["+j+"]"+" de la matriz"));
                                System.out.print(matriz[i][j]+" ");
                        }
                        System.out.println();
                }
                        int sum=0;
                        for(int j=1;j<columnas;j++){
                                for(int i=0;i<filas;i++){
                                        if(i<j){
                                                sum+=matriz[i][j];
                                        }
                                }
                        }
                
                        if(sum==0){
                                JOptionPane.showMessageDialog(null,"Es una matriz triagular inferior");
                        }
                        else{
                                JOptionPane.showMessageDialog(null,"No es una matriz triagular inferior");
                        }
                        
                }else{
                        JOptionPane.showMessageDialog(null, "No es cuadrada");
                }
           
        }

}

