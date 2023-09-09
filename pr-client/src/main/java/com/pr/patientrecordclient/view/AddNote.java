package com.pr.patientrecordclient.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import com.pr.patientrecordclient.model.NoteModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class AddNote extends JFrame {

	private JPanel contentPane;
	private JLabel l1;
	private JLabel l2;
	private JTextField textField_pname;
	private JTextField textField_cprovider;
	private JFormattedTextField formattedTextField_time ;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_type;
	private JTextArea textArea_note;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNote frame = new AddNote();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param value 
	 * 
	 */
	public void patientDetails(String id,String name) {
		System.out.println(id);
		l1.setText(id);
		l2.setText(name);
		textField_pname.setText(name);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AddNote() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 617, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 601, 492);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 204));
		panel_1.setBounds(0, 0, 601, 83);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add Medical Note");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(210, 24, 248, 34);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 110, 601, 37);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Patient ID : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 92, 14);
		panel_2.add(lblNewLabel_1);

		l1 = new JLabel("Output");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l1.setBounds(99, 6, 46, 25);
		panel_2.add(l1);



		JLabel lblNewLabel_1_1 = new JLabel("Patient Name :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(179, 11, 117, 14);
		panel_2.add(lblNewLabel_1_1);

		l2 = new JLabel("Output");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(293, 6, 298, 25);
		panel_2.add(l2);

		JLabel lblNewLabel_2 = new JLabel("Patient name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(39, 169, 100, 14);
		panel.add(lblNewLabel_2);

		textField_pname = new JTextField();
		textField_pname.setBounds(39, 194, 251, 29);
		panel.add(textField_pname);
		textField_pname.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Note type");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(332, 162, 121, 29);
		panel.add(lblNewLabel_2_1);
		comboBox_type = new JComboBox();
		comboBox_type.setModel(new DefaultComboBoxModel(new String[] {"note1", "note2", "note3", "note4"}));
		comboBox_type.setBackground(new Color(255, 255, 255));
		comboBox_type.setBounds(332, 194, 224, 29);
		panel.add(comboBox_type);

		JLabel lblNewLabel_2_2 = new JLabel("Care Provider");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(39, 234, 212, 14);
		panel.add(lblNewLabel_2_2);

		textField_cprovider = new JTextField();
		textField_cprovider.setColumns(10);
		textField_cprovider.setBounds(39, 259, 251, 29);
		panel.add(textField_cprovider);

		JLabel lblNewLabel_2_2_1 = new JLabel("Time");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_1.setBounds(332, 234, 148, 20);
		panel.add(lblNewLabel_2_2_1);

		//float minutes = 100.5f; // 1:40:30
		Calendar c = Calendar.getInstance();
		final Date date = c.getTime();
		Format timeFormat = new SimpleDateFormat("HH:mm:ss");
		formattedTextField_time = new JFormattedTextField(timeFormat);
		formattedTextField_time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		formattedTextField_time.setValue(date);
		formattedTextField_time.setBounds(332, 259, 224, 29);
		panel.add(formattedTextField_time);


		textArea_note = new JTextArea();
		textArea_note.setBackground(SystemColor.textHighlightText);
		textArea_note.setVisible(true);
		textArea_note.setBounds(39, 339, 517, 79);
		panel.add(textArea_note);
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		textArea_note.setBorder(BorderFactory.createCompoundBorder(border,
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		System.out.println(textField_pname.getText());
		JLabel lblNewLabel_2_2_2 = new JLabel("Note");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2_2.setBounds(39, 299, 126, 29);
		panel.add(lblNewLabel_2_2_2);
		btnNewButton = new JButton("Add Note");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String patientName = textField_pname.getText();
				String noteType  = String.valueOf(comboBox_type.getSelectedItem());
				String careProvider = textField_cprovider.getText();
				String noteStatus="not signed";
				String noteTime = formattedTextField_time.getText();
				String note = textArea_note.getText();
				String rid=l1.getText();
				int recordID= Integer.parseInt(rid);
				String POST_URL ="http://localhost:8080/pr_management_server/webapi/note/add";
				ResteasyClient client = (ResteasyClient)ClientBuilder.newClient();
				ResteasyWebTarget target = client.target(POST_URL );
				//Invocation.Builder request = target.request();
				Response response = null;
				try
				{
					NoteModel notemodel = new  NoteModel(patientName,noteType,careProvider,noteTime,note,noteStatus,recordID);
					response =target.request().post(Entity.json(notemodel));
					System.out.println("loop");
					System.out.println(response.getStatusInfo());
				}
				finally
				{
					response.close();
					client.close();
				}
			}
		});

		btnNewButton.setBackground(new Color(102, 204, 204));
		btnNewButton.setBounds(144, 444, 121, 37);
		panel.add(btnNewButton);
		JButton btnClearNote = new JButton("Clear  Note");
		btnClearNote.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				refreshnote();
			}
		});

		btnClearNote.setForeground(Color.WHITE);
		btnClearNote.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClearNote.setBackground(new Color(102, 204, 204));
		btnClearNote.setBounds(344, 444, 121, 37);
		panel.add(btnClearNote);
	}

	public void refreshnote() {
		textField_cprovider.setText(null);
		textArea_note .setText(null);
	}
}
