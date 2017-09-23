import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable{

	private static ArrayList<Possibility> Origine;
	private static ArrayList<Possibility> Metier;
	
	private static ArrayList<Possibility> OriginePossible;
	private static ArrayList<Possibility> MetierPossible;
	
	private static Possibility currentP;
	private static Personnage perso;
	private final static int MAX = 20;
	private final static int MIN = 0;
	
	public Model()
	{
		Origine = new ArrayList<Possibility>();
		Metier = new ArrayList<Possibility>();
		
		AddOrigine();
		AddMetier();
		
	}
	
	
	public static void CheckPerso()
	{
		//reset des possibilités
		OriginePossible = new ArrayList<Possibility>();
		MetierPossible = new ArrayList<Possibility>();
		
		boolean co, in, ch, ad, fo;
		
		//Parcour des origines
		for(int i=0; i < Origine.size(); i++)
		{
			if (Origine.get(i).getMyCarac().size() == 0)
			{
				OriginePossible.add(Origine.get(i));
			}
			else
			{
				co = true;
				in = true;
				ch = true;
				ad = true;
				fo = true;
				for(int j=0; j < Origine.get(i).getMyCarac().size(); j++)
				{
					if(Origine.get(i).getMyCarac().get(j).getTAG().equals("Courage"))
					{
						co = Origine.get(i).getMyCarac().get(j).Compare(perso.getCourage());
					}
					if(Origine.get(i).getMyCarac().get(j).getTAG().equals("Intelligence"))
					{
						in = Origine.get(i).getMyCarac().get(j).Compare(perso.getIntelligence());
					}
					if(Origine.get(i).getMyCarac().get(j).getTAG().equals("Charisme"))
					{
						ch = Origine.get(i).getMyCarac().get(j).Compare(perso.getCharisme());
					}
					if(Origine.get(i).getMyCarac().get(j).getTAG().equals("Adresse"))
					{
						ad = Origine.get(i).getMyCarac().get(j).Compare(perso.getAdresse());
					}
					if(Origine.get(i).getMyCarac().get(j).getTAG().equals("Force"))
					{
						fo = Origine.get(i).getMyCarac().get(j).Compare(perso.getForce());
					}
				}
				if (co && in && ch && ad && fo)
				{
					OriginePossible.add(Origine.get(i));
				}
			}
			
		}
		
		//Parcour des métier
				for(int i=0; i < Metier.size(); i++)
				{
					if (Metier.get(i).getMyCarac().size() == 0)
					{
						MetierPossible.add(Metier.get(i));
					}
					else
					{
						co = true;
						in = true;
						ch = true;
						ad = true;
						fo = true;
						for(int j=0; j < Metier.get(i).getMyCarac().size(); j++)
						{
							if(Metier.get(i).getMyCarac().get(j).getTAG().equals("Courage"))
							{
								co = Metier.get(i).getMyCarac().get(j).Compare(perso.getCourage());
							}
							if(Metier.get(i).getMyCarac().get(j).getTAG().equals("Intelligence"))
							{
								in = Metier.get(i).getMyCarac().get(j).Compare(perso.getIntelligence());
							}
							if(Metier.get(i).getMyCarac().get(j).getTAG().equals("Charisme"))
							{
								ch = Metier.get(i).getMyCarac().get(j).Compare(perso.getCharisme());
							}
							if(Metier.get(i).getMyCarac().get(j).getTAG().equals("Adresse"))
							{
								ad = Metier.get(i).getMyCarac().get(j).Compare(perso.getAdresse());
							}
							if(Metier.get(i).getMyCarac().get(j).getTAG().equals("Force"))
							{
								fo = Metier.get(i).getMyCarac().get(j).Compare(perso.getForce());
							}
						}
						if (co && in && ch && ad && fo)
						{
							MetierPossible.add(Metier.get(i));
						}
					}
					
				}
	}
	
	public static void AddOrigine()
	{
		currentP = new Possibility("Humain");
		Origine.add(currentP);
		
		currentP = new Possibility("Barbare");
		currentP.getMyCarac().add(new Caracteristique("Courage",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Force",13,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Nain");
		currentP.getMyCarac().add(new Caracteristique("Courage",11,MAX));
		currentP.getMyCarac().add(new Caracteristique("Force",12,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Haut Elfe");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",11,MAX));
		currentP.getMyCarac().add(new Caracteristique("Charisme",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Adresse",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Force",MIN,12));
		Origine.add(currentP);
		
		currentP = new Possibility("Demi-Elfe");
		currentP.getMyCarac().add(new Caracteristique("Charisme",10,MAX));
		currentP.getMyCarac().add(new Caracteristique("Adresse",11,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Elfe Sylvain");
		currentP.getMyCarac().add(new Caracteristique("Charisme",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Adresse",10,MAX));
		currentP.getMyCarac().add(new Caracteristique("Force",MIN,11));
		Origine.add(currentP);
		
		currentP = new Possibility("Elfe Noir");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Adresse",13,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Orque");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",MIN,8));
		currentP.getMyCarac().add(new Caracteristique("Charisme",MIN,10));
		currentP.getMyCarac().add(new Caracteristique("Force",12,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Demi-Orque");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",MIN,10));
		currentP.getMyCarac().add(new Caracteristique("Adresse",MIN,11));
		currentP.getMyCarac().add(new Caracteristique("Force",12,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Gobelin");
		currentP.getMyCarac().add(new Caracteristique("Courage",MIN,10));
		currentP.getMyCarac().add(new Caracteristique("Intelligence",MIN,10));
		currentP.getMyCarac().add(new Caracteristique("Charisme",MIN,8));
		currentP.getMyCarac().add(new Caracteristique("Force",MIN,9));
		Origine.add(currentP);
		
		currentP = new Possibility("Ogre");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",MIN,9));
		currentP.getMyCarac().add(new Caracteristique("Charisme",MIN,10));
		currentP.getMyCarac().add(new Caracteristique("Adresse",MIN,11));
		currentP.getMyCarac().add(new Caracteristique("Force",13,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Hobbit");
		currentP.getMyCarac().add(new Caracteristique("Courage",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Intelligence",10,MAX));
		currentP.getMyCarac().add(new Caracteristique("Force",MIN,10));
		Origine.add(currentP);
		
		currentP = new Possibility("Gnôme");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",10,MAX));
		currentP.getMyCarac().add(new Caracteristique("Adresse",13,MAX));
		currentP.getMyCarac().add(new Caracteristique("Force",MIN,8));
		Origine.add(currentP);
	}
	
	public static void AddMetier()
	{	
		currentP = new Possibility("Guerrier");
		currentP.getMyCarac().add(new Caracteristique("Courage",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Force",12,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Gladiateur");
		currentP.getMyCarac().add(new Caracteristique("Courage",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Force",12,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Ninja");
		currentP.getMyCarac().add(new Caracteristique("Adresse",13,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Assassin");
		currentP.getMyCarac().add(new Caracteristique("Adresse",13,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Voleur");
		currentP.getMyCarac().add(new Caracteristique("Adresse",12,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Prêtre");
		currentP.getMyCarac().add(new Caracteristique("Charisme",12,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Mage");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",12,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Sorcier");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",12,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Paladin");
		currentP.getMyCarac().add(new Caracteristique("Courage",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Intelligence",10,MAX));
		currentP.getMyCarac().add(new Caracteristique("Charisme",11,MAX));
		currentP.getMyCarac().add(new Caracteristique("Force",9,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Ranger");
		currentP.getMyCarac().add(new Caracteristique("Charisme",10,MAX));
		currentP.getMyCarac().add(new Caracteristique("Adresse",10,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Ménestrel");
		currentP.getMyCarac().add(new Caracteristique("Charisme",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Adresse",11,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Marchand");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Charisme",11,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Négociant");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",12,MAX));
		currentP.getMyCarac().add(new Caracteristique("Charisme",11,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Ingénieur");
		currentP.getMyCarac().add(new Caracteristique("Adresse",11,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Pirate");
		currentP.getMyCarac().add(new Caracteristique("Courage",11,MAX));
		currentP.getMyCarac().add(new Caracteristique("Adresse",11,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Bourgeois");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",10,MAX));
		currentP.getMyCarac().add(new Caracteristique("Charisme",11,MAX));
		Origine.add(currentP);
		
		currentP = new Possibility("Noble");
		currentP.getMyCarac().add(new Caracteristique("Intelligence",10,MAX));
		currentP.getMyCarac().add(new Caracteristique("Charisme",11,MAX));
		Origine.add(currentP);
		
	}
	
	public void setPerso(Personnage perso) {
		this.perso = perso;
		CheckPerso();
		
		System.out.println(" # Origine :");
		
		for (int i=0; i < OriginePossible.size(); i++)
		{
			System.out.println( OriginePossible.get(i).getNom() );
		}
		System.out.println(" # Métier :");
		
		for (int i=0; i < MetierPossible.size(); i++)
		{
			System.out.println( MetierPossible.get(i).getNom() );
		}
	//	setChanged();
	//	notifyObservers(this.OriginePossible);
	//	notifyObservers(this.MetierPossible);
	}
	
}
