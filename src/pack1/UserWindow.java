package pack1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class UserWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField URLText;
	private JTextField depthText;
	private JTextField threadText;

	private boolean clicked = false;

	public boolean getClick() {
		return clicked;
	}

	public UserWindow() {
		setTitle("URL checker");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 357);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel error = new JLabel("");
		error.setForeground(new Color(220, 20, 60));
		error.setFont(new Font("Tahoma", Font.PLAIN, 13));
		error.setBounds(51, 279, 363, 26);
		contentPane.add(error);
		setLocation(new Point(380, 100));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 10, 762, 295);
		contentPane.add(panel);
		panel.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("URL checker");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(10, 10, 742, 36);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				
						JLabel lblNewLabel_1 = new JLabel("URL:");
						lblNewLabel_1.setBounds(50, 44, 44, 36);
						panel.add(lblNewLabel_1);
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
						
								URLText = new JTextField();
								URLText.setBounds(50, 90, 680, 26);
								panel.add(URLText);
								URLText.setBackground(SystemColor.inactiveCaptionBorder);
								URLText.setColumns(10);
								
										depthText = new JTextField();
										depthText.setBounds(206, 148, 96, 20);
										panel.add(depthText);
										depthText.setBackground(SystemColor.inactiveCaptionBorder);
										depthText.addKeyListener(new KeyAdapter() {
											@Override
											public void keyPressed(KeyEvent e) {
												if (Character.isDigit(e.getKeyChar())|| Character.isISOControl(e.getKeyChar())) {
													depthText.setEditable(true);
												} else {
													depthText.setEditable(false);
												}
											}
										});
										depthText.setColumns(10);
										
												JLabel lblNewLabel_2 = new JLabel("Depth:");
												lblNewLabel_2.setBounds(67, 146, 111, 18);
												panel.add(lblNewLabel_2);
												lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
												
														JLabel lblNewLabel_3 = new JLabel("Number of Threads:");
														lblNewLabel_3.setBounds(67, 187, 134, 26);
														panel.add(lblNewLabel_3);
														lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
														
																threadText = new JTextField();
																threadText.setBounds(257, 193, 96, 20);
																panel.add(threadText);
																threadText.setBackground(SystemColor.inactiveCaptionBorder);
																threadText.addKeyListener(new KeyAdapter() {
																	@Override
																	public void keyPressed(KeyEvent e) {
																		if (Character.isDigit(e.getKeyChar())|| Character.isISOControl(e.getKeyChar())) {
																			threadText.setEditable(true);
																		} else {
																			threadText.setEditable(false);
																		}
																	}
																});
																threadText.setColumns(10);
																
																		JLabel message = new JLabel("Max number of threads : " + MyThread.getMaxThreadCount());
																		message.setBounds(373, 193, 247, 18);
																		panel.add(message);
																		message.setForeground(new Color(0, 128, 128));
																		
																				JButton btnNewButton = new JButton("check");
																				btnNewButton.setBounds(341, 237, 96, 36);
																				panel.add(btnNewButton);
																				btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
																				btnNewButton.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						int thread = 0;
																						if (!threadText.getText().equals("") && Integer.parseInt(threadText.getText()) > 0
																								&& Integer.parseInt(threadText.getText()) <= MyThread.getMaxThreadCount())
																							thread = Integer.parseInt(threadText.getText());
																						error.setText("Invalid NumberOfThread!!");

																						if (URLText.getText().equals("") || depthText.getText().equals("") || threadText.getText().equals("")) {
																							error.setText("Please fill all the data!!");
																						} else if (LinkValidator.verifyUrl(URLText.getText(), " ") && thread != 0) {
																							Main.setUrl(URLText.getText());
																							Main.setDepth(Integer.parseInt(depthText.getText()));
																							Main.setNoOfThreads(thread);
																							error.setText("");
																							clicked = true;
																						} else {
																							error.setText("Invalid!!");
																						}
																					}
																				});
																				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));

	}
}
