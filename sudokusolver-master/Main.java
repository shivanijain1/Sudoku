package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] Sudouku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String row = br.readLine();
            for (int j = 0; j < 9; j++) {
                Sudouku[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));

            }

        }

        //System.out.println("Solved Finally");

              solve(Sudouku,0,0);

      //  print(Sudouku);






    }



    public static void solve(int[][] sudoku,int row,int col){

        if(row>=9){
            print(sudoku);
            return;
        }


        int nrow = row;
        int ncol = col+1;


        if(col==8){
            ncol =0;
            nrow+=1;
        }
        if(sudoku[row][col]!=0){
            solve(sudoku,nrow,ncol);
        } else{
            for(int i =1;i<10;i++){

                if(crow(sudoku,row,i)&&ccol(sudoku,col,i)&&checkBox(sudoku,row,col,i)){
                    sudoku[row][col]=i;
                    solve(sudoku,nrow,ncol);
                    sudoku[row][col]=0;

                }
            }
            return;
        }

    }
    static void print(int sudoku[][]){
        for (int l = 0; l < 9; l++) {
            for (int k = 0; k < 9; k++) {
                System.out.print(sudoku[l][k]);
            }
            System.out.println("");
        }
    }


    public static boolean crow(int [][] sudoku,int row,int value){

        for(int i =0;i<9;i++){
            if(sudoku[row][i]==value){
                return false;
            } else{
                continue;
            }
        }
        return true;
    }
    public  static boolean ccol(int [][] sudoku,int col,int value){

        for(int i =0;i<9;i++){
            if(sudoku[i][col]==value){
                return false;
            } else{
                continue;
            }
        }
        return true;
    }
    public static boolean checkBox(int[][] Matrix, int row, int column, int value) {
        // System.out.println("Checking for Martix["+row+"]["+column+"]");
        int SIR = (row / 3);
        SIR*=3;
        int SIC = (column / 3);
        SIC*=3;

        for (int k = SIR; k <=(SIR+2); k++) {
            for (int j = SIC; j <=(SIC +2); j++) {
                //System.out.println("Checking for Martix["+row+"]["+column+"] with the " + Matrix[k][j] );

                if (Matrix[k][j] == value) {
                    return  false;
                }
            }
        }
        return true;
    }
}