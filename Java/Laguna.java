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
        while(!this.hayGanador() && !this.sinMovimientos()){
            this.mostrarRocas();
            this.moverRana();
        }

        this.mostrarRocas();
        if(this.hayGanador())
            System.out.println("Felicidades!!! " + this.jugador.getNombre() + " has logrado finalizar el juego");
        else
            System.out.println("Has perdido!!! " + this.jugador.getNombre() + " sigue intentando...");

    }

    private boolean hayGanador(){
        if(!this.rana[0].vaPara("<")) return false;
        if(!this.rana[1].vaPara("<")) return false;
        if(!this.rana[2].vaPara("<")) return false;
        if(!this.rana[3].vaPara("-")) return false;
        if(!this.rana[4].vaPara(">")) return false;
        if(!this.rana[5].vaPara(">")) return false;
        if(!this.rana[6].vaPara(">")) return false;

        return true;
    }

    private boolean sinMovimientos(){
        for(int i=0; i<7; i++)
            if(!this.ranaTieneMovimiento(i)) return false;
        return true;

    }

    private boolean ranaTieneMovimiento(int i){
        if(this.rana[i].vaPara("<"))
            if(i>=2 && (this.rana[i-1].vaPara("-") || this.rana[i-2].vaPara("-"))) return true;
            else if(i==1 && this.rana[i-1].vaPara("-"))
                return true;
                else if(i==0)return true; 
        
        if(this.rana[i].vaPara(">"))
            if(i<= 4 && (this.rana[i+1].vaPara("-") || this.rana[i+2].vaPara("-"))) return true;
            else if(i==5 && this.rana[i+1].vaPara("-")) return true; 
                else if(i==6) return true;

        if(this.rana[i].vaPara("-")) return true;

        return false;
    }

    public void mostrarRocas(){
        System.out.println("\n***********************\nEstado del Juego: ");
        for(Rana rana: this.rana)
            System.out.print(rana + " ");
        System.out.println("");
        for(int i=0; i<7; i++)
            System.out.print(i + " ");

        System.out.println("\n***********************\n");
    }
    
    public void moverRana(){
        int r, m;
        Rana auxiliar;
        do{
            r = this.jugador.escogerRana();
            m = this.jugador.escogerMovimiento(this.rana[r], r);
        }while(!this.verificarMovimientoValido(r, m));

        auxiliar = this.rana[m];
        this.rana[m] = this.rana[r];
        this.rana[r] = auxiliar;
    }

    private boolean verificarMovimientoValido(int rana, int movimiento){
        return (((movimiento == rana + 1 || movimiento == rana + 2) || (movimiento == rana - 1 || movimiento == rana - 2)) && this.rana[movimiento].vaPara("-"));
    }
}
