package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DBMS.DBMSAbstract;
import DBMS.DBMScsv;
import DBMS.Record;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DBMSApp {

	private JFrame frame;
	private JTextField databasefileField;
	private DBMSAbstract database = new DBMScsv();
	private JTextField messageField;
	JTextArea fieldsTextArea;
	private JButton insertButton;
	ArrayList<String> tablefields;
	private JButton selectButton;
	private JLabel fieldsLabel;
	private JButton deleteButton;
	private JButton containsButton;
	private JButton updateButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBMSApp window = new DBMSApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DBMSApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					database.disconnect();
				} catch (FileNotFoundException e1) {
					// -- fail silently
				}
			}
		});
		frame.setBounds(100, 100, 590, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Database File:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(120, 17, 87, 26);
		panel.add(lblNewLabel);
		
		databasefileField = new JTextField();
		databasefileField.setEditable(false);
		databasefileField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		databasefileField.setBounds(205, 21, 119, 19);
		panel.add(databasefileField);
		databasefileField.setColumns(10);
		
		JButton openButton = new JButton("Connect");
		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	                JFileChooser jfc = new JFileChooser();
	                if (jfc.showDialog(null, "Load") == JFileChooser.APPROVE_OPTION) {
						database.connect(jfc.getSelectedFile().getAbsolutePath());
						databasefileField.setText(jfc.getSelectedFile().getName());
						tablefields = database.getTable().getFieldNames();
						for (String s : tablefields) {
							fieldsTextArea.append(s + "\n");
						}
	                }
				} catch (FileNotFoundException e1) {
					messageField.setText(e1.getMessage());
				}
				
			}
		});
		openButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		openButton.setBounds(25, 20, 85, 21);
		panel.add(openButton);
		
		messageField = new JTextField();
		messageField.setEditable(false);
		messageField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		messageField.setBounds(25, 442, 527, 19);
		panel.add(messageField);
		messageField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 74, 276, 84);
		panel.add(scrollPane);
		fieldsTextArea = new JTextArea();
		fieldsTextArea.setLineWrap(false);
		scrollPane.setViewportView(fieldsTextArea);

		selectButton = new JButton("Select Record");
		selectButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new selectRecord();
			}
		});
		selectButton.setBounds(25, 168, 119, 21);
		panel.add(selectButton);
		
		insertButton = new JButton("Insert Record");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new insertRecord(tablefields.size());
			}
		});
		insertButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		insertButton.setBounds(25, 199, 119, 21);
		panel.add(insertButton);
		
		fieldsLabel = new JLabel("Fields");
		fieldsLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fieldsLabel.setBounds(25, 51, 64, 13);
		panel.add(fieldsLabel);
		
		deleteButton = new JButton("Delete Record");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new deleteRecord();
			}
		});
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		deleteButton.setBounds(25, 230, 119, 21);
		panel.add(deleteButton);
		
		containsButton = new JButton("Contains Record");
		containsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new containsRecord();
			}
		});
		containsButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		containsButton.setBounds(25, 261, 119, 21);
		panel.add(containsButton);
		
		updateButton = new JButton("Update Records");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new updateRecord();
			}
		});
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		updateButton.setBounds(25, 292, 119, 21);
		panel.add(updateButton);
	}
	
	@SuppressWarnings("serial")
	/**
	 * Inner class for record insertion dialog.
	 */
	public class insertRecord extends JFrame {
		
		private JLabel[] labels;
		private JTextField[] fields;
		
		public insertRecord(int n) {
			JFrame jf = this;
			labels = new JLabel[n];
			fields = new JTextField[n];
			this.setBounds(100, 100, 300, 250);
			this.setTitle("Insert Record");

			JPanel jp = new JPanel();
			getContentPane().add(jp);
			jp.setLayout(null);
			
			for (int i = 0; i < labels.length; ++i) {
				labels[i] = new JLabel(tablefields.get(i));
				labels[i].setBounds(10, 25 * (i + 1), labels[i].getText().length() * 10, 21);
				fields[i] = new JTextField();
				fields[i].setBounds(60, 25 * (i + 1), 100, 21);
				jp.add(labels[i]);
				jp.add(fields[i]);
				
			}
			JButton submitButton = new JButton("Insert");
			submitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] s = new String[n];
					for (int i = 0; i < s.length; ++i) {
						String rec = labels[i].getText() + "=" + fields[i].getText();
						s[i] = rec;
					}
					try {
						database.insert(s);
					}
					catch (IllegalArgumentException iae) {
						messageField.setText(iae.getMessage());
					}
					jf.dispose();
				}
			});
			submitButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			submitButton.setBounds(25, (labels.length + 1) * 30, 85, 21);
			jp.add(submitButton);

			this.setVisible(true);
		}
	}
	
	@SuppressWarnings("serial")
	/**
	 * Inner class for record selection dialog.
	 */
	public class selectRecord extends JFrame {

		private JPanel contentPane;
		private JTextField field;
		private JTextField value;
		
		public selectRecord() {
			JFrame jf = this;
			messageField.setText("");

			this.setTitle("Select Records");
			setBounds(100, 100, 450, 351);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			field = new JTextField();
			field.setFont(new Font("Tahoma", Font.PLAIN, 12));
			field.setBounds(120, 27, 96, 19);
			contentPane.add(field);
			field.setColumns(10);
			
			JLabel fieldLabel = new JLabel("Field");
			fieldLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			fieldLabel.setBounds(23, 30, 75, 13);
			contentPane.add(fieldLabel);
			
			JLabel valuelabel = new JLabel("Value");
			valuelabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			valuelabel.setBounds(23, 65, 75, 13);
			contentPane.add(valuelabel);
			
			value = new JTextField();
			value.setFont(new Font("Tahoma", Font.PLAIN, 12));
			value.setBounds(120, 63, 96, 19);
			contentPane.add(value);
			value.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 88, 300, 118);
			contentPane.add(scrollPane);
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(false);
			scrollPane.setViewportView(textArea);
			
			JButton selectButton = new JButton("Select");
			selectButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			selectButton.setBounds(23, 228, 85, 21);
			selectButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(null);
					String s = field.getText().toUpperCase() + "=" + value.getText();
					ArrayList<Record> selections = database.select(s);
					for (Record r : selections) {
						textArea.append(r + "\n");
					}

				}
			});
			contentPane.add(selectButton);
			
			JButton dismissButton = new JButton("Dismiss");
			dismissButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			dismissButton.setBounds(23, 261, 85, 21);
			dismissButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jf.dispose();
				}
			});
			contentPane.add(dismissButton);

			this.setVisible(true);
		}
	}
	
	@SuppressWarnings("serial")
	/**
	 * Inner class for record deletion dialog.
	 */
	public class deleteRecord extends JFrame {

		private JPanel contentPane;
		private JTextField field;
		private JTextField value;
		
		public deleteRecord() {
			JFrame jf = this;
			messageField.setText("");

			this.setTitle("Delete Records");
			setBounds(100, 100, 450, 351);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			field = new JTextField();
			field.setFont(new Font("Tahoma", Font.PLAIN, 12));
			field.setBounds(120, 27, 96, 19);
			contentPane.add(field);
			field.setColumns(10);
			
			JLabel fieldLabel = new JLabel("Field");
			fieldLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			fieldLabel.setBounds(23, 30, 75, 13);
			contentPane.add(fieldLabel);
			
			JLabel valuelabel = new JLabel("Value");
			valuelabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			valuelabel.setBounds(23, 65, 75, 13);
			contentPane.add(valuelabel);
			
			value = new JTextField();
			value.setFont(new Font("Tahoma", Font.PLAIN, 12));
			value.setBounds(120, 63, 96, 19);
			contentPane.add(value);
			value.setColumns(10);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 88, 300, 118);
			contentPane.add(scrollPane);
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(false);
			scrollPane.setViewportView(textArea);
			
			JButton deleteButton = new JButton("Delete");
			deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			deleteButton.setBounds(23, 228, 85, 21);
			deleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(null);
					String s = field.getText().toUpperCase() + "=" + value.getText();
					ArrayList<Record> deletions = database.delete(s);
					for (Record r : deletions) {
						textArea.append(r + "\n");
					}

				}
			});
			contentPane.add(deleteButton);
			
			JButton dismissButton = new JButton("Dismiss");
			dismissButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			dismissButton.setBounds(23, 261, 85, 21);
			dismissButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jf.dispose();
				}
			});
			contentPane.add(dismissButton);


			this.setVisible(true);
		}
	}

	@SuppressWarnings("serial")
	/**
	 * Inner class for record containment dialog.
	 */
	public class containsRecord extends JFrame {

		private JPanel contentPane;
		private JTextField field;
		private JTextField value;
		private JTextField containsField;
		
		public containsRecord() {
			JFrame jf = this;
			messageField.setText("");

			this.setTitle("Contains Record");
			setBounds(100, 100, 450, 351);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			field = new JTextField();
			field.setFont(new Font("Tahoma", Font.PLAIN, 12));
			field.setBounds(120, 27, 96, 19);
			contentPane.add(field);
			field.setColumns(10);
			
			JLabel fieldLabel = new JLabel("Field");
			fieldLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			fieldLabel.setBounds(23, 30, 75, 13);
			contentPane.add(fieldLabel);
			
			JLabel valuelabel = new JLabel("Value");
			valuelabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			valuelabel.setBounds(23, 65, 75, 13);
			contentPane.add(valuelabel);
			
			value = new JTextField();
			value.setFont(new Font("Tahoma", Font.PLAIN, 12));
			value.setBounds(120, 63, 96, 19);
			contentPane.add(value);
			value.setColumns(10);
			
			JButton containsButton = new JButton("Contains");
			containsButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			containsButton.setBounds(23, 88, 85, 21);
			containsButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String s = field.getText().toUpperCase() + "=" + value.getText();
					boolean containment = database.contains(s);
					containsField.setText(containment ? "Does Contain" : "Does Not Contain");

				}
			});
			contentPane.add(containsButton);
			
			containsField = new JTextField();
			containsField.setEditable(false);
			containsField.setFont(new Font("Tahoma", Font.PLAIN, 12));
			containsField.setBounds(23, 118, 150, 21);
			contentPane.add(containsField);
			containsField.setColumns(20);
			
			JButton dismissButton = new JButton("Dismiss");
			dismissButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			dismissButton.setBounds(23, 281, 85, 21);
			dismissButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jf.dispose();
				}
			});
			contentPane.add(dismissButton);

			this.setVisible(true);
		}
	}
	
	@SuppressWarnings("serial")
	/**
	 * Inner class for record update dialog.
	 */
	public class updateRecord extends JFrame {

		private JPanel contentPane;
		private JTextField field;
		private JTextField value;
		private JTextField updatefield;
		private JTextField updatevalue;
		
		public updateRecord() {
			JFrame jf = this;
			messageField.setText("");

			this.setTitle("Update Records");
			setBounds(100, 100, 450, 400);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel fieldLabel = new JLabel("Field");
			fieldLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			fieldLabel.setBounds(23, 30, 75, 13);
			contentPane.add(fieldLabel);

			field = new JTextField();
			field.setFont(new Font("Tahoma", Font.PLAIN, 12));
			field.setBounds(120, 30, 96, 19);
			contentPane.add(field);
			field.setColumns(10);			
			
			JLabel valuelabel = new JLabel("Value");
			valuelabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			valuelabel.setBounds(23, 63, 75, 13);
			contentPane.add(valuelabel);
			
			value = new JTextField();
			value.setFont(new Font("Tahoma", Font.PLAIN, 12));
			value.setBounds(120, 63, 96, 19);
			contentPane.add(value);
			value.setColumns(10);
			
			JLabel updatefieldlabel = new JLabel("Update Field");
			updatefieldlabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			updatefieldlabel.setBounds(23, 95, 75, 13);
			contentPane.add(updatefieldlabel);
			
			updatefield = new JTextField();
			updatefield.setFont(new Font("Tahoma", Font.PLAIN, 12));
			updatefield.setBounds(120, 95, 96, 19);
			contentPane.add(updatefield);
			updatefield.setColumns(10);

			JLabel updatevaluelabel = new JLabel("New Value");
			updatevaluelabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			updatevaluelabel.setBounds(23, 125, 75, 13);
			contentPane.add(updatevaluelabel);
			
			updatevalue = new JTextField();
			updatevalue.setFont(new Font("Tahoma", Font.PLAIN, 12));
			updatevalue.setBounds(120, 125, 96, 19);
			contentPane.add(updatevalue);
			updatevalue.setColumns(10);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 155, 300, 118);
			contentPane.add(scrollPane);
			JTextArea textArea = new JTextArea();
			textArea.setLineWrap(false);
			scrollPane.setViewportView(textArea);
			
			JButton updateButton = new JButton("Update");
			updateButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			updateButton.setBounds(23, 300, 85, 21);
			updateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText(null);
					String sfield = field.getText().toUpperCase() + "=" + value.getText();
					String supdate = updatefield.getText().toUpperCase() + "=" + updatevalue.getText();
					try {
						ArrayList<Record> updates = database.update(sfield, supdate);						
						for (Record r : updates) {
							textArea.append(r + "\n");
						}
					}
					catch (IllegalArgumentException iae) {
						messageField.setText(iae.getMessage());
					}

				}
			});
			contentPane.add(updateButton);
			
			JButton dismissButton = new JButton("Dismiss");
			dismissButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			dismissButton.setBounds(23, 330, 85, 21);
			dismissButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jf.dispose();
				}
			});
			contentPane.add(dismissButton);

			this.setVisible(true);
		}
	}


}
