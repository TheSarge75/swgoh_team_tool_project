package com.jonesGroup.swgoh.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserProfileTest {

    private static UserProfile userProfile;

    @BeforeAll
    private static void setUp() {
        userProfile = UserProfile.getProfile();
    }

    @Test
    void itShouldGetAProfile(){
        Assertions.assertNotNull(userProfile.getUserName());
    }

    @Test
    void itShouldBeTheCorrectUserName(){
        Assertions.assertTrue(userProfile.getUserName().matches("TheSarge"));
    }

    @Test
    void itShouldHaveTheCorrectLevelValue(){
        Assertions.assertEquals(userProfile.getLevel(),85);
    }

    @Test
    void itShouldHaveANULLAllyCode(){
        Assertions.assertNull(userProfile.getAllyCode());
    }
    @Test
    void itShouldHaveAGalacticWarBattleWinsValue(){
        Assertions.assertNotEquals(userProfile.getBattle_wins_galacticWar(),0);
    }
    @Test
    void itShouldHaveAHardBattleWinsValue(){
        Assertions.assertNotEquals(userProfile.getBattle_wins_hard(),0);
    }
    @Test
    void itShouldHaveANormalBattleWinsValue(){
        Assertions.assertNotEquals(userProfile.getBattle_wins_normal(),0);
    }
}