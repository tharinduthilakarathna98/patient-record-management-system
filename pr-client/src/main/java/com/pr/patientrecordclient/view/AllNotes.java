package com.pr.patientrecordclient.view;

import java.awt.EventQueue;
import javax.swing.table.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import com.pr.patientrecordclient.model.NoteModel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;


@SuppressWarnings("serial")
public class AllNotes extends JFrame {

	private JPanel contentPane;
	static JTable table;
	String[] columnNames = {"Note Id", "Patient name","Note Type", "care Provider", "Updated Time","Note","Note Satus"};
	private JTable table_4;
	private JTextField textField;
	private JTextField textField_2;
	private JTextArea textArea;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private String updateid;
	private JButton btnSave;
	private String signedStatus;
	private JButton btnNewButton;
	private int recordID;
	private JTextField textField_1;
	private TableRowSorter<DefaultTableModel> sorter;
	private JFormattedTextField formattedTextField_time ;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;

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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AllNotes() {
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

		JLabel lblNewLabel = new JLabel("View Patient Notes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(280, 21, 298, 36);
		panel.add(lblNewLabel);

		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView home=new HomeView();
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(10, 32, 89, 23);
		panel.add(btnNewButton_1);

		JPanel panel_1 =new JPanel();
		panel_1.setVisible(true);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 78, 784, 582);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 439, 753, 116);
		panel_1.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		table_4 = new JTable();
		table_4.repaint();
		scrollPane.setViewportView(table_4);
		JTableHeader header = table_4.getTableHeader();
		table_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_4.setBackground(new Color(255, 255, 255));
		table_4.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_4.setFillsViewportHeight(true);
		final DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table_4.setModel(model);
		model.fireTableDataChanged();
		table_4.revalidate();
		table_4.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table_4.getModel();
				int selectedRowIndex = table_4.getSelectedRow();
				updateid=model.getValueAt(selectedRowIndex, 0).toString();
				textField.setText(model.getValueAt(selectedRowIndex, 1).toString());
				textField_2.setText(model.getValueAt(selectedRowIndex, 3).toString());
				comboBox.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());//String.valueOf(comboBox_type.getSelectedItem());
				textArea.setText(model.getValueAt(selectedRowIndex,5).toString());
				signedStatus=model.getValueAt(selectedRowIndex, 6).toString();

				if (signedStatus.equals("signed")){
					btnactionfalse();
					refresh();
				}
				else {
					btnactiontrue();
					refresh();
				}
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

		JLabel lblNewLabel_1 = new JLabel("Patient name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(18, 42, 91, 14);
		panel_1.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(18, 67, 251, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setEditable(true);

		JLabel lblNewLabel_2 = new JLabel("Note Type");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 103, 169, 20);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Care Provider");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(394, 33, 155, 32);
		panel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1 = new JLabel("Time");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(394, 106, 169, 14);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Medical Note");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(20, 177, 148, 18);
		panel_1.add(lblNewLabel_1_1_2);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_2.setEditable(true);
		textField_2.setColumns(10);
		textField_2.setBounds(394, 67, 251, 29);
		panel_1.add(textField_2);

		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		textArea.setBorder(BorderFactory.createCompoundBorder(border,
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textArea.setVisible(true);
		textArea.setBounds(20, 206, 718, 116);
		panel_1.add(textArea);

		btnNewButton = new JButton("Sign");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String patientName = textField.getText();
				String noteType  = String.valueOf(comboBox.getSelectedItem());
				String careProvider = textField_2.getText();
				String noteStatus="signed";
				String noteTime = formattedTextField_time.getText();
				String note = textArea.getText();
				int noteid=Integer.parseInt(updateid);
				System.out.println(recordID);
				String POST_URL ="http://localhost:8080/pr_management_server/webapi/note/update";
				ResteasyClient client = (ResteasyClient)ClientBuilder.newClient();
				ResteasyWebTarget target = client.target(POST_URL );
				//Invocation.Builder request = target.request();
				Response response = null;
				try
				{
					NoteModel notemodel = new  NoteModel(noteid,patientName,noteType,careProvider,noteTime,note,noteStatus,recordID);
					response =target.request().post(Entity.json(notemodel));
					refresh();
					btnactionfalse();
					model.fireTableDataChanged();
					System.out.println("loop");
					// System.out.println(response.getStatusInfo());
				}
				finally
				{
					response.close();
					client.close();
					model.fireTableDataChanged();
				}
			}
		});

		btnNewButton.setBounds(121, 351, 103, 23);
		panel_1.add(btnNewButton);
		//System.out.println(noteID);
		btnSave = new JButton("Save");
		btnSave.setBackground(new Color(102, 204, 204));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBounds(341, 351, 89, 23);
		panel_1.add(btnSave);

		btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int noteid=Integer.parseInt(updateid);
				System.out.println(noteid);
				String BASE_URL="http://localhost:8080/pr_management_server/webapi/note/"+noteid;
				ResteasyClient client = new ResteasyClientBuilder().build();
				ResteasyWebTarget target = client.target(BASE_URL);
				Response response = target.request().delete();
				refresh();
				model.fireTableDataChanged();
				System.out.println(response.getStatus());
				response.close();
				//model.fireTableDataChanged();
				final ResteasyWebTarget target1 = client.target(BASE_URL);
				String response1 = target1.request().get(String.class);
				System.out.println(response1);
				refresh();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(102, 204, 204));
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(539, 353, 89, 23);
		panel_1.add(btnNewButton_1_1);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"note1", "note2", "note3", "note4"}));
		comboBox.setBounds(18, 135, 251, 29);
		panel_1.add(comboBox);

		textField_1 = new JTextField();
		textField_1.setBounds(610, 408, 161, 20);
		panel_1.add(textField_1);
		sorter = new TableRowSorter<>(model);
		table_4.setRowSorter(sorter);
		textField_1.setColumns(10);
		textField_1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(textField_1.getText());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				search(textField_1.getText());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				search(textField_1.getText());
			}
			public void search(String str) {
				if (str.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(str));
				}
			}
		});

		Format timeFormat = new SimpleDateFormat("HH:mm:ss");
		formattedTextField_time= new JFormattedTextField(timeFormat);
		formattedTextField_time.setFont(new Font("Tahoma", Font.PLAIN, 15));
		formattedTextField_time.setBounds(394, 136, 124, 29);
		panel_1.add(formattedTextField_time);
		Calendar c = Calendar.getInstance();
		final Date date = c.getTime();
		formattedTextField_time.setValue(date);

		JLabel lblNewLabel_3 = new JLabel("Search note");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(516, 409, 91, 14);
		panel_1.add(lblNewLabel_3);
		header.setFont(new Font("Tahoma", Font.BOLD, 15));

		String GET_URL ="http://localhost:8080/pr_management_server/webapi/note/get";
		ResteasyClient client = (ResteasyClient)ClientBuilder.newClient();
		ResteasyWebTarget target = client.target(GET_URL);
		Invocation.Builder request = target.request();
		Response response = null;

		try
		{
			response = request.get();
			List<NoteModel> list = response.readEntity(new GenericType<List<NoteModel>>() {});
			for (int i = 0; i < list.size(); i++){
				int noteID =list.get(i). getNoteId();
				String patientName = list.get(i).getPatientName();
				String noteType=list.get(i).getNoteType();
				String careProvider = list.get(i).getCareProvider();
				String noteTime = list.get(i).getNoteTime();
				String note = list.get(i).getNote();
				String noteStatus = list.get(i).getNoteStatus();
				recordID=list.get(i).getRecordID();
				// System.out.println(patientName);
				model.addRow(new Object[]{noteID,patientName,noteType,careProvider,noteTime,note,noteStatus });
			}  
		}
		finally
		{
			response.close();
			client.close();
		}
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String patientName = textField.getText();
				String noteType  = String.valueOf(comboBox.getSelectedItem());
				String careProvider = textField_2.getText();
				String noteStatus="not signed";
				String noteTime = formattedTextField_time.getText();
				String note = textArea.getText();
				int noteid=Integer.parseInt(updateid);
				String POST_URL ="http://localhost:8080/pr_management_server/webapi/note/update";
				ResteasyClient client = (ResteasyClient)ClientBuilder.newClient();
				ResteasyWebTarget target = client.target(POST_URL );
				//Invocation.Builder request = target.request();
				Response response = null;
				try
				{
					NoteModel notemodel = new  NoteModel(noteid,patientName,noteType,careProvider,noteTime,note,noteStatus,recordID);
					response =target.request().post(Entity.json(notemodel));
					refresh();
					model.fireTableDataChanged();
					refresh();
					refreshnote();
					System.out.println("loop");

				}
				finally
				{    
					response.close();
					client.close();
					model.fireTableDataChanged();
				}
			}	
		});
		// System.out.println(patientName);
	}

	public void refresh(){
		String GET_URL ="http://localhost:8080/pr_management_server/webapi/note/get/";
		ResteasyClient client = (ResteasyClient)ClientBuilder.newClient();
		ResteasyWebTarget target = client.target(GET_URL);
		Invocation.Builder request =target.request();
		Response response = null;

		try
		{
			response = request.get();
			List<NoteModel> list = response.readEntity(new GenericType<List<NoteModel>>() {});
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			table_4.setModel(model);
			for (int i = 0; i <list.size(); i++){
				int noteID =list.get(i). getNoteId();
				String patientName = list.get(i).getPatientName();
				String noteType=list.get(i).getNoteType();
				String careProvider = list.get(i).getCareProvider();
				String noteTime = list.get(i).getNoteTime();
				String note = list.get(i).getNote();
				String noteStatus = list.get(i).getNoteStatus();
				System.out.println(patientName);
				model.addRow(new Object[]{noteID,patientName,noteType,careProvider,noteTime,note,noteStatus });
			}  
		}
		finally
		{
			response.close();
			client.close();
		}
	}

	public void btnactionfalse() {
		btnSave.setEnabled(false);
		btnNewButton_1_1.setEnabled(false);
		btnNewButton.setEnabled(false);
	}

	public void btnactiontrue() {
		btnSave.setEnabled(true);
		btnNewButton_1_1.setEnabled(true);
		btnNewButton.setEnabled(true);
	}
	public void refreshnote() {
		textField.setText(null);
		textField_2 .setText(null);
		textArea.setText(null);

	}
}
