package com.pandapulsestudios.monopolyminecraft.Object;

import com.pandapulsestudios.monopolyminecraft.Enum.*;
import com.pandapulsestudios.pulsecore.Chat.ChatAPI;
import com.pandapulsestudios.pulsecore.Chat.MessageType;
import com.pandapulsestudios.pulsecore.Data.API.UUIDDataAPI;
import com.pandapulsestudios.pulsecore.Player.TitleAPI;
import com.pandapulsestudios.pulsematchmaking.Objects.NetworkRoom;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.*;

public class GameBoard {

    public static GameBoard CreateBlankGameBoard(NetworkRoom networkRoom){
        var data = new ArrayList<GameTile>();
        var tileNameCount = 0;


        var a = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), 2.975, -12.102, 296.109, -127.4f, 48.2f));
        a.AddVector(new Vector(37.444301, -47.000000, 289.262343));
        a.AddVector(new Vector(29.327942, -47.000000, 289.386874));
        a.AddVector(new Vector(21.393683, -47.000000, 289.655866));
        a.AddVector(new Vector(13.555316, -47.000000, 289.508955));
        a.AddVector(new Vector(8.347194, -47.000000, 283.308050));
        a.AddVector(new Vector( 8.628173, -47.000000, 275.413485));
        a.AddVector(new Vector( 8.382264, -47.000000, 267.491271));
        a.AddVector(new Vector(8.405784, -47.000000, 259.556670));
        a.SetTileName(TileName.values()[tileNameCount]);
        tileNameCount += 1;
        data.add(a);

        for(var i = 0; i < 9; i++){
            var offset = i * 23.905491;
            var cameraOffset = i * 24;

            var gameTile = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), -6.112, -15.846, 248.215 - cameraOffset, -88f, 48.8f));
            gameTile.AddVector(new Vector(9.525038, -47.000000, 235.482476 - offset));
            gameTile.AddVector(new Vector(9.633186, -47.000000, 241.376551 - offset));
            gameTile.AddVector(new Vector(9.476602, -47.000000, 247.669737 - offset));
            gameTile.AddVector(new Vector(9.577046, -47.000000, 253.620313 - offset));

            gameTile.AddVector(new Vector(15.557611, -47.000000, 235.447534 - offset));
            gameTile.AddVector(new Vector(15.263984, -47.000000, 241.381373 - offset));
            gameTile.AddVector(new Vector(15.589700, -47.000000, 247.580596 - offset));
            gameTile.AddVector(new Vector(15.334186, -47.000000, 253.475544 - offset));
            gameTile.SetTileName(TileName.values()[tileNameCount]);
            tileNameCount += 1;
            data.add(gameTile);
        }

        var b = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), -0.968, -15.099, 0.009, -50.1f, 47.3f));
        b.AddVector(new Vector( 6.372269, -47.000000, 37.525345));
        b.AddVector(new Vector(6.692944, -47.000000, 28.273794));
        b.AddVector(new Vector(6.460882, -47.000000, 19.591024));
        b.AddVector(new Vector(6.473336, -47.000000, 10.359280));
        b.AddVector(new Vector(13.637152, -47.000000, 6.425691));
        b.AddVector(new Vector(22.160724, -47.000000, 6.363386));
        b.AddVector(new Vector(29.336410, -47.000000, 6.410944));
        b.AddVector(new Vector(37.245697, -47.000000, 6.450981));
        b.SetTileName(TileName.values()[tileNameCount]);
        tileNameCount += 1;
        data.add(b);

        for(var i = 0; i < 9; i++){
            var offset = i * 23.905491;
            var cameraOffset = i * 24;

            var gameTile = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), 53.838 + cameraOffset, -15.09, -9.5, 0.9f, 45.7f));
            gameTile.AddVector(new Vector(43.287833 + offset, -47.000000, 9.588817));
            gameTile.AddVector(new Vector(49.687364 + offset, -47.000000, 9.395988));
            gameTile.AddVector(new Vector(55.578411 + offset, -47.000000, 9.278666));
            gameTile.AddVector(new Vector( 61.382957 + offset, -47.000000, 9.538132));
            gameTile.AddVector(new Vector(43.529216 + offset, -47.000000, 15.555461));
            gameTile.AddVector(new Vector( 49.452445 + offset, -47.000000, 15.426103));
            gameTile.AddVector(new Vector(55.553800 + offset, -47.000000, 15.387855));
            gameTile.AddVector(new Vector(61.518552 + offset, -47.000000, 15.270809));
            gameTile.SetTileName(TileName.values()[tileNameCount]);
            tileNameCount += 1;
            data.add(gameTile);
        }

        var c = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), 302.541, -15, -3.073, 43.7f, 49.3f));
        c.AddVector(new Vector(259.486289, -47.000000, 6.254233));
        c.AddVector(new Vector(267.468857, -47.000000, 6.260687));
        c.AddVector(new Vector(275.535279, -47.000000, 6.464511));
        c.AddVector(new Vector(283.441422, -47.000000, 6.289379));
        c.AddVector(new Vector(290.338202, -47.000000, 13.291727));
        c.AddVector(new Vector(290.287177, -47.000000, 21.452002));
        c.AddVector(new Vector(290.453427, -47.000000, 29.319460));
        c.AddVector(new Vector(290.309150, -47.000000, 37.612713));
        c.SetTileName(TileName.values()[tileNameCount]);
        tileNameCount += 1;
        data.add(c);

        for(var i = 0; i < 9; i++){
            var offset = i * 23.905491;
            var cameraOffset = i * 24;

            var gameTile = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), 307.903, -15, 54.258 + cameraOffset, 90f, 49f));
            gameTile.AddVector(new Vector(281.635087, -47.000000, 61.632975 + offset));
            gameTile.AddVector(new Vector(281.553111, -47.000000, 55.514464 + offset));
            gameTile.AddVector(new Vector(281.351149, -47.000000, 49.372253 + offset));
            gameTile.AddVector(new Vector(281.553480, -47.000000, 43.624350 + offset));
            gameTile.AddVector(new Vector(287.647054, -47.000000, 61.406699 + offset));
            gameTile.AddVector(new Vector(287.675312, -47.000000, 55.545508 + offset));
            gameTile.AddVector(new Vector(287.697730, -47.000000, 49.565731 + offset));
            gameTile.AddVector(new Vector(287.430714, -47.000000, 43.670234 + offset));
            gameTile.SetTileName(TileName.values()[tileNameCount]);
            tileNameCount += 1;
            data.add(gameTile);
        }

        var d = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), 299.707, -15.46, 200.758, 131, 48));
        d.AddVector(new Vector(259.700000, -47.000000, 288.623851));
        d.AddVector(new Vector(267.324897, -47.000000, 288.395351));
        d.AddVector(new Vector(275.700000, -47.000000, 288.240221));
        d.AddVector(new Vector(283.567969, -47.000000, 288.526004));
        d.AddVector(new Vector(290.655271, -47.000000, 283.404047));
        d.AddVector(new Vector(290.372072, -47.000000, 275.300000));
        d.AddVector(new Vector(290.447285, -47.000000, 267.582152));
        d.AddVector(new Vector(290.210053, -47.000000, 259.719301));
        d.SetTileName(TileName.values()[tileNameCount]);
        tileNameCount += 1;
        data.add(d);

        for(var i = 0; i < 9; i++){
            var offset = i * 23.789;
            var cameraOffset = i * 24;

            var gameTile = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), 246.526 - cameraOffset, -15.4, 310, -179.8f, 48.6f));
            gameTile.AddVector(new Vector(253.503613 - offset, -47.000000, 287.401768));
            gameTile.AddVector(new Vector(247.314676 - offset, -47.000000, 287.355535));
            gameTile.AddVector(new Vector(241.357601 - offset, -47.000000, 287.191176));
            gameTile.AddVector(new Vector(235.430815 - offset, -47.000000, 287.523998));
            gameTile.AddVector(new Vector(235.694956 - offset, -47.000000, 281.679823));
            gameTile.AddVector(new Vector(241.429946 - offset, -47.000000, 281.430056));
            gameTile.AddVector(new Vector(247.613398 - offset, -47.000000, 281.418179));
            gameTile.AddVector(new Vector(253.419246 - offset, -47.000000, 281.549996));
            gameTile.SetTileName(TileName.values()[tileNameCount]);
            tileNameCount += 1;
            data.add(gameTile);
        }

        return new GameBoard(data);
    }

    private final List<GameTile> gameTiles;

    private GameBoard(List<GameTile> gameTiles){
        this.gameTiles = gameTiles;
    }

    public GameTile MovePlayerXSquares(GamePiece gamePiece, List<Player> players, Player player, int toMove){
        var countdownMoves = toMove;

        GameTile gameTile = null;
        while (countdownMoves > 0){
            var lastGameTile = ReturnPlayerTile(player);
            if(lastGameTile != null) lastGameTile.RemovePlayerPiece(player);
            var currentIndex = lastGameTile == null ? 0 : gameTiles.indexOf(lastGameTile);
            var newIndex = currentIndex + 1 >= gameTiles.size() ? 0 : currentIndex + 1;
            gameTile = SpawnPlayerPiece(gamePiece, players, player, newIndex);
            countdownMoves -=1;
        }
        return gameTile;
    }

    public GameTile ReturnPlayerTile(Player player){
        for(var gameTile : gameTiles){
            if(gameTile.IsPlayerHere(player)) return gameTile;
        }
        return null;
    }

    public void MakeActivePlayer(Player player, List<Player> players){
        var currentPlayerTile = ReturnPlayerTile(player);
        currentPlayerTile.SetPlayerCamera(players);
    }

    public GameTile SpawnPlayerPiece(GamePiece gamePiece, List<Player> players, Player player, int newIndex){
        var newGameTile = gameTiles.get(newIndex);
        newGameTile.SpawnPlayerPiece(player, gamePiece);
        newGameTile.SetPlayerCamera(players);
        return newGameTile;
    }

    public void SendNextTurnToPlayers(NetworkRoom networkRoom, Player current){
        Player next = null;
        if(current == null){
            var totalPlayers = networkRoom.ReturnAllPlayers();
            var randomIndex = new Random().nextInt(totalPlayers.size());
            next = totalPlayers.get(randomIndex);
        }else{
            ClearPlayerChat(current);
            UUIDDataAPI.Store(current.getUniqueId(), "DoubleCount", 0);
            var nextIndex = networkRoom.ReturnAllPlayers().indexOf(current) + 1;
            if(nextIndex >= networkRoom.ReturnAllPlayers().size()) nextIndex = 0;
            next = networkRoom.ReturnAllPlayers().get(nextIndex);
        }

        MakeActivePlayer(next, networkRoom.ReturnAllPlayers());
        TitleAPI.SendTitleToPlayer(next, ChatColor.GREEN + "Your turn!", "", 0, 1, 0);
        networkRoom.SetRoomProperty(RoomKeys.TURN_PLAYER_UUID.name(), next.getUniqueId());
        SendRollTextToPlayer(next);
    }

    public void BuyPropertyCommand(NetworkRoom networkRoom, Player player, TileName tileName){
        var moneyBank = (HashMap<UUID, Integer>) networkRoom.GetRoomProperty(RoomKeys.PLAYER_MONEY.ID, new HashMap<UUID, Integer>());
        var tileOwnership = (HashMap<TileName, UUID>) networkRoom.GetRoomProperty(RoomKeys.PROPERTY_OWNERSHIP.ID, new HashMap<TileName, UUID>());

        var currentPlayerMoney = moneyBank.get(player.getUniqueId());
        var gameProperty = tileName.gameProperty;
        if(currentPlayerMoney >= gameProperty.mortgageValue){
            var newMoney = currentPlayerMoney - gameProperty.mortgageValue;
            moneyBank.put(player.getUniqueId(), newMoney);
            networkRoom.SetRoomProperty(RoomKeys.PLAYER_MONEY.ID, moneyBank);

            tileOwnership.put(tileName, player.getUniqueId());
            networkRoom.SetRoomProperty(RoomKeys.PROPERTY_OWNERSHIP.ID, tileOwnership);

            var firstDice = UUIDDataAPI.Get(player.getUniqueId(), "FirstDice", -1);
            var secondDice = UUIDDataAPI.Get(player.getUniqueId(), "SecondDice", 0);
            if(firstDice == secondDice){
                SendRollTextToPlayer(player);
            }else{
                SendEndTurnTextToPlayer(player);
            }

            networkRoom.BroadCastMessage(ChatColor.GREEN + String.format("%s has bought a property [%s] for [£%d]", player.getDisplayName(), tileName.name, gameProperty.mortgageValue));
            ChatAPI.chatBuilder().messageType(MessageType.Player).playerToo(player)
                    .SendMessage(ChatColor.GREEN + String.format("Balance: [£%d] ---> [%d]", currentPlayerMoney, newMoney));
        }else{
            ChatAPI.chatBuilder().messageType(MessageType.Player).playerToo(player)
                    .SendMessage(ChatColor.RED + "You don't have enough money to buy this property! Sending to auction......");
            AucPropertyCommand(player, tileName);
        }
    }

    public void AucPropertyCommand(Player player, TileName tileName){

    }

    public void SendRollTextToPlayer(Player player){
        ClearPlayerChat(player);
        var textComp1 = new TextComponent(ChatColor.GREEN + "Click to ");
        var textComp2 = new TextComponent(ChatColor.AQUA + "[ROLL]");
        textComp2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("CLICK TO ROLL!")));
        textComp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/monopoly rolldice forturn 8049398596"));
        textComp1.addExtra(textComp2);
        player.spigot().sendMessage(textComp1);
    }

    public void SendEndTurnTextToPlayer(Player player){
        ClearPlayerChat(player);
        var textComp1 = new TextComponent(ChatColor.GREEN + "Click to ..... ");
        var textComp2 = new TextComponent(ChatColor.RED + "[END TURN]");
        textComp2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("CLICK TO END TURN!")));
        textComp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/monopoly endturn 8049398596"));
        textComp1.addExtra(textComp2);
        player.spigot().sendMessage(textComp1);
    }

    public void SendBuyTextToPlayer(Player player, TileName tileName, GameProperty gameProperty, int currentBalance){
        ClearPlayerChat(player);
        var textComp1 = new TextComponent(ChatColor.AQUA + String.format("Do you want to buy the property? [%s] [£%d]", tileName.name, gameProperty.mortgageValue));
        var texrComp4 = new TextComponent(ChatColor.AQUA + String.format("Current balance: [£%d]", currentBalance));
        var textComp2 = new TextComponent(ChatColor.GREEN + "[BUY PROPERTY]");
        textComp2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("BUY PROPERTY!")));
        textComp2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, String.format("/monopoly buy_prop %s 8049398596", tileName)));
        var textComp3 = new TextComponent(ChatColor.RED + "[AUCTION PROPERTY]");
        textComp3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("AUCTION PROPERTY!")));
        textComp3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, String.format("/monopoly auc_prop %s 8049398596", tileName)));
        player.spigot().sendMessage(textComp1);
        player.spigot().sendMessage(texrComp4);
        player.spigot().sendMessage(textComp2);
        player.spigot().sendMessage(textComp3);
    }

    public void DoneMoving(NetworkRoom networkRoom, Player player, int firstDice, int secondDice, GameTile gameTile){
        var tileOwnership = (HashMap<TileName, UUID>) networkRoom.GetRoomProperty(RoomKeys.PROPERTY_OWNERSHIP.ID, new HashMap<TileName, UUID>());
        var tileOwnershipLevel = (HashMap<TileName, _PropertyLevel>) networkRoom.GetRoomProperty(RoomKeys.PROPERTY_OWNERSHIP.ID, new HashMap<TileName, _PropertyLevel>());
        var tileName = gameTile.ReturnTileName();
        var moneyBank = (HashMap<UUID, Integer>) networkRoom.GetRoomProperty(RoomKeys.PLAYER_MONEY.ID, new HashMap<UUID, Integer>());

        var doubleCount = (int) UUIDDataAPI.Get(player.getUniqueId(), "DoubleCount", 0);
        if(firstDice == secondDice) doubleCount++;
        if(doubleCount >= 3){
            player.sendMessage("GO TO JAIL");
            SendEndTurnTextToPlayer(player);
            return;
        }else{
            UUIDDataAPI.Store(player.getUniqueId(), "FirstDice", firstDice);
            UUIDDataAPI.Store(player.getUniqueId(), "SecondDice", secondDice);
        }

        //what happens if the property has been bought
        if(tileName.tileType == TileType.PROPERTY){
            if(tileOwnership.get(tileName) != null){
                var ownershipLevel = tileOwnershipLevel.get(tileName);
                var propertyCost = tileName.gameProperty.properLevelTable.get(ownershipLevel);
                var uuidOwner = tileOwnership.get(tileName);
                var playerOwner = Bukkit.getOfflinePlayer(uuidOwner);

                moneyBank.put(player.getUniqueId(), moneyBank.get(player.getUniqueId()) - propertyCost);
                moneyBank.put(uuidOwner, moneyBank.get(uuidOwner) + propertyCost);
                networkRoom.SetRoomProperty(RoomKeys.PROPERTY_OWNERSHIP.ID, moneyBank);

                var createMessage = "%s has landed on a property owned by %s! This has cost them [£%d]";
                networkRoom.BroadCastMessage(String.format(createMessage, player.getDisplayName(), playerOwner.getName(), propertyCost));
            }else{
                var gameProperty = gameTile.ReturnTileName().gameProperty;
                SendBuyTextToPlayer(player, gameTile.ReturnTileName(), gameProperty, moneyBank.get(player.getUniqueId()));
                return;
            }
        }

        if(firstDice == secondDice){
            SendRollTextToPlayer(player);
        }else{
            SendEndTurnTextToPlayer(player);
        }
    }

    private void ClearPlayerChat(Player player){
        for(var i = 0; i < 100; i++) player.sendMessage("");
    }

}
