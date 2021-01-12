package com.wedding.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wedding.model.Food;

import javax.swing.JButton;

public class JFoodDetail extends JPanel {
	private JTextField txt_name;
	private JTextField txt_price;
	private JTextField txt_note;
	
	private Food food;

	/**
	 * Create the panel.
	 */
	public JFoodDetail(Food food) {
		this.food = food;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(53, 56, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(53, 95, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblPrice = new JLabel("Note");
		lblPrice.setBounds(53, 132, 46, 14);
		add(lblPrice);
		
		txt_name = new JTextField();
		txt_name.setBounds(150, 53, 86, 20);
		add(txt_name);
		txt_name.setColumns(10);
		txt_name.setText(food.getFoodName());
		
		txt_price = new JTextField();
		txt_price.setBounds(150, 92, 86, 20);
		add(txt_price);
		txt_price.setColumns(10);
		txt_price.setText(String.valueOf(food.getFoodPrice()));
		
		txt_note = new JTextField();
		txt_note.setBounds(150, 129, 86, 20);
		add(txt_note);
		txt_note.setColumns(10);
		txt_note.setText(food.getFoodNote());
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(187, 193, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(301, 193, 89, 23);
		add(btnNewButton_1);

	}
	public JFoodDetail() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(53, 56, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setBounds(53, 95, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblPrice = new JLabel("Note");
		lblPrice.setBounds(53, 132, 46, 14);
		add(lblPrice);
		
		txt_name = new JTextField();
		txt_name.setBounds(150, 53, 86, 20);
		add(txt_name);
		txt_name.setColumns(10);
		
		txt_price = new JTextField();
		txt_price.setBounds(150, 92, 86, 20);
		add(txt_price);
		txt_price.setColumns(10);
		
		txt_note = new JTextField();
		txt_note.setBounds(150, 129, 86, 20);
		add(txt_note);
		txt_note.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(187, 193, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(301, 193, 89, 23);
		add(btnNewButton_1);
	}
}
