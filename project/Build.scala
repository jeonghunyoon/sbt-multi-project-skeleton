import Common._
import Dependencies._
import sbt.Keys._
import sbt._
import sbtassembly.AssemblyPlugin.autoImport._

object JobBuild extends Build {
  lazy val root = (project in file("."))
    .settings(commonSettings: _*)
    .settings(
      assemblyJarName in assembly := "skeleton.jar"
    ) aggregate (common)

  // ---------- common project ----------
  lazy val common = (project in file("common"))
    .settings(commonSettings: _*)
    .settings(
      libraryDependencies ++= (commonDependencies ++ sparkDependencies)
    )
}