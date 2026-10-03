package padroescomportamentais.state_observer;

import java.util.Observable;
import java.util.Observer;
public class Pedido implements Observer {

    private String nome;
    private PedidoEstado estado;

    private String ultimaNotificacao;

    public Pedido() {
        this.estado = PedidoEstadoPendente.getInstance();
        this.estado.addObserver(this);
    }


    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        estado.addObserver(this);
        estado.lancarEstado();
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


    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }


    @Override
    public void update(Observable estado, Object arg1) {
        this.ultimaNotificacao =
                this.nome + " estado atualizado para " + estado.toString();
    }


}