package com.pandapulsestudios.monopolyminecraft.Enum;

public enum RoomKeys {
    PLAYER_GAME_PIECE("PLAYER_GAME_PIECE"),
    GAME_BOARD("GAME_BOARD"),
    TURN_PLAYER_UUID("TURN_PLAYER_UUID"),
    PLAYER_MONEY("PLAYER_MONEY"),
    PROPERTY_OWNERSHIP("PROPERTY_OWNERSHIP"),
    PROPERTY_OWNERSHIP_LEVEL("PROPERTY_OWNERSHIP_LEVEL");

    public final String ID;

    RoomKeys(String ID){
        this.ID = ID;
    }
}
