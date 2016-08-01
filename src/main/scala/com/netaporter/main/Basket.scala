package com.netaporter.main

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

import scala.collection.mutable.ListBuffer
import scala.util.{Failure, Success, Try}

/**
 * Created by Abim on 31/07/2016.
 */
case class Basket(inventory: Map[Int, Product]) {

  private val logger = Logger(LoggerFactory.getLogger("com.netaporter.main.basket"))

  private val content = ListBuffer.empty[Product]

  def add(productId: String) = Try { productId.toInt } match {
    case Success(id) =>
      inventory get id match {
        case None => println(s"The id $id is not a valid id")
        case Some(p) =>
          println(s"${p.name} added")
          content += p
      }
    case Failure(ex) => logger.warn("The user tried to add a non-existent product", ex)
  }

  def remove(productId: String) = Try { productId.toInt } match {
    case Success(id) =>
      inventory get id match {
        case None => println(s"The id $id is not a valid id")
        case Some(p) =>
          if (content.contains(p)) {
            println(s"${p.name} removed")
            content -= p
          }
          else println(s"${p.name} is not in your basket")
      }
    case Failure(ex) => logger.warn("The user tried to remove a non-existent product", ex)
  }

  def check() = content.toList

  def cost() = content
    .map(_.price)
    .map(_.substring(1))
    .map(_.toDouble)
    .map(BigDecimal(_))
    .sum
}
