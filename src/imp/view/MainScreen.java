package imp.view;

import imp.core.IPObject;
import imp.model.NetScanner;
import imp.model.ServerTableModel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.ScrollPane;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import java.awt.event.InputEvent;

public class MainScreen {

	private JFrame frmImpudentsql;
	private JTextField txtStartIP;
	private JTextField txtEndIP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frmImpudentsql.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImpudentsql = new JFrame();
		frmImpudentsql.setTitle("ImpudentSQL");
		frmImpudentsql.setBounds(100, 100, 777, 421);
		frmImpudentsql.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmImpudentsql.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExportResults = new JMenuItem("Export Results");
		mntmExportResults.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnFile.add(mntmExportResults);

		JMenuItem mntmOptions = new JMenuItem("Preferences");
		mntmOptions.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
		mnFile.add(mntmOptions);

		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
		mnFile.add(mntmQuit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);

		JProgressBar progressBar = new JProgressBar();
		menuBar.add(progressBar);
		progressBar.setStringPainted(true);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);
		GroupLayout groupLayout = new GroupLayout(frmImpudentsql.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(splitPane, Alignment.TRAILING,
				GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.TRAILING).addComponent(splitPane, Alignment.LEADING,
				GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE));

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);

		JLabel lblServerModel = new JLabel("Server Model");
		lblServerModel.setFont(new Font("Lucida Grande", Font.BOLD, 13));

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "MySQL",
				"MSSQL", "Both" }));
		comboBox.setMaximumRowCount(3);

		JLabel lblStartIp = new JLabel("Start IP");
		lblStartIp.setFont(new Font("Lucida Grande", Font.BOLD, 13));

		txtStartIP = new JTextField();
		txtStartIP.setToolTipText("(xxx.xxx.xxx.xxx)");
		txtStartIP.setColumns(10);

		JLabel lblEndIp = new JLabel("End IP");
		lblEndIp.setFont(new Font("Lucida Grande", Font.BOLD, 13));

		txtEndIP = new JTextField();
		txtEndIP.setToolTipText("(xxx.xxx.xxx.xxx)");
		txtEndIP.setColumns(10);

		JButton btnStart = new JButton("Start Scan");
		btnStart.setToolTipText("Begin network scan");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(6)
								.addComponent(lblEndIp)
								.addGap(58)
								.addComponent(txtEndIP,
										GroupLayout.PREFERRED_SIZE, 122,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
				.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 228,
						Short.MAX_VALUE)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(6)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(lblServerModel)
												.addComponent(lblStartIp))
								.addGap(12)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addComponent(
														txtStartIP,
														GroupLayout.PREFERRED_SIZE,
														122,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														comboBox,
														GroupLayout.PREFERRED_SIZE,
														122,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(4)
																.addComponent(
																		lblServerModel))
												.addComponent(
														comboBox,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblStartIp)
												.addComponent(
														txtStartIP,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.BASELINE)
												.addComponent(lblEndIp)
												.addComponent(
														txtEndIP,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED,
										255, Short.MAX_VALUE)
								.addComponent(btnStart).addContainerGap()));
		panel.setLayout(gl_panel);
		final TableModel data = new ServerTableModel();

		JTable table = new JTable(data);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		splitPane.setRightComponent(scrollPane);
		frmImpudentsql.getContentPane().setLayout(groupLayout);
		
		btnStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (!MainScreen.isIPAddress(txtStartIP.getText())) {
				
					JOptionPane.showMessageDialog(frmImpudentsql,
					    "The start address is not a valid IPv4 address",
					    "IP Error",
					    JOptionPane.ERROR_MESSAGE);
				} else if(!MainScreen.isIPAddress(txtEndIP.getText())) {
					JOptionPane.showMessageDialog(frmImpudentsql,
						    "The end address is not a valid IPv4 address",
						    "IP Error",
						    JOptionPane.ERROR_MESSAGE);	
				} else {
					NetScanner scanner = new NetScanner(new IPObject(txtStartIP.getText()), new IPObject(txtEndIP.getText()));
					ArrayList<IPObject> items = scanner.getIps();
					for (IPObject obj : items) {
						((ServerTableModel) data).addElement(obj);
					}
				}
			}
		});
	}
	/**
	 * This method will check if a string matches the correct format of an
	 * IPv4 address
	 * @param ipAddress string ip address (x.x.x.x)
	 * @return true or false
	 */
	public static boolean isIPAddress(String ipAddress) {
		String[] tokens = ipAddress.split("\\.");
		if (tokens.length != 4) {
			return false;
		}
		for (String str : tokens) {
			int i = Integer.parseInt(str);
			if ((i < 0) || (i > 255)) {
				return false;
			}
		}
		return true;
	}
}
