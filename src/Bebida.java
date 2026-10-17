import java.util.ArrayList;
import java.util.List;

public abstract class Bebida {

	private String descricao;
	protected List<EFruta> frutas;

	public Bebida(String descricao) {
		this.descricao = descricao;
		this.frutas = new ArrayList<>();
	}

	public abstract int adicionar(EFruta fruta);

	public abstract double preco();

	@Override
	public String toString() {
		return String.format("%s %s - R$ %.2f", descricao, frutas, preco());
	}

}
