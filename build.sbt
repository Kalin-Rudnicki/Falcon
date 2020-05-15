lazy val root = project
  .in(file("."))
  .settings(
    name := "Falcon",
    version := "0.1.0",
    
    scalaVersion := "0.24.0-RC1",
    
    libraryDependencies ++= List(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "org.scalaz" %% "scalaz-core" % "7.2.30",
      "org.rogach" %% "scallop" % "3.4.0",
      "org.scalactic" %% "scalactic" % "3.1.1",
      "org.scalatest" %% "scalatest" % "3.1.1" % "test"
    ).map(_.withDottyCompat(scalaVersion.value))
    
  )
