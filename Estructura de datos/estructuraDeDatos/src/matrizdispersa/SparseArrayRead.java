/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrizdispersa;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
/**
 *
 * @author Yael
 */
public class SparseArrayRead {

    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new FileReader("./data/map.data"));
        List<String> list =  new ArrayList<>();
        String s = "";
        while ((s = br.readLine()) != null){
            list.add(s);
        }
        int[][] newSparseArrayRead = new int[list.size()][list.size()-1];
        String s1 = list.get(0);
        String[] split = s1.split("\t");
                 // Primero pon 11 11 3 en la matriz
        newSparseArrayRead[0][0] = Integer.parseInt(split[0]);
        newSparseArrayRead[0][1] = Integer.parseInt(split[1]);
        newSparseArrayRead[0][2] = list.size()-1;
                 // Establezca el valor de recuento y realice juicios posteriores. El número de filas en la matriz bidimensional.
        int count = 0;
        for (int i = 1; i < list.size(); i++) {
            String str = list.get(i);
            String[] strings = str.split("\t");
            count ++;
            for (int j = 0; j < strings.length; j++) {
                newSparseArrayRead[count][j] = Integer.parseInt(strings[j]);
            }
        }
                 System.out.println ("Matriz dispersa creada después de leer el archivo:");
        for (int[] ints : newSparseArrayRead) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
 
 
                 // Convertir de matriz bidimensional a matriz original
                 // 1. Primero lea la primera fila de la matriz dispersa y cree la matriz bidimensional original basada en los datos de la primera fila
        int[][] chessArr2 = new int[newSparseArrayRead[0][0]][newSparseArrayRead[0][1]];
                 // 2. Leer los datos de las últimas filas de la matriz dispersa (comenzando desde la segunda fila) y asignarlos a la matriz bidimensional original.
        for (int i = 1; i < newSparseArrayRead.length; i++) {
            chessArr2[newSparseArrayRead[i][0]][newSparseArrayRead[i][1]] = newSparseArrayRead[i][2];
        }
 
                 // Salida de la matriz bidimensional restaurada
        System.out.println();
                 System.out.println ("Matriz bidimensional recuperada:");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
 
        br.close();
 
    }
}

