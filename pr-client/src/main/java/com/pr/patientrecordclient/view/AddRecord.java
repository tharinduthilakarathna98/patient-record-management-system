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
import com.pr.patientrecordclient.model.RecordModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class AddRecord extends JFrame {

	private JPanel contentPane;
	private JTextField textField_patientname;
	private JTextField textField_patientage;
	private JTextField textField_patientWeight;
	private JTextField textField_patientRate;
	private JTextField textField_patientGroup;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRecord frame = new AddRecord();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddRecord() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 654, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 638, 464);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 204));
		panel_1.setBounds(0, 0, 638, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Add New Record");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(229, 18, 209, 29);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Patient Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(45, 97, 104, 19);
		panel.add(lblNewLabel_1);

		textField_patientname = new JTextField();
		textField_patientname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_patientname.setBounds(45, 127, 487, 29);
		panel.add(textField_patientname);
		textField_patientname.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Patient Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(45, 160, 104, 19);
		panel.add(lblNewLabel_1_1);

		textField_patientage = new JTextField();
		textField_patientage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_patientage.setColumns(10);
		textField_patientage.setBounds(45, 190, 200, 29);
		panel.add(textField_patientage);

		JLabel lblNewLabel_1_1_1 = new JLabel("Patient Weight");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(332, 160, 104, 19);
		panel.add(lblNewLabel_1_1_1);

		textField_patientWeight = new JTextField();
		textField_patientWeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_patientWeight.setColumns(10);
		textField_patientWeight.setBounds(332, 190, 200, 29);
		panel.add(textField_patientWeight);

		JLabel lblNewLabel_1_1_2 = new JLabel("Patient Heart rate");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(45, 221, 143, 19);
		panel.add(lblNewLabel_1_1_2);

		textField_patientRate = new JTextField();
		textField_patientRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_patientRate.setColumns(10);
		textField_patientRate.setBounds(45, 251, 200, 29);
		panel.add(textField_patientRate);

		textField_patientGroup = new JTextField();
		textField_patientGroup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_patientGroup.setColumns(10);
		textField_patientGroup.setBounds(332, 251, 200, 29);
		panel.add(textField_patientGroup);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Patient Blood Group");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(332, 221, 143, 19);
		panel.add(lblNewLabel_1_1_2_1);

		JLabel symptoms = new JLabel("Symptoms");
		symptoms.setFont(new Font("Tahoma", Font.PLAIN, 15));
		symptoms.setBounds(45, 296, 143, 19);
		panel.add(symptoms);

		final JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String patientName = textField_patientname.getText();
				String patientAge = textField_patientage.getText();
				String patientWeight = textField_patientWeight.getText();
				String patientHrate = textField_patientRate.getText();
				String patientBgroup = textField_patientGroup.getText();
				String patientSymptoms =textArea.getText();
				String POST_URL ="http://localhost:8080/pr_management_server/webapi/record/add";
				ResteasyClient client = (ResteasyClient)ClientBuilder.newClient();
				ResteasyWebTarget target = client.target(POST_URL );
				//Invocation.Builder request = target.request();
				Response response = null;
				try
				{
					RecordModel person = new RecordModel(patientName, patientAge,patientWeight,patientHrate,patientBgroup,patientSymptoms);
					response =target.request().post(Entity.json(person));
					System.out.println("loop");
					System.out.println(response.getStatusInfo());
					refresh();
				}
				finally
				{
					response.close();
					client.close();
				}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 204, 204));
		btnNewButton.setBounds(165, 426, 135, 27);
		panel.add(btnNewButton);

		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh();
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBackground(new Color(102, 204, 204));
		btnClear.setBounds(360, 426, 135, 27);
		panel.add(btnClear);

		JButton btnNewButton_1 = new JButton("Demo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_patientname.setText("Pasindu Zoysa");
				textField_patientage.setText("28");
				textField_patientRate.setText("45bpa");
				textField_patientWeight.setText("33KG");
				textField_patientGroup.setText("O+");
				textArea.setText("A high temperature or shivering (chills)");
			}
		});
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		btnNewButton_1.setBounds(518, 76, 89, 23);
		panel.add(btnNewButton_1);

		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		textArea.setBorder(BorderFactory.createCompoundBorder(border,
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textArea.setBounds(45, 326, 487, 65);
		panel.add(textArea);
	}
	public void refresh() {
		textField_patientname.setText(null);
		textField_patientage.setText(null);
		textField_patientRate.setText(null);
		textField_patientWeight.setText(null);
		textField_patientGroup.setText(null);
		textArea.setText(null);
	}
}
