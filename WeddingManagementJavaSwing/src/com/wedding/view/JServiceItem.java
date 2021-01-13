package com.wedding.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.wedding.model.Service;

public class JServiceItem extends JPanel {

	private JServicePanel service_panel;
	private int id;

	/**
	 * Create the panel.
	 */
	public JServiceItem(JServicePanel service_panel, Service service) {
		this.service_panel = service_panel;
		this.id = service.getServiceID();
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		
		/* utils */
		Color edit_btn_bg = new Color(255, 193, 7);
		Color delete_btn_bg = new Color(220, 53, 69);
		Color item_border = new Color(222, 226, 230);
		
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, item_border));
		
		// Food name
		JLabel txt_name = new JLabel("New label");
		txt_name.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_name.setBounds(10, 15, 151, 25);
		txt_name.setText(service.getServiceName());
		add(txt_name);
		
		// Food Price
		JLabel txt_price = new JLabel("New label");
		txt_price.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txt_price.setBounds(250, 15, 89, 25);
		txt_price.setText(String.valueOf(service.getServicePrice()));
		add(txt_price);


		// Delete button
		JButton btn_delete = new JButton("Delete");
		btn_delete.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_delete.setBackground(delete_btn_bg);
		btn_delete.setBorderPainted(false);
		btn_delete.setBorder(new LineBorder(new Color(255, 193, 7), 5, true));
		btn_delete.setBounds(474, 13, 46, 32);
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				service_panel.DeleteService(id);
			}
		});
		add(btn_delete);

		// edit button
		JButton btn_edit = new JButton("Edit");
		btn_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_edit.setBackground(edit_btn_bg);
		btn_edit.setBorderPainted(false);
		btn_edit.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn_edit.setBorder(new LineBorder(new Color(255, 193, 7), 5, true));
		btn_edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				service_panel.GetServiceById(service.getServiceID());
			}
		});
		btn_edit.setBounds(418, 13, 46, 32);
		add(btn_edit);

	}
}
