organization := "com.qifun"

name := "stateless-future"

libraryDependencies <+= (scalaVersion) { sv =>
  "org.scala-lang" % "scala-reflect" % sv
}

libraryDependencies += "junit" % "junit-dep" % "4.10" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.10" % "test"

scalacOptions ++= Seq("-optimize", "-unchecked", "-Xlint", "-feature")

scalacOptions <++= (scalaVersion) map { sv =>
  if (sv.startsWith("2.10.")) {
    Seq("-deprecation") // Fully compatible with 2.10.x 
  } else {
    Seq() // May use deprecated API in 2.11.x
  }
}

crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1")

description := "The rubost asynchronous programming facility for Scala that offers a direct API for working with Futures."

startYear := Some(2014)
