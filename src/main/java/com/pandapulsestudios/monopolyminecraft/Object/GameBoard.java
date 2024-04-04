package com.pandapulsestudios.monopolyminecraft.Object;

import com.pandapulsestudios.monopolyminecraft.Enum.GamePiece;
import com.pandapulsestudios.monopolyminecraft.Enum.TileDirection;
import com.pandapulsestudios.pulsematchmaking.Objects.NetworkRoom;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBoard {

    public static GameBoard CreateBlankGameBoard(NetworkRoom networkRoom){
        var data = new ArrayList<GameTile>();

        var goGameTile = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), 2.975, -12.102, 296.109, -127.4f, 48.2f));
        goGameTile.AddVector(new Vector(37.444301, -47.000000, 289.262343));
        goGameTile.AddVector(new Vector(29.327942, -47.000000, 289.386874));
        goGameTile.AddVector(new Vector(21.393683, -47.000000, 289.655866));
        goGameTile.AddVector(new Vector(13.555316, -47.000000, 289.508955));
        goGameTile.AddVector(new Vector(8.347194, -47.000000, 283.308050));
        goGameTile.AddVector(new Vector( 8.628173, -47.000000, 275.413485));
        goGameTile.AddVector(new Vector( 8.382264, -47.000000, 267.491271));
        goGameTile.AddVector(new Vector(8.405784, -47.000000, 259.556670));
        data.add(goGameTile);

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
            data.add(gameTile);
        }

        var prisonGameTime = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), -0.968, -15.099, 0.009, -50.1f, 47.3f));
        goGameTile.AddVector(new Vector( 6.372269, -47.000000, 37.525345));
        goGameTile.AddVector(new Vector(6.692944, -47.000000, 28.273794));
        goGameTile.AddVector(new Vector(6.460882, -47.000000, 19.591024));
        goGameTile.AddVector(new Vector(6.473336, -47.000000, 10.359280));
        goGameTile.AddVector(new Vector(13.637152, -47.000000, 6.425691));
        goGameTile.AddVector(new Vector(22.160724, -47.000000, 6.363386));
        goGameTile.AddVector(new Vector(29.336410, -47.000000, 6.410944));
        goGameTile.AddVector(new Vector(37.245697, -47.000000, 6.450981));
        data.add(prisonGameTime);


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
            data.add(gameTile);
        }

        var freeParkingGameTile = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), 302.541, -15, -3.073, 43.7f, 49.3f));
        freeParkingGameTile.AddVector(new Vector(259.486289, -47.000000, 6.254233));
        freeParkingGameTile.AddVector(new Vector(267.468857, -47.000000, 6.260687));
        freeParkingGameTile.AddVector(new Vector(275.535279, -47.000000, 6.464511));
        freeParkingGameTile.AddVector(new Vector(283.441422, -47.000000, 6.289379));
        freeParkingGameTile.AddVector(new Vector(290.338202, -47.000000, 13.291727));
        freeParkingGameTile.AddVector(new Vector(290.287177, -47.000000, 21.452002));
        freeParkingGameTile.AddVector(new Vector(290.453427, -47.000000, 29.319460));
        freeParkingGameTile.AddVector(new Vector(290.309150, -47.000000, 37.612713));
        data.add(freeParkingGameTile);

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
            data.add(gameTile);
        }

        var jailGameTile = new GameTile(new Location(networkRoom.GameWorld().ReturnGameWorld(), 299.707, -15.46, 200.758, 131, 48));
        freeParkingGameTile.AddVector(new Vector(259.700000, -47.000000, 288.623851));
        freeParkingGameTile.AddVector(new Vector(267.324897, -47.000000, 288.395351));
        freeParkingGameTile.AddVector(new Vector(275.700000, -47.000000, 288.240221));
        freeParkingGameTile.AddVector(new Vector(283.567969, -47.000000, 288.526004));
        freeParkingGameTile.AddVector(new Vector(290.655271, -47.000000, 283.404047));
        freeParkingGameTile.AddVector(new Vector(290.372072, -47.000000, 275.300000));
        freeParkingGameTile.AddVector(new Vector(290.447285, -47.000000, 267.582152));
        freeParkingGameTile.AddVector(new Vector(290.210053, -47.000000, 259.719301));
        data.add(jailGameTile);

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
            data.add(gameTile);
        }

        return new GameBoard(data);
    }

    private final List<GameTile> gameTiles;

    private GameBoard(List<GameTile> gameTiles){
        this.gameTiles = gameTiles;
    }

    public void MovePlayerXSquares(GamePiece gamePiece, List<Player> players, Player player, int toMove){
        var countdownMoves = toMove;
        while (countdownMoves > 0){
            var lastGameTile = ReturnPlayerTile(player);
            if(lastGameTile != null) lastGameTile.RemovePlayerPiece(player);
            var currentIndex = lastGameTile == null ? 0 : gameTiles.indexOf(lastGameTile);
            var newIndex = currentIndex + 1 >= gameTiles.size() ? 0 : currentIndex + 1;
            SpawnPlayerPiece(gamePiece, players, player, newIndex);
            countdownMoves -=1;
        }
    }

    public void SpawnPlayerPiece(GamePiece gamePiece, List<Player> players, Player player, int newIndex){
        var newGameTile = gameTiles.get(newIndex);
        newGameTile.SpawnPlayerPiece(player, gamePiece);
        newGameTile.SetPlayerCamera(players);
    }

    public void DoneMoving(NetworkRoom networkRoom, Player player, int firstDice, int secondDice){

    }

    public GameTile ReturnPlayerTile(Player player){
        for(var gameTile : gameTiles){
            if(gameTile.IsPlayerHere(player)) return gameTile;
        }
        return null;
    }


}
