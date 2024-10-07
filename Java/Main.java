import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Bienvenido al Juego de Ranas");
        System.out.println("\nIngrese su nombre: ");
        Jugador jugador1 = new Jugador(lector.nextLine());

        Laguna rocas = new Laguna(jugador1);
        rocas.comenzarJuego();
        
        System.out.println("Juego terminado, Gracias por jugar!");
    }
    
}
