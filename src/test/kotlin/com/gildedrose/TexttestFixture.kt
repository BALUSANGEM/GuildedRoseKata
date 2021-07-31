package com.gildedrose

import com.gildedrose.items.*

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = arrayOf<IDailyUpdatable>(
            Dexterity("+5 Dexterity Vest", 10, 20), //
            AgedBride("Aged Brie", 2, 0), //
            ElixirOfMongoose("Elixir of the Mongoose", 5, 7), //
            Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80), //
            Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80),
            BackStagePasses("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            BackStagePasses("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            BackStagePasses("Backstage passes to a TAFKAL80ETC concert", 5, 49)
            // this conjured item does not work properly yet
//            Item("Conjured Mana Cake", 3, 6)
    )

    val app = GildedRose(items)

    var days = 2
    if (args.size > 0) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0..days - 1) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in items) {
            println(item)
        }
        println()
        app.updateQuality()
    }


}
