package padroescomportamentais.state;

public class PedidoEstadoPendente extends PedidoEstado {

    private PedidoEstadoPendente() {};
    private static PedidoEstadoPendente instance = new PedidoEstadoPendente();
    public static PedidoEstadoPendente getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pendente";
    }


    public boolean pagar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
