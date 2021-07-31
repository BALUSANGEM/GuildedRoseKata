package com.gildedrose.items

import com.gildedrose.Item
import com.gildedrose.QUALITY_MIN_LIMIT

class Conjured(
        name: String, sellIn: Int, quality: Int
) : Item(name, sellIn, quality), IDailyUpdatable {
    override fun update() {
        sellIn -= 1
        if (quality <= QUALITY_MIN_LIMIT) return
        quality -= 2
    }

}