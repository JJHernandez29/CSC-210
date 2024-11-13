package csc210.CalendarGUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalendarGUI extends JFrame {

	public static void main(String[] args) {
		new CalendarGUI();
		System.out.println("main() is terminating");
	}

	// -- Every class has a constructor that looks something like this
	//    This is how an object is created (instantiated) from a class
	//    A constructor always has the same name as the class
	public CalendarGUI ()
	{
		this.setTitle("Calendar");
		
		// -- the initial size of the window
		this.setSize(700, 100);
		
		// -- terminate the program when the window closes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// -- describe how the window components will be laid out
		this.setLayout(new FlowLayout());
		
		this.setLocationRelativeTo(null);
		
		// -- add the components to the window
				
		// -- a text field for input/output
		JLabel yearlabel = new JLabel("Year: ");
		JTextField yeartextfield = new JTextField("1900");
		yeartextfield.setHorizontalAlignment(JTextField.CENTER);
		yeartextfield.setColumns(4);
		
		// -- a text field for input/output
		JLabel monthlabel = new JLabel("Month: ");
		JTextField monthtextfield = new JTextField("January");
		monthtextfield.setHorizontalAlignment(JTextField.CENTER);
		monthtextfield.setColumns(9);
		
		// -- a text field for input/output
		JLabel datelabel = new JLabel("Date: ");
		JTextField datetextfield = new JTextField("1");
		datetextfield.setHorizontalAlignment(JTextField.CENTER);
		datetextfield.setColumns(3);
		
		// -- a text field for input/output
		JLabel daylabel = new JLabel("Day: ");
		JTextField daytextfield = new JTextField();
		daytextfield.setHorizontalAlignment(JTextField.CENTER);
		daytextfield.setColumns(7);
		daytextfield.setEditable(false);
		
		// -- a button with associated code
		JButton computebutton = new JButton("Compute");
		computebutton.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
				Calendar c = new Calendar();
				int y = Integer.parseInt(yeartextfield.getText());
				String m = monthtextfield.getText();
				int date = Integer.parseInt(datetextfield.getText());
				String d = c.getDay(y, m, date);
				daytextfield.setText(d);
			}});
		
	

		this.add(monthlabel);
		this.add(monthtextfield);
		this.add(datelabel);
		this.add(datetextfield);
		this.add(yearlabel);
		this.add(yeartextfield);
		this.add(computebutton);
		this.add(daylabel);
		this.add(daytextfield);
		
		// -- make the window visible to the world
		this.setVisible(true);
		
	}
	
}
