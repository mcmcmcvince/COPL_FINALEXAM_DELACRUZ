import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 405);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(58, 175, 169));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtuser = new JTextField();
		txtuser.setBounds(139, 182, 223, 27);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Dubai Light", Font.BOLD, 15));
		lblNewLabel.setBounds(55, 180, 97, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Dubai Light", Font.BOLD, 15));
		lblNewLabel_1.setBounds(55, 220, 130, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Mcvince Paul\\OneDrive\\Documents\\PROGRAMMING\\Java\\FINALS\\img\\house (Custom).png"));
		lblNewLabel_2.setBounds(176, 11, 198, 171);
		contentPane.add(lblNewLabel_2);
		
		JButton btnsignin = new JButton("LOG IN");
		btnsignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnsignin.setFont(new Font("Dubai Light", Font.BOLD, 15));
		btnsignin.setForeground(new Color(0, 0, 0));
		btnsignin.setBackground(new Color(255, 255, 255));
		btnsignin.setBounds(139, 274, 103, 23);
		contentPane.add(btnsignin);
		
		JButton btnreset = new JButton("CLEAR\r\n");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
			}
		});
		btnreset.setFont(new Font("Dubai Light", Font.BOLD, 15));
		btnreset.setBackground(new Color(255, 255, 255));
		btnreset.setBounds(259, 274, 103, 23);
		contentPane.add(btnreset);
		
		JButton btnsignup = new JButton("DON'T HAVE AN ACCOUNT? CLICK HERE\r\n");
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration reg = new Registration();
				reg.setVisible(true);
				dispose();
			}
		});
		btnsignup.setFont(new Font("Dubai Light", Font.BOLD, 10));
		btnsignup.setBackground(new Color(255, 255, 255));
		btnsignup.setBounds(139, 308, 223, 31);
		contentPane.add(btnsignup);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(139, 224, 223, 27);
		contentPane.add(txtpass);
	}
	
	public void login() {
		try {
			//set the mysql jdbc driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//set the mysql connection string
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/final_tbl","root","");
			Statement stmt = (Statement) con.createStatement();
			//sql query for the login 
			String sql = "Select * from final_tbl where username='"+txtuser.getText() + "'and password='"+txtpass.getText()+"'";
			
			//execute query
			ResultSet rs = ((java.sql.Statement)stmt).executeQuery(sql);
								

			// conditions for uname & pword
			if(rs.next()) {
				String userName = txtuser.getText();
				Dashboard frmtwo = new Dashboard();
				frmtwo.lbluserT.setText("USER : "+userName);
				frmtwo.setVisible(true);
				dispose();
				JOptionPane.showMessageDialog(null, "Login successful...","Login Alert",2);
			}else if (txtuser.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Username is required...","Login Warning",2);
			}else if (txtpass.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Password is required...","Login Warning",2);
			}else {
				JOptionPane.showMessageDialog(null, "Username or password incorrect...","Login Warning",2);
			}
		}catch(Exception ex) {
			System.out.print(ex);
		}
	}
	private void clearTextfield() {
		// TODO Auto-generated method stub
		txtuser.setText("");
		txtpass.setText("");
		//JOptionPane.showMessageDialog(null, "Clear successful");
	}
}