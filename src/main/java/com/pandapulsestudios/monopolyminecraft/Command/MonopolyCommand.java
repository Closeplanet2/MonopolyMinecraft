package com.pandapulsestudios.monopolyminecraft.Command;

import com.pandapulsestudios.monopolyminecraft.BukkitRunnable.MoveOnBoardRunnable;
import com.pandapulsestudios.monopolyminecraft.Enum.GamePiece;
import com.pandapulsestudios.monopolyminecraft.Enum.GameTypes;
import com.pandapulsestudios.monopolyminecraft.Enum.RoomKeys;
import com.pandapulsestudios.monopolyminecraft.Enum.TileName;
import com.pandapulsestudios.monopolyminecraft.MonopolyMinecraft;
import com.pandapulsestudios.monopolyminecraft.Object.GameBoard;
import com.pandapulsestudios.pulsecommands.Enums.TabType;
import com.pandapulsestudios.pulsecommands.Interface.*;
import com.pandapulsestudios.pulsecommands.PlayerCommand;
import com.pandapulsestudios.pulsecore.Chat.ChatAPI;
import com.pandapulsestudios.pulsecore.Chat.MessageType;
import com.pandapulsestudios.pulsematchmaking.API.LobbyAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.*;

@PCCommand
public class MonopolyCommand extends PlayerCommand {

    public MonopolyCommand() { super("monopoly", false);}

    @PCMethod
    @PCSignature("base_world")
    @PCTab(pos = 0, type = TabType.Information_From_Function, data = "GameTypes")
    public void BaseWorld(UUID playerUUID, String gameType){
        var player = Bukkit.getPlayer(playerUUID);
        if(player == null) return;
        var gameWorld = Bukkit.getWorld(GameTypes.valueOf(gameType).baseGameWorldName);
        player.teleport(gameWorld.getSpawnLocation());
    }

    @PCMethod
    @PCSignature("join_game")
    @PCTab(pos = 0, type = TabType.Information_From_Function, data = "GameTypes")
    public void JoinGame(UUID playerUUID, String gameType){
        var player = Bukkit.getPlayer(playerUUID);
        if(player == null) return;
        GameTypes.valueOf(gameType).JoinGame(false, false, player);
    }

    @PCMethod
    @PCSignature("rolldice")
    public void RollDice(UUID playerUUID, String type, String password){
        var player = Bukkit.getPlayer(playerUUID);
        if(player == null) return;
        var networkRoom = LobbyAPI.ReturnPlayerRoom(player);
        if(networkRoom == null || !password.equals("8049398596")) return;

        if(type.equals("forturn")){
            var firstDice = new Random().nextInt(6) + 1;
            var secondDice = new Random().nextInt(6) + 1;
            for(var i = 0; i < 100; i++) player.sendMessage("");
            player.sendMessage(ChatColor.RED + "Rolled: [" + firstDice + "][" + secondDice + "]");
            var gameboard = (GameBoard) networkRoom.GetRoomProperty(RoomKeys.GAME_BOARD.ID, null);
            var piecedata = (HashMap<UUID, GamePiece>) networkRoom.GetRoomProperty(RoomKeys.PLAYER_GAME_PIECE.ID, null);
            var runnable = new MoveOnBoardRunnable(networkRoom, gameboard, piecedata.get(player.getUniqueId()), player, firstDice, secondDice);
            runnable.runTaskTimer(MonopolyMinecraft.Instance, 0, 10);
        }
    }

    @PCMethod
    @PCSignature("endturn")
    public void EndTurn(UUID playerUUID, String password){
        var player = Bukkit.getPlayer(playerUUID);
        if(player == null) return;
        var networkRoom = LobbyAPI.ReturnPlayerRoom(player);
        if(networkRoom == null || !password.equals("8049398596")) return;
        var gameboard = (GameBoard) networkRoom.GetRoomProperty(RoomKeys.GAME_BOARD.ID, null);
        gameboard.SendNextTurnToPlayers(networkRoom, player);
    }

    @PCMethod
    @PCSignature("buy_prop")
    public void BuyProp(UUID playerUUID, String tileName, String password){
        var player = Bukkit.getPlayer(playerUUID);
        if(player == null) return;
        var networkRoom = LobbyAPI.ReturnPlayerRoom(player);
        if(networkRoom == null || !password.equals("8049398596")) return;
        var gameboard = (GameBoard) networkRoom.GetRoomProperty(RoomKeys.GAME_BOARD.ID, null);
        gameboard.BuyPropertyCommand(networkRoom, player, TileName.valueOf(tileName));
    }

    @PCMethod
    @PCSignature("auc_prop")
    public void AucProp(UUID playerUUID, String tileName, String password){
        var player = Bukkit.getPlayer(playerUUID);
        if(player == null) return;
        var networkRoom = LobbyAPI.ReturnPlayerRoom(player);
        if(networkRoom == null || !password.equals("8049398596")) return;
        var gameboard = (GameBoard) networkRoom.GetRoomProperty(RoomKeys.GAME_BOARD.ID, null);
        gameboard.AucPropertyCommand(player, TileName.valueOf(tileName));
    }

    @PCMethodData
    public List<String> GameTypes(String currentInput){
        var data = new ArrayList<String>();
        for(var value : GameTypes.values()){
            if(value.name().contains(currentInput)) data.add(value.name());
        }
        return data;
    }
}
