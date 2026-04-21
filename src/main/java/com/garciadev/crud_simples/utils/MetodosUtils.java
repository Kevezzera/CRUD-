package com.garciadev.crud_simples.utils;

import static java.lang.Character.isDigit;
import static java.lang.Character.isUpperCase;

public class MetodosUtils {


    public boolean validEmail(String email){
        boolean contemArroba = false;
        boolean contemEspaco = false;

        for (int c=1 ; c < email.length(); c++){
            char l = email.charAt(c);
            if (l == '@') contemArroba = true;
            if (l == ' ') contemEspaco = true;
        }

        return email.length() > 10 && contemArroba && !contemEspaco;
    }

    public boolean validaSenha(String senha){
        boolean contemMaiuscula = false;
        boolean contemEspaco = false;
        boolean contemNumero = false;

        for (int c = 0 ; c < senha.length(); c++){
            char l = senha.charAt(c);
            if (isUpperCase(l)) contemMaiuscula = true;
            if (l == ' ') contemEspaco = true;
            if (isDigit(l)) contemNumero = true;
        }

        return senha.length() >= 8 && contemMaiuscula && contemNumero && !contemEspaco;
    }
}
