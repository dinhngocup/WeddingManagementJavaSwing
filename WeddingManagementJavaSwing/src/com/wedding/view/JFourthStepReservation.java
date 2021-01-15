package com.wedding.view;

import java.util.List;

import javax.swing.JPanel;

import com.wedding.model.Reservation;
import com.wedding.model.Service;
import com.wedding.model.ServicePair;
import com.wedding.service.ServiceService;
import com.wedding.serviceImpl.ServiceServiceImpl;
import java.awt.Color;

public class JFourthStepReservation extends JPanel {
	private ServiceService serviceService;
	private Reservation reservation;
	private JFourthStepReservation panel;
	/**
	 * Create the panel.
	 */
	public JFourthStepReservation(Reservation reservation) {
		setBackground(Color.WHITE);
		panel = this;
		this.reservation = reservation;
		setLayout(null);
		serviceService = new ServiceServiceImpl();
		List<Service> services = serviceService.getAllService();

		int index = 0;
		for (Service service : services) {
			//System.out.println(service.getServiceName());
			JServiceInfo service_item = new JServiceInfo(panel, service);
			service_item.setBounds(23, 5 + 39 * index, 455, 39);
			panel.add(service_item);
			index++;
		}

	}
	public void AddService(ServicePair service, int price) {
		reservation.getListServiceReservation().add(service);
		int servicePrice = reservation.getTotalServicePrice();
		servicePrice = servicePrice + price;
		reservation.setTotalServicePrice(servicePrice);
		//System.out.println("service price" + reservation.getTotalServicePrice());
	}

	public void RemoveService(ServicePair service, int price) {
		List<ServicePair> listService = reservation.getListServiceReservation();
		for (int i = 0; i < listService.size(); i++) {
			if (listService.get(i).getServiceID() == service.getServiceID()) {
				listService.remove(i);
				int servicePrice = reservation.getTotalServicePrice();
				servicePrice = servicePrice - price * service.getServiceQuantity();
				reservation.setTotalServicePrice(servicePrice);
				//System.out.println("service price" + reservation.getTotalServicePrice());
				break;
			}
		}
	}
	
	public void EditQuantityService(ServicePair service, int price) {
		List<ServicePair> listService = reservation.getListServiceReservation();
		for (int i = 0; i < listService.size(); i++) {
			if (listService.get(i).getServiceID() == service.getServiceID()) {
				
				int servicePrice = reservation.getTotalServicePrice();
				servicePrice = servicePrice - price * listService.get(i).getServiceQuantity() + price * service.getServiceQuantity();
				
				listService.get(i).setServiceQuantity(service.getServiceQuantity());
				reservation.setTotalServicePrice(servicePrice);
				System.out.println("service price" + reservation.getTotalServicePrice());
				return;
			}

		}
	}
}
