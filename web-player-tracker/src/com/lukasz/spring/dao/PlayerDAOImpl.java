package com.lukasz.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lukasz.spring.entity.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Player> getPlayers() {
		
		// get the current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		// create a query... sort by last name
		Query<Player> theQuery= currentSession.createQuery(" from Player order by lastName", Player.class);
		
		// execute a query and get result list
		List<Player> players= theQuery.getResultList();
		
		// return the results
		return players;
	}

	@Override
	public void savePlayer(Player thePlayer) {
		
		//get current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//save/update the player
		currentSession.saveOrUpdate(thePlayer);
		
	}

	@Override
	public Player getPlayer(int theId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//read from database using the primary key
		Player thePlayer=currentSession.get(Player.class,theId);
		
		return thePlayer;
	}

	@Override
	public void deletePlayer(int theId) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//delete the object with the primary key
		Query theQuery=currentSession.createQuery("delete from Player where id=:playerId");
		
		theQuery.setParameter("playerId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<Player> searchPlayers(String theSearchName) {
		
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query theQuery=null;
		
		//only search by name if theSearchName is not empty
		if(theSearchName!=null && theSearchName.trim().length()>0) {
			
			//search for first name or last name
			theQuery=currentSession.createQuery("from Player where lower(firstName) like :theName or lower(lastName) like :theName",Player.class);
			theQuery.setParameter("theName","%"+theSearchName.toLowerCase()+"%");
		
		}else {
			
			//theSearchName is empty...so just get all players
			theQuery=currentSession.createQuery("from Player",Player.class);
			
		}
		
		//execute query and get all results
		List<Player> players=theQuery.getResultList();
		
		//return the result
		return players;
	}

}
