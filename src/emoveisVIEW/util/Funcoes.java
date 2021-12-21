/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emoveisVIEW.util;

/**
 *
 * @author Heverson Funções para o tratamento dos botões
 */
public class Funcoes {

    public boolean ehNumeroInteiro(String texto) {
        if (texto.matches("[0-9]*")) {
            return true;
        }
        return false;
    }

    public boolean ehNumeroReal(String texto) {
        if (texto.matches("[0-9-,]*")) {
            return true;
        }
        return false;
    }

    public boolean ehLetra(String texto) {
        if (texto.matches("[a-z-A-Z]*")) {
            return true;
        }
        return false;
    }
}
