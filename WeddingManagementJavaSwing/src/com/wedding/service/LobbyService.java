package com.wedding.service;

import java.util.List;

import com.wedding.model.Lobby;

public interface LobbyService {
	List<Lobby> getAllLobby();
	void addLobby(Lobby sanh);
	void deleteLobby(int id);
	void updateLobby(Lobby sanh);
	List<Lobby> checkLobby(String weddingDate, int shift);
}
