package com.wedding.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.wedding.model.Service;

public class JServiceDetail extends JPanel {
	
	private JTextField txt_name;
	private JTextField txt_price;

	private Service service;

	Color btn_confirm_bg = new Color(147, 165, 172);

	/**
	 * Create the panel.
	 */
	public JServiceDetail() {
		setBackground(Color.WHITE);

		setLayout(null);

	}

	public JServiceDetail(JServicePanel service_panel, Service service) {
		this.service = service;
		setBackground(Color.WHITE);
		setLayout(null);
		// setBounds(10, 48, 574, 300);
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_name.setBounds(98, 60, 60, 14);
		add(lbl_name);

		JLabel lbl_price = new JLabel("Price");
		lbl_price.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_price.setBounds(98, 113, 60, 14);
		add(lbl_price);

		txt_name = new JTextField(service.getServiceName());
		txt_name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_name.setBounds(232, 53, 249, 28);
		add(txt_name);
		txt_name.setColumns(10);

		txt_price = new JTextField(String.valueOf(service.getServicePrice()));
		txt_price.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_price.setBounds(232, 106, 249, 26);
		add(txt_price);
		txt_price.setColumns(10);

		JButton btn_confirm = new JButton("OK");
		btn_confirm.setForeground(Color.WHITE);
		btn_confirm.setBounds(408, 220, 48, 23);

		btn_confirm.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_confirm.setBackground(btn_confirm_bg);
		btn_confirm.setBorderPainted(false);
		btn_confirm.setBorder(new LineBorder(new Color(147, 165, 172), 7, true));
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service serviceUpdate = new Service();
				serviceUpdate.setServiceID(service.getServiceID());
				serviceUpdate.setServiceName(txt_name.getText());
				int servicePrice = Integer.parseInt(txt_price.getText());
				serviceUpdate.setServicePrice(servicePrice);
				service_panel.UpdateService(serviceUpdate);
				service_panel.setVisible(true);
				setVisible(false);
			}
		});
		add(btn_confirm);

		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		// btn_cancel.setBorderPainted(false);
		btn_cancel.setBorder(new LineBorder(new Color(147, 165, 172), 2, true));
		btn_cancel.setBackground(Color.WHITE);
		btn_cancel.setBounds(466, 220, 86, 23);
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service_panel.GetServices();
				service_panel.setVisible(true);
				setVisible(false);
			}
		});
		add(btn_cancel);

	}

	public JServiceDetail(JServicePanel service_panel) {
		setBackground(Color.WHITE);
		setLayout(null);
		// setBounds(10, 48, 574, 300);
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_name.setBounds(98, 60, 60, 14);
		add(lbl_name);

		JLabel lbl_price = new JLabel("Price");
		lbl_price.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_price.setBounds(98, 113, 60, 14);
		add(lbl_price);


		txt_name = new JTextField();
		txt_name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_name.setBounds(232, 53, 249, 28);
		add(txt_name);
		txt_name.setColumns(10);

		txt_price = new JTextField();
		txt_price.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_price.setBounds(232, 106, 249, 26);
		add(txt_price);
		txt_price.setColumns(10);

		JButton btn_confirm = new JButton("OK");
		btn_confirm.setForeground(Color.WHITE);
		btn_confirm.setBounds(408, 220, 48, 23);

		btn_confirm.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_confirm.setBackground(btn_confirm_bg);
		btn_confirm.setBorderPainted(false);
		btn_confirm.setBorder(new LineBorder(new Color(147, 165, 172), 7, true));
		btn_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service service = new Service();
				service.setServiceName(txt_name.getText());
				int servicePrice = Integer.parseInt(txt_price.getText());
				service.setServicePrice(servicePrice);
				service_panel.AddService(service);
				service_panel.setVisible(true);
				setVisible(false);
			}
		});
		add(btn_confirm);

		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btn_cancel.setFont(new Font("Segoe UI", Font.BOLD, 15));

		btn_cancel.setBorder(new LineBorder(new Color(147, 165, 172), 2, true));
		btn_cancel.setBackground(Color.WHITE);
		btn_cancel.setBounds(466, 220, 86, 23);
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service_panel.GetServices();
				service_panel.setVisible(true);
				setVisible(false);
			}
		});
		add(btn_cancel);
	}
}
