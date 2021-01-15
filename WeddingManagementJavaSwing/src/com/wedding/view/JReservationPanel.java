package com.wedding.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wedding.model.Reservation;
import com.wedding.service.ReservationService;
import com.wedding.serviceImpl.ReservationServiceImpl;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class JReservationPanel extends JPanel {
	private JTextField textField;
	private int currentPaneID;
	private JPanel currentPane;
	private Reservation reservation;
	private ReservationService reservationService;
	JLabel txt_title;
	/**
	 * Create the panel.
	 */
	public JReservationPanel(JHomeView homePanel) {
		setBackground(Color.WHITE);
		reservationService = new ReservationServiceImpl();
		String basePath = new File("").getAbsolutePath();
		setLayout(null);
		
		 txt_title = new JLabel("Step 1: LOBBY");
		txt_title.setHorizontalAlignment(SwingConstants.CENTER);
		txt_title.setForeground(new Color(255, 150, 165));
		txt_title.setFont(new Font("Segoe UI", Font.BOLD, 17));
		txt_title.setBounds(44, 11, 502, 22);
		add(txt_title);
		
		reservation = new Reservation();
		
		JFirstStepReservation firstStepPanel = new JFirstStepReservation(reservation);
		JSecondStepReservation secondStepPanel = new JSecondStepReservation(reservation);
		JThirdStepReservation thirdStepPanel = new JThirdStepReservation(reservation);
		JFourthStepReservation fourthStepPanel = new JFourthStepReservation(reservation);
		JLastStepReservation lastStepPanel = new JLastStepReservation(reservation);
		
		secondStepPanel.setBounds(44, 44, 502, 351);
		thirdStepPanel.setBounds(44, 44, 502, 351);
		firstStepPanel.setBounds(44, 44, 502, 351);
		fourthStepPanel.setBounds(44, 44, 502, 351);
		lastStepPanel.setBounds(44, 44, 502, 351);
		
		add(firstStepPanel);
		add(secondStepPanel);
		add(thirdStepPanel);
		add(fourthStepPanel);
		add(lastStepPanel);
		
		
		secondStepPanel.setVisible(false);
		thirdStepPanel.setVisible(false);
		fourthStepPanel.setVisible(false);
		lastStepPanel.setVisible(false);
		
		currentPaneID = 1;
		currentPane = firstStepPanel;
		
		// btn next
		JButton btn_next = new JButton("");
		JButton btn_back = new JButton("");
		btn_back.setVisible(false);
		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(currentPane == firstStepPanel) {
					btn_back.setVisible(true);
					firstStepPanel.setVisible(false);
					secondStepPanel.setVisible(true);
					currentPane = secondStepPanel;
					currentPaneID = 2;
				} else if(currentPane == secondStepPanel) {
					thirdStepPanel.setVisible(true);
					secondStepPanel.setVisible(false);
					currentPane = thirdStepPanel;
					currentPaneID = 3;
				} else if(currentPane == thirdStepPanel) {
					thirdStepPanel.setVisible(false);
					fourthStepPanel.setVisible(true);
					currentPane = fourthStepPanel;
					currentPaneID = 4;
				} else if(currentPane == fourthStepPanel) {
					lastStepPanel.BindData();
					lastStepPanel.setVisible(true);
					fourthStepPanel.setVisible(false);
					currentPane = lastStepPanel;
					currentPaneID = 5;
					btn_next.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//done_btn.png"));
				} else if (currentPane == lastStepPanel) {
					reservation.setUserID(1);
					reservationService.addReservation(reservation);
					homePanel.NewReservation();
				}
				ChangeTitle();
			}
		});
		btn_next.setBackground(Color.WHITE);
		btn_next.setBounds(554, 192, 30, 30);
		btn_next.setBorderPainted(false);
		btn_next.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//next_btn.png"));
		add(btn_next);
		
		
		// btn back
		
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPane == secondStepPanel) {
					btn_back.setVisible(false);
					firstStepPanel.setVisible(true);
					secondStepPanel.setVisible(false);
					currentPane = firstStepPanel;
					currentPaneID = 1;
				} else if(currentPane == thirdStepPanel) {
					thirdStepPanel.setVisible(false);
					secondStepPanel.setVisible(true);
					currentPane = secondStepPanel;
					currentPaneID = 2;
				}  else if(currentPane == fourthStepPanel) {
					thirdStepPanel.setVisible(true);
					fourthStepPanel.setVisible(false);
					currentPane = thirdStepPanel;
					currentPaneID = 3;
				} else if(currentPane == lastStepPanel) {
					fourthStepPanel.setVisible(true);
					lastStepPanel.setVisible(false);
					btn_next.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//next_btn.png"));
					currentPane = fourthStepPanel;
					currentPaneID = 4;
				}
				ChangeTitle();
			}
		});
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(10, 192, 30, 30);
		btn_back.setBorderPainted(false);
		btn_back.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//back_btn.png"));
		add(btn_back);
		
	}
	public void ChangeTitle() {
		switch(currentPaneID) {
		case 1:
			txt_title.setText("Step 1: LOBBY");
			break;
		case 2:
			txt_title.setText("Step 2: WEDDING INFORMATION");
			break;
		case 3:
			txt_title.setText("Step 3: FOOD RESERVATION");
			break;
		case 4:
			txt_title.setText("Step 4: SERVICE RESERVATION");
			break;
		case 5:
			txt_title.setText("Step 5: YOUR INVOICE");
			break;
		}
	}
}
