package is3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {

	private JFrame frame;
	private JTextField textField_cNumber;
	private JTextField textField_cName;
	private JTextField textField_cAdress;
	private JTextField textField_pName;
	private JTextField textField_pCategory;
	private JTextField textField_pPrice;
	private JTextField textField_orderId;
	private JTextField textField_delDate;
	private JTextField textField_oRowNr;
	private JTextField textField_oRowAmount;
	private JTextField textField_iSerialNr;
	private JLabel lbl_customer;
	private JLabel lbl_product;
	private JLabel lbl_Order;
	private JLabel lbl_oRow;
	private JLabel lbl_items;
	private JLabel lbl_Response;
	private JLabel lbl_cNumber;
	private JLabel lbl_cName;
	private JLabel lbl_cAdress;
	private JButton btn_cCreate;
	private JButton btn_cChange;
	private JButton btn_cFind;
	private JButton btn_cRemove;
	private JLabel lbl_pName;
	private JLabel lbl_pCategory;
	private JLabel lbl_pPrice;
	private JButton btn_pCreate;
	private JButton btn_pChange;
	private JButton btn_pFind;
	private JButton btn_pRemove;
	private JLabel lbl_orderId;
	private JLabel lbl_delDate;
	private JButton btn_oCreate;
	private JButton btn_oRemove;
	private JLabel lbl_oRowNr;
	private JLabel lbl_oRowAmount;

	private JButton btn_oRowCreate;
	private JButton btn_oRowRemove;
	private JLabel lbl_iSerialNr;
	private JButton bttn_iCreate;
	private JButton bttn_iRemove;

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

		lbl_Response = new JLabel("Response:");
		lbl_Response.setBounds(495, 116, 352, 27);
		frame.getContentPane().add(lbl_Response);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 44, 453, 334);
		frame.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Kund och order", null, panel, null);
		panel.setLayout(null);

		lbl_customer = new JLabel("Kund");
		lbl_customer.setBounds(77, 5, 88, 29);
		panel.add(lbl_customer);
		lbl_customer.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lbl_cNumber = new JLabel("Kundnummer:");
		lbl_cNumber.setBounds(10, 38, 98, 14);
		panel.add(lbl_cNumber);

		textField_cNumber = new JTextField();
		textField_cNumber.setBounds(99, 35, 86, 20);
		panel.add(textField_cNumber);
		textField_cNumber.setColumns(10);

		lbl_cName = new JLabel("Namn:");
		lbl_cName.setBounds(10, 62, 46, 14);
		panel.add(lbl_cName);

		textField_cName = new JTextField();
		textField_cName.setBounds(99, 59, 86, 20);
		panel.add(textField_cName);
		textField_cName.setColumns(10);

		textField_cAdress = new JTextField();
		textField_cAdress.setBounds(99, 84, 86, 20);
		panel.add(textField_cAdress);
		textField_cAdress.setColumns(10);

		lbl_cAdress = new JLabel("Adress:");
		lbl_cAdress.setBounds(10, 87, 46, 14);
		panel.add(lbl_cAdress);

		btn_cCreate = new JButton("Skapa kund");
		btn_cCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				String cName = textField_cName.getText();
				String cAdress = textField_cAdress.getText();
				Customer tmpCustomer = controller.findCustomer(cNumber);
				if (tmpCustomer == null) {
					if (textField_cNumber.getText().length() == 4) {
						try {
							cName = cName.substring(0, 1).toUpperCase() + cName.substring(1).toLowerCase();
							cAdress = cAdress.substring(0, 1).toUpperCase() + cAdress.substring(1).toLowerCase();
							controller.addCustomer(cNumber, cName, cAdress);
							textPane.setText(
									"Kundnummer: " + cNumber + "\nKundnamn: " + cName + "\nAdress: " + cAdress);
							textField_cName.setText("");
							textField_cAdress.setText("");
							lbl_Response.setText("");
						} catch (Exception e1) {
							lbl_Response.setText("Fel: Skriv in kundnummer, namn eller adress.");
							textPane.setText("");
						}
					} else {
						lbl_Response.setText("Ett kundnummer måste vara 4 siffror långt");
						textField_cNumber.setText("");
						textField_cName.setText("");
						textField_cAdress.setText("");
						textPane.setText("");
					}
				} else {
					lbl_Response.setText("Fel: Kund existerar redan.");
					textField_cName.setText("");
					textField_cAdress.setText("");
					textPane.setText("");
				}
			}
		});
		btn_cCreate.setBounds(22, 115, 120, 23);
		panel.add(btn_cCreate);

		btn_cFind = new JButton("Hitta kund");
		btn_cFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				try {
					Customer tmpCustomer = controller.findCustomer(cNumber);
					String info = ("Kundnummer: " + tmpCustomer.getcNumber() + "\nNamn: " + tmpCustomer.getName()
							+ "\nAddress: " + tmpCustomer.getcAdress());
					if (tmpCustomer != null) {
						textPane.setText(info);
						lbl_Response.setText("");
					}

				} catch (Exception e1) {
					lbl_Response.setText("Fel: Skriv in kundnummer.");
					textPane.setText("");
				}
			}
		});
		btn_cFind.setBounds(22, 149, 120, 23);
		panel.add(btn_cFind);

		btn_cRemove = new JButton("Ta bort kund");
		btn_cRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				Customer tmpCustomer = controller.findCustomer(cNumber);
				if (tmpCustomer != null) {
					try {
						controller.removeCustomer(cNumber);
						lbl_Response.setText("Kund borttagen");
						textField_cNumber.setText("");
						textPane.setText("");
					} catch (Exception e1) {
						lbl_Response.setText("Fel: Skriv in kundnummer.");
						textPane.setText("");
					}
				} else {
					lbl_Response.setText("Den här kunden finns inte.");
					textPane.setText("");
				}
			}
		});
		btn_cRemove.setBounds(22, 183, 120, 23);
		panel.add(btn_cRemove);

		btn_cChange = new JButton("\u00C4ndra kund");
		btn_cChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				String cName = textField_cName.getText();
				String cAdress = textField_cAdress.getText();
				Customer tmpCustomer = controller.findCustomer(cNumber);
				if (tmpCustomer != null) {
					try {
						controller.updateCustomerName(cNumber, cName, cAdress);
						lbl_Response.setText("Kund ändrad");
						textPane.setText("Kundnummer: " + cNumber + "\nKundnamn: " + cName + "\nAdress: " + cAdress);
						textField_cName.setText("");
						textField_cAdress.setText("");
					} catch (Exception e1) {
						lbl_Response.setText("Fel: Skriv in kundnummer för att ändra namn och adress.");
						textPane.setText("");
					}
				} else {
					lbl_Response.setText("Den här kunden finns inte.");
					textPane.setText("");
				}
			}
		});
		btn_cChange.setBounds(22, 215, 120, 23);
		panel.add(btn_cChange);

		lbl_Order = new JLabel("Order");
		lbl_Order.setBounds(326, 11, 35, 17);
		panel.add(lbl_Order);
		lbl_Order.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lbl_orderId = new JLabel("OrderID:");
		lbl_orderId.setBounds(239, 38, 81, 14);
		panel.add(lbl_orderId);

		textField_orderId = new JTextField();
		textField_orderId.setBounds(352, 35, 86, 20);
		panel.add(textField_orderId);
		textField_orderId.setColumns(10);

		textField_delDate = new JTextField();
		textField_delDate.setBounds(352, 59, 86, 20);
		panel.add(textField_delDate);
		textField_delDate.setColumns(10);

		lbl_delDate = new JLabel("Leveransdatum:");
		lbl_delDate.setBounds(239, 65, 122, 14);
		panel.add(lbl_delDate);

		btn_oCreate = new JButton("Skapa order");
		btn_oCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				String orderId = textField_orderId.getText();
				String delDate = textField_delDate.getText();
				Customer customer = controller.findCustomer(cNumber);
				String info = ("Kundnummer: " + cNumber + "\nOrderID: " + orderId + "\nLeveransdatum: " + delDate);
				if (customer != null) {
					if (textField_orderId.getText().length() == 4 && textField_delDate.getText().length() == 6) {
						try {
							textPane.setText(info);
							controller.addCustomerOrder(orderId, delDate, cNumber);
							lbl_Response.setText("Order Skapad.");
							textField_delDate.setText("");

						} catch (Exception e1) {
							lbl_Response.setText("Fel: Skriv in kundnummer, orderID och leveransdatum.");
							textPane.setText("");
						}
					} else {
						lbl_Response.setText("Ett orderid måste vara 4-siffrigt och ett datum skrivs ååmmdd.");
						textPane.setText("");
					}

				} else {
					lbl_Response.setText("Vänligen fyll i kundnummer.");
					textPane.setText("");
				}
			}
		});
		btn_oCreate.setBounds(228, 94, 114, 23);
		panel.add(btn_oCreate);

		btn_oRemove = new JButton("Ta bort");
		btn_oRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String orderId = textField_orderId.getText();
				String cNumber = textField_cNumber.getText();
				try {
					controller.removeOrder(orderId, cNumber);
					lbl_Response.setText("Order borttagen");
					textField_orderId.setText("");
					textPane.setText("");
				} catch (Exception e1) {
					lbl_Response.setText("Fel: Skriv in orderid och kundnummer.");
					textPane.setText("");
				}
			}
		});
		btn_oRemove.setBounds(352, 94, 86, 23);
		panel.add(btn_oRemove);

		lbl_oRowNr = new JLabel("Nummer:");
		lbl_oRowNr.setBounds(239, 169, 140, 14);
		panel.add(lbl_oRowNr);

		textField_oRowNr = new JTextField();
		textField_oRowNr.setBounds(352, 166, 86, 20);
		panel.add(textField_oRowNr);
		textField_oRowNr.setColumns(10);

		lbl_oRowAmount = new JLabel("Antal:");
		lbl_oRowAmount.setBounds(239, 197, 140, 14);
		panel.add(lbl_oRowAmount);

		textField_oRowAmount = new JTextField();
		textField_oRowAmount.setBounds(352, 194, 86, 20);
		panel.add(textField_oRowAmount);
		textField_oRowAmount.setColumns(10);

		btn_oRowCreate = new JButton("Skapa orderrad");
		btn_oRowCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField_oRowNr.getText();
				String amount = textField_oRowAmount.getText();
				String orderId = textField_orderId.getText();
				String cNumber = textField_cNumber.getText();
				Customer customer = controller.findCustomer(cNumber);
				if (customer != null) {
					if (textField_oRowNr.getText().length() == 4) {
						try {
							controller.addOrderOrderRow(cNumber, number, amount, orderId);
							lbl_Response.setText("Orderrad skapad.");
							textPane.setText(
									"Kundnummer: " + cNumber + "\nOrderID: " + orderId + "\nOrderradnummer: " + number);
							textField_oRowAmount.setText("");
						} catch (Exception e1) {
							lbl_Response.setText("Fel: Skriv in nummer, antal, orderid och kundnummer.");
							textPane.setText("");
						}
					} else {
						lbl_Response.setText("Ett orderradsnummer måste vara 4-siffrigt.");
						textPane.setText("");
					}
				} else {
					lbl_Response.setText("Den här kunden finns inte.");
					textPane.setText("");
				}
			}
		});

		btn_oRowCreate.setBounds(209, 229, 133, 23);
		panel.add(btn_oRowCreate);

		btn_oRowRemove = new JButton("Ta bort");
		btn_oRowRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField_oRowNr.getText();
				String orderId = textField_orderId.getText();
				String cNumber = textField_cNumber.getText();
				if (textField_oRowNr.getText().length() == 4) {
					try {
						controller.removeOrderRow(cNumber, orderId, number);
						lbl_Response.setText("Orderrad borttagen");
						textField_oRowNr.setText("");
						textPane.setText("");
					} catch (Exception e1) {
						lbl_Response.setText("Fel: Skriv in nummer, orderid och kundnummer.");
						textPane.setText("");
					}
				} else {
					lbl_Response.setText("Ordern finns inte.");
					textPane.setText("");
				}
			}
		});
		btn_oRowRemove.setBounds(352, 229, 86, 23);
		panel.add(btn_oRowRemove);

		lbl_oRow = new JLabel("Orderrad");
		lbl_oRow.setBounds(314, 138, 124, 17);
		panel.add(lbl_oRow);
		lbl_oRow.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btn_cShowOrders = new JButton("Visa kundens ordrar");
		btn_cShowOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				try {
					Customer tmpCustomer = controller.findCustomer(cNumber);
					String info = controller.printOrders(cNumber);
					if (tmpCustomer != null) {
						textPane.setText(info);
						lbl_Response.setText("");
					}

				} catch (Exception e1) {
					lbl_Response.setText("Fel: Skriv in kundnummer.");
					textPane.setText("");
				}
			}
		});
		btn_cShowOrders.setBounds(22, 249, 143, 23);
		panel.add(btn_cShowOrders);

		JButton btn_emptyFieldsOne = new JButton("T\u00F6m alla f\u00E4lt");
		btn_emptyFieldsOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_cNumber.setText("");
				textField_cName.setText("");
				textField_cAdress.setText("");
				textField_orderId.setText("");
				textField_delDate.setText("");
				textField_oRowNr.setText("");
				textField_oRowAmount.setText("");
			}
		});
		btn_emptyFieldsOne.setBounds(326, 272, 112, 23);
		panel.add(btn_emptyFieldsOne);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Produkt och exemplar", null, panel_1, null);
		panel_1.setLayout(null);

		lbl_items = new JLabel("Exemplar");
		lbl_items.setBounds(315, 11, 79, 14);
		panel_1.add(lbl_items);
		lbl_items.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textField_iSerialNr = new JTextField();
		textField_iSerialNr.setBounds(352, 36, 86, 20);
		panel_1.add(textField_iSerialNr);
		textField_iSerialNr.setColumns(10);

		lbl_iSerialNr = new JLabel("Serienummer:");
		lbl_iSerialNr.setBounds(242, 39, 98, 14);
		panel_1.add(lbl_iSerialNr);

		bttn_iRemove = new JButton("Ta bort");
		bttn_iRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serNumber = textField_iSerialNr.getText();
				String name = textField_pName.getText();
				if (serNumber.length() > 0) {
					try {
						controller.removeItem(serNumber, name);
						textField_iSerialNr.setText(" ");
						lbl_Response.setText("Exemplar borttaget");
						textPane.setText("");
					} catch (Exception e1) {
						lbl_Response.setText("Fel: Skriv in serienummer/ skriv in namn på produkt");
						textPane.setText("");
					}
				} else {
					lbl_Response.setText("Exemplaret finns inte.");
					textPane.setText("");
				}
			}
		});
		bttn_iRemove.setBounds(352, 67, 86, 23);
		panel_1.add(bttn_iRemove);

		bttn_iCreate = new JButton("Skapa exemplar");
		bttn_iCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_pName.getText();
				String serNumber = textField_iSerialNr.getText();
				try {
					controller.addItemProduct(serNumber, name);
					textPane.setText("Namn: " + name + "\nSerienummer: " + serNumber);
					textField_pName.setText("");
					textField_iSerialNr.setText("");
					lbl_Response.setText("Exemplar skapat.");
				} catch (Exception e1) {
					textPane.setText("");
					lbl_Response.setText("Fel: Skriv in produktens namn/skapa produkten");
				}
			}
		});
		bttn_iCreate.setBounds(207, 67, 133, 23);
		panel_1.add(bttn_iCreate);

		lbl_product = new JLabel("Produkt");
		lbl_product.setBounds(74, 11, 97, 14);
		panel_1.add(lbl_product);
		lbl_product.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lbl_pName = new JLabel("Namn:");
		lbl_pName.setBounds(10, 38, 79, 14);
		panel_1.add(lbl_pName);

		textField_pName = new JTextField();
		textField_pName.setBounds(99, 35, 86, 20);
		panel_1.add(textField_pName);
		textField_pName.setColumns(10);

		lbl_pCategory = new JLabel("Kategori:");
		lbl_pCategory.setBounds(10, 63, 79, 14);
		panel_1.add(lbl_pCategory);

		textField_pCategory = new JTextField();
		textField_pCategory.setBounds(99, 60, 86, 20);
		panel_1.add(textField_pCategory);
		textField_pCategory.setColumns(10);

		lbl_pPrice = new JLabel("Pris:");
		lbl_pPrice.setBounds(10, 88, 79, 14);
		panel_1.add(lbl_pPrice);

		textField_pPrice = new JTextField();
		textField_pPrice.setBounds(99, 85, 86, 20);
		panel_1.add(textField_pPrice);
		textField_pPrice.setColumns(10);

		btn_pCreate = new JButton("Skapa produkt");
		btn_pCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = textField_pName.getText();
				String category = textField_pCategory.getText();
				String price = textField_pPrice.getText();
				Product p = productReg.findProduct(name);
				if (p == null) {
					if (price.length() > 0 && price.length() < 99) {
						try {
							name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
							category = category.substring(0, 1).toUpperCase() + category.substring(1).toLowerCase();
							controller.addProduct(name, category, price);
							textPane.setText("Namn: " + name + "\nKategori: " + category + "\nPris: " + price);
							textField_pCategory.setText("");
							textField_pPrice.setText("");
							lbl_Response.setText("");
						} catch (Exception e1) {
							lbl_Response.setText("Fel: Skriv in namn, kategori och pris.");
							textPane.setText("");
						}

					} else {
						lbl_Response.setText("Fel: Skriv in namn, kategori och pris.");
						textPane.setText("");
					}
				}
			}
		});

		btn_pCreate.setBounds(10, 113, 122, 23);
		panel_1.add(btn_pCreate);

		btn_pChange = new JButton("\u00C4ndra produkt");
		btn_pChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_pName.getText();
				String category = textField_pCategory.getText();
				String price = textField_pPrice.getText();

				Product p = controller.findProduct(name);
				if (p != null) {
					if (price.length() > 0 && price.length() < 99 && category.length() > 0 && category.length() < 99) {
						try {
							controller.updateProduct(name, category, price);
							textPane.setText("Namn: " + name + "\nKategori: " + category + "\nPris: " + price);
							textField_pCategory.setText("");
							textField_pPrice.setText("");
							lbl_Response.setText("");
						} catch (Exception e1) {
							lbl_Response.setText("Fel: Skriv in produktnamn för att ändra kategori och pris");
							textPane.setText("");
						}
					} else {
						lbl_Response.setText("Fel skriv in namn, kategori och pris.");
						textPane.setText("");
					}
				} else {
					lbl_Response.setText("Den här produkten finns inte.");
					textPane.setText("");
				}
			}
		});
		btn_pChange.setBounds(140, 147, 122, 23);
		panel_1.add(btn_pChange);

		btn_pFind = new JButton("Hitta produkt");
		btn_pFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_pName.getText();
				try {
					Product newProduct = controller.findProduct(name);
					String info = "Namn: " + newProduct.getName() + "\nKategori: " + newProduct.getCategory()
							+ "\nPris: " + newProduct.getPrice();
					if (newProduct != null) {
						textPane.setText(info);
						lbl_Response.setText("");
					}
				} catch (Exception e1) {
					lbl_Response.setText("Fel: Skriv in namnet på en existerande produkt.");
					textPane.setText("");
				}
			}
		});
		btn_pFind.setBounds(140, 113, 122, 23);
		panel_1.add(btn_pFind);

		btn_pRemove = new JButton("Ta bort produkt");
		btn_pRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_pName.getText();
				Product p = controller.findProduct(name);
				if (p != null) {
					try {
						controller.removeProduct(name);
						textField_pName.setText("");
						textField_pCategory.setText("");
						textField_pPrice.setText("");
						lbl_Response.setText("Produkt borttagen");
						textPane.setText("");
					} catch (Exception e1) {
						textPane.setText("");
					}
				} else {
					lbl_Response.setText("Den här produkten finns inte.");
					textPane.setText("");

				}
			}
		});
		btn_pRemove.setBounds(10, 148, 122, 23);
		panel_1.add(btn_pRemove);

		JButton btn_pSum = new JButton("Summa produkter");
		btn_pSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cNumber = textField_cNumber.getText();
				String orderId = textField_orderId.getText();

				try {
					double info = controller.getOrderProductPrice(orderId, cNumber);
					textPane.setText(String.valueOf(info));
					lbl_Response.setText("");
				} catch (Exception e1) {
					lbl_Response.setText("Produkt finns inte.");
					textPane.setText("");
				}
			}
		});
		btn_pSum.setBounds(10, 249, 190, 23);
		panel_1.add(btn_pSum);

		JButton btn_pAddToRow = new JButton("L\u00E4gg produkt till orderrad");
		btn_pAddToRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField_oRowNr.getText();
				String cNumber = textField_cNumber.getText();
				String orderId = textField_orderId.getText();
				String name = textField_pName.getText();
				if (name.length() > 0 && number.length() > 0) {
					Product p = productReg.findProduct(name);
					Customer c = customerReg.findCustomer(cNumber);
					Order o = c.findOrder(orderId);
					OrderRow row = o.findOrderRow(number);
					String test = row.getAmount();
					if (p.getItemList().size() >= Integer.parseInt(test)) {
						try {
							controller.addProductOrderRow(name, number, orderId, cNumber);
							textPane.setText("Produkt tillagd till orderrad.");
							textField_pCategory.setText("");
							textField_pPrice.setText("");
							lbl_Response.setText("");
						} catch (Exception e1) {
							lbl_Response.setText("Produkt ej tillagd.");
							textPane.setText("");
						}
					} else {
						textPane.setText("Otillräckligt med exemplar i lager.");
					}
				}
			}
		});
		btn_pAddToRow.setBounds(10, 215, 190, 23);
		panel_1.add(btn_pAddToRow);

		JButton btn_pRemoveFromRow = new JButton("Ta bort produkt från orderrad");
		btn_pRemoveFromRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String number = textField_oRowNr.getText();
				String cNumber = textField_cNumber.getText();
				String orderId = textField_orderId.getText();
				String name = textField_pName.getText();
				if (name.length() > 0 && number.length() > 0) {
					try {
						controller.removeProductOrderRow(name, number, orderId, cNumber);
						;
						textPane.setText("Produkt borttagen från orderrad.");
						lbl_Response.setText("");
					} catch (Exception e1) {
						lbl_Response.setText("Produkt ej borttagen.");
						textPane.setText("");
					}
				}
			}
		});
		btn_pRemoveFromRow.setBounds(10, 181, 216, 23);
		panel_1.add(btn_pRemoveFromRow);

		JButton btn_emptyFieldsTwo = new JButton("T\u00F6m alla f\u00E4lt");
		btn_emptyFieldsTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_pName.setText("");
				textField_pCategory.setText("");
				textField_pPrice.setText("");
				textField_iSerialNr.setText("");
			}
		});
		btn_emptyFieldsTwo.setBounds(327, 272, 111, 23);
		panel_1.add(btn_emptyFieldsTwo);
	}
}
