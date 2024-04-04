package com.pandapulsestudios.monopolyminecraft.Enum;

public enum RoomKeys {
    PLAYER_GAME_PIECE("PLAYER_GAME_PIECE"),
    GAME_BOARD("GAME_BOARD"),
    TURN_PLAYER_UUID("TURN_PLAYER_UUID");

    public final String ID;

    RoomKeys(String ID){
        this.ID = ID;
    }
}
