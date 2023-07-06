package org.marco.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marco.exception.ExplosaoException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TabuleiroTeste {

    private Tabuleiro tabuleiro;

    @BeforeEach
    void setUp() {
        // Configuração inicial para cada teste
        int linhas = 3;
        int colunas = 3;
        int minas = 1;
        tabuleiro = new Tabuleiro(linhas, colunas, minas);
    }

    @Test
    void testAbrir() {
        int linha = 0;
        int coluna = 0;
        tabuleiro.abrir(linha, coluna);
        Boolean response;
        List<Campo> campos = tabuleiro.getCampos();
        try {
            response = campos.get(0).isAberto();
        }catch (ExplosaoException e){
            response = campos.get(0).isAberto();
        }catch (Exception e){
            response = false;
        }
        assertTrue(response);
    }

    @Test
    void testAlternarMarcacao() {
        int linha = 0;
        int coluna = 0;

        tabuleiro.abrir(linha, coluna);
        List<Campo> campos = tabuleiro.getCampos();
        Campo campo = campos.get(0);
        boolean marcadoOld = campo.getMarcado();
        tabuleiro.alternarMarcacao(linha, coluna);
        boolean marcadonew = campo.getMarcado();

        assertEquals(marcadoOld,marcadonew);
    }


    @Test
    void testObjetivoAlcancado() {
        setUp();
        assertFalse(tabuleiro.objetivoAlcancado());

        // Abre todos os campos, exceto as minas
        int i = 0;
        for (int linha = 0; linha < tabuleiro.getLinhas(); linha++) {
            for (int coluna = 0; coluna < tabuleiro.getColunas(); coluna++) {
                if (tabuleiro.getCampos().get(i).isMinado()){
                    tabuleiro.getCampos().get(i).alternarMarcacao();
                }else{
                    tabuleiro.getCampos().get(i).setAberto(true);
                }
                i++;
            }
        }

        // Verifica se o objetivo é alcançado quando todos os campos não minados são abertos
        assertTrue(tabuleiro.objetivoAlcancado());
    }

    @Test
    void testReiniciar() {
        int linha = 0;
        int coluna = 0;

        // Marca o campo
        tabuleiro.alternarMarcacao(linha, coluna);

        tabuleiro.reiniciar();

        Campo campo = tabuleiro.getCampos().get(0);
        assertFalse(campo.isMarcado());
    }


}
