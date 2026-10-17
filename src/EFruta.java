public enum EFruta {

	CUPUACU(9.0),
	GRAVIOLA(8.0),
	LARANJA(5.0),
	MANGA(6.0),
	MORANGO(7.0);

	private double valor;
	
	EFruta(double preco){
		this.valor = preco;
	}

	public double valor(){
		return valor;
	}
}
