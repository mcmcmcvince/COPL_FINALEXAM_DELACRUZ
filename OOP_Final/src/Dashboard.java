import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	JLabel lbluserT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setForeground(Color.BLACK);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 302);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(58, 175, 169));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome!");
		lblNewLabel.setFont(new Font("Microsoft Himalaya", Font.BOLD, 50));
		lblNewLabel.setBounds(252, 65, 197, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Mcvince Paul\\OneDrive\\Documents\\PROGRAMMING\\Java\\FINALS\\img\\hello (Custom).png"));
		lblNewLabel_1.setBounds(74, 54, 170, 133);
		contentPane.add(lblNewLabel_1);
		
		lbluserT = new JLabel("");
		lbluserT.setFont(new Font("Dubai Light", Font.BOLD, 29));
		lbluserT.setBounds(252, 131, 197, 30);
		contentPane.add(lbluserT);
	}

}