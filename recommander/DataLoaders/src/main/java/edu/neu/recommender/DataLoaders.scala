package edu.neu.recommender

import java.sql.{Connection, DriverManager}
import java.util.Properties

import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.sql.{DataFrame, SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext, sql}


case class Movie()
case class Rating()
case class Tag()
case class MySqlConfig(str: String, str1: String, str2: String, str3: String)

//把MySQL和ES封装成样例类
case class MySQLConfig(uri:String , db:String,username:String,password:String)

case class ESConfig(httpHosts:String,transportHosts:String,index:String,clustername:String)


object DataLoaders {
  val getConn: () => Connection = () => {
    DriverManager.getConnection("jdbc:mysql://localhost:3306/mrs?serverTimezone=GMT","root","lx199909077997")
  }

  def main(args: Array[String]): Unit = {
    val config = Map(
      "spark.cores"->"local[*]",
      "mysql.uri" ->"jdbc:mysql:localhost:3306/mrs",
      "mysql.db"->"mrs",
      "mysql.username"->"root",
      "mysql.password"->"lx199909077997",
      "es.transportHosts" -> "localhost:9300",
      "es.index" -> "mrs",
      "es.cluster.name" -> "elasticsearch"
    )
//    val mySQLConfig = Map(
//      "url" -> "jdbc:mysql://localhost:3306/mrs?serverTimezone=GMT",
//      "driver"->"com.mysql.cj.jdbc.Driver",
//      "dbtable"->"test",
//      "user"->"root",
//      "password"->"lx199909077997"
//    )

    implicit val mySqlconfig: MySqlConfig = MySqlConfig(config("mysql.uri"),config("mysql.db"),config("mysql.username"),config("mysql.password"))

    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("DataLoader")

    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

    val prop = new Properties()
    prop.setProperty("user",config("mysql.username"))
    prop.setProperty("password",config("mysql.password"))


    //    加载数据
    val movieDF:DataFrame = spark.read.jdbc("jdbc:mysql://localhost:3306/mrs?serverTimezone=GMT","movie",prop)
//    movieDF.show()
    movieDF.createOrReplaceTempView("Table")



    spark.stop()
    val ratingRDD = null
    val tagRDD = null


//
//    //数据保存到mySQL
//    storeDataInMySQL()

//
//    //数据保存到ES
//    storeDataInES()
//
//    spark.stop()
  }

//def storeDataInMySQL(movieDF:DataFrame,ratingDF:DataFrame,tagDF:DataFrame)(implicit seqconfig:MySqlConfig):Unit = {
//  val sqlClient =
//}


}


