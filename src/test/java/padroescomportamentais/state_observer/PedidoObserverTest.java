package padroescomportamentais.state_observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoObserverTest {

    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido();
        pedido.setNome("Pedido 1");
    }

    @Test
    public void deveNotificarObserverAoAlterarParaPendente() {
        pedido.setEstado(PedidoEstadoPendente.getInstance());

        assertEquals(
                "Pedido 1 estado atualizado para Pendente",
                pedido.getUltimaNotificacao()
        );
    }

    @Test
    public void deveNotificarObserverAoAlterarParaPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());

        assertEquals(
                "Pedido 1 estado atualizado para Pago",
                pedido.getUltimaNotificacao()
        );
    }

    @Test
    public void deveNotificarObserverAoAlterarParaEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());

        assertEquals(
                "Pedido 1 estado atualizado para Enviado",
                pedido.getUltimaNotificacao()
        );
    }

    @Test
    public void deveNotificarObserverAoAlterarParaEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());

        assertEquals(
                "Pedido 1 estado atualizado para Entregue",
                pedido.getUltimaNotificacao()
        );
    }

    @Test
    public void deveNotificarObserverAoAlterarParaCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());

        assertEquals(
                "Pedido 1 estado atualizado para Cancelado",
                pedido.getUltimaNotificacao()
        );
    }

    @Test
    public void deveNotificarObserverDuranteTodaSequenciaDeEstados() {
        pedido.setEstado(PedidoEstadoPendente.getInstance());

        assertEquals(
                "Pedido 1 estado atualizado para Pendente",
                pedido.getUltimaNotificacao()
        );

        pedido.pagar();

        assertEquals(
                "Pedido 1 estado atualizado para Pago",
                pedido.getUltimaNotificacao()
        );

        pedido.enviar();

        assertEquals(
                "Pedido 1 estado atualizado para Enviado",
                pedido.getUltimaNotificacao()
        );

        pedido.entregar();

        assertEquals(
                "Pedido 1 estado atualizado para Entregue",
                pedido.getUltimaNotificacao()
        );
    }

}
