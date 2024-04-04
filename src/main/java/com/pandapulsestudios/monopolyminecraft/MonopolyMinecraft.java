package com.pandapulsestudios.monopolyminecraft;

import com.pandapulsestudios.pulsecommands.PulseCommands;
import com.pandapulsestudios.pulsecore.Java.ClassAPI;
import com.pandapulsestudios.pulsematchmaking.API.LobbyAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class MonopolyMinecraft extends JavaPlugin {
    public static MonopolyMinecraft Instance;

    @Override
    public void onEnable() {
        Instance = this;
        ClassAPI.RegisterClasses(this);
        PulseCommands.RegisterRaw(this);
        LobbyAPI.RegisterCustomLobbies(this);
    }
}
