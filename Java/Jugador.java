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
        }while(rana < 0 || rana > 6);
        return rana;
    }

    public int escogerMovimiento(Rana rana, int posicion){
        int salto;
        Scanner lector = new Scanner(System.in);
        do{
            System.out.println("Indique: \n - 1 si la rana hace salto simple, o \n - 2 si la rana hace salto doble.");
            salto = lector.nextInt();
        }while(salto < 1 || salto > 2);
        if(rana.vaPara(">"))
            return posicion + salto;
        
        if(rana.vaPara("<"))
            return posicion - salto;

        return -1;
    }
}