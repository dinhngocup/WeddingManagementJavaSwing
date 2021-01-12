package com.wedding.view;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.UIManager;

import com.wedding.model.Food;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFoodItem extends JPanel {
private JFoodPanel food_panel;
private int id;
	/**
	 * Create the panel.
	 */
	public JFoodItem(JFoodPanel food_panel, Food food) {
		this.food_panel = food_panel;
		this.id = food.getFoodID();
		setBackground(UIManager.getColor("Button.darkShadow"));
		setLayout(null);
		
		JLabel txt_no = new JLabel("New label");
		txt_no.setBounds(10, 15, 46, 14);
		add(txt_no);
		
		JLabel txt_name = new JLabel("New label");
		txt_name.setBounds(114, 15, 46, 14);
		add(txt_name);
		
		JLabel txt_price = new JLabel("New label");
		txt_price.setBounds(194, 15, 46, 14);
		add(txt_price);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.setBounds(346, 11, 89, 23);
		add(btn_delete);
		
		JButton btn_edit = new JButton("Edit");
		btn_edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				food_panel.GetFoodById(food.getFoodID());
			}
		});
		btn_edit.setBounds(250, 11, 89, 23);
		add(btn_edit);
		txt_no.setText("1");
		txt_name.setText(food.getFoodName());
		txt_price.setText(String.valueOf(food.getFoodPrice()));
	}
}
