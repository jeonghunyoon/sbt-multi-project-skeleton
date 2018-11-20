import sbt._
import Keys._

object Common {
  val commonSettings = Seq(
    version := "0.0.1-SNAPSHOT",
    organization := "com.kakao.talkhello",
    scalaVersion := "2.11.8",
    javacOptions ++= Seq("-source", "1.7"),
    resolvers ++= Seq(
      "cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos",
      Resolver.sonatypeRepo("releases"),
      Resolver.sonatypeRepo("snapshots")
    ),
    addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
  )
}