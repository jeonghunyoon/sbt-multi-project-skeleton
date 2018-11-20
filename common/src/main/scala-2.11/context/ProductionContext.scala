package context

import org.apache.spark.sql.SparkSession

trait ProductionContext extends CommonContext {
  override protected def initializeContextOptions(): Unit = {

  }

  val spark: SparkSession = ss

  override protected def ss: SparkSession = {
    initializeContext()

    _spark
  }

  override protected def initializeContext(): Unit = {
    if (_spark == null) {
      if (!ProductionContext.initialized) {
        ProductionContext.this.synchronized {
          initializeSparkSession()
        }
      }
    }
  }

  private def initializeSparkSession(): Unit = {
    def createBuilder() = {
      val builder = SparkSession.builder()
      if (contextOptions.getEnableHive() == true) {
        try {
          builder.enableHiveSupport()
        } catch {
          case e: Exception => e.getMessage()
        }
      }

      builder
    }

    if (GlobalContext.spark == null) {
      _spark = createBuilder().getOrCreate()
      GlobalContext.initialize(_spark)
    } else {
      _spark = GlobalContext.spark
    }

    ProductionContext.initialized = true
  }
}

object ProductionContext {
  @volatile
  private var initialized = false

  val initLock = new Object()
}