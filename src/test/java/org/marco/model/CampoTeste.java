package org.marco.model;

import org.junit.Test;
import org.junit.Before;
import org.marco.exception.ExplosaoException;

import static org.junit.Assert.*;

public class CampoTeste {

    private Campo campo33;

    @Before
    public void iniciarCampo(){
        campo33 = new Campo(3,3);
    }

    @Test
    public void testeVizinhoDistancia1(){
        Campo vizinho = new Campo(3,2);
        boolean resultado = campo33.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    public void testeVizinhoDistancia2(){
        Campo vizinho = new Campo(2,2);
        boolean resultado = campo33.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
    public void testeNaoVizinho(){
        Campo vizinho = new Campo(1,1);
        boolean resultado = campo33.adicionarVizinho(vizinho);
        assertFalse(resultado);
    }

    @Test
    public void testeValorPadraoAtributoMarcado(){
        assertFalse(campo33.isMarcado());
    }

    @Test
    public void testeAlternarMarcacao(){
        campo33.alternarMarcacao();
        assertTrue(campo33.isMarcado());
    }

    @Test
    public void testeAbrirNaoMinadoNaoMarcado(){
        assertTrue(campo33.abrir());
    }

    @Test
    public void testeAbrirNaoMinadoMarcado(){
        campo33.alternarMarcacao();
        assertFalse(campo33.abrir());
    }

    @Test
    public void testeAbrirMinadoMarcado(){
        campo33.alternarMarcacao();
        campo33.minar();
        assertFalse(campo33.abrir());
    }

    @Test
    public void testeAbrirMinadoNaoMarcado(){
        campo33.minar();
        assertThrows(ExplosaoException.class, () -> {
            campo33.abrir();
        });
    }

    @Test
    public void testeAbrirComVizinhos(){
        Campo campo11 = new Campo(1,1);
        Campo campo22 = new Campo(2,2);
        campo22.adicionarVizinho(campo11);
        campo33.adicionarVizinho(campo22);
        campo33.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

    @Test
    public void testeAbrirComVizinhos2(){
        Campo campo11 = new Campo(1,1);
        Campo campo12 = new Campo(1,2);
        campo12.minar();

        Campo campo22 = new Campo(2,2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo33.adicionarVizinho(campo22);
        campo33.abrir();

        assertTrue(campo22.isAberto() && campo11.isFechado());
    }
}
