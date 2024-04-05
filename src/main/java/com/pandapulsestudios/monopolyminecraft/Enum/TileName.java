package com.pandapulsestudios.monopolyminecraft.Enum;

import java.util.Arrays;

public enum TileName {
    GO("GO!", TileType.EVENT_SQUARE, null),
    OldKentRoad("Old Kent Road", TileType.PROPERTY, new GameProperty(50, 50, 30, 2, 10, 30, 90, 160, 250)),
    CommunityChest1("Comunity Chest", TileType.EVENT_SQUARE, null),
    WhitechapelRoad("Whitechapel Road", TileType.PROPERTY, new GameProperty(50, 50, 30, 4, 20, 60, 180, 320, 450)),
    IncomeTax("Income Tax", TileType.EVENT_SQUARE, null),
    KingCrossStation("King's Cross Station", TileType.RAILWAY, null),
    TheAngelIslington("The Angel Islington", TileType.PROPERTY, new GameProperty(50, 50, 50, 6, 30, 90, 270, 400, 550)),
    Chance1("Chance", TileType.EVENT_SQUARE, null),
    EustonRoad("Euston Road", TileType.PROPERTY, new GameProperty(50, 50, 50, 6, 30, 90, 270, 400, 550)),
    PentonvilleRoad("Pentonville Road", TileType.PROPERTY, new GameProperty(50, 50, 60,8, 40, 100, 300, 450, 600)),
    Jail("Jail", TileType.EVENT_SQUARE, null),
    PallMall("Pall Mall", TileType.PROPERTY, new GameProperty(100, 100, 70, 10, 50, 150, 450, 625, 750)),
    ElectricCompany("Electric Company", TileType.UTILITY, null),
    Whitehall("Whitehall", TileType.PROPERTY, new GameProperty(100, 100, 70, 10, 50, 150, 450, 625, 750)),
    NorthumberlandAvenue("Northumberland Avenue", TileType.PROPERTY, new GameProperty(100, 100, 80,12, 60, 180, 500, 700, 900)),
    MarylebonStation("Marylebone Station", TileType.RAILWAY, null),
    BowStreet("Bow Street", TileType.PROPERTY, new GameProperty(100, 100, 90,14, 70, 200, 550, 750, 950)),
    CommunityChest2("Comunity Chest", TileType.EVENT_SQUARE, null),
    MarlboroughStreet("Marlborough Street", TileType.PROPERTY, new GameProperty(100, 100, 90,14, 70, 200, 550, 750, 950)),
    VineStreet("Vine Street", TileType.PROPERTY, new GameProperty(100, 100, 100, 16, 80, 220, 600, 800, 1000)),
    FreeParking("Free Parking", TileType.EVENT_SQUARE, null),
    TheStrand("The Strand", TileType.PROPERTY, new GameProperty(150, 150, 110,18, 90, 250, 700, 875, 1050)),
    Chance2("Chance", TileType.EVENT_SQUARE, null),
    FleetStreet("Fleet Street", TileType.PROPERTY, new GameProperty(150, 150, 110,18, 90, 250, 700, 875, 1050)),
    TrafalgarSquare("Trafalgar Square", TileType.PROPERTY, new GameProperty(150, 150, 120,20, 100, 300, 750, 925, 1100)),
    FenchurchStStation("Fenchurch St Station", TileType.RAILWAY, null),
    LeicesterSquare("Leicester Square", TileType.PROPERTY, new GameProperty(150, 150, 130,22, 110, 330, 800, 975, 1150)),
    CoventryStreet("Coventry Street", TileType.PROPERTY, new GameProperty(150, 150, 130, 22, 110, 330, 800, 975, 1150)),
    WaterWorks("Water Works", TileType.UTILITY, null),
    Piccadilly("Piccadilly", TileType.PROPERTY, new GameProperty(150, 150, 140, 24, 120, 360, 850, 1025, 1200)),
    GoToJail("Go To Jail", TileType.EVENT_SQUARE, null),
    RegentStreet("RegentStreet", TileType.PROPERTY, new GameProperty(200, 200, 150, 26, 130, 390, 900, 1100, 1275)),
    OxfordStreet("OxfordStreet", TileType.PROPERTY, new GameProperty(200, 200, 150, 26, 130, 390, 900, 1100, 1275)),
    CommunityChest3("Comunity Chest", TileType.EVENT_SQUARE, null),
    BondStreet("BondStreet", TileType.PROPERTY, new GameProperty(200, 200, 160,28, 150, 450, 1000, 1200, 1400)),
    LiverpoolStreetStation("Liverpool Street Station", TileType.RAILWAY, null),
    Chance3("Chance", TileType.EVENT_SQUARE, null),
    ParkLane("ParkLane", TileType.PROPERTY, new GameProperty(200, 200, 175,35, 175, 500, 1100, 1300, 1500)),
    UtilityTax("Unility Tax", TileType.EVENT_SQUARE, null),
    Mayfair("Mayfair", TileType.PROPERTY, new GameProperty(200, 200, 200, 50, 200, 600, 1400, 1700, 2000));

    public final String name;
    public final TileType tileType;
    public final GameProperty gameProperty;
    TileName(String name, TileType tileType, GameProperty gameProperty){
        this.name = name;
        this.tileType = tileType;
        this.gameProperty = gameProperty;
    }

}
