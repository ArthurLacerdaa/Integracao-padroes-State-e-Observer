package padroescomportamentais.state;

public class Pedido {
    
    private String nome;
    private PedidoEstado estado;

    public Pedido() {
        this.estado = PedidoEstadoPendente.getInstance();
    }
    
    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }
    
    public boolean pagar() {
        return estado.pagar(this);
    }
    
    public boolean entregar() {
        return estado.entregar(this);
    }
    
    public boolean enviar() {
        return estado.enviar(this);
    }
    
    public boolean cancelar() {
        return estado.cancelar(this);
    }
    




    public String getNomeEstado() {
        return estado.getEstado();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PedidoEstado getEstado() {
        return estado;
    }    
}
