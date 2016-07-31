package com.netaporter.main

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

/**
 * Created by Abim on 31/07/2016.
 */
object Inventory {

  import Models._

  import purecsv.safe._
  import purecsv.safe.tryutil._

  val logger = Logger(LoggerFactory.getLogger("com.netaporter.main.inventory"))

  def apply() = {

    val (items, errors) = CSVReader[Product]
      .readCSVFromFileName("src/main/resources/items.csv", skipHeader = true)
      .getSuccessesAndFailures

    errors foreach (e => logger.error(s"There was an error with record ${e._1}", e._2))

    items
  }
}
