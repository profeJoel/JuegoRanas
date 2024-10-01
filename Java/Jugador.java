import java.util.Scanner;

public class Jugador{
    private String nombre;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int escogerRana(){
        int rana;
        Scanner lector = new Scanner(System.in);
        do{
            System.out.println("Indique la rana para saltar [0-6]: ");
            rana = lector.nextInt();
        }while(rana <= 0 || rana > 6);
        return rana;
    }

    public int escogerMovimiento(Rana rana, int movimiento){
        
    }
}