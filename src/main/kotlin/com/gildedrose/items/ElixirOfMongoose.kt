package com.gildedrose.items

import com.gildedrose.Item
import com.gildedrose.QUALITY_MIN_LIMIT
import com.gildedrose.SELLIN_MIN_LIMIT

class ElixirOfMongoose(
        name: String, sellIn: Int, quality: Int
) : Item(name, sellIn, quality), IDailyUpdatable {
    override fun update() {
        sellIn -= 1
        if (quality <= QUALITY_MIN_LIMIT) return
        updateQuality()
    }

    private fun updateQuality() {
        quality -= if (sellIn < SELLIN_MIN_LIMIT) {
            2
        } else {
            1
        }
    }

}