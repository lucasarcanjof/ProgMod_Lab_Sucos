import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

	private Pedido pedido;

	@BeforeEach
	public void setUp() {
		pedido = new Pedido();
	}

	@Test
	public void adicionaBebidasAoPedido() {
		assertEquals(1, pedido.adicionar(new Suco(EFruta.LARANJA)));
		assertEquals(2, pedido.adicionar(new Vitamina(EFruta.MANGA)));
	}

	@Test
	public void precoDoPedidoEhASomaDasBebidas() {
		pedido.adicionar(new Suco(EFruta.LARANJA));
		pedido.adicionar(new Vitamina(EFruta.MANGA));
		assertEquals(13.5, pedido.preco(), 0.01);
	}

	@Test
	public void pedidoVazioCustaZero() {
		assertEquals(0.0, pedido.preco(), 0.01);
	}
}
