package com.wedding.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.wedding.model.Reservation;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLastStepReservation extends JPanel {
	private JTextField txt_deposit;
	private Reservation reservation;

	private JLabel txt_cost_wedding, txt_bride, txt_table, txt_groom, txt_price_table, txt_cost_service, txt_balance,
			txt_total_cost_table, txt_payment_date, txt_wedding_date, txt_phone;
	private int totalWeddingCost;

	/**
	 * Create the panel.
	 */
	public JLastStepReservation(Reservation reservation) {
		Color btn_bg = new Color(147, 165, 172);
		setBackground(Color.WHITE);
		this.reservation = reservation;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Name of Groom");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 119, 18);
		add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Name of Bride");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(265, 11, 101, 18);
		add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Wedding date");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4.setBounds(250, 261, 101, 18);
		add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("Total of Table");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 61, 111, 19);
		add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Price per Table");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 111, 119, 19);
		add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Total Service Cost");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 161, 129, 18);
		add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Deposit");
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_9.setBounds(10, 214, 53, 15);
		add(lblNewLabel_9);

		JLabel lblNewLabel_11 = new JLabel("Total Cost of Table");
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_11.setBounds(265, 111, 143, 19);
		add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Total Wedding Cost");
		lblNewLabel_12.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_12.setBounds(265, 161, 143, 18);
		add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Payment date");
		lblNewLabel_13.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_13.setBounds(10, 261, 101, 18);
		add(lblNewLabel_13);

		JLabel lblNewLabel_15 = new JLabel("Balance");
		lblNewLabel_15.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_15.setBounds(240, 214, 77, 15);
		add(lblNewLabel_15);

		JLabel lblNewLabel_1 = new JLabel("Phone");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1.setBounds(271, 61, 46, 19);
		add(lblNewLabel_1);

		// data reservation

		txt_cost_wedding = new JLabel();
		txt_cost_wedding.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_cost_wedding.setBounds(406, 161, 77, 18);
		add(txt_cost_wedding);

		txt_bride = new JLabel();
		txt_bride.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_bride.setBounds(376, 11, 119, 18);
		add(txt_bride);

		txt_table = new JLabel();
		txt_table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_table.setBounds(121, 61, 77, 19);
		add(txt_table);

		txt_groom = new JLabel();
		txt_groom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_groom.setBounds(131, 11, 119, 18);
		add(txt_groom);

		txt_price_table = new JLabel();
		txt_price_table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_price_table.setBounds(131, 111, 77, 19);
		add(txt_price_table);

		txt_cost_service = new JLabel();
		txt_cost_service.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_cost_service.setBounds(159, 161, 91, 18);
		add(txt_cost_service);

		txt_balance = new JLabel();
		txt_balance.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_balance.setBounds(327, 214, 88, 15);
		add(txt_balance);

		txt_deposit = new JTextField();
		txt_deposit.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				reservation.setDeposit(Integer.parseInt(txt_deposit.getText()));
				int balance = totalWeddingCost - reservation.getDeposit();
				txt_balance.setText(String.valueOf(balance));
			}
		});
		txt_deposit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_deposit.setBounds(73, 211, 86, 18);
		add(txt_deposit);
		txt_deposit.setColumns(10);

		

		txt_total_cost_table = new JLabel();
		txt_total_cost_table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_total_cost_table.setBounds(406, 111, 77, 19);
		add(txt_total_cost_table);

		txt_payment_date = new JLabel(java.time.LocalDate.now().toString());
		txt_payment_date.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_payment_date.setBounds(121, 261, 77, 18);
		add(txt_payment_date);

		txt_wedding_date = new JLabel();
		txt_wedding_date.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_wedding_date.setBounds(361, 261, 77, 18);
		add(txt_wedding_date);

		txt_phone = new JLabel();
		txt_phone.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_phone.setBounds(327, 61, 101, 19);
		add(txt_phone);

		Color item_border = new Color(222, 226, 230);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, item_border));
		panel_1.setBounds(0, 101, 505, 92);
		add(panel_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(0, 0, 1, 0, item_border));
		panel.setBounds(0, 0, 505, 92);
		add(panel);

	}

	public void BindData() {
		int totalTable = reservation.getReservedTable() + reservation.getTableQuantity();
		totalWeddingCost = reservation.getTablePrice() * totalTable + reservation.getTotalServicePrice();

		txt_cost_wedding.setText(String.valueOf(totalWeddingCost));

		txt_bride.setText(reservation.getBride());

		txt_table.setText(String.valueOf(totalTable));

		txt_groom.setText(reservation.getGroom());

		txt_price_table.setText(String.valueOf(reservation.getTablePrice()));

		txt_cost_service.setText(String.valueOf(reservation.getTotalServicePrice()));

		txt_balance.setText(String.valueOf(totalWeddingCost));

		txt_total_cost_table.setText(String.valueOf(reservation.getTablePrice() * totalTable));

		txt_payment_date.setText(java.time.LocalDate.now().toString());

		txt_wedding_date.setText(reservation.getWeddingDate());

		txt_phone.setText(reservation.getPhone());

	}
}
