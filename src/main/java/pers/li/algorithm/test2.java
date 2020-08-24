package pers.li.algorithm;

import java.util.*;

/**
 * create by lishengbo 2018/7/8
 *
 * 面试模拟;文件内容的数据统计
 */
public class test2 {

    public static void main(String[] args) {
        Map<String,String> map=new HashMap<String,String>();
        map.put("1-1","we");
        map.put("2-1","we1");
        map.put("3-1","we2");
        map.put("1-2","we3");
        map.put("2-2","we3");
        map.put("2-3","we3");

       /* Set<Map.Entry<String, String>> entries = map.entrySet();
        for (int i = 0; i <entries.size() ; i++) {
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> next = iterator.next();
                System.out.println(next.getKey()+"|"+next.getValue());
            }
        }*/
        Map<String,String > map1=new TreeMap<String, String>();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            System.out.println(entry.getKey().substring(0,1));
            String key=entry.getKey().substring(0,1);
            for (String keys:map1.keySet()
                 ) {
                if(keys.equals(key)){

                }
            }
        }
    }
}
