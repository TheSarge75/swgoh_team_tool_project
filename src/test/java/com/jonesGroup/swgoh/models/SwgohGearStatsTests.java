package com.jonesGroup.swgoh.models;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SwgohGearStatsTests {

    @Test
    public void allPropertiesAreFalseOrZero_when_SwgohGearStats_constructor_called(){

        SwgohGearStats stats = new SwgohGearStats();

        Assert.assertFalse(stats.isAddsAgility());
        Assert.assertFalse(stats.isAddsArmor());
        Assert.assertFalse(stats.isAddsArmorPenetration());
        Assert.assertFalse(stats.isAddsArmor());
        Assert.assertFalse(stats.isAddsHealth());
        Assert.assertFalse(stats.isAddsPhysicalCriticalChance());
        Assert.assertFalse(stats.isAddsHealthSteal());
        Assert.assertFalse(stats.isAddsPhysicalDamage());
        Assert.assertFalse(stats.isAddsPotency());
        Assert.assertFalse(stats.isAddsResistancePenetration());
        Assert.assertFalse(stats.isAddsSpecialCriticalChance());
        Assert.assertFalse(stats.isAddsSpecialDamage());
        Assert.assertFalse(stats.isAddsSpeed());
        Assert.assertFalse(stats.isAddsStrength());
        Assert.assertFalse(stats.isAddsTactics());
        Assert.assertFalse(stats.isAddsTenacity());

        Assert.assertTrue(stats.getAgilityPointsAdded() == 0);
        Assert.assertTrue(stats.getHealthStealPercentageAdded() == 0.0);
        Assert.assertTrue(stats.getArmorPenetrationPointsAdded() == 0);
        Assert.assertTrue(stats.getArmorPointsAdded() == 0);
        Assert.assertTrue(stats.getHealthPointsAdded() == 0);
        Assert.assertTrue(stats.getPhysicalCriticalChancePointsAdded() == 0);
        Assert.assertTrue(stats.getPhysicalDamagePointsAdded() == 0);
        Assert.assertTrue(stats.getPotencyPercentageAdded() == 0.0);
        Assert.assertTrue(stats.getResistancePenetrationPointsAdded() == 0);
        Assert.assertTrue(stats.getSpecialCriticalChancePointsAdded() == 0);
        Assert.assertTrue(stats.getSpecialDamagePointsAdded() == 0);
        Assert.assertTrue(stats.getSpeedPointsAdded() == 0);
        Assert.assertTrue(stats.getStrengthPointsAdded() == 0);
        Assert.assertTrue(stats.getTacticsPointsAdded() == 0);
        Assert.assertTrue(stats.getTenacityPercentageAdded() == 0.0);
    }
}
