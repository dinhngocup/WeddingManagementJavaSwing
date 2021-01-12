package com.wedding.view;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.wedding.model.Food;
import com.wedding.service.FoodService;
import com.wedding.serviceImpl.FoodServiceImpl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFoodPanel extends JPanel {

	private FoodService foodService;
	private List<JFoodItem> foodItems;
	/**
	 * Create the panel.
	 */
	public JFoodPanel() {
		setBackground(Color.PINK);
		setLayout(null);
		
		JButton btn_add = new JButton("Add");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFood();
			}
		});
		btn_add.setBounds(514, 313, 89, 23);
		add(btn_add);
		foodService = new FoodServiceImpl();
		foodItems = new ArrayList<JFoodItem>();
	}
	
	public void GetFoods() {
		List<Food> foods = foodService.getAllFood();
		int index = 0;
		foodItems.clear();
		for(Food food : foods) {
			JFoodItem food_item = new JFoodItem(this, food);
			System.out.println(food.getFoodName());
			food_item.setBounds(42, 42 + 45 * index, 475, 45);
			food_item.setVisible(true);
			add(food_item);
			foodItems.add(food_item);
			index ++;
		}
	}
	
	public void GetFoodById(int id) {
		for(JFoodItem foodItem : foodItems) {
			foodItem.setVisible(false);
			remove(foodItem);
		}
		foodItems.clear();
		List<Food> foods = foodService.getAllFood();
		for(Food food : foods) {
			if(food.getFoodID() == id) {
				JFoodDetail foodDetail = new JFoodDetail(food);
				foodDetail.setBounds(42,42,458,307);
				foodDetail.setVisible(true);
				add(foodDetail);
				return;
			}
		}
	}
	
	public void AddFood() {
		for(JFoodItem foodItem : foodItems) {
			foodItem.setVisible(false);
			remove(foodItem);
		}
		foodItems.clear();
		JFoodDetail foodDetail = new JFoodDetail();
		foodDetail.setBounds(42,42,458,307);
		foodDetail.setVisible(true);
		add(foodDetail);
	}

}
