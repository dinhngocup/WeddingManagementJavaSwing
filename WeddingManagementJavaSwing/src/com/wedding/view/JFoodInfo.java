package com.wedding.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.wedding.model.Food;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class JFoodInfo extends JPanel {
	/**
	 * Create the panel.
	 */
	public JFoodInfo(JThirdStepReservation panel, Food food) {
		setBackground(Color.WHITE);
		
		Color item_border = new Color(222, 226, 230);
		
		setBorder(new MatteBorder(0, 0, 1, 0, item_border));
		setLayout(null);
		
		JLabel txt_name = new JLabel("New label");
		txt_name.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_name.setBounds(10, 11, 137, 18);
		txt_name.setText(food.getFoodName());
		add(txt_name);
		
		JLabel txt_note = new JLabel("A");
		txt_note.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_note.setBounds(157, 11, 104, 18);
		txt_note.setText(food.getFoodNote());
		add(txt_note);
		
		JLabel txt_price = new JLabel("50");
		txt_price.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txt_price.setBounds(291, 9, 104, 20);
		txt_price.setText(String.valueOf(food.getFoodPrice()));
		add(txt_price);
		
		
		JRadioButton btn = new JRadioButton("");
		btn.setBackground(Color.WHITE);
		btn.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btn.setBounds(416, 9, 21, 21);
		add(btn);
		
		btn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           if(e.getSource() == btn){
	        	   if(btn.isSelected())
	        		   panel.AddFood(food);
	        	   else
	        		   panel.RemoveFood(food);
	           }
	        }
	    });
	}

}
