package com.java.study;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class PushHashSetLoader {

  private Jedis redis = new Jedis();

  private HashMap<String, String> cache = new HashMap<String, String>();

  private HashSet<String> keyset = new HashSet<String>();

  /*
  * 构造函数
  * @param Host 地址
  * @param port 端口
   */
  public PushHashSetLoader(String host, int port){

      this.redis = new Jedis(host, port);

  }
  /*
  * 将数据存储到hashmap中，然后数量超过10000后写入redis
   */
  private void Load_data(String uid, String data){
      cache.put(uid, data);
      if(cache.size()>10000) {
          try {
              Pipeline pipeline = redis.pipelined();
              for (Map.Entry<String, String> entry : cache.entrySet()) {
                  keyset.add(entry.getValue());
                  pipeline.sadd(entry.getValue() + "temp", entry.getKey());
              }
              cache.clear();
              pipeline.syncAndReturnAll();
              pipeline.close();
          } catch (Exception e) {
              e.printStackTrace();
          }finally {
              try {
                  redis.close();
              }catch (Exception ee){
                  ee.printStackTrace();
              }
              redis = new Jedis(redis.getClient().getHost(), redis.getClient().getPort());
          }
      }
  }

  /*
  * 把存储的中间键值rename，覆盖掉原先存在的数据
   */
  private void clean_data(){
      try {
          Pipeline pipeline = redis.pipelined();
          for (Map.Entry<String, String> entry : cache.entrySet()) {
              keyset.add(entry.getValue());
              pipeline.sadd(entry.getValue() + "_temp", entry.getKey());
          }
          System.out.println("cache size:" + cache.size());
          cache.clear();
          pipeline.syncAndReturnAll();
          pipeline.clear();

          Iterator<String> iter = keyset.iterator();
          while (iter.hasNext()) {
              String key = iter.next();
              if (this.redis.exists(key + "_temp")) {
                  this.redis.rename(key + "_temp", key);
              }
          }
      }catch (Exception e){
          e.printStackTrace();
      }
  }

  /*
  * 关闭redis连接
   */
  public void close(){
      this.redis.close();
  }

  /*
  读取数据写入redis
   */
  public void write_redis() {
      try {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
          String line = null;
          while((line = br.readLine())!=null){
              String[] lineArr = line.trim().split("\t", -1);
              if(lineArr.length != 2)
                  continue;
              String uid = lineArr[0];
              String key = lineArr[1];
              System.out.println(lineArr);
              this.Load_data(uid, key);
          }
          this.clean_data();
          br.close();

      }catch (Exception e){
          e.printStackTrace();
      }
  }
  /*
  主函数
   */
  public static void main(String args[]){
      if(args[0] == null || args[1] == null){
          System.exit(0);
      }
      else {
          PushHashSetLoader redis = new PushHashSetLoader(args[0],Integer.parseInt(args[1]));
          redis.write_redis();
          redis.close();
      }
  }
}
