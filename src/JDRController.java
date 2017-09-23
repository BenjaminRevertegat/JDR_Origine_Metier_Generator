public class JDRController {
	
	private Model model = null;

	public MainView mainView = null;

	/** * Default constructeur */
	public JDRController(Model model) {
		this.model = model;
	}

	public void init(MainView mView) {
		this.mainView = mView;
	}

	public void displayViews() {
		this.mainView.display();
	}

	public void closeViews() {
		this.mainView.close();
	}

	public void notifyButtonPressed(Personnage perso) {
		this.model.setPerso(perso);
	}
}