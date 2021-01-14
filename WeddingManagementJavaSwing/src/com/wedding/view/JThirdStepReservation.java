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

	public void AddFood(int foodID) {
		List<Integer> listFood = reservation.getListFoodID();
		listFood.add(foodID);
		//System.out.println(reservation.getListFoodID().size());
	}

	public void RemoveFood(int foodID) {
		List<Integer> listFoodID = reservation.getListFoodID();
		for (int i = 0; i < listFoodID.size(); i++) {
			if (listFoodID.get(i) == foodID)
				listFoodID.remove(i);

		}
		//reservation.getListFoodID().remove(foodID);
		//System.out.println(reservation.getListFoodID().size());
	}
}
