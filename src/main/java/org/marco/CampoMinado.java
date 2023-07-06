package org.marco;

import org.marco.model.Tabuleiro;
import org.marco.view.TabuleiroConsole;

import java.util.Scanner;

import static org.marco.enumeration.CoresENUM.*;

public class CampoMinado {
    public static void main(String[] args) {
        int linhas,colunas,minas;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o número de Linhas Desejada: ");
        try {
            linhas = Integer.parseInt(entrada.nextLine());
        }catch(Exception e){
            linhas = 0;
        }

        while(linhas<=0){
            System.out.println(VERMELHO+"ERRO: Informe um número maior que zero!!"+CORPADRAO);
            System.out.println("Informe o número de Linhas Desejada: ");
            try {
                linhas = Integer.parseInt(entrada.nextLine());
            }catch(Exception e){
                linhas = 0;
            }
        }
        minas = Math.round((linhas/2));
        colunas = linhas;

        Tabuleiro tabuleiro = new Tabuleiro(linhas,colunas,minas);
        new TabuleiroConsole(tabuleiro);
    }
}