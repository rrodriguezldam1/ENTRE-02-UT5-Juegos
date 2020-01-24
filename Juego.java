/**
* Un objeto de esta clase guarda informaci�n relativa a un juego
* 
* @author - Ram�n Rodr�guez Lucas
*/
public class Juego {
    private static final String SEPARADOR = ":";
    private String titulo;
    private Genero genero;
    private int year;
    private int[] valoraciones;

    /**
    *  Inicializa los atributos a partir de la informaci�n recibida
    *  Esta informaci�n se encuentra en linea
    */
    public Juego(String linea) {
        String[] valores = linea.split(SEPARADOR);
        for (int i = 0; i < valores.length; i++) {
            valores[i] = valores[i].trim();
        }
        titulo = valores[0].toUpperCase();
        genero = Genero.valueOf(valores[1].toUpperCase());
        year = Integer.valueOf(valores[2]);
        valoraciones = new int[10];
        for (int i = 0; i < valoraciones.length; i++) {
            valoraciones[i] = Integer.valueOf(valores [i + 3]);
        }
    }

    /**
     * accesor t�tulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * accesor g�nero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * accesor year
     */
    public int getYear() {
        return year;
    }

    /**
     * accesor valoraciones
     */
    public int[] getValoraciones() {
        return valoraciones;
    }

    /**
     * total votos emitidos
     */
    public int getVotos() {
        int cantidad = 0; 
        for (int i = 0; i < valoraciones.length; i++) {
            cantidad += valoraciones[i];
        }
        return cantidad;
    }

    /**
     *  obtener valoraci�n media
     */
    public double getValoracionMedia() {
        double media = 0; 
        for (int i = 0; i < valoraciones.length; i++) {
            media += valoraciones[i] * (i + 1);
        }
        return media/getVotos();
    }

    /**
     *  Un usuario punt�a el juego con un valor entre 1 y 10 
     */
    public void puntuar(int puntuacion) {
         valoraciones[puntuacion - 1]++;
    }

    /**
     * Representaci�n textual del juego 
     * (Ver enunciado)
     */
    public String toString() {
        return titulo + "\nG�nero: " + this.genero +
                            "| Lanzamiento: " + this.year +
                            "\nValoraci�n (" + getVotos() + " votos): "
                            + String.format("%.2f", this.getValoracionMedia());

    }

    public static void main(String[] args) {
        Juego juego1 = new Juego(
                            "Steep: deporte: 2016  : 0:0:0:0: 0: 0:0:0:12:  10");
        System.out.println(juego1.toString());

        Juego juego2 = new Juego(
                            "For the King: estrategia: 2018  : 0:0:0:7: 12: 0:33:13:2: 0");
        System.out.println(juego2.toString());

    }
}
