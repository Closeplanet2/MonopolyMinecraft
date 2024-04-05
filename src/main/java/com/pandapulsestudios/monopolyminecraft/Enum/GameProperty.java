package com.pandapulsestudios.monopolyminecraft.Enum;

import java.util.HashMap;

public class GameProperty {
    public HashMap<_PropertyLevel, Integer> properLevelTable = new HashMap<>();
    public final Integer houseCost;
    public final Integer hotelCost;
    public final Integer mortgageValue;

    public GameProperty(Integer houseCost, Integer hotelCost, Integer mortgageValue, Integer... values){
        this.houseCost = houseCost;
        this.hotelCost = hotelCost;
        this.mortgageValue = mortgageValue;
        for(var i = 0; i < _PropertyLevel.values().length; i++){
            properLevelTable.put(_PropertyLevel.values()[i], values[i]);
        }
    }
}
