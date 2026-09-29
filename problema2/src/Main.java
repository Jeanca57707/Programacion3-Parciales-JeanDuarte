import java.util.*;

public class Main{
    public static void main(String[] args){
        menu();   
    }
    public static void menu(){

        Visitante visitante = new Visitante(null, null, null, null);
        Reporte r = new Reporte(visitante);

        Scanner sc = new Scanner(System.in);
        int opc = 0;
        
          do{

            try{

              System.out.println("\n===========================");
              System.out.println("         RECEPCION        ");
              System.out.println("===========================\n");

              System.out.println("1. Registrar entrada.");
              System.out.println("2. Buscar por nombre.");
              System.out.println("3. Listar visitantes.");
              System.out.println("4. Registrar salida.");
              System.out.println("5. Eliminar registro.");
              System.out.println("6.Generar reporte.");
              System.out.println("\n7. Salir\n");
              System.out.printf("Elija una opcion: ");
              opc = sc.nextInt();

              switch (opc) {
                  case 1:
                      visitante.registrarEntrada();
                      break;

                  case 2:
                      visitante.buscarPorNombre();
                      break;

                  case 3:
                    visitante.mostrarVisitantes();
                    break;

                  case 4:
                    visitante.registrarSalida();
                      break;

                  case 5:
                    visitante.eliminarRegistro();
                      break;
                  
                    case 6:
                        

                      break;
                  case 7:
                      System.out.println("\nSaliendo del programa...");
                      break;
            
                  default:
                      System.out.println("\nOpcion invalida");
                      break;
            }
        }catch(VisitanteInvalidoException e){
            System.out.println(e.getMessage());

        }
        }while(opc != 7); 
    }
}