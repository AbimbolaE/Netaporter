package com.netaporter.main

import org.scalatest.FlatSpec

/**
 * Created by Abim on 01/08/2016.
 */
class InventorySpec extends FlatSpec {

  val sugar = Product(1, "sugar", "$5.00")
  val bread = Product(2, "bread", "$2.00")
  val milk = Product(3, "milk", "$1.50")

  "An Inventory" should "produce a list of Products from a CSV" in {

    assert(Inventory("src/test/resources/test.csv") == Map(1 -> sugar, 2 -> bread, 3 -> milk))
  }
}
