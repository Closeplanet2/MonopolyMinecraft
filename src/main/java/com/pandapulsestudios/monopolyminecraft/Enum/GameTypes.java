package com.pandapulsestudios.monopolyminecraft.Enum;

import com.pandapulsestudios.pulsematchmaking.API.LobbyAPI;
import com.pandapulsestudios.pulsematchmaking.Enum.GameLobbyType;
import com.pandapulsestudios.pulsematchmaking.Objects.RoomOptions;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public enum GameTypes {
    ClassicGame("MonopolyMinecraft:ClassicGameLobby", "ClassicGameWorld", GameLobbyType.NoLobby,
            GameMode.ADVENTURE, 1, GameMode.SPECTATOR, 1),
    SpeedGame("MonopolyMinecraft:SpeedGameLobby", "SpeedGameWorld", GameLobbyType.NoLobby,
            GameMode.ADVENTURE, 1, GameMode.SPECTATOR, 1);

    public final String lobbyName;
    public final String baseGameWorldName;
    public final GameLobbyType gameLobbyType;
    public final GameMode lobbyGamemode;
    public final int lobbyCountdown;
    public final GameMode gameGamemode;
    public final int gameCountdown;

    GameTypes(String lobbyName, String baseGameWorldName, GameLobbyType gameLobbyType, GameMode lobbyGamemode, int lobbyCountdown, GameMode gameGamemode, int gameCountdown){
        this.lobbyName = lobbyName;
        this.baseGameWorldName = baseGameWorldName;
        this.gameLobbyType = gameLobbyType;
        this.lobbyGamemode = lobbyGamemode;
        this.lobbyCountdown = lobbyCountdown;
        this.gameGamemode = gameGamemode;
        this.gameCountdown = gameCountdown;
    }

    public void JoinGame(boolean joinSameTeam, boolean logErrors, Player... players){
        LobbyAPI.JoinRandomRoom(lobbyName, joinSameTeam, logErrors, players);
    }

    public void CreateRandomGame(boolean isVisible, boolean isOpen, String roomPassword, boolean joinSameTeam, boolean logErrors, Player... players){
        var roomOptions = RoomOptions.Create(lobbyName, new HashMap<>(), isVisible, isOpen, roomPassword);
        LobbyAPI.CreateRoomAndJoin(lobbyName, UUID.randomUUID().toString(), roomOptions, joinSameTeam, logErrors, players);
    }
}
