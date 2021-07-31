package com.gildedrose

import com.gildedrose.items.IDailyUpdatable

class GildedRose(var items: Array<IDailyUpdatable>) {

    fun updateQuality() {
        for (i in items.indices) {
            val item = items[i]
            item.update()
        }
    }

}

