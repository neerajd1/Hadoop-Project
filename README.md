# Hadoop-Project
Sales analysis Project using hadoop mapreduce and java


hadoop fs -put Sales.csv input  //input data to csv files

hadoop fs -rm -r -f o1         //delete from hdfs

hadoop jar test1.jar testHadoop input o1  //operating mapreduce

to browse hdfs http://localhost:50070/ open in browser

project folder contains the output of mapreduce

jar files required to operate map reduce :-

#Copy hadoop-mapreduce-client-core-2.7.1.jar from ~/hadoop/share/hadoop/mapreduce directory
#Copy hadoop-common-2.7.1.jar from ~/hadoop/share/hadoop/common directory
#Copy commons-cli-1.2.jar from ~/hadoop/share/hadoop/common/lib directory
