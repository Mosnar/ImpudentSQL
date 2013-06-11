package imp.view;

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
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class MainScreen {

	private JFrame frame;
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 777, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExportResults = new JMenuItem("Export Results");
		mnFile.add(mntmExportResults);
		
		JMenuItem mntmOptions = new JMenuItem("Preferences");
		mnFile.add(mntmOptions);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		
		txtStartIP = new JTextField();
		txtStartIP.setToolTipText("(xxx.xxx.xxx.xxx)");
		txtStartIP.setColumns(10);
		
		JLabel lblStartIp = new JLabel("Start IP");
		lblStartIp.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		txtEndIP = new JTextField();
		txtEndIP.setToolTipText("(xxx.xxx.xxx.xxx)");
		txtEndIP.setColumns(10);
		
		JLabel lblEndIp = new JLabel("End IP");
		lblEndIp.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JButton btnStart = new JButton("Start");
		btnStart.setToolTipText("Begin network scan");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"MySQL", "MSSQL", "Both"}));
		comboBox.setMaximumRowCount(3);
		
		JLabel lblServerModel = new JLabel("Server Model");
		lblServerModel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(133)
					.addComponent(lblServerModel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(lblStartIp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtStartIP, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblEndIp, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEndIP, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addGap(52)
					.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnStart)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtEndIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEndIp)
							.addComponent(txtStartIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblStartIp)
							.addComponent(lblServerModel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
