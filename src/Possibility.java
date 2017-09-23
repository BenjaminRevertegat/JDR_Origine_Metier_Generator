import java.util.ArrayList;

public class Possibility {
	
	private String nom;
	//Liste des carac non null
	private ArrayList<Caracteristique> myCarac;
	
	public Possibility(String nom)
	{
		this.nom = nom;
		myCarac = new ArrayList<Caracteristique>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Caracteristique> getMyCarac() {
		return myCarac;
	}

	public void setMyCarac(ArrayList<Caracteristique> myCarac) {
		this.myCarac = myCarac;
	}
	
	

}
