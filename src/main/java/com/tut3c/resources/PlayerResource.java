package com.tut3c.resources;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.tut3c.model.Player;

/**
 * The Ultimate Tic Tac Toe Challenge 2014
 * 
 * http://jugda.wordpress.com/termine/tic-tac-toe/
 */
@Path("/player")
@Produces({ "application/json" })
public class PlayerResource {

	public static final String PLAYERID = "playerid";

	public static Map<Integer, Player> players = new HashMap<>();

	private static Logger LOG = Logger.getLogger(PlayerResource.class);

	public static Player getPlayer(Map<String, Object> parameter) {
		return players.get(parameter.get(PLAYERID));
	}

	@POST
	@Consumes({ "application/json" })
	public Map<String, Object> register(Player player) {
		players.put(player.getId(), player);
		LOG.info("player name: " + player.getName());

		Map<String, Object> response = new HashMap<>();
		response.put(PLAYERID, player.getId());

		return response;
	}

	@GET
	public Collection<Player> get() {
		return players.values();
	}

}