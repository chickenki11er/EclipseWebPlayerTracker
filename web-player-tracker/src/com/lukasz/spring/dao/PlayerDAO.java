package com.lukasz.spring.dao;

import java.util.List;

import com.lukasz.spring.entity.Player;

public interface PlayerDAO {

	public List<Player> getPlayers();

	public void savePlayer(Player thePlayer);

	public Player getPlayer(int theId);

	public void deletePlayer(int theId);

	public List<Player> searchPlayers(String theSearchName);

	
}
