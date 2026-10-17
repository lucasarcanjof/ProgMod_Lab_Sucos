import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SucoTest {

	private Suco suco;

	@BeforeEach
	public void setUp() {
		suco = new Suco(EFruta.LARANJA);
	}

	@Test
	public void precoDeSucoComUmaFrutaEhOValorDaFruta() {
		assertEquals(5.0, suco.preco(), 0.01);
	}

	@Test
	public void precoDeSucoComDuasFrutasEhAMedia() {
		suco.adicionar(EFruta.MANGA);
		assertEquals(5.5, suco.preco(), 0.01);
	}

	@Test
	public void naoAdicionaSegundaFrutaSemLaranja() {
		Suco sucoManga = new Suco(EFruta.MANGA);
		assertEquals(1, sucoManga.adicionar(EFruta.MORANGO));
		assertEquals(2, sucoManga.adicionar(EFruta.LARANJA));
	}

	@Test
	public void naoAdicionaMaisDeDuasFrutas() {
		suco.adicionar(EFruta.MANGA);
		assertEquals(2, suco.adicionar(EFruta.LARANJA));
	}
}
