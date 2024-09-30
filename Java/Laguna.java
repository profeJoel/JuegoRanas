public class Laguna {

    private Jugador jugador;
    private Rana[] rana;

    public Laguna(Jugador jugador){
        this.jugador = jugador;
        this.rana = new Rana[7];// por las 7 posiciones de rocas
        this.rana[0] = new Rana("v", ">");
        this.rana[1] = new Rana("v", ">");
        this.rana[2] = new Rana("v", ">");
        this.rana[3] = new Rana("-", "-");
        this.rana[4] = new Rana("r", "<");
        this.rana[5] = new Rana("r", "<");
        this.rana[6] = new Rana("r", "<");
    }

    public void comenzarJuego(){
        while(!this.hayGanador() || this.sinMovimientos()){
            this.jugador.mueveRana();
        }
        if(this.hayGanador())
            System.out.println("Felicidades!!! " + this.jugador.getNombre() + " has logrado finalizar el juego");
        else
            System.out.println("Has perdido!!! " + this.jugador.getNombre() + " sigue intentando...");

    }
    
}
