package srshotel;

public class Seguridad {
    
    private static final int DESPLAZAMIENTO = 3;

    public static String cifrarCesar(String texto) {
        StringBuilder cifrado = new StringBuilder();
        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                cifrado.append((char) ((caracter - base + DESPLAZAMIENTO) % 26 + base));
            } else {
                cifrado.append(caracter); 
            }
        }
        return cifrado.toString();
    }
}
