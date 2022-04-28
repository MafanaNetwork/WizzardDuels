package me.TahaCheji.game.scoreboard;

import fr.mrmicky.fastboard.FastBoard;
import me.TahaCheji.gameData.Game;
import me.TahaCheji.gameData.GamePlayer;
import me.TahaCheji.scoreboard.GameScoreboard;
import org.bukkit.ChatColor;

public class InGameLobbyScoreboard extends GameScoreboard {

    Game game;

    public InGameLobbyScoreboard(Game game) {
        super(ChatColor.GOLD + "**WizzardDuels**");
        this.game = game;
    }

    @Override
    public void updateBoard(FastBoard board, GamePlayer gamePlayer) {
        board.updateLines(
                ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-",
                "",
                ChatColor.GRAY + ">> " + ChatColor.GOLD + "Name: " + game.getName() + " | Mode: " +
                        game.getGameMode().toString() + " | Map: " + game.getMap().getName(),
                "",
                ChatColor.GRAY + ">> " + ChatColor.GOLD + "Game Time: " + game.getMaxGameTime(),
                "",
                ChatColor.GRAY + ">> " + ChatColor.GOLD + "Players: " + game.getPlayers().size() + "/" + game.getMaxPlayers(),
                "",
                ChatColor.GOLD + "-=-=-=-Mafana.us.to-=-=-=-"
        );
    }
}
