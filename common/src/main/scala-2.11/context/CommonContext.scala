package context

import org.apache.spark.sql.SparkSession

trait CommonContext {
  @transient
  protected var _spark: SparkSession = null
  protected val contextOptions = ContextOptions()

  protected def ss: SparkSession

  protected def initializeContextOptions(): Unit
  protected def initializeContext(): Unit

  initializeContextOptions()
}