organization := "play-circe"

name := "play-circe"

version := "2.5-0.4.1"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8")

libraryDependencies ++= {
  val playV = "2.5.3"
  val circeV = "0.4.1"
  Seq(
    "io.circe" %% "circe-core" % circeV,
    "io.circe" %% "circe-generic" % circeV,
    "io.circe" %% "circe-parser" % circeV,
    "com.typesafe.play" %% "play" % playV % "provided",
    "org.scalatest" %% "scalatest" % "2.2.5" % "test",
    "com.typesafe.play" %% "play-test" % playV % "test",
    "com.typesafe.play" %% "play-ws" % playV % "test"
  )
}


libraryDependencies := {
  CrossVersion.partialVersion(scalaVersion.value) match {
    // if scala 2.11+ is used, quasiquotes are merged into scala-reflect
    case Some((2, scalaMajor)) if scalaMajor >= 11 =>
      libraryDependencies.value
    // in Scala 2.10, quasiquotes are provided by macro paradise
    case Some((2, 10)) =>
      libraryDependencies.value ++ Seq(
        compilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
        "org.scalamacros" %% "quasiquotes" % "2.0.0" cross CrossVersion.binary)
  }
}

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
