name := "naptest"

organization := "com.netaporter"
     
version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.github.melrief" %% "purecsv" % "0.0.6",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",

  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)

resolvers += Resolver.sonatypeRepo("releases")
