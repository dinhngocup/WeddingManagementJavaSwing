package com.wedding.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import com.wedding.model.Service;
import com.wedding.model.ServicePair;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JServiceInfo extends JPanel {
	private JTextField txt_quantity;

	/**
	 * Create the panel.
	 */
	public JServiceInfo(JFourthStepReservation panel, Service service) {
		setBackground(Color.WHITE);
		Color item_border = new Color(222, 226, 230);

		setBorder(new MatteBorder(0, 0, 1, 0, item_border));
		setLayout(null);

		JLabel txt_name = new JLabel("New label");
		txt_name.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_name.setBounds(10, 11, 137, 18);
		txt_name.setText(service.getServiceName());
		add(txt_name);

		JLabel txt_price = new JLabel("50");
		txt_price.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_price.setBounds(291, 9, 104, 20);
		txt_price.setText(String.valueOf(service.getServicePrice()));
		add(txt_price);

		JRadioButton btn = new JRadioButton("");
		btn.setBackground(Color.WHITE);
		btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btn.setBounds(416, 9, 21, 21);
		add(btn);

		txt_quantity = new JTextField();
		txt_quantity.setEditable(false);
		txt_quantity.setBackground(Color.LIGHT_GRAY);
		txt_quantity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int quantity = 0;
				if (txt_quantity.getText() != null)
					quantity = Integer.parseInt(txt_quantity.getText());
				if (quantity <= 0) {
					txt_quantity.setText("1");
				} else {
					ServicePair servicePair = new ServicePair(service.getServiceID(),
							Integer.parseInt(txt_quantity.getText()));
					panel.EditQuantityService(servicePair, service.getServicePrice());
				}
			}
		});
		txt_quantity.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_quantity.setBounds(157, 11, 86, 20);
		add(txt_quantity);
		txt_quantity.setColumns(10);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn) {
					if (btn.isSelected()) {
						txt_quantity.setEditable(true);
						txt_quantity.setBackground(Color.WHITE);
						txt_quantity.setText("1");
						ServicePair servicePair = new ServicePair(service.getServiceID(),
								Integer.parseInt(txt_quantity.getText()));
						panel.AddService(servicePair, service.getServicePrice());
					} else {
						txt_quantity.setEditable(false);
						ServicePair servicePair = new ServicePair(service.getServiceID(),
								Integer.parseInt(txt_quantity.getText()));
						txt_quantity.setText("");
						panel.RemoveService(servicePair, service.getServicePrice());
					}
				}
			}
		});
	}
}
