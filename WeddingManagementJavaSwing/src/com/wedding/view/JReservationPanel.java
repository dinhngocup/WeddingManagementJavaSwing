package com.wedding.view;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.wedding.model.Reservation;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JReservationPanel extends JPanel {
	private JTextField textField;
	//private int currentPaneID;
	private JPanel currentPane;
	private Reservation reservation;
	/**
	 * Create the panel.
	 */
	public JReservationPanel() {
		setBackground(Color.LIGHT_GRAY);
		String basePath = new File("").getAbsolutePath();
		setLayout(null);
		
		reservation = new Reservation();
		
		JFirstStepReservation firstStepPanel = new JFirstStepReservation(reservation);
		JSecondStepReservation secondStepPanel = new JSecondStepReservation(reservation);
		JThirdStepReservation thirdStepPanel = new JThirdStepReservation(reservation);
		
		secondStepPanel.setBounds(44, 44, 502, 351);
		thirdStepPanel.setBounds(44, 44, 502, 351);
		firstStepPanel.setBounds(44, 44, 502, 351);
		
		add(firstStepPanel);
		add(secondStepPanel);
		add(thirdStepPanel);
		
		secondStepPanel.setVisible(false);
		thirdStepPanel.setVisible(false);
		
		//currentPaneID = 1;
		currentPane = firstStepPanel;
		
		// btn next
		JButton btn_next = new JButton("");
		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPane == firstStepPanel) {
					firstStepPanel.setVisible(false);
					secondStepPanel.setVisible(true);
					currentPane = secondStepPanel;
				} else if(currentPane == secondStepPanel) {
					thirdStepPanel.setVisible(true);
					secondStepPanel.setVisible(false);
					currentPane = thirdStepPanel;
				}
			}
		});
		btn_next.setBackground(Color.WHITE);
		btn_next.setBounds(554, 192, 30, 30);
		btn_next.setBorderPainted(false);
		btn_next.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//next_btn.png"));
		add(btn_next);
		
		
		// btn back
		JButton btn_back = new JButton("");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPane == secondStepPanel) {
					firstStepPanel.setVisible(true);
					secondStepPanel.setVisible(false);
					currentPane = firstStepPanel;
				} else if(currentPane == thirdStepPanel) {
					thirdStepPanel.setVisible(false);
					secondStepPanel.setVisible(true);
					currentPane = secondStepPanel;
				}
			}
		});
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(10, 192, 30, 30);
		btn_back.setBorderPainted(false);
		btn_back.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//back_btn.png"));
		add(btn_back);
		
		
		
		
	}
}
