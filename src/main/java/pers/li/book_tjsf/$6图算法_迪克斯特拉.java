package pers.li.book_tjsf;

import java.util.*;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/9/4 10:57
 * @Description : pers\li\book_tjsf\img\广度优先.jpg    导航：找出用时最短的
 */
public class $6图算法_迪克斯特拉 {

    private static final List<String> finished = new ArrayList<>();

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> graph01 = new HashMap<>();
        Map<String, Integer> graph02 = new HashMap<>();
        Map<String, Integer> graph03 = new HashMap<>();
        Map<String, Integer> graph04 = new HashMap<>();
        Map<String, Integer> graph05 = new HashMap<>();

        graph01.put("A", 5);
        graph01.put("B", 2);
        graph.put("start", graph01);
        graph02.put("D", 4);
        graph02.put("C", 2);
        graph.put("A", graph02);
        graph03.put("A", 8);
        graph03.put("C", 7);
        graph.put("B", graph03);
        graph04.put("F", 3);
        graph04.put("C", 6);
        graph.put("D", graph04);
        graph05.put("F", 1);
        graph.put("C", graph05);
        graph.put("F", null);

        Map<String, Integer> costs = new HashMap<>();
        costs.put("A", 5);
        costs.put("B", 2);
        costs.put("C", Integer.MAX_VALUE);
        costs.put("D", Integer.MAX_VALUE);
        costs.put("F", Integer.MAX_VALUE);

        Map<String, String> parents = new HashMap<>();
        parents.put("A", "start");
        parents.put("B", "start");
        parents.put("C", null);
        parents.put("D", null);
        parents.put("F", null);

//        1.找到最便宜的节点
        String smallNode = findSmallNode(costs);
//        2.如果节点不为null，则需要一直遍历
        while (smallNode != null) {
//        3.获取该节点现在的开销
            Integer oreK = costs.get(smallNode);
            Map<String, Integer> member = graph.get(smallNode);
            if (member == null) {
                break;
            }
//            4.遍历当前节点的邻居节点
            Iterator<Map.Entry<String, Integer>> iter = member.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, Integer> entry = iter.next();
//                计算经邻居节点后的总开销是否比当前开销表小
                String key = entry.getKey();
                Integer linju = entry.getValue();
//              5.计算最新开销
                int newCost = oreK + linju;
//                6.更新的是邻居的开销
                if (costs.get(key) > newCost) {
                    costs.put(key, newCost);
                    parents.put(key, smallNode);
                }
            }
            finished.add(smallNode);
            smallNode = findSmallNode(costs);
        }

        System.err.println(costs);
        System.err.println(parents);
    }

    /**
     * 找最便宜的节点
     *
     * @param costs
     * @return
     */
    private static String findSmallNode(Map<String, Integer> costs) {
        Integer smallVal = Integer.MAX_VALUE;
        String smallKey = "";
        Iterator<Map.Entry<String, Integer>> iter = costs.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value < smallVal && !finished.contains(key)) {
                smallVal = value;
                smallKey = key;
            }
        }
        return smallKey;
    }


}
