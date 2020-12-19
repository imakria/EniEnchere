package fr.eniEnchere.bo;

public class Retraits {
	
	
	private int noArticle;
	private String rue;
	private String codePostal;
	private String ville;

	
	
	//CONSTRUCTORS -----------------------------------------------
	
	public Retraits() {
		super();
	}
	
	
	public Retraits(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
	public Retraits(int noArticle, String rue, String codePostal, String ville) {
		super();
		this.noArticle = noArticle;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	//GETTERS ET SETTERS -----------------------------------------

	public int getNoArticle() {
		return noArticle;
	}



	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}



	public String getRue() {
		return rue;
	}



	public void setRue(String rue) {
		this.rue = rue;
	}



	public String getCodePostal() {
		return codePostal;
	}



	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}



	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}

	
	
	
	//Méthode to String -----------------------------------------

	
	@Override
	public String toString() {
		return "Retraits [noArticle=" + noArticle + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}
	
		

}
