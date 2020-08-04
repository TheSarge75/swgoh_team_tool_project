package com.jonesGroup.swgoh.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SwgohGearStatsTests {
    private static SwgohGearStats stats;

    @BeforeAll
    public static void setup(){
        stats = new SwgohGearStats();
    }

    @Test
    public void allPropertiesAreFalseOrZero_when_SwgohGearStats_constructor_called(){
        Assertions.assertFalse(stats.isAddsAgility());
        Assertions.assertFalse(stats.isAddsArmor());
        Assertions.assertFalse(stats.isAddsArmorPenetration());
        Assertions.assertFalse(stats.isAddsArmor());
        Assertions.assertFalse(stats.isAddsHealth());
        Assertions.assertFalse(stats.isAddsPhysicalCriticalChance());
        Assertions.assertFalse(stats.isAddsHealthSteal());
        Assertions.assertFalse(stats.isAddsPhysicalDamage());
        Assertions.assertFalse(stats.isAddsPotency());
        Assertions.assertFalse(stats.isAddsResistancePenetration());
        Assertions.assertFalse(stats.isAddsSpecialCriticalChance());
        Assertions.assertFalse(stats.isAddsSpecialDamage());
        Assertions.assertFalse(stats.isAddsSpeed());
        Assertions.assertFalse(stats.isAddsStrength());
        Assertions.assertFalse(stats.isAddsTactics());
        Assertions.assertFalse(stats.isAddsTenacity());

        Assertions.assertEquals((int) stats.getAgilityPointsAdded(), 0);
        Assertions.assertEquals(stats.getHealthStealPercentageAdded(), 0.0);
        Assertions.assertEquals((int) stats.getArmorPenetrationPointsAdded(), 0);
        Assertions.assertEquals((int) stats.getArmorPointsAdded(), 0);
        Assertions.assertEquals((int) stats.getHealthPointsAdded(), 0);
        Assertions.assertEquals((int) stats.getPhysicalCriticalChancePointsAdded(), 0);
        Assertions.assertEquals((int) stats.getPhysicalDamagePointsAdded(), 0);
        Assertions.assertEquals(stats.getPotencyPercentageAdded(), 0.0);
        Assertions.assertEquals((int) stats.getResistancePenetrationPointsAdded(), 0);
        Assertions.assertEquals((int) stats.getSpecialCriticalChancePointsAdded(), 0);
        Assertions.assertEquals((int) stats.getSpecialDamagePointsAdded(), 0);
        Assertions.assertEquals((int) stats.getSpeedPointsAdded(), 0);
        Assertions.assertEquals((int) stats.getStrengthPointsAdded(), 0);
        Assertions.assertEquals((int) stats.getTacticsPointsAdded(), 0);
        Assertions.assertEquals(stats.getTenacityPercentageAdded(), 0.0);
    }
}
