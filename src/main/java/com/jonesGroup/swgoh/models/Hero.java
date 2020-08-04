package com.jonesGroup.swgoh.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String displayName;
    private String nameForURL;

    public Hero(){}

    public Hero(String displayName){
        this.displayName = displayName;
    }

    public Hero(String displayName, String nameForURL){
        this.displayName = displayName;
        this.nameForURL = nameForURL;
    }

    public static List<Hero> getAllHeroes(){
        List<Hero> heroesList = new ArrayList<>();

        try {
            Document fullListDocument = Jsoup.connect("https://swgoh.gg/p/417316997/characters/").get();
            Elements heroDisplayNamesFromAltAttributes = fullListDocument.select("a.char-portrait-full-link > img[alt]");
            for (Element hero : heroDisplayNamesFromAltAttributes){
                String displayName = hero.attr("alt");
                heroesList.add(new Hero(displayName, processDisplayName(displayName)));
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        return heroesList;
    }

    public static List<Hero> getMySquadArenaTeam(){
        List<Hero> squadArenaTeamList = new ArrayList<>();

        try {
            Document squadArenaTeamListDocument = Jsoup.connect("https://swgoh.gg/p/417316997/").get();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return squadArenaTeamList;
    }

    public static String processDisplayName(String raw){
        String processed = raw.toLowerCase();
        processed = processed.replace(" ", "-");
        processed = processed.replace("'", "");
        processed = processed.replace("\"", "");
        processed = processed.replace("(", "");
        processed = processed.replace(")", "");
        processed = processed.replace("---", "-");
        processed = Normalizer.normalize(processed,Normalizer.Form.NFD);
        processed = processed.replaceAll("[^\\p{ASCII}]","");
        return processed;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getNameForURL() {
        return nameForURL;
    }

    public void setNameForURL(String nameForURL) {
        this.nameForURL = nameForURL;
    }

}
