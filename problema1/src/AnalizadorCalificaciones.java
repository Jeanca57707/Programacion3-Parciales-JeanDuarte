public class AnalizadorCalificaciones {

    private double[] calificaciones;

    public AnalizadorCalificaciones(double[] calificaciones) {
        this.calificaciones = calificaciones;
    }

    public double[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(double[] calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void informacionGeneral(){

        mostrarCalificaciones();
        System.out.println();
        System.out.printf("Promedio General: %.2f%n%n" , calcularPromedio());
        System.out.printf("Mayor nota: %.2f%n", mayorNota());
        System.out.printf("Menor nota: %.2f%n", menorNota());
        System.out.println("\nCantidad de estudiantes Aprobados: " + aprobados());
        System.out.println();
    }

    public void mostrarCalificaciones(){

        System.out.println("\n============= CALIFICACIONES =============\n");

        for(int i = 0; i < calificaciones.length; i++){

            System.out.printf("Estudiante %d: %.2f%n", i +1 , calificaciones[i]);
        }
    }
    public double calcularPromedio(){

        double promedio = 0;

        for(int i = 0; i < calificaciones.length; i++){
            promedio += calificaciones[i];
        }
        return promedio / calificaciones.length;
    }

    public double menorNota(){
        double menor = calificaciones[0];
        for(int i = 0; i < calificaciones.length; i++){

            if(calificaciones[i] < menor){
                menor = calificaciones[i];
            }
        }
        return menor;

    }

    public double mayorNota(){

        double mayor = calificaciones[0];
        for(int i = 0; i < calificaciones.length; i++){

            if(calificaciones[i] > mayor){
                mayor = calificaciones[i];
            }
        }
        return mayor;
    }

    public int aprobados(){

        int aprobados = 0;
        for(int i = 0; i < calificaciones.length; i++){
            if(calificaciones[i] >= 70.0){
                aprobados ++;
            }
        }
        return aprobados;
    }   
}
