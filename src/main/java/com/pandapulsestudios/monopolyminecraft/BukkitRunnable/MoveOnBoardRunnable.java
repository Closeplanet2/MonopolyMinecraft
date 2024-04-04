package com.pandapulsestudios.monopolyminecraft.BukkitRunnable;

import com.google.common.graph.Network;
import com.pandapulsestudios.monopolyminecraft.Enum.GamePiece;
import com.pandapulsestudios.monopolyminecraft.Enum.RoomKeys;
import com.pandapulsestudios.monopolyminecraft.Object.GameBoard;
import com.pandapulsestudios.pulsecore.Player.TitleAPI;
import com.pandapulsestudios.pulsematchmaking.Objects.NetworkRoom;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MoveOnBoardRunnable extends BukkitRunnable {
    private final NetworkRoom networkRoom;
    private final GameBoard gameBoard;
    private final GamePiece gamePiece;
    private final Player player;
    private final int firstDice;
    private final int secondDice;
    private int amountToMove;

    public MoveOnBoardRunnable(NetworkRoom networkRoom, GameBoard gameBoard, GamePiece gamePiece, Player player, int firstDice, int secondDice){
        this.networkRoom = networkRoom;
        this.gameBoard = gameBoard;
        this.gamePiece = gamePiece;
        this.firstDice = firstDice;
        this.secondDice = secondDice;
        this.player = player;
        amountToMove = this.firstDice + this.secondDice;
    }

    @Override
    public void run() {
        var listeners = networkRoom.ReturnAllPlayers();
        for(var player : listeners) TitleAPI.SendTitleToPlayer(player, ChatColor.BLUE + "" + amountToMove, ChatColor.GREEN + "Moving", 0, 1, 0);
        gameBoard.MovePlayerXSquares(gamePiece, listeners, player, 1);
        amountToMove -= 1;
        if(amountToMove <= 0){
            gameBoard.DoneMoving(networkRoom, player, firstDice, secondDice);
            cancel();
        }
    }
}
