public class Rana {
    private String color;
    private String sentido;
    
    public Rana(String color, String sentido){
        this.color = color;
        this.sentido = sentido;
    }

    public String getSentido(){
        return this.sentido;
    }

    public boolean vaPara(String sentido){
        return this.sentido == sentido;
    }

    @Override
    public String toString(){
        return this.sentido;
    }
}
