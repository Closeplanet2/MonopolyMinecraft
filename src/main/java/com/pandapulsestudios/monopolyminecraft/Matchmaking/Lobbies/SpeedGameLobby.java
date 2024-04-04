package com.pandapulsestudios.monopolyminecraft.Matchmaking.Lobbies;

import com.pandapulsestudios.monopolyminecraft.Enum.GameTypes;
import com.pandapulsestudios.pulsecore.Java.PulseAutoRegister;
import com.pandapulsestudios.pulsematchmaking.Enum.CreateRoomResponse;
import com.pandapulsestudios.pulsematchmaking.Enum.GameLobbyType;
import com.pandapulsestudios.pulsematchmaking.Enum.JoinRandomRoomResponse;
import com.pandapulsestudios.pulsematchmaking.Interfaces.LobbyCallbacks;
import com.pandapulsestudios.pulsematchmaking.Objects.GameWorld;
import com.pandapulsestudios.pulsematchmaking.Objects.NetworkRoom;
import com.pandapulsestudios.pulsematchmaking.Objects.RoomOptions;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

@PulseAutoRegister
public class SpeedGameLobby implements LobbyCallbacks {
    private static final GameTypes GAME_TYPES = GameTypes.SpeedGame;

    @Override
    public String lobbyName() { return GAME_TYPES.lobbyName; }

    @Override
    public int minPlayers() { return 2; }

    @Override
    public int maxPlayers() { return 8; }

    @Override
    public int playerTtl() { return 0; }

    @Override
    public int roomTtl() { return 0; }

    @Override
    public int numberOfPlayersPerTeam() { return 1; }

    @Override
    public String DefaultGameWorldName() { return "world"; }

    @Override
    public String BaseGameWorldName() { return GAME_TYPES.baseGameWorldName; }

    @Override
    public String NewGameWorldName(String s) { return String.format("%s:%S", BaseGameWorldName(), s); }

    @Override
    public GameLobbyType GameLobbyType() { return GameLobbyType.NoLobby; }

    @Override
    public Location DefaultLobbyLocation(GameWorld gameWorld) { return Bukkit.getWorld(DefaultGameWorldName()).getSpawnLocation(); }

    @Override
    public GameMode LobbyGameMode() { return GameMode.ADVENTURE; }

    @Override
    public List<Location> SpawnLocations(GameWorld gameWorld) {
        return Arrays.asList(new Location[]{new Location(gameWorld.ReturnGameWorld(), 2.756, -12.102, 294.192, -129.4f, 53.5f)});
    }

    @Override
    public void GameLoop(NetworkRoom networkRoom, int i, int i1, boolean b) {

    }

    @Override
    public void JoinRandomRoomFailed(JoinRandomRoomResponse joinRandomRoomResponse, RoomOptions roomOptions, Player... players) {

    }

    @Override
    public void CreateRoomFailed(CreateRoomResponse createRoomResponse, RoomOptions roomOptions, Player... players) {

    }

    @Override
    public void CreateRoomSuccess(NetworkRoom networkRoom, Player... players) {

    }

    @Override
    public void PlayerJoinedRoom(NetworkRoom networkRoom, Player... players) {

    }

    @Override
    public void PlayerLeftRoom(NetworkRoom networkRoom, Player player) {

    }

    @Override
    public void LobbyTimerCountdown(NetworkRoom networkRoom, int i, boolean b) {

    }

    @Override
    public void SpawnTimerCountdown(NetworkRoom networkRoom, int i, boolean b) {

    }
}
