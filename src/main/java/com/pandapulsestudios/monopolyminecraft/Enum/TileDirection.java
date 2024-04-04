package com.pandapulsestudios.monopolyminecraft.Enum;

public enum TileDirection {
    NORTH(0, 0),
    SOUTH(0, 0),
    EAST(0, 0),
    WEST(0, 0);

    public final int x;
    public final int y;

    TileDirection(int x, int y){
        this.x = x;
        this.y = y;
    }
}
