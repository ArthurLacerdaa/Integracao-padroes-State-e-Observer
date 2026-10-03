package padroescomportamentais.state_observer;

import java.util.Observable;

public abstract class PedidoEstado extends Observable {

    public abstract String getEstado();

    public void lancarEstado() {
        setChanged();
        notifyObservers();
    }

    public boolean pagar(Pedido pedido) {
        return false;
    }

    public boolean entregar(Pedido pedido) {
        return false;
    }

    public boolean enviar(Pedido pedido) {
        return false;
    }

    public boolean cancelar(Pedido pedido) {
        return false;
    }

    @Override
    public String toString() {
        return getEstado();
    }
}
