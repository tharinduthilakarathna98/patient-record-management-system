package com.pr.patientrecordclient.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class HomeView extends JFrame {

	private JPanel contentPane;
	private JPanel menu1;
	private JPanel menu2;
	private JPanel menu3;
	private Image icon1=new ImageIcon(HomeView.class.getResource("/addreport.jpg")).getImage().getScaledInstance(90, 90,Image.SCALE_SMOOTH);
	private Image icon2=new ImageIcon(HomeView.class.getResource("/OIP.jpg")).getImage().getScaledInstance(90, 90,Image.SCALE_SMOOTH);
	private Image icon3=new ImageIcon(HomeView.class.getResource("/noty.png")).getImage().getScaledInstance(90, 90,Image.SCALE_SMOOTH);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
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
	public HomeView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 846, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(0, 0, 994, 91);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Medical Record Management System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(243, 26, 401, 35);
		panel.add(lblNewLabel);

		menu1 = new JPanel();//add correct naming conventions
		menu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddRecord addrecord= new AddRecord();
				addrecord.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setcolor(menu1);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setbcolor(menu1);
			}
		});
		menu1.setBackground(new Color(255, 255, 255));
		menu1.setBounds(66, 199, 142, 113);
		contentPane.add(menu1);
		menu1.setLayout(null);

		JLabel menuicon = new JLabel("New label");
		menuicon.setBounds(28, 11, 80, 70);
		menuicon.setIcon(new ImageIcon(icon1));
		menu1.add(menuicon);

		JLabel lblNewLabel_1 = new JLabel("Add Record");
		lblNewLabel_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(28, 88, 80, 14);
		menu1.add(lblNewLabel_1);

		menu2 = new JPanel();
		menu2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setbcolor(menu2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setcolor(menu2);
			}
		});
		menu2.setBackground(Color.WHITE);
		menu2.setBounds(343, 199, 142, 113);
		contentPane.add(menu2);
		menu2.setLayout(null);

		JLabel menuicon2 = new JLabel("");
		menuicon2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewRecord viewrecord= new ViewRecord();
				viewrecord.setVisible(true);
				dispose();
			}
		});
		menuicon2.setBounds(27, 11, 90, 65);
		menuicon2.setIcon(new ImageIcon(icon2));
		menu2.add(menuicon2);

		JLabel lblNewLabel_1_1 = new JLabel("View Record");
		lblNewLabel_1_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(37, 88, 90, 14);
		menu2.add(lblNewLabel_1_1);

		menu3 = new JPanel();
		menu3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AllNotes notes= new AllNotes();
				notes.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setbcolor(menu3);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setcolor(menu3);
			}
		});
		menu3.setBackground(Color.WHITE);
		menu3.setBounds(625, 199, 142, 113);
		contentPane.add(menu3);
		menu3.setLayout(null);

		JLabel menuicon3 = new JLabel("New label");
		menuicon3.setIcon(new ImageIcon(icon3));
		menuicon3.setBounds(21, 11, 98, 75);
		menu3.add(menuicon3);

		JLabel lblNewLabel_1_1_1 = new JLabel("Notes");
		lblNewLabel_1_1_1.setForeground(new Color(0, 51, 153));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(52, 88, 90, 14);
		menu3.add(lblNewLabel_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240,240, 240));
		panel_1.setBounds(226, 359, 55, 38);
		contentPane.add(panel_1);
	}

	public void setcolor(JPanel j1) {

		j1.setBackground(new Color(255,255,255));

	}

	public void setbcolor(JPanel j2) {
		j2.setBackground(new Color(205,255,255));
	}
}
