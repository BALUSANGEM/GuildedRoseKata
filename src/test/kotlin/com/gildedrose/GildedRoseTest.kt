package com.gildedrose

import com.gildedrose.items.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun whenParametersGivenCheckIfStringisValid() {
        val dexterity = Dexterity("name", 0,0)
        val items = arrayOf<IDailyUpdatable>(dexterity)
        fastForwardDays(items, 4)
        assertEquals("name, -4, 0", dexterity.toString())
    }

    @Test
    fun foo() {
        val dexterity = Dexterity("+5 Dexterity Vest", 10, 20)
        val items = arrayOf<IDailyUpdatable>(dexterity)
        fastForwardDays(items, 1)
        assertEquals("+5 Dexterity Vest", dexterity.name)
    }

    @Test
    fun whenSellDatePassedQualityShouldNotBeNegative() {
        val dexterity = Dexterity("+5 Dexterity Vest", 1, 20)
        val items = arrayOf<IDailyUpdatable>(dexterity)
        fastForwardDays(items, 3)
        assertTrue(dexterity.quality >= 0)
    }

    @Test
    fun whenSellDatePassedAssertQualityDegradestwiceAsFast() {
        val elixirOfMongoose = ElixirOfMongoose("Elixir of the Mongoose", 1, 10)
        val items = arrayOf<IDailyUpdatable>(elixirOfMongoose)
        fastForwardDays(items, 2)
        assertEquals(7, elixirOfMongoose.quality)
    }

    @Test
    fun whenSellDatePassedAssertQualityShouldNotbeNegative() {
        val elixirOfMongoose = ElixirOfMongoose("Elixir of the Mongoose", 1, 10)
        val items = arrayOf<IDailyUpdatable>(elixirOfMongoose)
        fastForwardDays(items, 4)
        assertTrue(elixirOfMongoose.quality >= 0)
    }

    @Test
    fun whenDaysPassedAgedBrideQualityShouldIncrease() {
        val agedBride = AgedBride("Aged Brie", 2, 0)
        val items = arrayOf<IDailyUpdatable>(agedBride)
        fastForwardDays(items, 2)
        assertEquals(2, agedBride.quality)
    }

    @Test
    fun qualityOfItemIsNeverMoreThanFifty() {
        val agedBride = AgedBride("Aged Brie", 2, 10)
        val items = arrayOf<IDailyUpdatable>(agedBride)
        fastForwardDays(items, 50)
        assertEquals(50, agedBride.quality)
    }

    @Test
    fun whenDaysPassedSulfurusQualityShouldNotChange() {
        val sulfuras = Sulfuras("Sulfuras, Hand of Ragnaros", 3, 80)
        val items = arrayOf<IDailyUpdatable>(sulfuras)
        fastForwardDays(items, 2)
        assertEquals(80, sulfuras.quality)
    }

    @Test
    fun whenDaysPassedBackstagePassesQualityShouldIncrease() {
        val backStagePasses = BackStagePasses("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        val items = arrayOf<IDailyUpdatable>(backStagePasses)
        fastForwardDays(items, 2)
        assertEquals(22, backStagePasses.quality)
    }

    @Test
    fun whenDaysPassedBackstagePassesQualityIncreasesByTwoWhenThereAreTenDaysOrLess() {
        val backStagePasses = BackStagePasses("Backstage passes to a TAFKAL80ETC concert", 10, 20)
        val items = arrayOf<IDailyUpdatable>(backStagePasses)
        fastForwardDays(items, 2)
        assertEquals(24, backStagePasses.quality)
    }

    @Test
    fun whenDaysPassedBackstagePassesQualityIncreasesByThreeWhenThereAreFiveDaysOrLess() {
        val backStagePasses = BackStagePasses("Backstage passes to a TAFKAL80ETC concert", 7, 20)
        val items = arrayOf<IDailyUpdatable>(backStagePasses)
        fastForwardDays(items, 3)
        assertEquals(27,backStagePasses.quality)
    }

    @Test
    fun whenConcertDoneBackstagePassesQualityDropsToZero() {
        val backStagePasses = BackStagePasses("Backstage passes to a TAFKAL80ETC concert", 3, 20)
        val items = arrayOf<IDailyUpdatable>(backStagePasses)
        fastForwardDays(items, 4)
        assertEquals(0, backStagePasses.quality)
    }

    @Test
    fun whenDayPassedConjuredItemQualityDecreasesByTwo() {
        val conjured = Conjured("Conjured", 7, 20)
        val items = arrayOf<IDailyUpdatable>(conjured)
        fastForwardDays(items, 3)
        assertEquals(14,conjured.quality)
    }

    private fun fastForwardDays(items: Array<IDailyUpdatable>, days: Int) {
        val app = GildedRose(items)
        for (i in (0 until days)) {
            app.updateQuality()
        }
    }


}


