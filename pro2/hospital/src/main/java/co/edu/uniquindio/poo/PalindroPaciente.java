package co.edu.uniquindio.poo;

public class PalindroPaciente {
    public static boolean esPalindromo(String nombre){
        String limpio = nombre.replace("\\s+", "").toLowerCase();
        return limpio.equals(new StringBuilder(limpio).reverse().toString());
    }
    
}
