package com.wedding.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wedding.model.Food;
import com.wedding.service.FoodService;
import com.wedding.serviceImpl.FoodServiceImpl;

import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class JHomeView extends JFrame {

	private JPanel contentPane;
	
	


	@Override
	protected void frameInit() {
		// TODO Auto-generated method stub
		super.frameInit();
	}




	/**
	 * Create the frame.
	 */
	public JHomeView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel service_panel = new JPanel();
		service_panel.setBackground(Color.ORANGE);
		service_panel.setBounds(121, 46, 613, 347);
		contentPane.add(service_panel);
		service_panel.setLayout(null);
		
		
		
		JPanel header = new JPanel();
		header.setBackground(Color.DARK_GRAY);
		header.setBounds(0, 0, 734, 47);
		contentPane.add(header);
		
		JPanel nav = new JPanel();
		nav.setBounds(0, 46, 121, 347);
		contentPane.add(nav);
		nav.setLayout(null);
		
		JPanel nav_food = new JPanel();
		nav_food.setBackground(Color.CYAN);
		nav_food.setBounds(0, 93, 121, 27);
		nav.add(nav_food);
		
		JLabel lblNewLabel = new JLabel("Food");
		nav_food.add(lblNewLabel);
		
		JPanel nav_service = new JPanel();
		
		nav_service.setBackground(Color.CYAN);
		nav_service.setBounds(0, 145, 121, 27);
		nav.add(nav_service);
		
		JLabel lblService = new JLabel("Service");
		nav_service.add(lblService);
		
	
		
		nav_food.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFoodPanel food_panel = new JFoodPanel();
				food_panel.setBounds(121, 46, 613, 347);
				food_panel.GetFoods();
				service_panel.setVisible(false);
				add(food_panel);
			}
		});
		nav_service.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				service_panel.setVisible(true);
				//food_panel.setVisible(false);
			}
		});
		
	}
}
