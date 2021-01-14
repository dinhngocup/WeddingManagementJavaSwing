package com.wedding.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;

import com.wedding.model.Lobby;

public class JLobbyInfo extends JPanel {
	public JRadioButton btn;

	/**
	 * Create the panel.
	 */
	public JLobbyInfo(JFirstStepReservation panel, Lobby lobby) {
		
		Color item_border = new Color(222, 226, 230);
		
		setBorder(new MatteBorder(0, 0, 1, 0, item_border));
		setBackground(Color.WHITE);
		setLayout(null);
		
		//this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, item_border));
		
		JLabel txt_name_lobby = new JLabel("New label");
		txt_name_lobby.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_name_lobby.setBounds(10, 11, 137, 14);
		txt_name_lobby.setText(lobby.getLobbyName());
		add(txt_name_lobby);
		
		JLabel txt_type_lobby = new JLabel("A");
		txt_type_lobby.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_type_lobby.setBounds(173, 11, 21, 14);
		txt_type_lobby.setText(lobby.getLobbyType());
		add(txt_type_lobby);
		
		JLabel txt_max_table = new JLabel("50");
		txt_max_table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_max_table.setBounds(258, 11, 21, 14);
		txt_max_table.setText(String.valueOf(lobby.getMaxTable()));
		add(txt_max_table);
		
		JLabel txt_min_price = new JLabel("1000000");
		txt_min_price.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_min_price.setBounds(322, 11, 79, 14);
		txt_min_price.setText(String.valueOf(lobby.getMinPrice()));
		add(txt_min_price);
		
		btn = new JRadioButton("");
		btn.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn.setBounds(428, 7, 21, 23);
		add(btn);
		btn.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		           if(e.getSource() == btn){
		        	   panel.SetLobbyID(lobby.getLobbyID());
		           }
		        }
		    });

	}

}
