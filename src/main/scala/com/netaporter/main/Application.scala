package com.netaporter.main

object Application extends App {

  println("************************************")
  println("************************************")
  println("* Welcome to the Net-A-Porter Shop *")
  println("************************************")
  println("Enter \"add <ProductId>\" to add to basket")
  println("Enter \"remove <ProductId>\" to remove from basket")
  println("Enter \"check\" to show the contents of the basket")
  println("Enter \"total\" to show the total price of the basket")
  println("Enter \"list\" to show a list of products in the inventory")
  println()
  println("Enter \"Q\" to Quit")
  println()

  val input = io.Source.stdin.getLines().takeWhile(!_.equals("Q")).map(_.split(" ").toList)

  val inventory = Inventory("src/main/resources/items.csv")

  val basket = Basket(inventory)

  input foreach {
      case "add" :: productId :: Nil => basket add productId
        //TODO: Implement adding to the basket
      case "remove" :: productId :: Nil => basket remove productId
        //TODO: Implement removing from the basket
      case "check" :: Nil =>
        val content = basket.check()
        if (content.isEmpty) println("Nothing in the basket")
        else println(content.map(_.name).mkString(", ")) + "\n"
        //TODO: Implement list the content of basket
      case "total" :: Nil => println(s"Total cost: ${basket.cost()}\n")
        //TODO: Implement the total cost of the basket
      case "list" :: Nil => println(inventory.values.mkString("\n") + "\n")
        //TODO: Implement listing the inventory
      case _ =>
        println(s"Sorry, that is not a valid command\n")
    }

  println("Thanks for shopping at Net-a-Porter!")
}