package co.edu.uniquindio.poo;

import java.util.HashSet;
import java.util.Set;

public class vocalIgualPaciente {
    public static boolean tieneVOcalesIguales(String nombre){
        Set<Character> vocales = new HashSet<>();
        for (char c : nombre.toLowerCase().toCharArray()){
            if ("aeiou".indexOf(c) != -1){
                vocales.add(c);
            }
        }
        return vocales.size() == 1;
    }
    
}
