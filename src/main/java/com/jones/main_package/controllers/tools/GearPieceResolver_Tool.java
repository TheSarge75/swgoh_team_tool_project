package com.jones.main_package.controllers.tools;

import com.jones.main_package.models.GearPiece;

import java.util.ArrayList;

public class GearPieceResolver_Tool {

    private ArrayList<GearPiece> gearPieces;

    public GearPieceResolver_Tool(){
        System.out.println("Gear piece tool launched.");

        this.gearPieces = new ArrayList<>();
    }


}
