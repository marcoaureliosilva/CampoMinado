package org.marco.enumeration;

public enum CoresENUM {
    AMARELO("\u001B[33m"),
    VERMELHO("\u001B[31m"),
    AZUL("\u001B[34m"),
    CORPADRAO("\u001B[0m");

    private final String cor;

    CoresENUM(String cor) { this.cor = cor; }

    public String getCor() { return cor; }
}
