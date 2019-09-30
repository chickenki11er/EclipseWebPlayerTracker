package com.lukasz.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lukasz.spring.dao.PlayerDAO;
import com.lukasz.spring.entity.Player;
import com.lukasz.spring.service.PlayerService;

@Controller
@RequestMapping("/Player")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/list")
	public String listPlayers(Model theModel) {
		
		// get players from service
		List<Player> thePlayers= playerService.getPlayers();
		
		// add the players to the model
		theModel.addAttribute("players", thePlayers);
		
		return "list-players";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
	
		//create model attribute to bind form data
		Player thePlayer= new Player();
		
		theModel.addAttribute("player",thePlayer);
		
		return "player-form";
	}
	
	@PostMapping("/savePlayer")
	public String savePlayer(@ModelAttribute("player") Player thePlayer) {

		//save the customer using service
		playerService.savePlayer(thePlayer);
		
		return "redirect:/Player/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("playerId") int theId, Model theModel) {
		
		//get the player from service
		Player thePlayer=playerService.getPlayer(theId);
		
		//set player as a model attribute to pre-populate form
		theModel.addAttribute("player",thePlayer);
		
		//send over to our form
		return "player-form";
	}
	
	@GetMapping("/delete")
	public String deletePlayer(@RequestParam("playerId")int theId) {
		
		//delete player
		playerService.deletePlayer(theId);
		
		return "redirect:/Player/list";
	}
	
	@GetMapping("/search")
	public String searchPlayer(@RequestParam("theSearchName")String theSearchName, Model theModel) {
		
		//search player from the service
		List<Player> thePlayers=playerService.searchPlayers(theSearchName);
		
		//add the player to the model
		theModel.addAttribute("players",thePlayers);
		
		return "list-players";
	}
}
