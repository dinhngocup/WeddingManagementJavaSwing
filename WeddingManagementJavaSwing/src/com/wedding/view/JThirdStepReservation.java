package com.wedding.view;

import java.util.List;

import javax.swing.JPanel;

import com.wedding.model.Food;
import com.wedding.model.Reservation;
import com.wedding.service.FoodService;
import com.wedding.serviceImpl.FoodServiceImpl;
import java.awt.Color;

public class JThirdStepReservation extends JPanel {
	// private List<Food> listFood;
	private FoodService foodService;
	private Reservation reservation;
	private JThirdStepReservation panel;

	/**
	 * Create the panel.
	 */
	public JThirdStepReservation(Reservation reservation) {
		this.reservation = reservation;
		setBackground(Color.WHITE);
		foodService = new FoodServiceImpl();
		this.reservation = reservation;
		panel = this;
		setLayout(null);
		List<Food> foods = foodService.getAllFood();

		int index = 0;
		for (Food food : foods) {
			// System.out.println(lobby.getLobbyName());
			JFoodInfo food_item = new JFoodInfo(panel, food);
			food_item.setBounds(23, 5 + 39 * index, 455, 39);
			panel.add(food_item);
			index++;
		}

	}

	public void AddFood(Food food) {
		List<Integer> listFood = reservation.getListFoodID();
		listFood.add(food.getFoodID());
		int tablePrice = reservation.getTablePrice();
		tablePrice = tablePrice + food.getFoodPrice();
		reservation.setTablePrice(tablePrice);
		//System.out.println("table price" + reservation.getTablePrice());
	}

	public void RemoveFood(Food food) {
		List<Integer> listFoodID = reservation.getListFoodID();
		for (int i = 0; i < listFoodID.size(); i++) {
			if (listFoodID.get(i) == food.getFoodID()) {
				listFoodID.remove(i);
				int tablePrice = reservation.getTablePrice();
				tablePrice = tablePrice - food.getFoodPrice();
				reservation.setTablePrice(tablePrice);
				//System.out.println("table price" + reservation.getTablePrice());
				break;
			}
		}
	}
}
