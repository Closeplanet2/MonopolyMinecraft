package com.pandapulsestudios.monopolyminecraft.Matchmaking.Lobbies;

import com.pandapulsestudios.monopolyminecraft.Enum.GamePiece;
import com.pandapulsestudios.monopolyminecraft.Enum.GameTypes;
import com.pandapulsestudios.monopolyminecraft.Enum.RoomKeys;
import com.pandapulsestudios.monopolyminecraft.Enum.TileDirection;
import com.pandapulsestudios.monopolyminecraft.Object.GameBoard;
import com.pandapulsestudios.monopolyminecraft.Object.GameTile;
import com.pandapulsestudios.pulsecore.Chat.ChatAPI;
import com.pandapulsestudios.pulsecore.Chat.MessageType;
import com.pandapulsestudios.pulsecore.Java.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.Movement.MovementAPI;
import com.pandapulsestudios.pulsecore.Player.PlayerAPI;
import com.pandapulsestudios.pulsecore.Player.PlayerAction;
import com.pandapulsestudios.pulsecore.Player.TitleAPI;
import com.pandapulsestudios.pulsecore.World.TimeLock;
import com.pandapulsestudios.pulsecore.World.WorldAPI;
import com.pandapulsestudios.pulsematchmaking.API.LobbyAPI;
import com.pandapulsestudios.pulsematchmaking.Enum.CreateRoomResponse;
import com.pandapulsestudios.pulsematchmaking.Enum.GameLobbyType;
import com.pandapulsestudios.pulsematchmaking.Enum.JoinRandomRoomResponse;
import com.pandapulsestudios.pulsematchmaking.Interfaces.LobbyCallbacks;
import com.pandapulsestudios.pulsematchmaking.Objects.GameWorld;
import com.pandapulsestudios.pulsematchmaking.Objects.NetworkRoom;
import com.pandapulsestudios.pulsematchmaking.Objects.RoomOptions;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.*;

@PulseAutoRegister
public class ClassicGameLobby implements LobbyCallbacks {

    private static final GameTypes GAME_TYPES = GameTypes.ClassicGame;
    private static final String JOIN_GAME_MESSAGE = "#51F4F7[#51F774+#51F4F7] #5163F7Player has joined the game #51F774%s #51F4F7[#51F774%d#000000/#51F774%d#51F4F7]";
    private static final String LEAVE_GAME_MESSAGE = "#51F4F7[#FE5454-#51F4F7] #5163F7Player has joined the game #51F774%s #51F4F7[#51F774%d#000000/#51F774%d#51F4F7]";
    private static final String LOBBY_COUNTDOWN = "#51F774Game Starting... #51F4F7(#51F774%d#51F4F7)";
    private static final String GAME_COUNTDOWN = "#51F774Game Starting... #51F4F7(#51F774%d#51F4F7)";

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
    public GameLobbyType GameLobbyType() { return GAME_TYPES.gameLobbyType; }

    @Override
    public Location DefaultLobbyLocation(GameWorld gameWorld) { return Bukkit.getWorld(DefaultGameWorldName()).getSpawnLocation(); }

    @Override
    public GameMode LobbyGameMode() { return GAME_TYPES.lobbyGamemode; }

    @Override
    public List<Location> SpawnLocations(GameWorld gameWorld) {
        return Arrays.asList(new Location[]{new Location(gameWorld.ReturnGameWorld(), 2.756, -12.102, 294.192, -129.4f, 53.5f)});
    }

    @Override
    public void GameLoop(NetworkRoom networkRoom, int i, int i1, boolean b) {

    }

    @Override
    public void JoinRandomRoomFailed(JoinRandomRoomResponse joinRandomRoomResponse, RoomOptions roomOptions, Player... players) {
        GAME_TYPES.CreateRandomGame(true, true, null, false, false, players);
    }

    @Override
    public void CreateRoomFailed(CreateRoomResponse createRoomResponse, RoomOptions roomOptions, Player... players) {
        GAME_TYPES.CreateRandomGame(true, true, null, false, false, players);
    }

    @Override
    public void CreateRoomSuccess(NetworkRoom networkRoom, Player... players) {

    }

    @Override
    public void PlayerJoinedRoom(NetworkRoom networkRoom, Player... players) {
        for(var player : players) networkRoom.BroadCastMessage(String.format(JOIN_GAME_MESSAGE, player.getDisplayName(), networkRoom.NumberOfPlayersInRoom(), maxPlayers()));
        if(networkRoom.MinPlayersReached()) networkRoom.StartLobbyCountdown(GAME_TYPES.lobbyCountdown);
    }

    @Override
    public void PlayerLeftRoom(NetworkRoom networkRoom, Player player) {
        networkRoom.BroadCastMessage(String.format(LEAVE_GAME_MESSAGE, player.getDisplayName(), networkRoom.NumberOfPlayersInRoom(), maxPlayers()));
    }

    @Override
    public void LobbyTimerCountdown(NetworkRoom networkRoom, int i, boolean b) {
        networkRoom.BroadCastMessage(String.format(LOBBY_COUNTDOWN, i));
        if(!b) return;
        networkRoom.StartSpawnSequence(GAME_TYPES.gameCountdown, GAME_TYPES.gameGamemode);
    }

    @Override
    public void SpawnTimerCountdown(NetworkRoom networkRoom, int i, boolean b) {
        networkRoom.BroadCastMessage(String.format(GAME_COUNTDOWN, i));
        for(var player : networkRoom.ReturnAllPlayers()){
            //if(PlayerAPI.CanPlayerAction(PlayerAction.PlayerMove, player)) PlayerAPI.TogglePlayerAction(PlayerAction.PlayerMove, false, player);
        }
        if(!b) return;

        WorldAPI.TimeLock(networkRoom.GameWorld().ReturnGameWorld(), TimeLock.Noon);
        networkRoom.SetRoomProperty(RoomKeys.GAME_BOARD.ID, GameBoard.CreateBlankGameBoard(networkRoom));
        networkRoom.SetRoomProperty(RoomKeys.PLAYER_GAME_PIECE.ID, ConfirmPlayerPieces(networkRoom));
        var gameBoard = (GameBoard) networkRoom.GetRoomProperty(RoomKeys.GAME_BOARD.ID, null);

        for(var player : networkRoom.ReturnAllPlayers()){
            var gamePiece = GetPlayerGamePiece(networkRoom, player);
            gameBoard.SpawnPlayerPiece(gamePiece, networkRoom.ReturnAllPlayers(), player, 0);
        }

        SendNextTurnToPlayers(networkRoom);
    }

    private GamePiece GetPlayerGamePiece(NetworkRoom networkRoom, Player player){
        var data = (HashMap<UUID, GamePiece>) networkRoom.GetRoomProperty(RoomKeys.PLAYER_GAME_PIECE.ID, null);
        return data.get(player.getUniqueId());
    }

    private HashMap<UUID, GamePiece> ConfirmPlayerPieces(NetworkRoom networkRoom){
        var pieceData = new HashMap<UUID, GamePiece>();
        for(var player : networkRoom.ReturnAllPlayers()){
            while (true){
                var randomIndex = new Random().nextInt(GamePiece.values().length);
                var randomPiece = GamePiece.values()[randomIndex];
                if(pieceData.containsValue(randomPiece)) continue;
                networkRoom.BroadCastMessage(randomPiece.ReturnConfirmationMessage(player));
                pieceData.put(player.getUniqueId(), randomPiece);
                break;
            }
        }
        return pieceData;
    }

    private void SendNextTurnToPlayers(NetworkRoom networkRoom){
        var totalPlayers = networkRoom.ReturnAllPlayers();
        var randomIndex = new Random().nextInt(totalPlayers.size());
        var randomPlayer = totalPlayers.get(randomIndex);
        TitleAPI.SendTitleToPlayer(randomPlayer, ChatColor.GREEN + "Your turn!", "", 0, 1, 0);
        networkRoom.SetRoomProperty(RoomKeys.TURN_PLAYER_UUID.name(), randomPlayer.getUniqueId());
        ClearPlayerChat(randomPlayer);
        SendRollTextToPlayer(randomPlayer);
    }

    private void SendRollTextToPlayer(Player player){
        var textComp1 = new TextComponent(ChatColor.GREEN + "Click to role..... ");
        var textComp2 = new TextComponent(ChatColor.AQUA + "[ROLL]");
        textComp2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("CLICK TO ROLL!")));
        textComp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/monopoly rolldice forturn 8049398596"));
        textComp1.addExtra(textComp2);
        player.spigot().sendMessage(textComp1);
    }

    private void ClearPlayerChat(Player player){
        for(var i = 0; i < 100; i++) player.sendMessage("");
    }


}
