import context.ProductionContext
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.DataTypes

object HiveTest extends ProductionContext {

  override protected def initializeContextOptions(): Unit = {
    contextOptions.setEnableHive(true)
  }

  def main(args: Array[String]): Unit = {


    spark.close()
  }
}