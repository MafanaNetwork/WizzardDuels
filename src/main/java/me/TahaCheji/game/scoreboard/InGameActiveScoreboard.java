package me.TahaCheji.game.scoreboard;

import fr.mrmicky.fastboard.FastBoard;
import me.TahaCheji.gameData.Game;
import me.TahaCheji.gameData.GamePlayer;
import me.TahaCheji.scoreboard.GameScoreboard;
import org.bukkit.ChatColor;

public class InGameActiveScoreboard extends GameScoreboard {

    Game game;

    public InGameActiveScoreboard(Game game) {
        super(ChatColor.GOLD + "**WizzardDuels**");
        this.game = game;
    }

    @Override
    public void updateBoard(FastBoard board, GamePlayer gamePlayer) {
        board.updateLines(
                ChatColor.GOLD + "=-=-=-=-=-=-=-=-=-=-=-=-",
                "",
                ChatColor.GRAY + ">> " + ChatColor.GOLD + "Time Left: " + game.getGameTime(),
                "",
                ChatColor.GRAY + ">> " + ChatColor.GOLD + "Players Alive: " + game.getPlayers().size(),
                "",
                ChatColor.GRAY + ">> " + ChatColor.GOLD + "Kills: " + gamePlayer.getKills(),
                "",
                ChatColor.GOLD + "-=-=-=-Mafana.us.to-=-=-=-"
                );
    }
}
