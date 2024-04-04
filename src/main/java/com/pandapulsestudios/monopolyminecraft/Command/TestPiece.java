package com.pandapulsestudios.monopolyminecraft.Command;

import com.pandapulsestudios.pulsecommands.Interface.PCCommand;
import com.pandapulsestudios.pulsecommands.Interface.PCMethod;
import com.pandapulsestudios.pulsecommands.PlayerCommand;
import com.pandapulsestudios.pulsecore.Chat.ChatAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.util.Vector;

import java.util.UUID;

@PCCommand
public class TestPiece extends PlayerCommand {
    public TestPiece() {
        super("testpiece", false);
    }

    @PCMethod
    public void TestPiece(UUID playerUUID){
        var player = Bukkit.getPlayer(playerUUID);
        var loc = player.getLocation();
        ChatAPI.chatBuilder().SendMessage(String.format("%f, %f, %f", loc.getX(), loc.getY(), loc.getZ()));
        for(var x = 0; x < 5; x++){
            for(var z = 0; z < 5; z++){
                loc.clone().add(new Vector(x, 0, z)).getBlock().setType(Material.BLUE_CONCRETE);
            }
        }
    }
}
