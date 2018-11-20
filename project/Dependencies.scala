import sbt._

object Dependencies {
  val sparkVersion = "2.1.0"
  val jbossVersion = "1.1"
  val log4jVersion = "1.2.17"
  val configVersion = "1.2.1"

  val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
  val sparkHive = "org.apache.spark" %% "spark-hive" % sparkVersion
  val sparkSql = "org.apache.spark" %% "spark-sql" % sparkVersion

  val commonDependencies: Seq[ModuleID] = Seq(

  )

  val sparkDependencies: Seq[ModuleID] = Seq(
    sparkCore % "provided"
    , sparkHive % "provided"
    , sparkSql % "provided"
  )
}