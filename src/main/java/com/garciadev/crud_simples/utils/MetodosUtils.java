package com.garciadev.crud_simples.utils;

import java.util.List;

public class MetodosUtils {


    public boolean validEmail(String email){
        char l = '@';

        if(email.indexOf(l) == -1) return false;
        if(email.length() < 10) return false;

        return true;
    }
}
