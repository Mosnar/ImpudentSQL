package imp.main;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6771442546801658873L;

	JPanel pane = new JPanel();
	
	
	MainScreen()
	{
		super("ImpudentSQL v0.1");
		setBounds(200, 200, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con =  this.getContentPane();
		con.add(pane);
		GroupLayout gl_pane = new GroupLayout(pane);
		gl_pane.setHorizontalGroup(
			gl_pane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 594, Short.MAX_VALUE)
		);
		gl_pane.setVerticalGroup(
			gl_pane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 472, Short.MAX_VALUE)
		);
		pane.setLayout(gl_pane);
		
		
		// Table Stuff
		String[] columnNames = {"IP Address", "Port", "Architecture", "Username", "Password"};
		Object[][] data = {
				{"192.168.1.1", "21", "MySQL", "", ""}
		};
		JTable table = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		con.add(scrollPane);
		setVisible(true);
		setResizable(false);
	}
}