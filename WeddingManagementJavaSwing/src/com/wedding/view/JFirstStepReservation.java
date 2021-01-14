package com.wedding.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.wedding.model.Lobby;
import com.wedding.model.Reservation;
import com.wedding.service.LobbyService;
import com.wedding.serviceImpl.LobbyServiceImpl;

public class JFirstStepReservation extends JPanel {
	private List<Lobby> listLobby;
	private List<JLobbyInfo> lobbyItems;
	private LobbyService lobbyService;
	private Reservation reservation;
	private ButtonGroup group_lobby;
	JFirstStepReservation panel = this;

	/**
	 * Create the panel.
	 */
	public JFirstStepReservation(Reservation reservation) {
		this.reservation = reservation;
		setBackground(Color.WHITE);
		setLayout(null);

		DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		JFormattedTextField txt_wedding_date = new JFormattedTextField(format);
		txt_wedding_date.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_wedding_date.setBounds(23, 41, 134, 20);
		add(txt_wedding_date);
		txt_wedding_date.setColumns(10);

		JRadioButton btn_shift_1 = new JRadioButton("Afternoon");
		btn_shift_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btn_shift_1.setBounds(177, 40, 92, 23);
		add(btn_shift_1);

		JRadioButton btn_shift_2 = new JRadioButton("Evening");
		btn_shift_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btn_shift_2.setBounds(271, 40, 77, 23);
		add(btn_shift_2);

		ButtonGroup group_shift = new ButtonGroup();
		group_shift.add(btn_shift_1);
		group_shift.add(btn_shift_2);

		JLabel lblNewLabel = new JLabel("Wedding Date");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel.setBounds(23, 16, 92, 20);
		add(lblNewLabel);

		group_lobby = new ButtonGroup();
		
		JButton btn_filter = new JButton("Filter");
		btn_filter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listLobby.clear();
				if(lobbyItems.size() !=0)
					ClearListLobbyInfo();
				int shift = 0;
				if (btn_shift_2.isSelected())
					shift = 1;
				listLobby = lobbyService.checkLobby(txt_wedding_date.getText(), shift);
				int index = 0;
				for (Lobby lobby : listLobby) {
					//System.out.println(lobby.getLobbyName());
					JLobbyInfo lobby_item = new JLobbyInfo(panel, lobby);
					group_lobby.add(lobby_item.btn);
					lobby_item.setBounds(23, 85 + 39 * index, 455, 39);
					panel.add(lobby_item);
					lobbyItems.add(lobby_item);
					index++;
				}
				reservation.setWeddingDate(txt_wedding_date.getText());
				reservation.setShift(shift);
			}
		});
		btn_filter.setBounds(371, 41, 89, 23);
		add(btn_filter);
		
		

		lobbyService = new LobbyServiceImpl();
		listLobby = new ArrayList<Lobby>();
		lobbyItems = new ArrayList<JLobbyInfo>();
	}

	public void ClearListLobbyInfo() {
			for (JLobbyInfo lobbyItem : lobbyItems) {
				panel.remove(lobbyItem);
			}
	}
	public void SetLobbyID(int lobbyID) {
		System.out.println(lobbyID);
		reservation.setLobbyID(lobbyID);
	}
	
}
