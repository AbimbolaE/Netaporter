package com.netaporter.main

object Application extends App {

  println("************************************")
  println("************************************")
  println("* Welcome to the Net-A-Porter Shop *")
  println("************************************")
  println("Enter \"Q\" to Quit")
  println("Enter \"add <ProductId>\" to add to basket")
  println("Enter \"remove <ProductId>\" to remove from basket")
  println("Enter \"list\" to show a list of products in the inventory")
  println("Enter \"total\" to show the total price of the basket")

  val input = io.Source.stdin.getLines().takeWhile(!_.equals("Q")).map(_.split(" ").toList)

  val items = Inventory()

  input foreach {
      case "add" :: productId :: Nil =>
        //TODO: Implement add to basket
      case "remove" :: productId :: Nil =>
        //TODO: Implement remove from basket
      case "list" :: Nil =>
        //TODO: Implement list basket
      case "total" :: Nil =>
        //TODO: Implement list basket
      case _ =>
        println(s"Sorry, that is not a valid command")
    }

  println("Thanks for shopping at Net-a-Porter!")

}