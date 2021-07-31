package com.gildedrose.items

import com.gildedrose.Item
import com.gildedrose.QUALITY_MAX_LIMIT
import com.gildedrose.QUALITY_MIN_LIMIT
import com.gildedrose.SELLIN_MIN_LIMIT

class BackStagePasses(
        name: String, sellIn: Int, quality: Int
) : Item(name, sellIn, quality), IDailyUpdatable {

    override fun update() {
        sellIn -= 1
        when {
            sellIn < SELLIN_MIN_LIMIT -> quality = QUALITY_MIN_LIMIT
            sellIn < 5 -> quality += 3
            sellIn < 10 -> quality += 2
            quality < QUALITY_MAX_LIMIT -> quality += 1
        }
    }

}
