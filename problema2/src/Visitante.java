import java.util.*;

public class Visitante {

    private String nombre;
    private String cedula;
    private String motivoVisita;
    private String estado;

    private ArrayList<Visitante> visitantes = new ArrayList<>();
    
    public Visitante(String nombre, String cedula, String motivoVisita, String estado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.motivoVisita = motivoVisita;
        this.estado = estado;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public String getEstado() {
        return estado;
    }

    public synchronized void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    public void registrarEntrada()throws VisitanteInvalidoException{

        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Cedula: ");
        String cedula = sc.nextLine();

        System.out.print("Motivo de visita: ");
        String motivo = sc.nextLine();

        if(visitantes.isEmpty()){

            Visitante visitante = new Visitante(nombre, cedula, motivo, "DENTRO");
            visitantes.add(visitante);
            System.out.println("VIsitante registrado correctamente");
            return;
        }
        else{

            for(Visitante v : visitantes){

              if(cedula.equals(v.cedula)){
                throw new VisitanteInvalidoException("Error. Esta cedula ya esta registrada");
        
               }
            }
        }

        if(nombre.isEmpty() || motivo.isEmpty() || cedula.isEmpty()){

            throw new VisitanteInvalidoException("Error. No puedes dejar ningun campo vacio");
           } 

        Visitante visitante = new Visitante(nombre, cedula, motivo, "DENTRO");
        visitantes.add(visitante);
        System.out.println("VIsitante registrado correctamente");     
    }

   
   
    public void registrarSalida() throws VisitanteInvalidoException{

        if(visitantes.isEmpty()){
            System.out.println("NO HAY VISITANTES REGISTRADOS");
            return ;
        }
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su cedula: ");
        String cedula = sc.nextLine();
        int encontrado = 0;

        if(cedula.isEmpty()){
            throw new VisitanteInvalidoException("No puede dejar el campo vacio");
        }

        for(Visitante v : visitantes){

            if(cedula.equals(v.cedula) && v.estado == "SALIO"){
                throw new VisitanteInvalidoException("El visitante ya se encuentra afuera");
            }  
            if(cedula.equals(v.cedula) && v.estado == "DENTRO"){

                encontrado = 1;
                v.setEstado("SALIO");
            }      
        }
        if(encontrado == 0){
            throw new VisitanteInvalidoException("Cedula no encontrada");
        }
        
    }

    public void buscarPorNombre(){

        if(visitantes.isEmpty()){
            System.out.println("NO HAY VISITANTES REGISTRADOS");
            return ;
        }

        Scanner name = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = name.nextLine();

        for(Visitante v: visitantes){
            if(v.nombre.toLowerCase().equals(nombre.toLowerCase())){
                System.out.println(v.nombre.toUpperCase());
            }
        }
    }

    public void mostrarVisitantes(){
        if(visitantes.isEmpty()){
            System.out.println("NO HAY VISITANTES REGISTRADOS");
        }
        else{
            System.out.println("\nLISTA DE VISITANTES\n");
            System.out.printf("%-10s\t%-10s\t%-10s\t%-10s%n", "NOMBRE", "CEDULA",
                "MOTIVO DE VISITA", "ESTADO");
            for (Visitante v: visitantes){
                System.out.printf("%-10s\t%-10s\t%-18s\t%-10s%n", v.nombre, v.cedula, v.motivoVisita, v.estado);
            }
        }
    }

    
    
    public void eliminarRegistro()throws VisitanteInvalidoException{

        if(visitantes.isEmpty()){
            System.out.println("LA LISTA ESTA VACIA");
            return ;
        }
        Scanner ced = new Scanner(System.in);
        boolean encontrado = false;
        System.out.print("Ingrese su cedula: ");
        String cedula = ced.nextLine();

        if(cedula.isEmpty()){
            throw new VisitanteInvalidoException("No puede dejar el campo vacio");
            
        }
        for(Visitante v: visitantes){
            if(cedula == v.cedula){
                visitantes.remove(v);
                encontrado = true;
            }
        }
        if(!encontrado){
            throw new VisitanteInvalidoException("Esta cedula no esta registrada");
        }
        System.out.println("Visitante eliminado de la lista!");
        
    }

    public synchronized ArrayList<Visitante> getVisitantes() {
        return visitantes;
    }
}
