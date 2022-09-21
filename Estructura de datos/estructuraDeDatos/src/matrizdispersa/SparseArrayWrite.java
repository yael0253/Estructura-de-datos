/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrizdispersa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Yael
 */
public class SparseArrayWrite {

    public static void main(String[] args) throws IOException {
 
                 // Crea una matriz bidimensional original 11 * 11
                 // 0: significa que no hay peón, 1 significa negro y 2 significa azul
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
                 // Salida de la matriz bidimensional original
                 System.out.println ("Matriz bidimensional original:");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
//                System.out.print(data + "\t");
            }
            System.out.println();
        }
 
                 // La idea de convertir una matriz bidimensional en una matriz dispersa
                 // 1. Primero recorra la matriz bidimensional para obtener el número de datos distintos de cero.
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
 
                 // Crea la matriz dispersa correspondiente
        int[][] sparseArr = new int[sum + 1][3];
                 // Asignar matriz dispersa
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
                 // Atraviesa la matriz bidimensional y almacena valores distintos de cero en sparseArr
                 int count = 0; // count se usa para registrar el número de datos distintos de cero
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
 
                 //Salvar
        BufferedWriter bw = new BufferedWriter(new FileWriter("./data/map.data"));
        System.out.println();
                 System.out.println ("Archivo ...");
        for (int i = 0; i < sparseArr.length; i++) {
            String s = "" + sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" + sparseArr[i][2] + "\t\n";
            bw.write(s);
        }
 
        bw.close();
 
    }
}

