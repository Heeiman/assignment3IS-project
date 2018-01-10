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
	private JTextField textField_cNumber;
	private JTextField textField_cName;
	private JTextField textField_cAdress;
	private JTextField textField_pName;
	private JTextField textField_pCategory;
	private JTextField textField_pPrice;
	private JTextField textField_orderId;
	private JTextField textField_orderLevDatum;
	private JTextField textField_orderRadNummer;
	private JTextField textField_orderRadAntal;
	private JTextField textField_serialnumber;
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
	private JLabel lbl_orderRadNummer;
	private JLabel lbl_orderRadAntal;
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
		frame.setBounds(100, 100, 914, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(495, 154, 352, 159);
		frame.getContentPane().add(textPane);
		textPane.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblResponse = new JLabel("Response:");
		lblResponse.setBounds(495, 116, 352, 27);
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
		
		textField_cNumber = new JTextField();
		textField_cNumber.setBounds(99, 35, 86, 20);
		panel.add(textField_cNumber);
		textField_cNumber.setColumns(10);
		
		lbl_kundnamn = new JLabel("Namn:");
		lbl_kundnamn.setBounds(10, 62, 46, 14);
		panel.add(lbl_kundnamn);
		
		textField_cName = new JTextField();
		textField_cName.setBounds(99, 59, 86, 20);
		panel.add(textField_cName);
		textField_cName.setColumns(10);
		
		textField_cAdress = new JTextField();
		textField_cAdress.setBounds(99, 84, 86, 20);
		panel.add(textField_cAdress);
		textField_cAdress.setColumns(10);
		
		lbl_kundadress = new JLabel("Adress:");
		lbl_kundadress.setBounds(10, 87, 46, 14);
		panel.add(lbl_kundadress);
		
		btn_kundskapa = new JButton("Skapa kund");
		btn_kundskapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				String cName = textField_cName.getText();
				String cAdress = textField_cAdress.getText();
				Customer tmpCustomer = controller.findCustomer(cNumber);
				if (tmpCustomer == null) {
				if (textField_cNumber.getText().length() == 4) {	
				try {	
				cName = cName.substring(0,1).toUpperCase() + cName.substring(1).toLowerCase();
				cAdress = cAdress.substring(0,1).toUpperCase() + cAdress.substring(1).toLowerCase(); //BLA
				controller.addCustomer(cNumber, cName, cAdress);
				textPane.setText("Kundnummer: " + cNumber + "\nKundnamn: " + cName + "\nAdress: " + cAdress);
				textField_cNumber.setText("");
				textField_cName.setText("");
				textField_cAdress.setText("");
				lblResponse.setText("");			
				} catch (Exception e1) {
					lblResponse.setText("Fel: Skriv in kundnummer, namn eller adress.");
					textPane.setText("");
				}
				} else {
					lblResponse.setText("Ett kundnummer måste vara 4 siffror långt");
					textField_cNumber.setText("");
					textField_cName.setText("");
					textField_cAdress.setText("");
					textPane.setText("");
				}
				} else {
					lblResponse.setText("Fel: Kund existerar redan.");
					textField_cNumber.setText("");
					textField_cName.setText("");
					textField_cAdress.setText("");
					textPane.setText("");
				}
			}
		});
		btn_kundskapa.setBounds(22, 115, 120, 23);
		panel.add(btn_kundskapa);
		
		btn_kundhitta = new JButton("Hitta kund");
		btn_kundhitta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				try {
				Customer tmpCustomer = controller.findCustomer(cNumber);
				String info = tmpCustomer.getcNumber() + " " + tmpCustomer.getName() + " " + tmpCustomer.getcAdress();
				if (tmpCustomer != null) {
					textPane.setText(info);
					textField_cNumber.setText("");
					lblResponse.setText("");
			}
				} catch (Exception e1) {
					lblResponse.setText("Fel: Skriv in kundnummer.");
			}
			}
		});
		btn_kundhitta.setBounds(22, 149, 120, 23);
		panel.add(btn_kundhitta);
		
		btn_kundtabort = new JButton("Ta bort kund");
		btn_kundtabort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				Customer tmpCustomer = controller.findCustomer(cNumber);
				if (tmpCustomer != null) {
				try {
				controller.removeCustomer(cNumber);	
				lblResponse.setText("Kund borttagen");
				textField_cNumber.setText("");
			} catch (Exception e1) {
				lblResponse.setText("Fel: Skriv in kundnummer.");
			}
			} else {
				lblResponse.setText("Den här kunden finns inte.");
			}
			}
		});
		btn_kundtabort.setBounds(22, 183, 120, 23);
		panel.add(btn_kundtabort);
		
		btn_kundandra = new JButton("\u00C4ndra");
		btn_kundandra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				String cName = textField_cName.getText();
				String cAdress = textField_cAdress.getText();
				Customer tmpCustomer = controller.findCustomer(cNumber);
				if (tmpCustomer != null) {
				try {
				customerReg.changeCustomer(cNumber, cName, cAdress);
				textPane.setText("Kund ändrad");
				textField_cNumber.setText("");
				textField_cName.setText("");
				textField_cAdress.setText("");
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in kundnummer för att ändra namn och adress.");
				}	
				} else {
					lblResponse.setText("Den här kunden finns inte.");
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
		
		textField_orderId = new JTextField();
		textField_orderId.setBounds(352, 35, 86, 20);
		panel.add(textField_orderId);
		textField_orderId.setColumns(10);
		
		textField_orderLevDatum = new JTextField();
		textField_orderLevDatum.setBounds(352, 59, 86, 20);
		panel.add(textField_orderLevDatum);
		textField_orderLevDatum.setColumns(10);
		
		lbl_levdatum = new JLabel("Leveransdatum:");
		lbl_levdatum.setBounds(239, 65, 122, 14);
		panel.add(lbl_levdatum);
		
		btn_orderskapa = new JButton("Skapa order");
		btn_orderskapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				String orderId = textField_orderId.getText();
				String delDate = textField_orderLevDatum.getText();
				Customer customer = controller.findCustomer(cNumber);
				String info = cNumber + " " + orderId + " " + delDate;
				if (customer != null) {
				if (textField_orderId.getText().length() == 4 && textField_orderLevDatum.getText().length() == 6) {
				try {
				textPane.setText(info);	
				controller.addCustomerOrder(orderId, delDate, cNumber);
				lblResponse.setText("Order Skapad.");
				textField_cNumber.setText("");
				textField_orderId.setText("");
				textField_orderLevDatum.setText("");
				
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in kundnummer, orderID och leveransdatum.");
				} 
				} else {
					lblResponse.setText("Ett orderid måste vara 4-siffrigt och ett datum skrivs ååmmdd.");
				}
				
					
			} else {
				lblResponse.setText("Vänligen fyll i kundnummer.");
			}
			}
		});
		btn_orderskapa.setBounds(228, 94, 114, 23);
		panel.add(btn_orderskapa);
		
		btn_ordertabort = new JButton("Ta bort");
		btn_ordertabort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String orderId = textField_orderId.getText();
				String cNumber = textField_cNumber.getText();
				try {
				controller.removeOrder(orderId, cNumber);
				lblResponse.setText("Order borttagen");
				textField_orderId.setText("");
				textField_cNumber.setText("");
				} catch (Exception e1) {
					textPane.setText("Fel: Skriv in orderid och kundnummer.");
				}
			}
		});
		btn_ordertabort.setBounds(352, 94, 86, 23);
		panel.add(btn_ordertabort);
		
		lbl_orderRadNummer = new JLabel("Nummer:");
		lbl_orderRadNummer.setBounds(239, 180, 140, 14);
		panel.add(lbl_orderRadNummer);
		
		textField_orderRadNummer = new JTextField();
		textField_orderRadNummer.setBounds(352, 177, 86, 20);
		panel.add(textField_orderRadNummer);
		textField_orderRadNummer.setColumns(10);
		
		lbl_orderRadAntal = new JLabel("Antal:");
		lbl_orderRadAntal.setBounds(239, 211, 140, 14);
		panel.add(lbl_orderRadAntal);
		
		textField_orderRadAntal = new JTextField();
		textField_orderRadAntal.setBounds(352, 208, 86, 20);
		panel.add(textField_orderRadAntal);
		textField_orderRadAntal.setColumns(10);
		

		btn_orderradskapa = new JButton("Skapa orderrad");
		
		btn_orderradskapa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String number = textField_orderRadNummer.getText();
						String amount = textField_orderRadAntal.getText();
						String orderId = textField_orderId.getText();
						String cNumber = textField_cNumber.getText();
						Customer customer = controller.findCustomer(cNumber);
						if (customer != null) {
							if (textField_orderRadNummer.getText().length() == 4) {
						try {
						controller.addOrderRow(number, amount, orderId, cNumber);
						textPane.setText("Orderrad skapad.");
						textField_orderRadNummer.setText("");
						textField_orderRadAntal.setText("");
						textField_orderId.setText("");
						textField_cNumber.setText("");
						} catch (Exception e1) {
							textPane.setText("Fel: Skriv in nummer, antal, orderid och kundnummer.");
						}
							}
							else {
								lblResponse.setText("Ett orderradsnummer måste vara 4-siffrigt.");
							}
						}
						else {
							lblResponse.setText("Den här kunden finns inte.");
						}
					}
				});
		
		btn_orderradskapa.setBounds(209, 240, 133, 23);
		panel.add(btn_orderradskapa);
		
		btn_orderradtabort = new JButton("Ta bort");
		btn_orderradtabort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField_orderRadNummer.getText();
				String orderId = textField_orderId.getText();
				String cNumber = textField_cNumber.getText();
				try {
				controller.removeOrderRow(cNumber, orderId, number);
				textPane.setText("Orderrad borttagen");
				textField_orderRadNummer.setText("");
				textField_orderId.setText("");
				textField_cNumber.setText("");
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
		
		textField_serialnumber = new JTextField();
		textField_serialnumber.setBounds(352, 36, 86, 20);
		panel_1.add(textField_serialnumber);
		textField_serialnumber.setColumns(10);
		
		lblSerienummer = new JLabel("Serienummer:");
		lblSerienummer.setBounds(242, 39, 98, 14);
		panel_1.add(lblSerienummer);
		
		
		button_extabort = new JButton("Ta bort");
		button_extabort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serNumber = textField_serialnumber.getText();
				String name = textField_pName.getText();
				try {
				controller.removeItem(serNumber, name);
				textField_serialnumber.setText(" ");
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
				String name = textField_pName.getText();
				String serNumber = textField_serialnumber.getText();
				try {
				controller.addItemProduct(serNumber, name);
				textPane.setText(name + serNumber);
				textField_pName.setText("");
				textField_serialnumber.setText("");
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
		
		textField_pName = new JTextField();
		textField_pName.setBounds(99, 35, 86, 20);
		panel_1.add(textField_pName);
		textField_pName.setColumns(10);
		
		lbl_exkategori = new JLabel("Kategori:");
		lbl_exkategori.setBounds(10, 63, 79, 14);
		panel_1.add(lbl_exkategori);
		
		textField_pCategory = new JTextField();
		textField_pCategory.setBounds(99, 60, 86, 20);
		panel_1.add(textField_pCategory);
		textField_pCategory.setColumns(10);
		
		lbl_expris = new JLabel("Pris:");
		lbl_expris.setBounds(10, 88, 79, 14);
		panel_1.add(lbl_expris);
		
		textField_pPrice = new JTextField();
		textField_pPrice.setBounds(99, 85, 86, 20);
		panel_1.add(textField_pPrice);
		textField_pPrice.setColumns(10);
		
		btn_prodskapa = new JButton("Skapa produkt");
		btn_prodskapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = textField_pName.getText();
				String category = textField_pCategory.getText();
				String price = textField_pPrice.getText();
				try {

				controller.addProduct(name, price, category);
				textPane.setText("Produkt skapad.");
				textField_pName.setText("");
				textField_pCategory.setText("");
				textField_pPrice.setText("");

				controller.addProduct(name, category, price);
				textPane.setText(name + " " + category + " " + price);
				textField_pName.setText("");
				textField_pCategory.setText("");
				textField_pPrice.setText("");

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
				String name = textField_pName.getText();
				try {
				Product newProduct = productReg.findProduct(name);
				String info = newProduct.getName() + " " + newProduct.getCategory() + " " + newProduct.getPrice();
				if (newProduct != null) {
					textPane.setText(info);
					textField_pName.setText("");
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
				String name = textField_pName.getText();
				try {
					controller.removeProduct(name);
					textField_pName.setText("");
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
