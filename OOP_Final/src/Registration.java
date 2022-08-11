import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtconfpass;
	private JPasswordField txtpword;
	private JTextField txtuname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(58, 175, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Mcvince Paul\\OneDrive\\Documents\\PROGRAMMING\\Java\\FINALS\\img\\key (2) (Custom) (1).png"));
		lblNewLabel_3.setBounds(195, 76, 156, 134);
		contentPane.add(lblNewLabel_3);
		
		JButton btnsignup = new JButton("SIGN UP");
		btnsignup.setFont(new Font("Dubai Light", Font.BOLD, 15));
		btnsignup.setBackground(new Color(255, 255, 255));
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regUser();
			}
		});
		btnsignup.setBounds(102, 348, 135, 23);
		contentPane.add(btnsignup);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Dubai Light", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
			}
		});
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setBounds(275, 348, 135, 23);
		contentPane.add(btnReset);
		
		txtconfpass = new JPasswordField();
		txtconfpass.setBounds(185, 303, 182, 23);
		contentPane.add(txtconfpass);
		
		txtpword = new JPasswordField();
		txtpword.setBounds(185, 262, 182, 23);
		contentPane.add(txtpword);
		
		txtuname = new JTextField();
		txtuname.setBounds(185, 221, 182, 23);
		contentPane.add(txtuname);
		txtuname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Dubai Light", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(59, 219, 104, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Dubai Light", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(59, 264, 93, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm password");
		lblNewLabel_2.setFont(new Font("Dubai Light", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(59, 295, 125, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Registration Form");
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Microsoft Himalaya", Font.BOLD, 52));
		lblNewLabel_4.setBounds(125, 36, 303, 59);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Dubai Light", Font.BOLD, 17));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login f1 = new login();
				f1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(399, 11, 98, 30);
		contentPane.add(btnNewButton);
	}
	
	//db connection
	static Connection connect() {
		try {
			String myDriver = "com.mysql.cj.jdbc.Driver";
			//connection string
			String url = "jdbc:mysql://localhost:3306/final_tbl";
			Class.forName(myDriver);
			return (Connection)DriverManager.getConnection(url,"root","");
		}catch(Exception e) {
			System.out.print("Cannot connect to the database");
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public void regUser() {
		Connection con = connect();
		
		try {
			Statement stmt = con.createStatement();
			String chk = "SELECT * from final_tbl where username ='"+txtuname.getText() +"'and password='"+txtpword.getText()+"'";
			ResultSet rs = stmt.executeQuery(chk); 
			if(rs.next()) 
			{
				JOptionPane.showMessageDialog(null, "Username " + txtuname.getText() + " is already used...","Error", JOptionPane.ERROR_MESSAGE);
				clearTextfield();
			}
			else if (!txtconfpass.getText().equals(txtpword.getText()))
			{
				JOptionPane.showMessageDialog(null, "Password is not match","Error", JOptionPane.ERROR_MESSAGE);
				clearTextfield();
			}
			else if (txtuname.getText().equals("") || txtpword.getText().equals("") || txtconfpass.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "You must fill in all of the fields. ","Error", JOptionPane.ERROR_MESSAGE);
				clearTextfield();
			}else {
			String sql = "INSERT INTO final_tbl(username, password, confpass) VALUES (?,?,?)";
			PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
			
			ps.setString(1, txtuname.getText());
			ps.setString(2, txtpword.getText());
			ps.setString(3, txtconfpass.getText());
			ps.execute();
			
			ImageIcon icon = new ImageIcon("E:\\ACAD\\OOP\\Eclipse\\finals\\Finals\\img\\7.png");
			 JOptionPane.showMessageDialog(null,"Registered successfully","Success",JOptionPane.PLAIN_MESSAGE,icon);
			
				login f1 = new login();
				f1.setVisible(true);
				dispose();
		}
			
			
		}catch(Exception e) {
			System.out.print("Error..." + e);
		}
	}// end of reg
	
	private void clearTextfield() {
		// TODO Auto-generated method stub
		txtuname.setText("");
		txtpword.setText("");
		txtconfpass.setText("");
		//JOptionPane.showMessageDialog(null, "Clear successful");
	}
}
