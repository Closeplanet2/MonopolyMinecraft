package com.pandapulsestudios.monopolyminecraft.Object;

import com.pandapulsestudios.monopolyminecraft.Enum.GamePiece;
import com.pandapulsestudios.monopolyminecraft.Enum.TileDirection;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.joml.Vector2f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class GameTile {
    private HashMap<UUID, Integer> playersOnTile = new HashMap<>();
    private List<Vector> tilePositions = new ArrayList<>();
    private final Location cameraLocation;

    public GameTile(Location cameraLocation){
        this.cameraLocation = cameraLocation;
    }

    public void AddVector(Vector vector){
        tilePositions.add(vector);
    }

    public boolean IsPlayerHere(Player player){
        return playersOnTile.containsKey(player.getUniqueId());
    }

    public void SetPlayerCamera(List<Player> players){
        for(var player : players) player.teleport(cameraLocation);
    }

    public void SpawnPlayerPiece(Player player, GamePiece gamePiece){
        if(playersOnTile.containsKey(player.getUniqueId())) return;
        for(var i = 0; i < tilePositions.size(); i++){
            if(playersOnTile.containsValue(i)) continue;
            var vector = tilePositions.get(i);
            PlayPiece(player.getWorld(), vector, gamePiece.material);
            playersOnTile.put(player.getUniqueId(), i);
            return;
        }
    }

    public void RemovePlayerPiece(Player player){
        if(!playersOnTile.containsKey(player.getUniqueId())) return;
        var vector = tilePositions.get(playersOnTile.get(player.getUniqueId()));
        PlayPiece(player.getWorld(), vector, Material.AIR);
        playersOnTile.remove(player.getUniqueId());
    }

    private void PlayPiece(World world, Vector vector, Material material){
        for(var x = 0; x < 5; x++){
            for(var z = 0; z < 5; z++){
                new Location(world, vector.getX() + x, vector.getY(), vector.getZ() + z).getBlock().setType(material);
            }
        }
    }
}
