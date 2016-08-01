package com.netaporter.main

/**
 * Created by Abim on 31/07/2016.
 */
case class Product(id: Int, name: String, price: String) {
  override def toString() = s"Id: $id, Name: $name, Price: $price"
}