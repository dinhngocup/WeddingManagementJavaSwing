package com.wedding.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wedding.model.Reservation;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;

public class JSecondStepReservation extends JPanel {
	private JTextField txt_groom;
	private JTextField txt_bride;
	private JTextField txt_phone;
	private JTextField txt_table;
	private JTextField txt_extra_table;

	/**
	 * Create the panel.
	 */
	public JSecondStepReservation(Reservation reservation) {
		setBackground(Color.WHITE);
		setLayout(null);

		txt_groom = new JTextField();
		txt_groom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				reservation.setGroom(txt_groom.getText());
			}
		});
		txt_groom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_groom.setBounds(34, 130, 192, 26);
		add(txt_groom);
		txt_groom.setColumns(10);

		txt_bride = new JTextField();
		txt_bride.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				reservation.setBride(txt_bride.getText());
				System.out.println(reservation.getBride());
			}
		});
		txt_bride.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_bride.setBounds(267, 130, 192, 26);
		add(txt_bride);
		txt_bride.setColumns(10);

		txt_phone = new JTextField();
		txt_phone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				reservation.setPhone(txt_phone.getText());
			}
		});
		txt_phone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_phone.setBounds(34, 216, 121, 26);
		add(txt_phone);
		txt_phone.setColumns(10);

		txt_table = new JTextField();
		txt_table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_table.getText() != null)
					reservation.setTableQuantity(Integer.parseInt(txt_table.getText()));
				else {
					txt_table.setText("0");
					reservation.setTableQuantity(Integer.parseInt(txt_table.getText()));
				}
			}
		});
		txt_table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_table.setBounds(194, 216, 129, 26);
		add(txt_table);
		txt_table.setColumns(10);

		txt_extra_table = new JTextField();
		txt_extra_table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txt_extra_table.getText() != null)
					reservation.setReservedTable(Integer.parseInt(txt_extra_table.getText()));
				else {
					txt_extra_table.setText("0");
					reservation.setReservedTable(Integer.parseInt(txt_extra_table.getText()));
				}
			}
		});
		txt_extra_table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_extra_table.setBounds(364, 216, 95, 26);
		add(txt_extra_table);
		txt_extra_table.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name of Groom");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(34, 102, 136, 17);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Extra Tables");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(364, 188, 95, 17);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Phone Number");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(34, 188, 121, 17);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Name of Bride");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setBounds(267, 102, 136, 17);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Number of Tables");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4.setBounds(194, 188, 129, 17);
		add(lblNewLabel_4);

	}

}
