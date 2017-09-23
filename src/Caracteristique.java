
public class Caracteristique {
	
	private String TAG;
	private int min;
	private int max;
	
	
	public Caracteristique(String nom, int min, int max)
	{
		this.TAG = nom;
		this.min = min;
		this.max = max;
	}
	
	public boolean Compare(int value)
	{
		if(( value >= min ) && ( value <= max ))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public String getTAG() {
		return TAG;
	}


	public void setTAG(String tAG) {
		TAG = tAG;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}
	
	

}
