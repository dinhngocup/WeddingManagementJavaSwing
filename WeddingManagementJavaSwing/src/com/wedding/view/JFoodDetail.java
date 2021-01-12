package com.wedding.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.wedding.model.Food;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFoodDetail extends JPanel {
	private JTextField txt_name;
	private JTextField txt_price;
	private JTextField txt_note;

	private Food food;

	Color btn_confirm_bg = new Color(147, 165, 172);

	/**
	 * Create the panel.
	 */
	public JFoodDetail() {
		setBackground(Color.WHITE);

		setLayout(null);

	}

	public JFoodDetail(JFoodPanel food_panel, Food food) {
		this.food = food;
		setBackground(Color.WHITE);
		setLayout(null);
		// setBounds(10, 48, 574, 300);
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_name.setBounds(98, 60, 60, 14);
		add(lbl_name);

		JLabel lbl_price = new JLabel("Price");
		lbl_price.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_price.setBounds(98, 169, 60, 14);
		add(lbl_price);

		JLabel lbl_note = new JLabel("Note");
		lbl_note.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_note.setBounds(98, 113, 60, 14);
		add(lbl_note);

		txt_name = new JTextField(food.getFoodName());
		txt_name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_name.setBounds(232, 53, 249, 28);
		add(txt_name);
		txt_name.setColumns(10);

		txt_price = new JTextField(String.valueOf(food.getFoodPrice()));
		txt_price.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_price.setBounds(232, 163, 249, 26);
		add(txt_price);
		txt_price.setColumns(10);

		txt_note = new JTextField(food.getFoodNote());
		txt_note.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_note.setBounds(232, 106, 249, 28);
		add(txt_note);
		txt_note.setColumns(10);

		JButton btn_confirm = new JButton("OK");
		btn_confirm.setForeground(Color.WHITE);
		btn_confirm.setBounds(408, 220, 48, 23);

		btn_confirm.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_confirm.setBackground(btn_confirm_bg);
		btn_confirm.setBorderPainted(false);
		btn_confirm.setBorder(new LineBorder(new Color(147, 165, 172), 7, true));
		add(btn_confirm);

		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		// btn_cancel.setBorderPainted(false);
		btn_cancel.setBorder(new LineBorder(new Color(147, 165, 172), 2, true));
		btn_cancel.setBackground(Color.WHITE);
		btn_cancel.setBounds(466, 220, 86, 23);
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food_panel.GetFoods();
				food_panel.setVisible(true);
				setVisible(false);
			}
		});
		add(btn_cancel);

	}

	public JFoodDetail(JFoodPanel food_panel) {
		setBackground(Color.WHITE);
		setLayout(null);
		// setBounds(10, 48, 574, 300);
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_name.setBounds(98, 60, 60, 14);
		add(lbl_name);

		JLabel lbl_price = new JLabel("Price");
		lbl_price.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_price.setBounds(98, 169, 60, 14);
		add(lbl_price);

		JLabel lbl_note = new JLabel("Note");
		lbl_note.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lbl_note.setBounds(98, 113, 60, 14);
		add(lbl_note);

		txt_name = new JTextField();
		txt_name.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_name.setBounds(232, 53, 249, 28);
		add(txt_name);
		txt_name.setColumns(10);

		txt_price = new JTextField();
		txt_price.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_price.setBounds(232, 163, 249, 26);
		add(txt_price);
		txt_price.setColumns(10);

		txt_note = new JTextField();
		txt_note.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txt_note.setBounds(232, 106, 249, 28);
		add(txt_note);
		txt_note.setColumns(10);

		JButton btn_confirm = new JButton("OK");
		btn_confirm.setForeground(Color.WHITE);
		btn_confirm.setBounds(408, 220, 48, 23);

		btn_confirm.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_confirm.setBackground(btn_confirm_bg);
		btn_confirm.setBorderPainted(false);
		btn_confirm.setBorder(new LineBorder(new Color(147, 165, 172), 7, true));
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
				food_panel.GetFoods();
				food_panel.setVisible(true);
				setVisible(false);
			}
		});
		add(btn_cancel);
	}

}
