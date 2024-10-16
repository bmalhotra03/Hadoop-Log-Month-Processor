package stubs;

import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Partitioner;

public class MonthPartitioner<K2, V2> extends Partitioner<Text, Text> implements
    Configurable {
  private Configuration configuration;
  HashMap<String, Integer> months = new HashMap<String, Integer>();
  @Override
  public void setConf(Configuration configuration) {
    this.configuration = configuration;
    months.put("Jan", 0);
    months.put("Feb", 1); // Go on till dec
  }
  @Override
  public Configuration getConf() {
    return configuration;
  }
  public int getPartition(Text key, Text value, int numReduceTasks) {
    return (int) (months.get(value.toString()));
  }
}



