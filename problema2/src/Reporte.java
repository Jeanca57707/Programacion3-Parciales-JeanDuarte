import java.util.ArrayList;

public class Reporte extends Thread{

    private Visitante visitante;
    
   

    public Reporte(Visitante visitante){
        this.visitante = visitante;
    }

    @Override 
    public void run(){

        int total = 0;
        int dentro = 0;
        int fuera = 0;

        while (true) {

            try {
                Thread.sleep(500);

                if(visitante.getEstado() == "DENTRO"){
                    total ++;
                    dentro ++;
                }
                else{
                    total++;
                    fuera++;
                }    
            } catch (InterruptedException e) {
                
            } 
        }   
    }
}

