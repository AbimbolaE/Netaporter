package com.netaporter.main

import java.io.{File, FileInputStream, InputStreamReader}

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

import scala.collection.immutable.TreeMap
import scala.io.Source

/**
 * Created by Abim on 31/07/2016.
 */
object Inventory {

  import purecsv.safe._
  import purecsv.safe.tryutil._

  val logger = Logger(LoggerFactory.getLogger("com.netaporter.main.inventory"))

  def apply(filename: String) = {

    val csv = Source.fromFile(filename, "UTF-8").mkString

    val (items, errors) = CSVReader[Product]
      .readCSVFromString(csv, skipHeader = true)
      .getSuccessesAndFailures

    errors foreach (e => logger.error(s"There was an error with record ${e._1}", e._2))

    items
      .map(_._2)
      .foldLeft(TreeMap.empty[Int, Product]) { (m, p) => m + (p.id -> p) }
  }
}
