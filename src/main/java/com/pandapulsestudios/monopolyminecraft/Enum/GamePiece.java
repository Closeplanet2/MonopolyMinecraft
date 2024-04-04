package com.pandapulsestudios.monopolyminecraft.Enum;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public enum GamePiece {
    RED("RED", "#FF5F5F", Material.RED_WOOL),
    ORANGE("ORANGE", "#FF5F5F", Material.ORANGE_WOOL),
    YELLOW("YELLOW", "#FF5F5F", Material.YELLOW_WOOL),
    GREEN("GREEN", "#FF5F5F", Material.GREEN_WOOL),
    BLUE("BLUE", "#FF5F5F", Material.BLUE_WOOL),
    PURPLE("PURPLE", "#FF5F5F", Material.PURPLE_WOOL),
    PINk("PINk", "#FF5F5F", Material.PINK_WOOL),
    BLACK("BLACK", "#FF5F5F", Material.BLACK_WOOL);

    public final String schemName;
    public final String hexColor;
    public final Material material;

    GamePiece(String schemName, String hexColor, Material material){
        this.schemName = schemName;
        this.hexColor = hexColor;
        this.material = material;
    }

    public String ReturnConfirmationMessage(Player player){
        return String.format("#5FFFFAPlayer (#5FFF9C%s#5FFFFA) has been assigned a color [%s%s#5FFFFA]", player.getDisplayName(), hexColor, schemName);
    }
}
