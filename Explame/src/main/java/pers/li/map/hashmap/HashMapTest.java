package pers.li.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * create by lishengbo 2018/7/4
 */
public class HashMapTest
{

    public static void main(String[] args) {
        Map<String,String > map=new HashMap<String,String >();
        String s= map.put("10", "李生波");
        String s1 = map.put("10", "李生波2");
        System.out.println(map.get("10"));




        System.out.println(s+"|"+s1);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();

            System.out.println(next.getKey()+"|"+next.getValue());
        }


        System.out.println(map.remove("10"));
        System.out.println(map.get("10"));
        System.out.println(map.size());

    }
}
