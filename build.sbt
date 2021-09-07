name := "UT-IT"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
  "org.mockito" %% "mockito-scala" % "1.16.39" % Test)
