package com.gildedrose.items

import com.gildedrose.Item
import com.gildedrose.QUALITY_MIN_LIMIT
import com.gildedrose.SELLIN_MIN_LIMIT

class Dexterity(
        name: String, sellIn: Int, quality: Int
) : Item(name, sellIn, quality), IDailyUpdatable {

    override fun update() {
        sellIn -= 1
        if (quality <= QUALITY_MIN_LIMIT) return
        updateQuantity()
    }

    private fun updateQuantity() {
        val value =
                if (sellIn < SELLIN_MIN_LIMIT) {
                    2
                } else {
                    1
                }
        quality -= value
    }

}