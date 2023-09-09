package com.pr.patientrecordclient.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import com.pr.patientrecordclient.model.RecordModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class ViewRecord extends JFrame {

	private JPanel contentPane;
	private TableRowSorter<DefaultTableModel> sorter;
	static JTable table;
	private JTable table_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_search;
	private JTextArea textArea;
	String[] columnNames = {"RecordId", "Name"," Age", "Weight", "Heart rate","Blood group","Symptoms"};
	private Image hospital=new ImageIcon(HomeView.class.getResource("/note.png")).getImage().getScaledInstance(90, 90,Image.SCALE_SMOOTH);
	private Image search=new ImageIcon(HomeView.class.getResource("/OIP.jpg")).getImage().getScaledInstance(90, 90,Image.SCALE_SMOOTH);
	/**
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRecord frame = new ViewRecord();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewRecord() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 699);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(0, 0, 784, 80);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("View Medical Records");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(280, 21, 298, 36);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView home=new HomeView();
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 21, 89, 23);
		panel.add(btnNewButton);

		JPanel panel_1 =new JPanel();
		panel_1.setVisible(true);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 78, 784, 582);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 398, 753, 116);
		panel_1.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table_4 = new JTable();
		scrollPane.setViewportView(table_4);
		JTableHeader header = table_4.getTableHeader();
		table_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_4.setBackground(new Color(255, 255, 255));
		table_4.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_4.setFillsViewportHeight(true);
		table_4.setModel(model);
		table_4.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table_4.getModel();
				int selectedRowIndex = table_4.getSelectedRow();
				textField.setText(model.getValueAt(selectedRowIndex, 0).toString());
				textField_1.setText(model.getValueAt(selectedRowIndex, 1).toString());
				textField_2.setText(model.getValueAt(selectedRowIndex, 2).toString());
				textField_3.setText(model.getValueAt(selectedRowIndex, 3).toString());
				textField_4.setText(model.getValueAt(selectedRowIndex, 4).toString());
				textArea.setText(model.getValueAt(selectedRowIndex, 6).toString());
				textField_6.setText(model.getValueAt(selectedRowIndex, 5).toString());
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});


		JLabel lblNewLabel_1 = new JLabel("Record ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 101, 91, 14);
		panel_1.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(20, 126, 195, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		JLabel lblNewLabel_2 = new JLabel("patient Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(266, 94, 169, 29);
		panel_1.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(266, 126, 195, 29);
		textField_1.setEditable(false);
		panel_1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(545, 126, 195, 29);
		textField_2.setEditable(false);
		panel_1.add(textField_2);

		JLabel lblNewLabel_2_1 = new JLabel("patient Age");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(545, 92, 155, 32);
		panel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1 = new JLabel("Patient Weight");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(20, 166, 169, 20);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Heart Rate");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(268, 166, 91, 14);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Blood Group");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(545, 163, 142, 20);
		panel_1.add(lblNewLabel_1_1_1_1);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(20, 191, 195, 29);
		textField_3.setEditable(false);
		panel_1.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(266, 191, 195, 29);
		textField_4.setEditable(false);
		panel_1.add(textField_4);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(545, 191, 195, 29);
		textField_6.setEditable(false);
		panel_1.add(textField_6);

		JLabel lblNewLabel_1_1_2 = new JLabel("Symptoms");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(20, 231, 148, 24);
		panel_1.add(lblNewLabel_1_1_2);

		textField_search = new JTextField();
		textField_search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_search.setBounds(514, 360, 260, 26);
		panel_1.add(textField_search);
		textField_search.setColumns(10);
		sorter = new TableRowSorter<>(model);
		table_4.setRowSorter(sorter);


		JLabel lblNewLabel_3 = new JLabel("Search Record");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(412, 365, 127, 14);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Add note");
		lblNewLabel_4.setBounds(693, 11, 80, 59);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String value=textField.getText();
				String value2=textField_1.getText();
				AddNote addnote= new AddNote();
				addnote.patientDetails(value,value2);
				addnote.setVisible(true);

			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(hospital));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBackground(new Color(0, 204, 102));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));

		JLabel lblNewLabel_4_1 = new JLabel("View note");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String value=textField.getText();
				int number = Integer.parseInt(value);
				ViewNotes view=new ViewNotes(number);
				view.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4_1.setIcon(new ImageIcon(search));
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4_1.setBackground(new Color(0, 204, 102));
		lblNewLabel_4_1.setBounds(628, 11, 72, 59);
		panel_1.add(lblNewLabel_4_1);

		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		textArea.setBorder(BorderFactory.createCompoundBorder(border,
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textArea.setBounds(20, 266, 720, 69);
		panel_1.add(textArea);
		header.setFont(new Font("Tahoma", Font.BOLD, 15));

		textField_search.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(textField_search.getText());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				search(textField_search.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				search(textField_search.getText());
			}
			public void search(String str) {
				if (str.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(str));
				}
			}
		});

		String GET_URL ="http://localhost:8080/pr_management_server/webapi/record/get";
		ResteasyClient client = (ResteasyClient)ClientBuilder.newClient();
		ResteasyWebTarget target = client.target(GET_URL);
		Invocation.Builder request = target.request();
		Response response = null;

		try
		{

			response = request.get();
			List<RecordModel> list = response.readEntity(new GenericType<List<RecordModel>>() {});

			for (int i = 0; i < list.size(); i++){
				int RecordId =list.get(i).getRecordId();
				String patientName = list.get(i).getPatientName();
				String patientAge=list.get(i).getPatientAge();
				String patientWeight = list.get(i).getPatientWeight();
				String patientHrate = list.get(i).getPatientHrate();
				String patientBgroup = list.get(i).getPatientBgroup();
				String patientSymptoms = list.get(i).getPatientSymptoms();
				System.out.println(patientName);
				model.addRow(new Object[]{RecordId,patientName,patientAge,patientWeight, patientHrate,patientBgroup,patientSymptoms });

			}   
		}
		finally
		{
			response.close();
			client.close();
		}

	}
}
