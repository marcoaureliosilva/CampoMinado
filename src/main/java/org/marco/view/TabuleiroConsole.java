package org.marco.view;

import org.marco.exception.ExplosaoException;
import org.marco.exception.SairException;
import org.marco.model.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import static org.marco.enumeration.CoresENUM.*;

public class TabuleiroConsole {
    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);
    private Integer linha = null;
    private Integer coluna = null;
    private String digitado;
    private String opcao;
    private Iterator<Integer> xy;
    public TabuleiroConsole(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        executarJogo();
    }

    private void executarJogo(){
        try {
            boolean continuar = true;

            while(continuar){
                cicloDoJogo();

                System.out.println("Outra partida? (S/n) ");
                String resposta = entrada.nextLine();

                if("n".equalsIgnoreCase(resposta)){
                    continuar = false;
                }else{
                    tabuleiro.reiniciar();
                }
            }

        }catch (SairException e){
            System.out.println("Tchau!!!");
        }finally{
            entrada.close();
        }
    }

    private void cicloDoJogo() {
        try{
            while(!tabuleiro.objetivoAlcancado()){
                System.out.println(tabuleiro);

                getLinhaColuna();
                while(linha==null || coluna ==null){
                    System.out.println(VERMELHO.getCor()+"ERRO: Você não digitou no padrão: Linha Vírgula Coluna... EX: (1,1) Informe novamente por favor!!"+CORPADRAO.getCor());
                    getLinhaColuna();
                }

                getOpcao();
                while(opcao==null){
                    System.out.println(VERMELHO.getCor()+"ERRO: Informe ou 1 ou 2!!"+CORPADRAO.getCor());
                    getOpcao();
                }
            }
            System.out.println(tabuleiro);
            System.out.println("Parabêns Você Ganhou");
        }catch (ExplosaoException e){
            System.out.println(tabuleiro);
            System.out.println("BOMBA Você PERDEU!!!");
        }
    }

    private void getLinhaColuna(){
        digitado = capturarValorDigitado("Informe o número da Linha, Depois uma Vírgula e depois o número da Coluna:");
        xy = Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim())).iterator();
        try {
            linha = xy.next();
            coluna = xy.next();
        }catch(Exception e){
            linha = null;
            coluna = null;
        }
    }
    private void getOpcao(){
        opcao = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");
        try{
            if ("1".equals(opcao)){
                tabuleiro.abrir(linha, coluna);
            }else if("2".equals(opcao)){
                tabuleiro.alternarMarcacao(linha,coluna);
            }else{
                opcao = null;
            }
        }catch (ExplosaoException e){
            throw new ExplosaoException();
        }catch (Exception e){
            opcao = null;
        }
    }

    private String capturarValorDigitado(String texto){
        System.out.print(texto);
        String digitado = entrada.nextLine();

        if("sair".equalsIgnoreCase(digitado)){
            throw new SairException();
        }

        return digitado;
    }

}
