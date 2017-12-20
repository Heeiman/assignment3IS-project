package is3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;

public class App {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_11;

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
		
		JLabel lblKund = new JLabel("Kund");
		lblKund.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKund.setBounds(74, 11, 88, 29);
		frame.getContentPane().add(lblKund);
		
		JLabel lblProdukt = new JLabel("Produkt");
		lblProdukt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProdukt.setBounds(74, 207, 97, 14);
		frame.getContentPane().add(lblProdukt);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrder.setBounds(312, 18, 46, 14);
		frame.getContentPane().add(lblOrder);
		
		JLabel lblOrderrad = new JLabel("Orderrad");
		lblOrderrad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrderrad.setBounds(509, 14, 79, 14);
		frame.getContentPane().add(lblOrderrad);
		
		JLabel lblExemplar = new JLabel("Exemplar");
		lblExemplar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExemplar.setBounds(290, 207, 79, 14);
		frame.getContentPane().add(lblExemplar);
		
		JLabel lblTotalbelopp = new JLabel("Totalbelopp f\u00F6r samtliga produkter:");
		lblTotalbelopp.setBounds(530, 234, 205, 14);
		frame.getContentPane().add(lblTotalbelopp);
		
		JLabel lblKundnummer = new JLabel("Kundnummer:");
		lblKundnummer.setBounds(10, 42, 79, 14);
		frame.getContentPane().add(lblKundnummer);
		
		JLabel lblNamn = new JLabel("Namn:");
		lblNamn.setBounds(43, 67, 46, 14);
		frame.getContentPane().add(lblNamn);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setBounds(43, 92, 46, 14);
		frame.getContentPane().add(lblAdress);
		
		textField = new JTextField();
		textField.setBounds(99, 39, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 64, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 89, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSkapa = new JButton("Skapa");
		btnSkapa.setBounds(23, 120, 71, 23);
		frame.getContentPane().add(btnSkapa);
		
		JButton btnndra = new JButton("\u00C4ndra");
		btnndra.setBounds(99, 120, 86, 23);
		frame.getContentPane().add(btnndra);
		
		JButton btnHitta = new JButton("Hitta");
		btnHitta.setBounds(23, 154, 71, 23);
		frame.getContentPane().add(btnHitta);
		
		JButton btnTaBort = new JButton("Ta bort");
		btnTaBort.setBounds(99, 154, 86, 23);
		frame.getContentPane().add(btnTaBort);
		
		JLabel lblNamn_1 = new JLabel("Namn:");
		lblNamn_1.setBounds(23, 234, 46, 14);
		frame.getContentPane().add(lblNamn_1);
		
		JLabel lblKategori = new JLabel("Kategori:");
		lblKategori.setBounds(10, 259, 46, 14);
		frame.getContentPane().add(lblKategori);
		
		JLabel lblPris = new JLabel("Pris:");
		lblPris.setBounds(23, 284, 46, 14);
		frame.getContentPane().add(lblPris);
		
		textField_3 = new JTextField();
		textField_3.setBounds(99, 231, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(99, 256, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(99, 281, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton button = new JButton("Skapa");
		button.setBounds(18, 309, 71, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u00C4ndra");
		button_1.setBounds(99, 309, 86, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Hitta");
		button_2.setBounds(18, 336, 71, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Ta bort");
		button_3.setBounds(99, 336, 86, 23);
		frame.getContentPane().add(button_3);
		
		JLabel lblOrderid = new JLabel("OrderID:");
		lblOrderid.setBounds(265, 42, 46, 14);
		frame.getContentPane().add(lblOrderid);
		
		JLabel lblLeveransdatum = new JLabel("Leveransdatum:");
		lblLeveransdatum.setBounds(231, 67, 98, 14);
		frame.getContentPane().add(lblLeveransdatum);
		
		textField_6 = new JTextField();
		textField_6.setBounds(322, 39, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(322, 64, 86, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton button_4 = new JButton("Skapa");
		button_4.setBounds(254, 92, 71, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Ta bort");
		button_5.setBounds(332, 92, 86, 23);
		frame.getContentPane().add(button_5);
		
		JLabel lblNummer = new JLabel("Nummer:");
		lblNummer.setBounds(473, 43, 46, 14);
		frame.getContentPane().add(lblNummer);
		
		JLabel lblAntal = new JLabel("Antal:");
		lblAntal.setBounds(473, 73, 46, 14);
		frame.getContentPane().add(lblAntal);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(530, 40, 86, 20);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(530, 70, 86, 20);
		frame.getContentPane().add(textField_9);
		
		JButton button_6 = new JButton("Skapa");
		button_6.setBounds(462, 92, 71, 23);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("Ta bort");
		button_7.setBounds(540, 90, 86, 23);
		frame.getContentPane().add(button_7);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(322, 232, 86, 20);
		frame.getContentPane().add(textField_11);
		
		JLabel lblSerienummer = new JLabel("Serienummer:");
		lblSerienummer.setBounds(247, 234, 98, 14);
		frame.getContentPane().add(lblSerienummer);
		
		JButton button_8 = new JButton("Skapa");
		button_8.setBounds(254, 260, 71, 23);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("Ta bort");
		button_9.setBounds(332, 260, 86, 23);
		frame.getContentPane().add(button_9);
	}
}
