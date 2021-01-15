package com.wedding.serviceImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wedding.model.Reservation;
import com.wedding.repository.ReservationRepository;
import com.wedding.service.ReservationService;

public class ReservationServiceImpl implements ReservationService {
	ReservationRepository reservationRepository;

	public ReservationServiceImpl() {
		reservationRepository = new ReservationRepository();
	}

	@Override
	public void addReservation(Reservation reservation) {
		reservationRepository.add(reservation);
	}

	
	
}
