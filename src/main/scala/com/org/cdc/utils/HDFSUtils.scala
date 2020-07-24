package com.org.cdc.utils

import org.apache.spark.sql.{DataFrame, SparkSession}

object HDFSUtils {
  def readFromHDFS(hdfsPath:String,hdfsFileName:String,spark:SparkSession): DataFrame ={
    val df=spark.read.option("delimiter",",")
      .option("header","false")
      .csv(s"$hdfsPath/$hdfsFileName")

    return df
  }

  def writeToHDFS(df:DataFrame,hdfsPath: String,hdfsFileName: String): Unit ={
    df.write.option("delimiter",",").csv(s"$hdfsPath/$hdfsFileName")
  }
}
