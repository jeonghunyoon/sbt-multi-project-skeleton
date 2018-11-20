package context

class ContextOptions {
  private var enableHive = true
  private val sparkConfigOptions = scala.collection.mutable.Map.empty[String, String]

  private type Self = this.type

  def getEnableHive() = this.enableHive
  def setEnableHive(enable: Boolean): Self = {
    this.enableHive = enable

    this
  }

  def getSparkConfigOptions() = this.sparkConfigOptions
  def setSparkConfigOptions(configOptions: Map[String, String]): Self = {
    this.sparkConfigOptions ++= configOptions

    this
  }
}

object ContextOptions {
  def apply(): ContextOptions = new ContextOptions()
}