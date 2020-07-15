package edu.neu.recommender

import java.sql.{Connection, DriverManager}

import org.apache.spark.rdd.JdbcRDD
import org.apache.spark.sql.{DataFrame, SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext, sql}


case class Movie()
case class Rating()
case class Tag()

//把MySQL和ES封装成样例类
case class MySQLConfig(uri:String , db:String,username:String,password:String)

case class ESConfig(httpHosts:String,transportHosts:String,index:String,clustername:String)


object DataLoaders {
  val getConn: () => Connection = () => {
    DriverManager.getConnection("jdbc:mysql://localhost:3306/mrs?serverTimezone=GMT","root","lx199909077997")
  }

  def main(args: Array[String]): Unit = {
//    val url = "jdbc:mysql:localhost:3306/my_test"
//    val username = "root"
//    val password = "lx199909077997"
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
    val mySQLConfig = Map(
      "url" -> "jdbc:mysql://localhost:3306/mrs?serverTimezone=GMT",
      "driver"->"com.mysql.cj.jdbc.Driver",
      "dbtable"->"test",
      "user"->"root",
      "password"->"lx199909077997"
    )



    val sparkConf = new SparkConf().setMaster(config("spark.cores")).setAppName("DataLoader").setJars(Array("/recommander/DataLoaders/DataLoaders.jar"))


    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    val movieDF = spark.read.format("jdbc").options(mySQLConfig).load()
    movieDF.show()

//    val sc = new SparkContext(sparkConf)

//    import spark.implicits._
//
////    val df = spark.read.format("jdbc").options()
////      options(config("mysql.uri"),"com.mysql.jdbc.Driver","SELECT * FROM movie","root","lx199909077997").load()
//
////    加载数据
//    val movieRDD:DataFrame = new JdbcRDD(
//      spark.sparkContext ,         //SparkContext
//      getConn,        //返回一个jdbc连接的函数
//      "SELECT * FROM movie WHERE m_id >= ? AND m_id <= ?",  //sql语句（要包含两个占位符）
//      1291543,      //第一个占位符的最小值
//      1291555,    //第二个占位符的最大值
//      2, //分区数量
//      rs => {
//        val id = rs.getLong(1)
//        val name = rs.getString(2)
//        val rate = rs.getFloat(3)
//        val director = rs.getString(4)
//        val screenwriter= rs.getString(5)
//        val actor = rs.getString(6)
//        val types = rs.getString(7)
//        val area = rs.getString(8)
//        val language =rs.getString(9)
//        val length = rs.getInt(10)
//        val coverurl = rs.getString(11)
//        val click = rs.getString(12)
//        val start_time=rs.getString(13)
//        val introduction = rs.getString(14)
//
//        (id, name,rate,director,screenwriter,actor,types,area,language,length,coverurl,click,start_time,introduction)           //将读取出来的数据保存到一个元组中
//      }
//    ).toDF()
//
//    val result  = movieRDD.collect()
//    println(result.toBuffer)

    spark.stop()
    val ratingRDD = null
    val tagRDD = null

    //数据预处理
//
//    //数据保存到mySQL
//    storeDataInMySQL()
//
//    //数据保存到ES
//    storeDataInES()
//
//    spark.stop()
  }




}


