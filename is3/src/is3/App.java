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
	private JTextField textField_Cnumber;
	private JTextField textField_Cname;
	private JTextField textField_Cadress;
	private JTextField textField_Pname;
	private JTextField textField_Pcategory;
	private JTextField textField_Pprice;
	private JTextField textField_orderid;
	private JTextField textField_orderlevdatum;
	private JTextField textField_orderradnummer;
	private JTextField textField_orderradantal;
	private JTextField textField_serienummer;
	private JLabel lblKund;
	private JLabel lblProdukt;
	private JLabel lblOrder;
	private JLabel lblOrderrad;
	private JLabel lblExemplar;
	private JLabel lblResponse;
	private JLabel lbl_kundnummer;
	private JLabel lbl_kundnamn;
	private JLabel lbl_kundadress;
	private JButton btn_kundskapa;
	private JButton btn_kundandra;
	private JButton btn_kundhitta;
	private JButton btn_kundtabort;
	private JLabel lbl_exnamn;
	private JLabel lbl_exkategori;
	private JLabel lbl_expris;
	private JButton btn_prodskapa;
	private JButton btn_prodandra;
	private JButton btn_prodhitta;
	private JButton btn_prodtabort;
	private JLabel lbl_orderId;
	private JLabel lbl_levdatum;
	private JButton btn_orderskapa;
	private JButton btn_ordertabort;
	private JLabel lbl_orderradnummer;
	private JLabel lbl_orderradantal;
	private JButton button_6;
	private JButton btn_orderradskapa;
	private JButton btn_orderradtabort;
	private JLabel lblSerienummer;
	private JButton button_exskapa;
	private JButton button_extabort;

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
		controller = new Controller(customerReg, productReg, frame);

		
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
		
		lbl_kundnummer = new JLabel("Kundnummer:");
		lbl_kundnummer.setBounds(10, 38, 98, 14);
		panel.add(lbl_kundnummer);
		
		textField_Cnumber = new JTextField();
		textField_Cnumber.setBounds(99, 35, 86, 20);
		panel.add(textField_Cnumber);
		textField_Cnumber.setColumns(10);
		
		lbl_kundnamn = new JLabel("Namn:");
		lbl_kundnamn.setBounds(10, 62, 46, 14);
		panel.add(lbl_kundnamn);
		
		textField_Cname = new JTextField();
		textField_Cname.setBounds(99, 59, 86, 20);
		panel.add(textField_Cname);
		textField_Cname.setColumns(10);
		
		textField_Cadress = new JTextField();
		textField_Cadress.setBounds(99, 84, 86, 20);
		panel.add(textField_Cadress);
		textField_Cadress.setColumns(10);
		
		lbl_kundadress = new JLabel("Adress:");
		lbl_kundadress.setBounds(10, 87, 46, 14);
		panel.add(lbl_kundadress);
		
		btn_kundskapa = new JButton("Skapa kund");
		btn_kundskapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_Cnumber.getText();
				String cName = textField_Cname.getText();
				String cAdress = textField_Cadress.getText();
				Customer tmpCustomer = controller.findCustomer(cNumber);
				if (tmpCustomer == null) {
				if (textField_Cnumber.getText().length() == 4) {	
				try {	
				cName = cName.substring(0,1).toUpperCase() + cName.substring(1).toLowerCase();
				cAdress = cAdress.substring(0,1).toUpperCase() + cAdress.substring(1).toLowerCase(); //BLA
				controller.addCustomer(cNumber, cName, cAdress);
				textPane.setText(cNumber + " " + cName + " " + cAdress);
				textField_Cnumber.setText("");
				textField_Cname.setText("");
				textField_Cadress.setText("");
				
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in kundnummer, namn och adress.");
				}
				} else {
					textPane.setText("Ett kundnummer måste vara 4 siffror långt");
					textField_Cnumber.setText("");
					textField_Cname.setText("");
					textField_Cadress.setText("");
				}
				} else {
					textPane.setText("Fel: Kund existerar redan.");
					textField_Cnumber.setText("");
					textField_Cname.setText("");
					textField_Cadress.setText("");
				}
			}
		});
		btn_kundskapa.setBounds(22, 115, 120, 23);
		panel.add(btn_kundskapa);
		
		btn_kundhitta = new JButton("Hitta kund");
		btn_kundhitta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_Cnumber.getText();
				try {
				Customer tmpCustomer = controller.findCustomer(cNumber);
				String info = tmpCustomer.getcNumber() + " " + tmpCustomer.getName() + " " + tmpCustomer.getcAdress();
				if (tmpCustomer != null) {
					textPane.setText(info);
					textField_Cnumber.setText("");
			}
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in kundnummer.");
			}
			}
		});
		btn_kundhitta.setBounds(22, 149, 120, 23);
		panel.add(btn_kundhitta);
		
		btn_kundtabort = new JButton("Ta bort kund");
		btn_kundtabort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_Cnumber.getText();
				try {
				controller.removeCustomer(cNumber);	
				textPane.setText("Kund borttagen");
				textField_Cnumber.setText("");
			} catch (Exception e1) {
				textPane.setText("Fel: Skriv in kundnummer.");
			}
			}
		});
		btn_kundtabort.setBounds(22, 183, 120, 23);
		panel.add(btn_kundtabort);
		
		btn_kundandra = new JButton("\u00C4ndra");
		btn_kundandra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_Cnumber.getText();
				String cName = textField_Cname.getText();
				String cAdress = textField_Cadress.getText();
				try {
				customerReg.changeCustomer(cNumber, cName, cAdress);
				textPane.setText("Kund ändrad");
				textField_Cnumber.setText("");
				textField_Cname.setText("");
				textField_Cadress.setText("");
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in kundnummer för att ändra namn och adress.");
				}
			}
		});
		btn_kundandra.setBounds(22, 215, 120, 23);
		panel.add(btn_kundandra);
		
		lblOrder = new JLabel("Order");
		lblOrder.setBounds(326, 11, 35, 17);
		panel.add(lblOrder);
		lblOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lbl_orderId = new JLabel("OrderID:");
		lbl_orderId.setBounds(239, 38, 81, 14);
		panel.add(lbl_orderId);
		
		textField_orderid = new JTextField();
		textField_orderid.setBounds(352, 35, 86, 20);
		panel.add(textField_orderid);
		textField_orderid.setColumns(10);
		
		textField_orderlevdatum = new JTextField();
		textField_orderlevdatum.setBounds(352, 59, 86, 20);
		panel.add(textField_orderlevdatum);
		textField_orderlevdatum.setColumns(10);
		
		lbl_levdatum = new JLabel("Leveransdatum:");
		lbl_levdatum.setBounds(239, 65, 122, 14);
		panel.add(lbl_levdatum);
		
		btn_orderskapa = new JButton("Skapa order");
		btn_orderskapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_Cnumber.getText();
				String orderId = textField_orderid.getText();
				String delDate = textField_orderlevdatum.getText();
				try {
				Customer customer = controller.findCustomer(cNumber);
				String info = cNumber + " " + orderId + " " + delDate;
				if (customer != null) {
				textPane.setText(info);	
				controller.addCustomerOrder(orderId, delDate, cNumber);
				lblResponse.setText("Order Skapad.");
				textField_Cnumber.setText("");
				textField_orderid.setText("");
				textField_orderlevdatum.setText("");
				}
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in kundnummer, orderID och leveransdatum.");
				}
			}
		});
		btn_orderskapa.setBounds(228, 94, 114, 23);
		panel.add(btn_orderskapa);
		
		btn_ordertabort = new JButton("Ta bort");
		btn_ordertabort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String orderId = textField_orderid.getText();
				String cNumber = textField_Cnumber.getText();
				try {
				controller.removeOrder(orderId, cNumber);
				lblResponse.setText("Order borttagen");
				textField_orderid.setText("");
				textField_Cnumber.setText("");
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in orderid och kundnummer.");
				}
			}
		});
		btn_ordertabort.setBounds(352, 94, 86, 23);
		panel.add(btn_ordertabort);
		
		lbl_orderradnummer = new JLabel("Nummer:");
		lbl_orderradnummer.setBounds(239, 180, 140, 14);
		panel.add(lbl_orderradnummer);
		
		textField_orderradnummer = new JTextField();
		textField_orderradnummer.setBounds(352, 177, 86, 20);
		panel.add(textField_orderradnummer);
		textField_orderradnummer.setColumns(10);
		
		lbl_orderradantal = new JLabel("Antal:");
		lbl_orderradantal.setBounds(239, 211, 140, 14);
		panel.add(lbl_orderradantal);
		
		textField_orderradantal = new JTextField();
		textField_orderradantal.setBounds(352, 208, 86, 20);
		panel.add(textField_orderradantal);
		textField_orderradantal.setColumns(10);
		

		btn_orderradskapa = new JButton("Skapa orderrad");
		
		btn_orderradskapa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String number = textField_orderradnummer.getText();
						String amount = textField_orderradantal.getText();
						String orderId = textField_orderid.getText();
						String cNumber = textField_Cnumber.getText();
						try {
						controller.addOrderRow(number, amount, orderId, cNumber);
						textPane.setText("Orderrad skapad.");
						textField_orderradnummer.setText("");
						textField_orderradantal.setText("");
						textField_orderid.setText("");
						textField_Cnumber.setText("");
						} catch (Exception e1) {
							textPane.setText("Fel: Skriv in nummer, antal, orderid och kundnummer.");
						}
					}
				});
		
		btn_orderradskapa.setBounds(209, 240, 133, 23);
		panel.add(btn_orderradskapa);
		
		btn_orderradtabort = new JButton("Ta bort");
		btn_orderradtabort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField_orderradnummer.getText();
				String orderId = textField_orderid.getText();
				String cNumber = textField_Cnumber.getText();
				try {
				controller.removeOrderRow(cNumber, orderId, number);
				textPane.setText("Orderrad borttagen");
				textField_orderradnummer.setText("");
				textField_orderid.setText("");
				textField_Cnumber.setText("");
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in nummer, orderid och kundnummer.");
				}
			}
		});
		btn_orderradtabort.setBounds(352, 240, 86, 23);
		panel.add(btn_orderradtabort);
		
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
		
		textField_serienummer = new JTextField();
		textField_serienummer.setBounds(352, 36, 86, 20);
		panel_1.add(textField_serienummer);
		textField_serienummer.setColumns(10);
		
		lblSerienummer = new JLabel("Serienummer:");
		lblSerienummer.setBounds(242, 39, 98, 14);
		panel_1.add(lblSerienummer);
		
		
		button_extabort = new JButton("Ta bort");
		button_extabort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serNumber = textField_serienummer.getText();
				String name = textField_Pname.getText();
				try {
				controller.removeItem(serNumber, name);
				textField_serienummer.setText(" ");
				lblResponse.setText("Exemplar borttaget");
				} catch (Exception e1) {
					lblResponse.setText("Fel: Skriv in serienummer/ skriv in namn på produkt");
				}
			} 
		});
		button_extabort.setBounds(352, 67, 86, 23);
		panel_1.add(button_extabort);
		
		button_exskapa = new JButton("Skapa exemplar");
		button_exskapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_Pname.getText();
				String serNumber = textField_serienummer.getText();
				try {
				controller.addItemProduct(serNumber, name);
				textPane.setText(name + serNumber);
				textField_Pname.setText("");
				textField_serienummer.setText("");
				lblResponse.setText("Exemplar skapat.");
				} catch (Exception e1) {
					textPane.setText(" ");
					lblResponse.setText("Fel: Skriv in produktens namn/skapa produkten");
			}
			}
		});
		button_exskapa.setBounds(207, 67, 133, 23);
		panel_1.add(button_exskapa);
		
		lblProdukt = new JLabel("Produkt");
		lblProdukt.setBounds(74, 11, 97, 14);
		panel_1.add(lblProdukt);
		lblProdukt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lbl_exnamn = new JLabel("Namn:");
		lbl_exnamn.setBounds(10, 38, 79, 14);
		panel_1.add(lbl_exnamn);
		
		textField_Pname = new JTextField();
		textField_Pname.setBounds(99, 35, 86, 20);
		panel_1.add(textField_Pname);
		textField_Pname.setColumns(10);
		
		lbl_exkategori = new JLabel("Kategori:");
		lbl_exkategori.setBounds(10, 63, 79, 14);
		panel_1.add(lbl_exkategori);
		
		textField_Pcategory = new JTextField();
		textField_Pcategory.setBounds(99, 60, 86, 20);
		panel_1.add(textField_Pcategory);
		textField_Pcategory.setColumns(10);
		
		lbl_expris = new JLabel("Pris:");
		lbl_expris.setBounds(10, 88, 79, 14);
		panel_1.add(lbl_expris);
		
		textField_Pprice = new JTextField();
		textField_Pprice.setBounds(99, 85, 86, 20);
		panel_1.add(textField_Pprice);
		textField_Pprice.setColumns(10);
		
		btn_prodskapa = new JButton("Skapa produkt");
		btn_prodskapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = textField_Pname.getText();
				String category = textField_Pcategory.getText();
				String price = textField_Pprice.getText();
				try {

				controller.addProduct(name, price, category);
				textPane.setText("Produkt skapad.");
				textField_Pname.setText("");
				textField_Pcategory.setText("");
				textField_Pprice.setText("");

				controller.addProduct(name, category, price);
				textPane.setText(name + " " + category + " " + price);
				textField_Pname.setText("");
				textField_Pcategory.setText("");
				textField_Pprice.setText("");

				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in namn, kategori och pris.");
				}

			}
		});

		btn_prodskapa.setBounds(18, 113, 122, 23);
		panel_1.add(btn_prodskapa);

//		
//		btnSkapaProdukt = new JButton("Skapa produkt");
//		btnSkapaProdukt.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				String name = textPname.getText();
//				String category = textPcategory.getText();
//				String price = textPprice.getText();
//				try {
//				controller.addProduct(name, price, category);
//				textPane.setText("Produkt skapad.");
//				textPname.setText("");
//				textPcategory.setText("");
//				textPprice.setText("");
//				} catch (Exception e1) {
//					textPane.setText("Fel: Skriv in namn, kategori, nummer och antal");
//				}
//			}
//		});
		
		btn_prodandra = new JButton("\u00C4ndra produkt");
		btn_prodandra.setBounds(18, 214, 122, 23);
		panel_1.add(btn_prodandra);
		
		btn_prodhitta = new JButton("Hitta produkt");
		btn_prodhitta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_Pname.getText();
				try {
				Product newProduct = productReg.findProduct(name);
				String info = newProduct.getName() + " " + newProduct.getCategory() + " " + newProduct.getPrice();
				if (newProduct != null) {
					textPane.setText(info);
					textField_Pname.setText("");
				}	
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in namn");
				}
				}              
			});
		btn_prodhitta.setBounds(18, 147, 122, 23);
		panel_1.add(btn_prodhitta);
		
		btn_prodtabort = new JButton("Ta bort produkt");
		btn_prodtabort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_Pname.getText();
				try {
					controller.removeProduct(name);
					textField_Pname.setText("");
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in produktens namn.");
				}
			}
		});
		btn_prodtabort.setBounds(18, 181, 122, 23);
		panel_1.add(btn_prodtabort);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 154, 260, 102);
		frame.getContentPane().add(scrollPane);
		
	
	}
}
