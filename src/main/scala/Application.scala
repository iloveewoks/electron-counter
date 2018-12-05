import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object Application extends App {
  val sparkConf = new SparkConf()
    .setAppName("electron-counter")
    .setMaster("local[2]")

  val sparkContext = new SparkContext(sparkConf)
  val sqlContext = new SQLContext(sparkContext)

  val df = sqlContext.read
    .format("com.databricks.spark.csv")
    .option("header","true")
    .option("inferSchema","true")
    .load("lend_rdr_dld_20150102.CSV")

  df.show
}
