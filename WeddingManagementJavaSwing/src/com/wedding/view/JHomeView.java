package com.wedding.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class JHomeView extends JFrame {

	private JPanel contentPane;
	private JPanel currentPane;
private JHomeView homePanel;
	private JPanel renderingBodyPane;

	// 1 is servicepanel- 2 is foodpanel
//	private int typePanelIsRendering = 1;

	@Override
	protected void frameInit() {
		// TODO Auto-generated method stub
		super.frameInit();
	}

	/**
	 * Create the frame.
	 */
	public JHomeView() {
		homePanel = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 481);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* util */
		Color nav_background = new Color(255, 150, 165);
		Color nav_background_hover = new Color(147, 165, 172);
		Color font_nav = new Color(255, 255, 255, 100);
		String basePath = new File("").getAbsolutePath();

		/* Header */
		JPanel header = new JPanel();
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 746, 47);
		contentPane.add(header);
		header.setLayout(null);

		JLabel icon_clock = new JLabel("asdfasdfasd");
		icon_clock.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//clock.png"));
		icon_clock.setBounds(162, 3, 32, 40);
		header.add(icon_clock);

		JLabel lbl_time = new JLabel("New label");
		lbl_time.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lbl_time.setBounds(212, 16, 89, 14);
		header.add(lbl_time);

		JLabel lbl_date = new JLabel();
		lbl_date.setForeground(nav_background);
		lbl_date.setFont(new Font("Segoe UI", Font.BOLD, 24));
		Date date = new Date();
		lbl_date.setText(String.valueOf(date.getDate()));
		lbl_date.setBounds(335, 5, 32, 32);
		header.add(lbl_date);

		JLabel lbl_year = new JLabel("January 2021");
		lbl_year.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_year.setBounds(377, 5, 79, 14);
		header.add(lbl_year);

		JLabel lbl_day = new JLabel("");

		lbl_day.setText(convertDayToString(date.getDay()));
		System.out.println(date.getDay());
		lbl_day.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_day.setBounds(377, 27, 62, 14);
		header.add(lbl_day);

		final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		ActionListener timerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				String time = timeFormat.format(date);
				lbl_time.setText(time);
			}
		};
		Timer timer = new Timer(1000, timerListener);
		// to make sure it doesn't wait one second at the start
		timer.setInitialDelay(0);
		timer.start();

		/* Nav */
		JPanel nav = new JPanel();
		nav.setBackground(nav_background);
		nav.setBounds(10, 46, 142, 343);

		contentPane.add(nav);
		nav.setLayout(null);

		/* Service Nav */
		JPanel nav_service = new JPanel();
		nav_service.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JPanel parent = (JPanel) e.getSource();
				nav_service.setBackground(nav_background_hover);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (currentPane != nav_service) {
					nav_service.setBackground(nav_background);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (currentPane != nav_service) {
					remove(renderingBodyPane);
					contentPane.remove(renderingBodyPane);
					JServicePanel service_panel = new JServicePanel();
					service_panel.setBounds(152, 46, 594, 406);
					service_panel.setVisible(false);
					contentPane.add(service_panel);
					renderingBodyPane = service_panel;

					service_panel.setVisible(true);
					service_panel.GetServices();
					nav_service.setBackground(nav_background_hover);
					currentPane.setBackground(nav_background);
					currentPane = nav_service;
				}
			}
		});
		nav_service.setLayout(null);
		nav_service.setBackground(nav_background);
		nav_service.setBounds(0, 11, 142, 37);

		nav.add(nav_service);

		JLabel icon_service = new JLabel("");
		icon_service.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//service_white.png"));
		icon_service.setBounds(10, 3, 32, 32);

		nav_service.add(icon_service);

		JLabel lbl_service = new JLabel("Service");
		lbl_service.setForeground(Color.WHITE);
		lbl_service.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lbl_service.setBounds(52, 6, 90, 23);
		nav_service.add(lbl_service);

		/* Lobby Nav */
		JPanel nav_lobby = new JPanel();

		nav_lobby.setLayout(null);
		nav_lobby.setBackground(nav_background);
		nav_lobby.setBounds(0, 83, 142, 37);
		nav_lobby.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nav_lobby.setBackground(nav_background_hover);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				nav_lobby.setBackground(nav_background);
			}
		});
		nav.add(nav_lobby);

		JLabel icon_lobby = new JLabel("");
		icon_lobby.setBounds(10, 3, 32, 32);
		icon_lobby.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//lobby_white.png"));
		nav_lobby.add(icon_lobby);

		JLabel lbl_lobby = new JLabel("Lobby");
		lbl_lobby.setForeground(Color.WHITE);
		lbl_lobby.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lbl_lobby.setBounds(52, 6, 90, 23);
		nav_lobby.add(lbl_lobby);

		/* Food Nav */
		JPanel nav_food = new JPanel();
		nav_food.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nav_food.setBackground(nav_background_hover);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (currentPane != nav_food) {
					nav_food.setBackground(nav_background);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (currentPane != nav_food) {

					remove(renderingBodyPane);
					contentPane.remove(renderingBodyPane);
					JFoodPanel food_panel = new JFoodPanel();
					food_panel.setBounds(152, 46, 594, 406);
					food_panel.setVisible(false);
					contentPane.add(food_panel);
					renderingBodyPane = food_panel;

					food_panel.setVisible(true);
					food_panel.GetFoods();
					nav_food.setBackground(nav_background_hover);
					currentPane.setBackground(nav_background);
					currentPane = nav_food;
				}
			}
		});
		nav_food.setLayout(null);
		nav_food.setBackground(nav_background);
		nav_food.setBounds(0, 157, 142, 37);
		nav.add(nav_food);

		JLabel icon_food = new JLabel("");
		icon_food.setBounds(10, 3, 32, 32);
		icon_food.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//food_white.png"));
		nav_food.add(icon_food);

		JLabel lbl_food = new JLabel("Food");
		lbl_food.setForeground(Color.WHITE);
		lbl_food.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lbl_food.setBounds(52, 6, 90, 23);
		nav_food.add(lbl_food);

		/* Wedding Nav */
		JPanel nav_wedding = new JPanel();

		nav_wedding.setLayout(null);
		nav_wedding.setBackground(nav_background);
		nav_wedding.setBounds(0, 229, 142, 37);
		nav_wedding.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nav_wedding.setBackground(nav_background_hover);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				nav_wedding.setBackground(nav_background);
			}
		});
		nav.add(nav_wedding);

		JLabel icon_wedding = new JLabel("");
		icon_wedding.setBounds(10, 3, 32, 32);
		icon_wedding.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//wedding_white.png"));
		nav_wedding.add(icon_wedding);

		JLabel lbl_wedding = new JLabel("Payment");
		lbl_wedding.setForeground(Color.WHITE);
		lbl_wedding.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lbl_wedding.setBounds(52, 6, 90, 23);
		nav_wedding.add(lbl_wedding);

		JServicePanel service_panel = new JServicePanel();
		service_panel.setBounds(152, 46, 594, 406);
		service_panel.setVisible(false);
		contentPane.add(service_panel);
		service_panel.setVisible(true);
		service_panel.GetServices();
		nav_service.setBackground(nav_background_hover);
		currentPane = nav_service;

		/* Reservation Nav */
		JPanel nav_reservation = new JPanel();
		nav_reservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (currentPane != nav_reservation) {

					remove(renderingBodyPane);
					contentPane.remove(renderingBodyPane);
					JReservationPanel reservation_panel = new JReservationPanel(homePanel);
					reservation_panel.setVisible(false);
					reservation_panel.setBounds(152, 46, 594, 406);
					contentPane.add(reservation_panel);
					renderingBodyPane = reservation_panel;

					reservation_panel.setVisible(true);
					nav_reservation.setBackground(nav_background_hover);
					currentPane.setBackground(nav_background);
					
					currentPane = nav_reservation;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				nav_reservation.setBackground(nav_background_hover);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (currentPane != nav_reservation) {
					nav_reservation.setBackground(nav_background);
				}
			}
		});
		nav_reservation.setLayout(null);
		nav_reservation.setBackground(new Color(255, 150, 165));
		nav_reservation.setBounds(0, 295, 142, 37);
		nav.add(nav_reservation);

		JLabel icon_reservation = new JLabel("");
		icon_reservation.setIcon(new ImageIcon(basePath + "//WeddingManagementJavaSwing//images//reservation_white.png"));
		icon_reservation.setBounds(10, 3, 32, 32);
		nav_reservation.add(icon_reservation);

		JLabel lbl_reservation = new JLabel("Reservation");
		lbl_reservation.setForeground(Color.WHITE);
		lbl_reservation.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lbl_reservation.setBounds(52, 6, 90, 23);
		nav_reservation.add(lbl_reservation);
		renderingBodyPane = service_panel;
	}

	public String convertDayToString(int day) {
		switch (day) {
		case 2:
			return "Monday";
		case 3:
			return "Tuesday";
		case 4:
			return "Wednesday";
		case 5:
			return "Thursday";
		case 6:
			return "Friday";
		case 7:
			return "Saturday";
		case 0:
			return "Sunday";
		}
		return null;
	}
	public void NewReservation() {
		remove(renderingBodyPane);
		contentPane.remove(renderingBodyPane);
		JReservationPanel reservation_panel = new JReservationPanel(homePanel);
		reservation_panel.setBounds(152, 46, 594, 406);
		contentPane.add(reservation_panel);
		renderingBodyPane = reservation_panel;
		repaint();
		setVisible(true);
		reservation_panel.setVisible(true);
	}
}
