import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.DefaultFormatter;


public class MainView implements ActionListener, Observer {
	
	private JDRController controller = null;
	private Model model = null;
	private JFrame frame = null;
	private JPanel mainPane = null;
	private JPanel contentPane = null;
	
	private JPanel originePane = null;
	private JPanel metierPane = null;
	
	private JFormattedTextField Couragefield = null;
	private JFormattedTextField Intelligencefield = null;
	private JFormattedTextField Charismefield = null;
	private JFormattedTextField Adressefield = null;
	private JFormattedTextField Forcefield = null;
	
	private String listOrigine;
	private String listMetier;
	
	private JButton button = null;
	private NumberFormat format = null;

	public MainView(Model model, JDRController controller) {
		this(model, controller, 0);
	}

	public MainView(Model model, JDRController controller, int volume) {
		this.model = model;
		this.model.addObserver(this);
		this.controller = controller;
		buildFrame();
	}

	private void buildFrame() {
		frame = new JFrame();
		frame.setLocation(300, 500);
		frame.setSize(800, 450);
		mainPane = new JPanel();
		mainPane.setLayout(new GridLayout(1, 3));
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(6, 2));
		
		
		format = NumberFormat.getNumberInstance();
		format.setParseIntegerOnly(true);
		format.setGroupingUsed(false);
		format.setMaximumFractionDigits(0);
		format.setMaximumIntegerDigits(3);
		
		JLabel cot = new JLabel("Courage :");
		JPanel jcot = new JPanel();
		jcot.add(cot);
		contentPane.add(jcot);
		Couragefield = new JFormattedTextField(format);
		((DefaultFormatter) Couragefield.getFormatter()).setAllowsInvalid(false);
		contentPane.add(Couragefield);
		
		JLabel inte = new JLabel("Intelligence :");
		JPanel jint = new JPanel();
		jint.add(inte);
		contentPane.add(jint);
		Intelligencefield = new JFormattedTextField(format);
		((DefaultFormatter) Intelligencefield.getFormatter()).setAllowsInvalid(false);
		contentPane.add(Intelligencefield);
		
		JLabel cha = new JLabel("Charisme :");
		JPanel jcha = new JPanel();
		jcha.add(cha);
		contentPane.add(jcha);
		Charismefield = new JFormattedTextField(format);
		((DefaultFormatter) Charismefield.getFormatter()).setAllowsInvalid(false);
		contentPane.add(Charismefield);
		
		JLabel adr = new JLabel("Adresse :");
		JPanel jadr = new JPanel();
		jadr.add(adr);
		contentPane.add(jadr);
		Adressefield = new JFormattedTextField(format);
		((DefaultFormatter) Adressefield.getFormatter()).setAllowsInvalid(false);
		contentPane.add(Adressefield);
		
		JLabel forc = new JLabel("Force :");
		JPanel jforc = new JPanel();
		jforc.add(forc);
		contentPane.add(jforc);
		Forcefield = new JFormattedTextField(format);
		((DefaultFormatter) Forcefield.getFormatter()).setAllowsInvalid(false);
		contentPane.add(Forcefield);
		
		button = new JButton("Générer");
		button.addActionListener(this);
		contentPane.add(button);
		
		buildOrigineFrame();
		buildMetierFrame();
		
		mainPane.add(contentPane);
		mainPane.add(originePane);
		mainPane.add(metierPane);
		
		frame.setContentPane(mainPane);
		frame.setTitle("JDR - Generator");
		frame.pack();
	}
	
	private void buildOrigineFrame() {
		
		originePane = new JPanel();
		originePane.setLayout(new FlowLayout());
		
		JLabel origine = new JLabel("Origine possible :");
		originePane.add(origine);
		
		if (Model.getOriginePossible() != null)
		{
			for (int i=0; i < Model.getOriginePossible().size() ; i++ )
			{
				JLabel currentOrigine = new JLabel(Model.getOriginePossible().get(i).getNom());
				originePane.add(currentOrigine);
			}
		}
		
	}
	
	private void buildMetierFrame() {
		metierPane = new JPanel();
		metierPane.setLayout(new FlowLayout());
		JLabel metier = new JLabel("Metier possible :");
		metierPane.add(metier);
		if (Model.getMetierPossible() != null)
		{
			for (int i=0; i < Model.getMetierPossible().size() ; i++ )
			{
				JLabel currentMetier = new JLabel(Model.getMetierPossible().get(i).getNom());
				metierPane.add(currentMetier);
			}
		}
	}

	public void close() {
		frame.dispose();
	}

	public void display() {
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.notifyButtonPressed(new Personnage(
				Integer.parseInt(this.Couragefield.getValue().toString()),
				Integer.parseInt(this.Intelligencefield.getValue().toString()),
				Integer.parseInt(this.Charismefield.getValue().toString()),
				Integer.parseInt(this.Adressefield.getValue().toString()),
				Integer.parseInt(this.Forcefield.getValue().toString())
				));
	}

	@Override
	public void update(Observable o, Object arg) {
		mainPane.remove(originePane);
		mainPane.remove(metierPane);
		buildOrigineFrame();
		buildMetierFrame();
		mainPane.add(originePane);
		mainPane.add(metierPane);
		frame.setVisible(true);
	}
}