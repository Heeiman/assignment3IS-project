package is3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class App {

	private JFrame frame;
	private JTextField textCnumber;
	private JTextField textCname;
	private JTextField textCadress;
	private JTextField textPname;
	private JTextField textPcategory;
	private JTextField textPprice;
	private JTextField textOrderId;
	private JTextField textdelDate;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;
	private JLabel lblKund;
	private JLabel lblProdukt;
	private JLabel lblOrder;
	private JLabel lblOrderrad;
	private JLabel lblExemplar;
	private JLabel lblTotalbelopp;
	private JLabel lblKundnummer;
	private JLabel lblNamn;
	private JLabel lblAdress;
	private JButton btnSkapa;
	private JButton btnndra;
	private JButton btnHitta;
	private JButton btnTaBort;
	private JLabel lblNamn_1;
	private JLabel lblKategori;
	private JLabel lblPris;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JLabel lblOrderid;
	private JLabel lblLeveransdatum;
	private JButton button_4;
	private JButton button_5;
	private JLabel lblNummer;
	private JLabel lblAntal;
	private JButton button_6;
	private JButton button_7;
	private JLabel lblSerienummer;
	private JButton button_8;
	private JButton button_9;

	private Controller controller;
	private CustomerRegister customerReg;
	private JTabbedPane tabbedPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		
		frame = new JFrame();
		frame.setBounds(100, 100, 809, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTotalbelopp = new JLabel("Totalbelopp f\u00F6r samtliga produkter:");
		lblTotalbelopp.setBounds(588, 16, 205, 14);
		frame.getContentPane().add(lblTotalbelopp);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 44, 396, 287);
		frame.getContentPane().add(tabbedPane);
				JPanel panel = new JPanel();
		tabbedPane.addTab("Kund och order", null, panel, null);
		panel.setLayout(null);
		
		lblKund = new JLabel("Kund");
		lblKund.setBounds(54, 11, 88, 29);
		panel.add(lblKund);
		lblKund.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblKundnummer = new JLabel("Kundnummer:");
		lblKundnummer.setBounds(10, 38, 79, 14);
		panel.add(lblKundnummer);
		
		textCnumber = new JTextField();
		textCnumber.setBounds(99, 35, 86, 20);
		panel.add(textCnumber);
		textCnumber.setColumns(10);
		
		lblNamn = new JLabel("Namn:");
		lblNamn.setBounds(10, 62, 46, 14);
		panel.add(lblNamn);
		
		textCname = new JTextField();
		textCname.setBounds(99, 59, 86, 20);
		panel.add(textCname);
		textCname.setColumns(10);
		
		textCadress = new JTextField();
		textCadress.setBounds(99, 84, 86, 20);
		panel.add(textCadress);
		textCadress.setColumns(10);
		
		lblAdress = new JLabel("Adress:");
		lblAdress.setBounds(10, 87, 46, 14);
		panel.add(lblAdress);
		
		btnSkapa = new JButton("Skapa");
		btnSkapa.setBounds(18, 115, 71, 23);
		panel.add(btnSkapa);
		
		btnHitta = new JButton("Hitta");
		btnHitta.setBounds(18, 149, 71, 23);
		panel.add(btnHitta);
		
		btnTaBort = new JButton("Ta bort");
		btnTaBort.setBounds(99, 149, 86, 23);
		panel.add(btnTaBort);
		
		btnndra = new JButton("\u00C4ndra");
		btnndra.setBounds(99, 115, 86, 23);
		panel.add(btnndra);
		
		lblOrder = new JLabel("Order");
		lblOrder.setBounds(276, 11, 46, 14);
		panel.add(lblOrder);
		lblOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblOrderid = new JLabel("OrderID:");
		lblOrderid.setBounds(195, 35, 46, 14);
		panel.add(lblOrderid);
		
		textOrderId = new JTextField();
		textOrderId.setBounds(286, 32, 86, 20);
		panel.add(textOrderId);
		textOrderId.setColumns(10);
		
		textdelDate = new JTextField();
		textdelDate.setBounds(286, 57, 86, 20);
		panel.add(textdelDate);
		textdelDate.setColumns(10);
		
		lblLeveransdatum = new JLabel("Leveransdatum:");
		lblLeveransdatum.setBounds(195, 60, 98, 14);
		panel.add(lblLeveransdatum);
		
		button_4 = new JButton("Skapa");
		button_4.setBounds(218, 85, 71, 23);
		panel.add(button_4);
		
		button_5 = new JButton("Ta bort");
		button_5.setBounds(296, 85, 86, 23);
		panel.add(button_5);
		
		lblNummer = new JLabel("Nummer:");
		lblNummer.setBounds(228, 145, 46, 14);
		panel.add(lblNummer);
		
		textField_8 = new JTextField();
		textField_8.setBounds(296, 143, 86, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		lblAntal = new JLabel("Antal:");
		lblAntal.setBounds(228, 170, 46, 14);
		panel.add(lblAntal);
		
		textField_9 = new JTextField();
		textField_9.setBounds(296, 167, 86, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		button_6 = new JButton("Skapa");
		button_6.setBounds(228, 195, 71, 23);
		panel.add(button_6);
		
		button_7 = new JButton("Ta bort");
		button_7.setBounds(306, 195, 86, 23);
		panel.add(button_7);
		
		lblOrderrad = new JLabel("Orderrad");
		lblOrderrad.setBounds(262, 123, 79, 14);
		panel.add(lblOrderrad);
		lblOrderrad.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Produkt och exemplar", null, panel_1, null);
		panel_1.setLayout(null);

		lblExemplar = new JLabel("Exemplar");
		lblExemplar.setBounds(243, 36, 79, 14);
		panel_1.add(lblExemplar);
		lblExemplar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_11 = new JTextField();
		textField_11.setBounds(284, 61, 86, 20);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		lblSerienummer = new JLabel("Serienummer:");
		lblSerienummer.setBounds(206, 64, 98, 14);
		panel_1.add(lblSerienummer);
		
		button_9 = new JButton("Ta bort");
		button_9.setBounds(294, 89, 86, 23);
		panel_1.add(button_9);
		
		button_8 = new JButton("Skapa");
		button_8.setBounds(216, 89, 71, 23);
		panel_1.add(button_8);
		
		lblProdukt = new JLabel("Produkt");
		lblProdukt.setBounds(74, 11, 97, 14);
		panel_1.add(lblProdukt);
		lblProdukt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNamn_1 = new JLabel("Namn:");
		lblNamn_1.setBounds(10, 38, 46, 14);
		panel_1.add(lblNamn_1);
		
		textPname = new JTextField();
		textPname.setBounds(99, 35, 86, 20);
		panel_1.add(textPname);
		textPname.setColumns(10);
		
		lblKategori = new JLabel("Kategori:");
		lblKategori.setBounds(10, 63, 46, 14);
		panel_1.add(lblKategori);
		
		textPcategory = new JTextField();
		textPcategory.setBounds(99, 60, 86, 20);
		panel_1.add(textPcategory);
		textPcategory.setColumns(10);
		
		lblPris = new JLabel("Pris:");
		lblPris.setBounds(10, 88, 46, 14);
		panel_1.add(lblPris);
		
		textPprice = new JTextField();
		textPprice.setBounds(99, 85, 86, 20);
		panel_1.add(textPprice);
		textPprice.setColumns(10);
		
		button = new JButton("Skapa");
		button.setBounds(18, 113, 71, 23);
		panel_1.add(button);
		
		button_1 = new JButton("\u00C4ndra");
		button_1.setBounds(99, 113, 86, 23);
		panel_1.add(button_1);
		
		button_2 = new JButton("Hitta");
		button_2.setBounds(18, 140, 71, 23);
		panel_1.add(button_2);
		
		button_3 = new JButton("Ta bort");
		button_3.setBounds(99, 140, 86, 23);
		panel_1.add(button_3);
				
		JTextPane textPane = new JTextPane();
		textPane.setBounds(475, 136, 260, 102);
		frame.getContentPane().add(textPane);
		textPane.setFont(new Font("Arial", Font.PLAIN, 12));
		textPane.setText("Emma Ordernr.123 Rad 1 Penna Serienr. 123 ");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(475, 134, 263, 104);
		frame.getContentPane().add(scrollPane);
		
	
	}
}
