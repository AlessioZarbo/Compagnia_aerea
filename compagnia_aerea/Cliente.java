package compagnia_aerea;

public class Cliente {
	
	private String nome;
	public Cliente(Cliente c)
	{
		this.nome=c.nome;
	}
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String toString() {
		return nome;
	}
	
	
	
	

}

