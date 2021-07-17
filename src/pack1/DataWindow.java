package pack1;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class DataWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable validTable;
	private JTable inValidTable;

	public void addLink(String val, String inVal) {
		DefaultTableModel model = (DefaultTableModel) validTable.getModel();
		DefaultTableModel model2 = (DefaultTableModel) inValidTable.getModel();
		Object[][] x = new Object[1][3];

		String[] splitString = val.split("\n");
		int i = 0, j = 1, count = 1;
		while (i < splitString.length && j < splitString.length) 
		{
			x[0][0] = count;
			x[0][1] = splitString[i];
			x[0][2] = splitString[j];
			model.addRow(x[0]);
			i += 2;
			j += 2;
			count++;
	}
		

		i = j = 0;
		 count = 1;
		splitString = inVal.split("\n");
		while (i < splitString.length && j < splitString.length) 
		{
			x[0][0] = count;
			x[0][1] = splitString[i];
			x[0][2] = splitString[j];
			model2.addRow(x[0]);
			i += 2;
			j += 2;
			count++;
	}
		}

	public DataWindow() {
		setTitle("Results");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 658);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 163, 762, 220);
		contentPane.add(scrollPane);

		validTable = new JTable();
		validTable.setForeground(new Color(0, 102, 51));
		validTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.", "VALID links", "text"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		validTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		validTable.getColumnModel().getColumn(1).setPreferredWidth(515);
		validTable.getColumnModel().getColumn(2).setPreferredWidth(123);
		scrollPane.setViewportView(validTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 393, 762, 220);
		contentPane.add(scrollPane_1);
		
		inValidTable = new JTable();
		inValidTable.setForeground(new Color(204, 0, 0));
		inValidTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.", "INVALID links", "text"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		inValidTable.getColumnModel().getColumn(0).setPreferredWidth(30);
		inValidTable.getColumnModel().getColumn(1).setPreferredWidth(515);
		inValidTable.getColumnModel().getColumn(2).setPreferredWidth(123);
		scrollPane_1.setViewportView(inValidTable);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 10, 762, 143);
		contentPane.add(panel);
				panel.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Result");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(10, 10, 742, 28);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
				
						JLabel validLinks = new JLabel("New label");
						validLinks.setBounds(36, 63, 165, 22);
						panel.add(validLinks);
						validLinks.setForeground(new Color(0, 128, 0));
						validLinks.setFont(new Font("Tahoma", Font.PLAIN, 13));
						validLinks.setText("Number of valid links: " + LinkValidator.getValidNum());
						
								JLabel invalidLinks = new JLabel("New label");
								invalidLinks.setBounds(285, 63, 165, 22);
								panel.add(invalidLinks);
								invalidLinks.setForeground(new Color(139, 0, 0));
								invalidLinks.setFont(new Font("Tahoma", Font.PLAIN, 13));
								invalidLinks.setText("Number of invalid links: " + LinkValidator.getInvalidNum());
								
										JLabel allLinks = new JLabel("New label");
										allLinks.setBounds(551, 63, 165, 22);
										panel.add(allLinks);
										allLinks.setForeground(new Color(0, 0, 153));
										allLinks.setFont(new Font("Tahoma", Font.PLAIN, 13));
										allLinks.setText("Number of all links: " + Main.noOfAllLinks());
										
												JLabel threads = new JLabel("New label");
												threads.setBounds(285, 95, 165, 22);
												panel.add(threads);
												threads.setForeground(new Color(0, 0, 0));
												threads.setFont(new Font("Tahoma", Font.PLAIN, 13));
												threads.setText("Number of Threads: " + MyThread.getThreadCount());
												
														JLabel time = new JLabel("New label");
														time.setBounds(36, 95, 196, 22);
														panel.add(time);
														time.setForeground(new Color(0, 0, 0));
														time.setFont(new Font("Tahoma", Font.PLAIN, 13));
														time.setText("Execution time: " + Main.time() + " sec");
														
														JLabel maxThreads = new JLabel("Number of Threads: 0");
														maxThreads.setBounds(551, 95, 165, 22);
														panel.add(maxThreads);
														maxThreads.setForeground(Color.BLACK);
														maxThreads.setFont(new Font("Tahoma", Font.PLAIN, 13));
														maxThreads.setText("Max number of Threads: " + MyThread.getMaxThreadCount());
		
		setLocation(new Point(380, 100));
	}
}
