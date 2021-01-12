package com.wedding.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.wedding.service.AuthenAccountService;
import com.wedding.serviceImpl.AuthenAccountServiceImpl;

public class JLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txt_password;
	private JTextField txt_username;
	private AuthenAccountService authenAccountService;

	@Override
	protected void frameInit() {
		// TODO Auto-generated method stub
		super.frameInit();
		authenAccountService = new AuthenAccountServiceImpl();
	}
	public JLoginView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(80, 73, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(80, 115, 46, 14);
		panel.add(lblNewLabel);

		txt_password = new JTextField();
		txt_password.setBounds(205, 112, 86, 20);
		panel.add(txt_password);
		txt_password.setColumns(10);

		txt_username = new JTextField();
		txt_username.setBounds(205, 70, 86, 20);
		panel.add(txt_username);
		txt_username.setColumns(10);

		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("username " + txt_username.getText());
				System.out.println("password " + txt_password.getText());
				setVisible(false);
				JHomeView frame = new JHomeView();
				frame.setVisible(true);
				
//				String username =  txt_username.getText();
//				String password =  txt_password.getText();
//				
//				UserDTO user = authenAccountService.authenAccountLogin(username, password);
//				if (user != null) {
//					System.out.println("id " +  user.getUserID());
//				}

			}
		});
		button.setBounds(164, 158, 70, 22);
		panel.add(button);
		
		
		
	}
}
