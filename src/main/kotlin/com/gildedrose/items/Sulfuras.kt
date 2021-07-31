package com.gildedrose.items

import com.gildedrose.Item

class Sulfuras(
        name: String, sellIn: Int, quality: Int
) : Item(name, sellIn, quality), IDailyUpdatable {
    init {
        this.quality = 80
    }
    override fun update() {
    }

}