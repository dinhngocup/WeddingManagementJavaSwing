package com.wedding.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.wedding.dto.UserDTO;
import com.wedding.service.AuthenAccountService;
import com.wedding.serviceImpl.AuthenAccountServiceImpl;

public class JLoginView extends JFrame {

	private JPanel contentPane;
	private JPasswordField  txt_password;
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

		JPanel panel = new JPanel(){
	        @Override
	        protected void paintComponent(Graphics g) {
	        	Graphics2D g2d = (Graphics2D) g;
	            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	            int w = getWidth();
	            int h = getHeight();
	            Color color1 = new Color(253,96,162);
	            Color color2 = new Color(255,150,165);
	            GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
	            g2d.setPaint(gp);
	            g2d.fillRect(0, 0, w, h);

	        }

	    };
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(80, 73, 103, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(80, 115, 103, 14);
		panel.add(lblNewLabel);

		txt_password = new JPasswordField ();
		txt_password.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_password.setBounds(205, 112, 114, 20);
		panel.add(txt_password);
		txt_password.setColumns(10);

		txt_username = new JTextField();
		txt_username.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_username.setBounds(205, 70, 114, 20);
		panel.add(txt_username);
		txt_username.setColumns(10);

		JLabel txt_error = new JLabel("Username or password is incorrect");
		
		Button button = new Button("Login");
		button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String username =  txt_username.getText();
				String password =  txt_password.getText();
				
				System.out.println("username " + txt_username.getText());
				System.out.println("password " + txt_password.getText());
				UserDTO user = authenAccountService.authenAccountLogin(username, password);
				if (user != null) {
					System.out.println("id " +  user.getUserID());
					setVisible(false);
					JHomeView frame = new JHomeView();
					frame.setVisible(true);
				} else {
					txt_error.setVisible(true);
				}

			}
		});
		button.setBounds(163, 179, 70, 22);
		panel.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME BACK");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(125, 11, 166, 33);
		panel.add(lblNewLabel_2);
		
		
		txt_error.setForeground(Color.RED);
		txt_error.setHorizontalAlignment(SwingConstants.CENTER);
		txt_error.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txt_error.setBounds(10, 147, 404, 14);
		txt_error.setVisible(false);
		panel.add(txt_error);
		
		
		
	}
}
