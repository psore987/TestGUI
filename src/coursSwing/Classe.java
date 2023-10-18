package coursSwing;

public class Classe {
	private String idClasse;
	private String LibClasse;
	
	//constructeur
	public Classe(String idClasse, String libClasse) {
		super();
		this.idClasse = idClasse;
		LibClasse = libClasse;
	}

	// Getteurs / Setteurs
	public String getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(String idClasse) {
		this.idClasse = idClasse;
	}

	public String getLibClasse() {
		return LibClasse;
	}

	public void setLibClasse(String libClasse) {
		LibClasse = libClasse;
	}

	@Override
	public String toString() {
		return "Classe [idClasse=" + idClasse + ", LibClasse=" + LibClasse + "]";
	}

	
}
