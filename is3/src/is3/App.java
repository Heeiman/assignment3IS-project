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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
	private JLabel lblResponse;
	private JLabel lblKundnummer;
	private JLabel lblNamn;
	private JLabel lblAdress;
	private JButton btnSkapakund;
	private JButton btnndra;
	private JButton btnHittakund;
	private JButton btnTaBortkund;
	private JLabel lblNamn_1;
	private JLabel lblKategori;
	private JLabel lblPris;
	private JButton btnSkapaProdukt;
	private JButton btnndraProdukt;
	private JButton button_2;
	private JButton btnTaBortProdukt;
	private JLabel lblOrderid;
	private JLabel lblLeveransdatum;
	private JButton btnSkapaOrderTill;
	private JButton button_tabortorder;
	private JLabel lblNummer;
	private JLabel lblAntal;
	private JButton button_6;
	private JButton btnSkapaOrderrad;
	private JButton button_7;
	private JLabel lblSerienummer;
	private JButton button_8;
	private JButton button_9;

	private Controller controller;
	private CustomerRegister customerReg;
	private ProductRegister productReg;
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
		customerReg = new CustomerRegister();
		productReg = new ProductRegister();
		controller = new Controller(customerReg, frame);

		
		frame = new JFrame();
		frame.setBounds(100, 100, 787, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(495, 154, 260, 102);
		frame.getContentPane().add(textPane);
		textPane.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblResponse = new JLabel("Response:");
		lblResponse.setBounds(495, 129, 205, 14);
		frame.getContentPane().add(lblResponse);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 44, 453, 334);
		frame.getContentPane().add(tabbedPane);
		

		button_6 = new JButton("Skapa");
		
		JPanel panel = new JPanel();		
		tabbedPane.addTab("Kund och order", null, panel, null);
		panel.setLayout(null);
		
		lblKund = new JLabel("Kund");
		lblKund.setBounds(77, 5, 88, 29);
		panel.add(lblKund);
		lblKund.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblKundnummer = new JLabel("Kundnummer:");
		lblKundnummer.setBounds(10, 38, 98, 14);
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
		
		btnSkapakund = new JButton("Skapa kund");
		btnSkapakund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textCnumber.getText();
				String cName = textCname.getText();
				String cAdress = textCadress.getText();
				controller.addCustomer(cNumber, cName, cAdress);
				textPane.setText(cNumber + " " + cName + " " + cAdress);
			}
		});
		btnSkapakund.setBounds(22, 115, 120, 23);
		panel.add(btnSkapakund);
		
		btnHittakund = new JButton("Hitta kund");
		btnHittakund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textCnumber.getText();
				Customer tmpCustomer = controller.findCustomer(cNumber);
				String info = tmpCustomer.getcNumber() + " " + tmpCustomer.getName() + " " + tmpCustomer.getcAdress();
				if (tmpCustomer != null) {
					textPane.setText(info);
			}
			}	
		});
		btnHittakund.setBounds(22, 149, 120, 23);
		panel.add(btnHittakund);
		
		btnTaBortkund = new JButton("Ta bort kund");
		btnTaBortkund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textCnumber.getText();
				controller.removeCustomer(cNumber);				
			}
		});
		btnTaBortkund.setBounds(22, 183, 120, 23);
		panel.add(btnTaBortkund);
		
		btnndra = new JButton("\u00C4ndra");
		btnndra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textCnumber.getText();
				String cName = textCname.getText();
				String cAdress = textCadress.getText();
				customerReg.changeCustomer(cNumber, cName, cAdress);
			}
		});
		btnndra.setBounds(22, 215, 120, 23);
		panel.add(btnndra);
		
		lblOrder = new JLabel("Order");
		lblOrder.setBounds(326, 11, 35, 17);
		panel.add(lblOrder);
		lblOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblOrderid = new JLabel("OrderID:");
		lblOrderid.setBounds(239, 38, 81, 14);
		panel.add(lblOrderid);
		
		textOrderId = new JTextField();
		textOrderId.setBounds(352, 35, 86, 20);
		panel.add(textOrderId);
		textOrderId.setColumns(10);
		
		textdelDate = new JTextField();
		textdelDate.setBounds(352, 59, 86, 20);
		panel.add(textdelDate);
		textdelDate.setColumns(10);
		
		lblLeveransdatum = new JLabel("Leveransdatum:");
		lblLeveransdatum.setBounds(239, 65, 122, 14);
		panel.add(lblLeveransdatum);
		
		btnSkapaOrderTill = new JButton("Skapa order");
		btnSkapaOrderTill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textCnumber.getText();
				String orderId = textOrderId.getText();
				String delDate = textdelDate.getText();
				Customer customer = controller.findCustomer(cNumber);
				String info = cNumber + " " + orderId + " " + delDate;
				if (customer != null) {
				textPane.setText(info);	
				controller.addCustomerOrder(orderId, delDate, cNumber);
				lblResponse.setText("Order Skapad.");
				}
			}
		});
		btnSkapaOrderTill.setBounds(228, 94, 114, 23);
		panel.add(btnSkapaOrderTill);
		
		button_tabortorder = new JButton("Ta bort");
		button_tabortorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String orderId = textOrderId.getText();
				String cNumber = textCnumber.getText();
				controller.removeOrder(orderId, cNumber);

			}
		});
		button_tabortorder.setBounds(352, 94, 86, 23);
		panel.add(button_tabortorder);
		
		lblNummer = new JLabel("Nummer:");
		lblNummer.setBounds(239, 180, 199, 14);
		panel.add(lblNummer);
		
		textField_8 = new JTextField();
		textField_8.setBounds(352, 177, 86, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		lblAntal = new JLabel("Antal:");
		lblAntal.setBounds(239, 211, 199, 14);
		panel.add(lblAntal);
		
		textField_9 = new JTextField();
		textField_9.setBounds(352, 208, 86, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		

		btnSkapaOrderrad = new JButton("Skapa orderrad");
		
		btnSkapaOrderrad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String number = textField_8.getText();
						String amount = textField_9.getText();
						String orderId = textOrderId.getText();
						String cNumber = textCnumber.getText();
						controller.addOrderRow(number, amount, orderId, cNumber);
						textPane.setText("Orderrad skapad.");
						textField_8.setText(" ");
						textField_9.setText(" ");
						textOrderId.setText(" ");
						textCnumber.setText(null);
						
			}
				});
		
		btnSkapaOrderrad.setBounds(209, 240, 133, 23);
		panel.add(btnSkapaOrderrad);
		
		button_7 = new JButton("Ta bort");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField_8.getText();
				String orderId = textOrderId.getText();
				String cNumber = textCnumber.getText();
				controller.removeOrderRow(cNumber, orderId, number);
			}
		});
		button_7.setBounds(352, 240, 86, 23);
		panel.add(button_7);
		
		lblOrderrad = new JLabel("Orderrad");
		lblOrderrad.setBounds(314, 149, 124, 17);
		panel.add(lblOrderrad);
		lblOrderrad.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Produkt och exemplar", null, panel_1, null);
		panel_1.setLayout(null);

		lblExemplar = new JLabel("Exemplar");
		lblExemplar.setBounds(315, 11, 79, 14);
		panel_1.add(lblExemplar);
		lblExemplar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_11 = new JTextField();
		textField_11.setBounds(352, 36, 86, 20);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		lblSerienummer = new JLabel("Serienummer:");
		lblSerienummer.setBounds(242, 39, 98, 14);
		panel_1.add(lblSerienummer);
		
		button_9 = new JButton("Ta bort");
		button_9.setBounds(352, 67, 86, 23);
		panel_1.add(button_9);
		
		button_8 = new JButton("Skapa exemplar");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_8.setBounds(207, 67, 133, 23);
		panel_1.add(button_8);
		
		lblProdukt = new JLabel("Produkt");
		lblProdukt.setBounds(74, 11, 97, 14);
		panel_1.add(lblProdukt);
		lblProdukt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblNamn_1 = new JLabel("Namn:");
		lblNamn_1.setBounds(10, 38, 79, 14);
		panel_1.add(lblNamn_1);
		
		textPname = new JTextField();
		textPname.setBounds(99, 35, 86, 20);
		panel_1.add(textPname);
		textPname.setColumns(10);
		
		lblKategori = new JLabel("Kategori:");
		lblKategori.setBounds(10, 63, 79, 14);
		panel_1.add(lblKategori);
		
		textPcategory = new JTextField();
		textPcategory.setBounds(99, 60, 86, 20);
		panel_1.add(textPcategory);
		textPcategory.setColumns(10);
		
		lblPris = new JLabel("Pris:");
		lblPris.setBounds(10, 88, 79, 14);
		panel_1.add(lblPris);
		
		textPprice = new JTextField();
		textPprice.setBounds(99, 85, 86, 20);
		panel_1.add(textPprice);
		textPprice.setColumns(10);
		
		btnSkapaProdukt = new JButton("Skapa produkt");
		btnSkapaProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textPname.getText();
				String category = textPcategory.getText();
				String price = textPprice.getText();
				String number = textField_8.getText();
				String amount = textField_9.getText();
				controller.addProduct(name, price, category, number, amount);
				textPane.setText("Produkt skapad.");
			}
		});
		btnSkapaProdukt.setBounds(18, 113, 122, 23);
		panel_1.add(btnSkapaProdukt);
		
		btnndraProdukt = new JButton("\u00C4ndra produkt");
		btnndraProdukt.setBounds(18, 214, 122, 23);
		panel_1.add(btnndraProdukt);
		
		button_2 = new JButton("Hitta produkt");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(18, 147, 122, 23);
		panel_1.add(button_2);
		
		btnTaBortProdukt = new JButton("Ta bort produkt");
		btnTaBortProdukt.setBounds(18, 181, 122, 23);
		panel_1.add(btnTaBortProdukt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 154, 260, 102);
		frame.getContentPane().add(scrollPane);
		
	
	}
}
