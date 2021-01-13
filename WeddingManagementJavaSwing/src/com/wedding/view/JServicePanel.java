package com.wedding.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.wedding.model.Service;
import com.wedding.service.ServiceService;
import com.wedding.serviceImpl.ServiceServiceImpl;

public class JServicePanel extends JPanel {
	
	private ServiceService serviceService;
	private List<JServiceItem> serviceItems;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel lbl_title;
	private JButton btn_add;
	/**
	 * Create the panel.
	 */
	Color btn_add_bg = new Color(147, 165, 172);
	public JServicePanel() {
		setBorder(null);
		setBackground(Color.WHITE);
		setLayout(null);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setBounds(10, 48, 574, 300);
		
		add(panel);
		panel.setLayout(null);
		
		lbl_title = new JLabel("LIST SERVICE");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_title.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl_title.setBounds(219, 11, 163, 36);
		add(lbl_title);
		
		btn_add = new JButton("Add");
		
		
		btn_add.setForeground(Color.WHITE);

		btn_add.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btn_add.setBackground(btn_add_bg);
		btn_add.setBorderPainted(false);
		btn_add.setBorder(new LineBorder(new Color(147, 165, 172), 7, true));
		
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_add.setVisible(false);
				RenderAddService();
			}
		});
		btn_add.setBounds(495, 359, 89, 23);
		add(btn_add);
		serviceService = new ServiceServiceImpl();
		serviceItems = new ArrayList<JServiceItem>();
	}

	public void GetServices() {
		List<Service> services = serviceService.getAllService();
		panel.setVisible(true);
		btn_add.setVisible(true);
		int index = 0;
		serviceItems.clear();
		for (Service service : services) {
			JServiceItem service_item = new JServiceItem(this, service);
			service_item.setBounds(0, 54 * index, 530, 54);
			service_item.setVisible(true);
			panel.add(service_item);
			serviceItems.add(service_item);
			index++;
		}
	}

	public void GetServiceById(int id) {
		lbl_title.setText("UPDATE SERVICE");
		HideListService();
		List<Service> services = serviceService.getAllService();
		for (Service service : services) {
			if (service.getServiceID() == id) {
				JServiceDetail serviceDetail = new JServiceDetail(this, service);
				serviceDetail.setBounds(10, 48, 574, 300);
				serviceDetail.setVisible(true);
				add(serviceDetail);
				return;
			}
		}
	}

	public void RenderAddService() {
		lbl_title.setText("NEW SERVICE");
		HideListService();
		JServiceDetail serviceDetail = new JServiceDetail(this);
		serviceDetail.setBounds(10, 48, 574, 300);
		serviceDetail.setVisible(true);
		add(serviceDetail);
	}
	public void HideListService() {
		for (JServiceItem serviceItem : serviceItems) {
			serviceItem.setVisible(false);
			panel.remove(serviceItem);
		}
		panel.setVisible(false);
		btn_add.setVisible(false);
		serviceItems.clear();
	}
	
	public void AddService(Service service) {
		if(service != null) {
			serviceService.addService(service);
			GetServices();
		}
	}
	
	public void DeleteService(int id) {
		serviceService.deleteService(id);
		HideListService();
		GetServices();
	}
	
	public void  UpdateService(Service service) {
		if(service != null) {
			serviceService.updateService(service);
			GetServices();
		}
	}
}
