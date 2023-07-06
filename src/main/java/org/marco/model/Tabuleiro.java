package org.marco.model;

import org.marco.exception.ExplosaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.marco.enumeration.CoresENUM.*;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private int minas;

    private final List<Campo> campos = new ArrayList<>();

    public Tabuleiro(int linhas, int colunas, int minas){
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;

        gerarCampos();
        associarVizinhos();
        sortearMinas();
    }

    public void abrir(int linha, int coluna){
        try {
            campos.parallelStream()
                    .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                    .findFirst()
                    .ifPresent(c -> c.abrir());
        } catch (ExplosaoException e){
            campos.forEach(c -> c.setAberto(true));
            throw e;
        }
    }

    public void alternarMarcacao(int linha, int coluna){
        campos.parallelStream()
                .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
                .findFirst()
                .ifPresent(c -> c.alternarMarcacao());
    }
    private void gerarCampos() {
        for (int linha =0; linha < linhas; linha++){
            for (int coluna =0; coluna < colunas; coluna++){
                campos.add(new Campo(linha,coluna));
            }
        }
    }

    private void associarVizinhos() {
        for (Campo c1: campos){
            for (Campo c2: campos){
                c1.adicionarVizinho(c2);
            }
        }
    }

    private void sortearMinas() {
        long minasArmadas = 0;
        Predicate<Campo> minado = campo -> campo.isMinado();
        do {
            int aleatorio = (int) (Math.random() * campos.size());
            campos.get(aleatorio).minar();
            minasArmadas = campos.stream().filter(minado).count();
        } while (minasArmadas < minas);
    }
    public boolean objetivoAlcancado(){
        return campos.stream().allMatch(c -> c.objetivoAlcancado());
    }

    public void reiniciar(){
        campos.stream().forEach(c -> c.reiniciar());
        sortearMinas();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(AMARELO.getCor()+"======= CAMPO MINADO ======= "+CORPADRAO.getCor());
        sb.append("\n");
        sb.append("(?) CAMPO PARA ABRIR OU MARCAR");
        sb.append("\n");
        sb.append(AMARELO.getCor()+"(#)"+CORPADRAO.getCor()+" CAMPO MARCADO");
        sb.append("\n");
        sb.append(AZUL.getCor()+"(1,2,3)"+CORPADRAO.getCor()+" Nº BOMBAS AO REDOR");
        sb.append("\n");
        sb.append(VERMELHO.getCor()+"(X)"+CORPADRAO.getCor()+" BOMBA!!");
        sb.append("\n");

        sb.append("  ");
        for(int c = 0; c < colunas; c++){
            sb.append("  ");
            sb.append(AMARELO.getCor());
            sb.append(c);
            sb.append(CORPADRAO.getCor());
            sb.append("  ");
        }

        sb.append("\n");

        int i = 0;
        for(int l = 0; l < linhas; l++){
            sb.append(AMARELO.getCor());
            sb.append(l);
            sb.append(CORPADRAO.getCor());
            sb.append(" ");
            for(int c = 0; c < colunas; c++){
                sb.append("  ");
                sb.append(campos.get(i));
                sb.append("  ");
                i++;
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<Campo> getCampos() {
        return this.campos;
    }

    public int getLinhas() {
        return this.linhas;
    }

    public int getColunas() {
        return this.colunas;
    }
}
