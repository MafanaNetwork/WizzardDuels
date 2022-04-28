package me.TahaCheji.game;

import me.TahaCheji.game.scoreboard.InGameActiveScoreboard;
import me.TahaCheji.game.scoreboard.InGameLobbyScoreboard;
import me.TahaCheji.gameData.Game;
import me.TahaCheji.gameData.GameMode;
import me.TahaCheji.gameData.GamePlayer;
import me.TahaCheji.kit.Kit;
import me.TahaCheji.mapUtil.GameMap;
import me.TahaCheji.mapUtil.LocalGameMap;
import me.TahaCheji.scoreboard.GameScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NormalDuel extends Game {

    InGameLobbyScoreboard inGameLobbyScoreBoard = new InGameLobbyScoreboard(this);
    InGameActiveScoreboard inGameActiveScoreBoard = new InGameActiveScoreboard(this);

    public NormalDuel() {
        super("Normal 1v1", new ItemStack(Material.DIAMOND_AXE), GameMode.NORMAL,
                new LocalGameMap(new File("plugins/MafanaGameAPI/", "maps"), "Rome", false), 2);
        setMaxGameTime(250);
        setGameTime(getMaxGameTime());
        List<Location> spawnPoints = new ArrayList<>();
        spawnPoints.add(new Location(Bukkit.getWorld("world"),
                3, 5, -17));
        spawnPoints.add(new Location(Bukkit.getWorld("world"),
                2, 5, 24));
        Location lobbySpawn = new Location(Bukkit.getWorld("world"), 3, 10, 4);
        setLobbySpawn(lobbySpawn);
        setPlayerSpawnLocations(spawnPoints);
    }

    @Override
    public void playerJoin(GamePlayer gamePlayer) {
        super.playerJoin(gamePlayer);
        inGameLobbyScoreBoard.onJoin(gamePlayer);
        inGameLobbyScoreBoard.updateScoreboard();
    }

    @Override
    public void assignSpawnPositions() {
        super.assignSpawnPositions();
        for(GamePlayer gamePlayer : getPlayers()) {
            Kit kit = new Kit();
            kit.addItem(0, new ItemStack(Material.IRON_AXE));
            kit.addItem(1, new ItemStack(Material.OAK_PLANKS, 64));
            kit.addItem(100, new ItemStack(Material.IRON_BOOTS));
            kit.addItem(102, new ItemStack(Material.DIAMOND_CHESTPLATE));
            kit.giveKit(gamePlayer.getPlayer());
            inGameActiveScoreBoard.onJoin(gamePlayer);
            inGameActiveScoreBoard.updateScoreboard();
        }
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void end() {
        super.end();
        for(GamePlayer gamePlayer : getPlayers()) {
            inGameActiveScoreBoard.onLeave(gamePlayer);
            inGameLobbyScoreBoard.onLeave(gamePlayer);
            gamePlayer.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        }
    }
}
