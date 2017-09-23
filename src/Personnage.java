
public class Personnage {
	
	private int Courage;
	private int Intelligence;
	private int Charisme;
	private int Adresse;
	private int Force;
	
	public Personnage(int Co, int I, int Ch, int A, int F)
	{
		Courage = Co;
		Intelligence = I;
		Charisme = Ch;
		Adresse = A;
		Force = F;
	}

	public int getCourage() {
		return Courage;
	}

	public int getIntelligence() {
		return Intelligence;
	}

	public int getCharisme() {
		return Charisme;
	}

	public int getAdresse() {
		return Adresse;
	}

	public int getForce() {
		return Force;
	}
	
	
	
}
