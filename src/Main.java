import java.util.ArrayList;


public class Main {
	

	public static void main(String[] args) 
	{
		
		Model model = new Model();
		JDRController controller = new JDRController(model);
		
		MainView mView = new MainView(model, controller);
		
		controller.init(mView);
		controller.displayViews();
		
		
		
	}
	
	

}
