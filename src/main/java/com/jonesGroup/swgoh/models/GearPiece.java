package com.jonesGroup.swgoh.models;

import java.util.ArrayList;

public class GearPiece {

    private String name;
    private String description;
    private Integer costInCrystals; // One (1) MK 12 ArmaTek Multi-tool costs 2100 in-game crystals
    private ArrayList<String> locationsFound;
    private ArrayList<Hero> heroesNeededBy;
    private Integer numberInInventory;
    private ArrayList<GearPiece> gearPiecesNeededToCraft;
    private Integer creditCostToCraft;
    private SwgohGearStats stats;

}
