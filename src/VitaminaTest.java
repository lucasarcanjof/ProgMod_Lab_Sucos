import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VitaminaTest {

	private Vitamina vitamina;

	@BeforeEach
	public void setUp() {
		vitamina = new Vitamina(EFruta.MANGA);
	}

	@Test
	public void vitaminaPequenaCobraMediaMaisLeite() {
		assertEquals(8.5, vitamina.preco(), 0.01);
	}

	@Test
	public void vitaminaMediaTemAcrescimoDe40PorCento() {
		vitamina.adicionar(EFruta.MORANGO);
		assertEquals((6.5 + 2.5) * 1.4, vitamina.preco(), 0.01);
	}

	@Test
	public void vitaminaGrandeTemAcrescimoDe60PorCento() {
		Vitamina grande = new Vitamina(EFruta.CUPUACU);
		grande.adicionar(EFruta.GRAVIOLA);
		grande.adicionar(EFruta.LARANJA);
		assertEquals((22.0 / 3 + 2.5) * 1.6, grande.preco(), 0.01);
	}

	@Test
	public void naoAdicionaMaisDeTresFrutas() {
		vitamina.adicionar(EFruta.MORANGO);
		vitamina.adicionar(EFruta.MANGA);
		assertEquals(3, vitamina.adicionar(EFruta.LARANJA));
	}
}
