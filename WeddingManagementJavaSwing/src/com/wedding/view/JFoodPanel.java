package com.wedding.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.wedding.model.Food;
import com.wedding.service.FoodService;
import com.wedding.serviceImpl.FoodServiceImpl;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class JFoodPanel extends JPanel {

	private FoodService foodService;
	private List<JFoodItem> foodItems;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel lbl_title;
	private JButton btn_add;
	/**
	 * Create the panel.
	 */
	Color btn_add_bg = new Color(147, 165, 172);
	public JFoodPanel() {
		
		
		
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		
		lbl_title = new JLabel("LIST FOOD");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl_title.setBounds(219, 11, 163, 36);
		add(lbl_title);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setBounds(10, 48, 574, 300);
		
		add(panel);
		panel.setLayout(null);
		
		
		
		btn_add = new JButton("Add");
		
		
		btn_add.setForeground(Color.WHITE);

		btn_add.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_add.setBackground(btn_add_bg);
		btn_add.setBorderPainted(false);
		btn_add.setBorder(new LineBorder(new Color(147, 165, 172), 7, true));
		
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_add.setVisible(false);
				RenderAddFood();
			}
		});
		btn_add.setBounds(495, 359, 89, 23);
		add(btn_add);
		foodService = new FoodServiceImpl();
		foodItems = new ArrayList<JFoodItem>();
	}

	public void GetFoods() {
		List<Food> foods = foodService.getAllFood();
		panel.setVisible(true);
		btn_add.setVisible(true);
		int index = 0;
		foodItems.clear();
		for (Food food : foods) {
			JFoodItem food_item = new JFoodItem(this, food);
			food_item.setBounds(0, 54 * index, 530, 54);
			food_item.setVisible(true);
			panel.add(food_item);
			foodItems.add(food_item);
			index++;
		}
	}

	public void GetFoodById(int id) {
		lbl_title.setText("UPDATE FOOD");
		HideListFood();
		List<Food> foods = foodService.getAllFood();
		for (Food food : foods) {
			if (food.getFoodID() == id) {
				JFoodDetail foodDetail = new JFoodDetail(this, food);
				foodDetail.setBounds(10, 48, 574, 300);
				foodDetail.setVisible(true);
				add(foodDetail);
				return;
			}
		}
	}

	public void RenderAddFood() {
		lbl_title.setText("NEW FOOD");
		HideListFood();
		JFoodDetail foodDetail = new JFoodDetail(this);
		foodDetail.setBounds(10, 48, 574, 300);
		foodDetail.setVisible(true);
		add(foodDetail);
	}
	public void HideListFood() {
		for (JFoodItem foodItem : foodItems) {
			foodItem.setVisible(false);
			panel.remove(foodItem);
		}
		panel.setVisible(false);
		btn_add.setVisible(false);
		foodItems.clear();
	}
	
	public void AddFood(Food food) {
		if(food != null) {
			foodService.addFood(food);
			GetFoods();
		}
	}
	
	public void UpdateFood(Food food) {
		if(food != null) {
			System.out.println("aaaaaaaa " + food.getFoodID());
			System.out.println("aaaaaaaa " + food.getFoodName());
			System.out.println("aaaaaaaa " + food.getFoodPrice());
			System.out.println("aaaaaaaa " + food.getFoodNote());
			foodService.updateFood(food);
			GetFoods();
		}
	}
	
	public void DeleteFood(int id) {
		foodService.deleteFood(id);
		HideListFood();
		GetFoods();
	}
	public void ShowDeleteDialog() {
		JDialog deleteDialog = new JDialog();
		add(deleteDialog);
	}
}
