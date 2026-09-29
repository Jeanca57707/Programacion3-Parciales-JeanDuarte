public class Main{

    public static void main(String[] args) {
        double [] calificaciones = {78, 92, 55, 88, 70, 95, 61};
        AnalizadorCalificaciones analizador = new AnalizadorCalificaciones(calificaciones);

        analizador.informacionGeneral();
    }
}