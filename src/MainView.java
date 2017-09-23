import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
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
	private JPanel contentPane = null;
	private JFormattedTextField Couragefield = null;
	private JFormattedTextField Intelligencefield = null;
	private JFormattedTextField Charismefield = null;
	private JFormattedTextField Adressefield = null;
	private JFormattedTextField Forcefield = null;
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
		frame.setContentPane(contentPane);
		frame.setTitle("JDR - Generator");
		frame.pack();
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
		if (arg instanceof Integer)
		{
			//field.setValue((Integer) arg);
		}
		System.out.println("[MainView] : update");
	}
}