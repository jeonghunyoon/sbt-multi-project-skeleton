package context

import org.apache.spark.sql.SparkSession

object GlobalContext {
  private var session: SparkSession = null

  def spark = session

  private[context] def initialize(sparkSession: SparkSession, unitTest: Boolean = false): Unit = {
    if (unitTest || session == null) {
      session = sparkSession
    }
  }

  def getSparkSession() = spark.sparkContext

  def getSqlSession() = spark.sqlContext
}