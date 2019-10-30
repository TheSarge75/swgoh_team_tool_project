package com.jones.main_package.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserProfile {

    private String userName;
    private int userId;
    private int level;
    private String allyCode;

    private String guildName;
    private String joinedGuild_date;

    private int galacticPower_total;
    private int galacticPower_heroes;
    private int galacticPower_ships;

    private int fleetArena_wins;
    private int squadArena_wins;

    private int battle_wins_normal;
    private int battle_wins_hard;
    private int battle_wins_galacticWar;

    private int guild_raid_wins;
    private int guild_tokens_earned;

    private int championship_battle_successful_defends;
    private int championship_battle_full_rounds_cleared;
    private int championship_lifetime_score;
    private int championship_battle_undersized_squad_wins;
    private int championship_promotions_earned;
    private int championship_banners_earned;
    private long championship_best_rank;
    private int championship_battle_successful_attacks;
    private int championship_territories_cleared;

    private int numberOf_heroes_unlocked;
    private int numberOf_zetas;
    private int numberOf_heroes_7star;
    private int numberOf_heroes_gear13;
    private int numberOf_heroes_gear12;
    private int numberOf_heroes_gear11;
    private int numberOf_heroes_gear10;
    private int numberOf_ships_unlocked;
    private int numberOf_ships_7star;

    private int squadArena_currentRank;
    private int squadArena_highestRank;
    private int squadArena_lowestRank;
    private int squadArena_averageRank;

    private int fleetArena_currentRank;
    private int fleetArena_highestRank;
    private int fleetArena_lowestRank;
    private int fleetArena_averageRank;

    public UserProfile(){

    }

    public UserProfile(String userName){
        this.userName = userName;
    }

    public static UserProfile getProfile(){
        try {
            Document profileDocument = Jsoup.connect("https://swgoh.gg/p/417316997/").get();
            UserProfile userProfile = createUserProfile(profileDocument);
            return userProfile;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

    private static UserProfile createUserProfile(Document doc){
        UserProfile profile = new UserProfile();

        Elements profileElementsFrom_panel_profile_class = doc.select("div.panel-profile > div.panel-body");
        System.out.println("start");
        System.out.println(profileElementsFrom_panel_profile_class);
        System.out.println("end");

        profile.setUserName(profileElementsFrom_panel_profile_class.select("h5.panel-title").get(0).text());
        profile.setUserId(Integer.parseInt(profileElementsFrom_panel_profile_class.select("h5.m-y-0").get(0).text()));
        profile.setSquadArena_currentRank(Integer.parseInt(profileElementsFrom_panel_profile_class.select("h5.m-y-0").get(1).text()));
        profile.setLevel(Integer.parseInt(profileElementsFrom_panel_profile_class.select("h5.m-y-0").get(2).text()));
        profile.setJoinedGuild_date(profileElementsFrom_panel_profile_class.select("div.panel-body > p > strong").get(2).text());

        profile.setGalacticPower_total(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(0).text()))
            );
        profile.setGalacticPower_heroes(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(1).text()))
            );
        profile.setGalacticPower_ships(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(2).text()))
            );

        profile.setFleetArena_wins(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(3).text()))
            );
        profile.setSquadArena_wins(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(4).text()))
            );
        profile.setBattle_wins_normal(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(5).text()))
            );
        profile.setBattle_wins_hard(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(6).text()))
            );
        profile.setBattle_wins_galacticWar(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(7).text()))
            );

        profile.setGuild_raid_wins(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(8).text()))
            );
        profile.setGuild_tokens_earned(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(9).text()))
            );

        profile.setChampionship_battle_successful_defends(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(10).text()))
            );
        profile.setChampionship_battle_full_rounds_cleared(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(11).text()))
            );
        profile.setChampionship_lifetime_score(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(12).text()))
            );
        profile.setChampionship_battle_undersized_squad_wins(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(13).text()))
            );
        profile.setChampionship_promotions_earned(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(14).text()))
            );
        profile.setChampionship_banners_earned(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(15).text()))
            );
        profile.setChampionship_best_rank(Long.parseLong(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(16).text()))
            );
        profile.setChampionship_battle_successful_attacks(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(17).text()))
            );
        profile.setChampionship_territories_cleared(Integer.parseInt(
                sanitizeString(profileElementsFrom_panel_profile_class.select(".player-stat-info__stat-value > strong").get(18).text()))
            );

        return profile;
    }

    public static String sanitizeString(String rawStr){
        String sanitizedStr = rawStr.replaceAll(",","");
        return sanitizedStr;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public String getAllyCode() {
        return allyCode;
    }

    public void setAllyCode(String allyCode) {
        this.allyCode = allyCode;
    }

    public String getJoinedGuild_date() {
        return joinedGuild_date;
    }

    public void setJoinedGuild_date(String joinedGuild_date) {
        this.joinedGuild_date = joinedGuild_date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGalacticPower_total() {
        return galacticPower_total;
    }

    public void setGalacticPower_total(int galacticPower_total) {
        this.galacticPower_total = galacticPower_total;
    }

    public int getGalacticPower_heroes() {
        return galacticPower_heroes;
    }

    public void setGalacticPower_heroes(int galacticPower_heroes) {
        this.galacticPower_heroes = galacticPower_heroes;
    }

    public int getGalacticPower_ships() {
        return galacticPower_ships;
    }

    public void setGalacticPower_ships(int galacticPower_ships) {
        this.galacticPower_ships = galacticPower_ships;
    }

    public int getFleetArena_wins() {
        return fleetArena_wins;
    }

    public void setFleetArena_wins(int fleetArena_wins) {
        this.fleetArena_wins = fleetArena_wins;
    }

    public int getSquadArena_wins() {
        return squadArena_wins;
    }

    public void setSquadArena_wins(int squadArena_wins) {
        this.squadArena_wins = squadArena_wins;
    }

    public int getBattle_wins_normal() {
        return battle_wins_normal;
    }

    public void setBattle_wins_normal(int battle_wins_normal) {
        this.battle_wins_normal = battle_wins_normal;
    }

    public int getBattle_wins_hard() {
        return battle_wins_hard;
    }

    public void setBattle_wins_hard(int battle_wins_hard) {
        this.battle_wins_hard = battle_wins_hard;
    }

    public int getBattle_wins_galacticWar() {
        return battle_wins_galacticWar;
    }

    public void setBattle_wins_galacticWar(int battle_wins_galacticWar) {
        this.battle_wins_galacticWar = battle_wins_galacticWar;
    }

    public int getGuild_raid_wins() {
        return guild_raid_wins;
    }

    public void setGuild_raid_wins(int guild_raid_wins) {
        this.guild_raid_wins = guild_raid_wins;
    }

    public int getGuild_tokens_earned() {
        return guild_tokens_earned;
    }

    public void setGuild_tokens_earned(int guild_tokens_earned) {
        this.guild_tokens_earned = guild_tokens_earned;
    }

    public int getChampionship_battle_successful_defends() {
        return championship_battle_successful_defends;
    }

    public void setChampionship_battle_successful_defends(int championship_battle_successful_defends) {
        this.championship_battle_successful_defends = championship_battle_successful_defends;
    }

    public int getChampionship_battle_full_rounds_cleared() {
        return championship_battle_full_rounds_cleared;
    }

    public void setChampionship_battle_full_rounds_cleared(int championship_battle_full_rounds_cleared) {
        this.championship_battle_full_rounds_cleared = championship_battle_full_rounds_cleared;
    }

    public int getChampionship_lifetime_score() {
        return championship_lifetime_score;
    }

    public void setChampionship_lifetime_score(int championship_lifetime_score) {
        this.championship_lifetime_score = championship_lifetime_score;
    }

    public int getChampionship_battle_undersized_squad_wins() {
        return championship_battle_undersized_squad_wins;
    }

    public void setChampionship_battle_undersized_squad_wins(int championship_battle_undersized_squad_wins) {
        this.championship_battle_undersized_squad_wins = championship_battle_undersized_squad_wins;
    }

    public int getChampionship_promotions_earned() {
        return championship_promotions_earned;
    }

    public void setChampionship_promotions_earned(int championship_promotions_earned) {
        this.championship_promotions_earned = championship_promotions_earned;
    }

    public int getChampionship_banners_earned() {
        return championship_banners_earned;
    }

    public void setChampionship_banners_earned(int championship_banners_earned) {
        this.championship_banners_earned = championship_banners_earned;
    }

    public long getChampionship_best_rank() {
        return championship_best_rank;
    }

    public void setChampionship_best_rank(long championship_best_rank) {
        this.championship_best_rank = championship_best_rank;
    }

    public int getChampionship_battle_successful_attacks() {
        return championship_battle_successful_attacks;
    }

    public void setChampionship_battle_successful_attacks(int championship_battle_successful_attacks) {
        this.championship_battle_successful_attacks = championship_battle_successful_attacks;
    }

    public int getChampionship_territories_cleared() {
        return championship_territories_cleared;
    }

    public void setChampionship_territories_cleared(int championship_territories_cleared) {
        this.championship_territories_cleared = championship_territories_cleared;
    }

    public int getNumberOf_heroes_unlocked() {
        return numberOf_heroes_unlocked;
    }

    public void setNumberOf_heroes_unlocked(int numberOf_heroes_unlocked) {
        this.numberOf_heroes_unlocked = numberOf_heroes_unlocked;
    }

    public int getNumberOf_zetas() {
        return numberOf_zetas;
    }

    public void setNumberOf_zetas(int numberOf_zetas) {
        this.numberOf_zetas = numberOf_zetas;
    }

    public int getNumberOf_heroes_7star() {
        return numberOf_heroes_7star;
    }

    public void setNumberOf_heroes_7star(int numberOf_heroes_7star) {
        this.numberOf_heroes_7star = numberOf_heroes_7star;
    }

    public int getNumberOf_heroes_gear13() {
        return numberOf_heroes_gear13;
    }

    public void setNumberOf_heroes_gear13(int numberOf_heroes_gear13) {
        this.numberOf_heroes_gear13 = numberOf_heroes_gear13;
    }

    public int getNumberOf_heroes_gear12() {
        return numberOf_heroes_gear12;
    }

    public void setNumberOf_heroes_gear12(int numberOf_heroes_gear12) {
        this.numberOf_heroes_gear12 = numberOf_heroes_gear12;
    }

    public int getNumberOf_heroes_gear11() {
        return numberOf_heroes_gear11;
    }

    public void setNumberOf_heroes_gear11(int numberOf_heroes_gear11) {
        this.numberOf_heroes_gear11 = numberOf_heroes_gear11;
    }

    public int getNumberOf_heroes_gear10() {
        return numberOf_heroes_gear10;
    }

    public void setNumberOf_heroes_gear10(int numberOf_heroes_gear10) {
        this.numberOf_heroes_gear10 = numberOf_heroes_gear10;
    }

    public int getNumberOf_ships_unlocked() {
        return numberOf_ships_unlocked;
    }

    public void setNumberOf_ships_unlocked(int numberOf_ships_unlocked) {
        this.numberOf_ships_unlocked = numberOf_ships_unlocked;
    }

    public int getNumberOf_ships_7star() {
        return numberOf_ships_7star;
    }

    public void setNumberOf_ships_7star(int numberOf_ships_7star) {
        this.numberOf_ships_7star = numberOf_ships_7star;
    }

    public int getSquadArena_currentRank() {
        return squadArena_currentRank;
    }

    public void setSquadArena_currentRank(int squadArena_currentRank) {
        this.squadArena_currentRank = squadArena_currentRank;
    }

    public int getSquadArena_highestRank() {
        return squadArena_highestRank;
    }

    public void setSquadArena_highestRank(int squadArena_highestRank) {
        this.squadArena_highestRank = squadArena_highestRank;
    }

    public int getSquadArena_lowestRank() {
        return squadArena_lowestRank;
    }

    public void setSquadArena_lowestRank(int squadArena_lowestRank) {
        this.squadArena_lowestRank = squadArena_lowestRank;
    }

    public int getSquadArena_averageRank() {
        return squadArena_averageRank;
    }

    public void setSquadArena_averageRank(int squadArena_averageRank) {
        this.squadArena_averageRank = squadArena_averageRank;
    }

    public int getFleetArena_currentRank() {
        return fleetArena_currentRank;
    }

    public void setFleetArena_currentRank(int fleetArena_currentRank) {
        this.fleetArena_currentRank = fleetArena_currentRank;
    }

    public int getFleetArena_highestRank() {
        return fleetArena_highestRank;
    }

    public void setFleetArena_highestRank(int fleetArena_highestRank) {
        this.fleetArena_highestRank = fleetArena_highestRank;
    }

    public int getFleetArena_lowestRank() {
        return fleetArena_lowestRank;
    }

    public void setFleetArena_lowestRank(int fleetArena_lowestRank) {
        this.fleetArena_lowestRank = fleetArena_lowestRank;
    }

    public int getFleetArena_averageRank() {
        return fleetArena_averageRank;
    }

    public void setFleetArena_averageRank(int fleetArena_averageRank) {
        this.fleetArena_averageRank = fleetArena_averageRank;
    }
}
