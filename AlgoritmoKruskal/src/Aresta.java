public class Aresta {
    private String origem;
    private String destino;
    private int peso;

    public Aresta(String origem, String destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return origem + " " + destino + " " + peso;
    }
}
