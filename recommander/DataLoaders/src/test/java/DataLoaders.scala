
import java.sql.{Connection, DriverManager}
import java.util.Properties

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

    val mySQLConfig = Map(
      "url" -> "jdbc:mysql://localhost:3306/mrs?serverTimezone=GMT",
      "driver"->"com.mysql.cj.jdbc.Driver",
      "dbtable"->"movie",
      "user"->"root",
      "password"->"lx199909077997"
    )



    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("DataLoader")


    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

    val properties = new Properties()

    properties.setProperty("user","root")
    properties.setProperty("password","lx199909077997")
    val person:DataFrame = spark.read.jdbc("jdbc:mysql://localhost:3306/mrs?serverTimezone=GMT","movie",properties)
    val view = person.createOrReplaceTempView("T1")

    print("select * from T1")
//    val movieDF = spark.read.format("jdbc").options(mySQLConfig).load()
//    movieDF.show()

        import spark.implicits._
//    val columns = Seq("language","users_count")
//    val data = Seq(("Java","2000"),("Python","1000"),("Scala","30000"))
//        val rdd = spark.sparkContext.makeRDD(data)
//        rdd.foreach(print)
//        val sql = rdd.toDF()
//        sql.show()
//        val movieRDD = new JdbcRDD(
//          spark.sparkContext ,         //SparkContext
//          getConn,        //返回一个jdbc连接的函数
//          "SELECT * FROM movie WHERE m_id >= ? AND m_id <= ?",  //sql语句（要包含两个占位符）
//          4,      //第一个占位符的最小值
//          10,    //第二个占位符的最大值
//          2, //分区数量
//          rs => {
//            val id = rs.getLong(1)
//            val name = rs.getString(2)
//            val rate = rs.getFloat(3)
//            val director = rs.getString(4)
//            val screenwriter= rs.getString(5)
//            val actor = rs.getString(6)
//            val types = rs.getString(7)
//            val area = rs.getString(8)
//            val language =rs.getString(9)
//            val length = rs.getInt(10)
//            val coverurl = rs.getString(11)
//            val click = rs.getString(12)
//            val start_time=rs.getString(13)
//            val introduction = rs.getString(14)
//
//            (id, name,rate,director,screenwriter,actor,types,area,language,length,coverurl,click,start_time,introduction)
//          }
//        ).toDF()
//

    spark.stop()
//    val ratingRDD = null
//    val tagRDD = null

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


