package com.netaporter.main

import org.scalatest.FlatSpec

/**
 * Created by Abim on 31/07/2016.
 */
class BasketSpec extends FlatSpec {

  val sugar = Product(1, "sugar", "$5.00")
  val bread = Product(2, "bread", "$2.00")
  val milk = Product(3, "milk", "$1.50")

  val inventory = Map(1 -> sugar, 2 -> bread, 3 -> milk)

  "A Basket" should "have a size of 1 when an item is added" in {

    val basket = Basket(inventory)

    assert(basket.check().isEmpty)

    basket.add("2")

    assert(basket.check().size == 1)
  }

  "A Basket" should "have a size of 0 when an item is removed" in {

    val basket = Basket(inventory)

    basket.add("2")

    assert(basket.check().size == 1)

    basket.remove("2")

    assert(basket.check().isEmpty)
  }

  "A Basket" should "remove an item only once" in {

    val basket = Basket(inventory)

    basket.add("2")
    basket.add("3")
    basket.add("2")

    assert(basket.check().size == 3)

    basket.remove("2")

    assert(basket.check().size == 2)
  }

  "A Basket" should "be listable" in {

    val basket = Basket(inventory)

    assert(basket.check() === Nil)

    basket.add("2")
    basket.add("3")

    assert(basket.check() === List(bread, milk))
  }

  "A Basket" should "containing milk and bread should cost 3.50" in {

    val basket = Basket(inventory)

    assert(basket.check() === Nil)

    basket.add("2")
    basket.add("3")

    assert(basket.cost() === BigDecimal(3.50))
  }
}
