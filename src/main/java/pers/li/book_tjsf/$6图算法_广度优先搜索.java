package pers.li.book_tjsf;

import java.util.*;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2022/9/4 10:57
 * @Description : pers\li\book_tjsf\img\广度优先.jpg    导航：找出最少需要转几次车
 * 1.将图转换为需要检查的数组
 * 2.有方向指针的叫有向图，没有的叫无向图
 * 3.先检查一度关系，再检查二度关系，判断不存在，则将二度关系加入队列中
 * 4.示例：在你的人际关系网中找到律师（需要考虑两个人可能会有共同的朋友）
 * 时间复杂度O(v+E) 人数加边数 其中V为顶点数，E为边数
 */
public class $6图算法_广度优先搜索 {

    public static void main(String[] args) {
        //数据准备：
//        1.将图转换为散列表
        Map<String, String[]> map = new HashMap<>();
        map.put("you", new String[]{"bob", "claire", "alice"});
        map.put("bob", new String[]{"aunj", "peggy"});
        map.put("claire", new String[]{"thom", "jonny"});
        map.put("alice", new String[]{"peggy"});
//        2.申明双端队列，将you放入检查队列
        boolean peggy = findPerson(map, "peggy");
        System.err.println(peggy);
    }

    private static boolean findPerson(Map<String, String[]> map, String peggy) {
        ArrayDeque<String> check = new ArrayDeque<>();
        addLast(map.get("you"), check, null);
//        用于存放已经检查过得朋友
        List<String> list = new ArrayList<>();
//        3.开始检查
//        只要队列有内容就一直检查
        while (!check.isEmpty()) {
            String first = check.pollFirst();
            list.add(first);
            if (peggy.equals(first)) {
                return true;
            } else {
                if (map.get(first) != null) {
                    addLast(map.get(first), check, list);
                }
            }
        }
        return false;
    }

    private static void addLast(String[] yours, ArrayDeque<String> check, List<String> list) {
        for (String your : yours) {
//            如果包含，则已经检查过，就没必要在加入队列中
            if(list!=null){
                boolean contains = list.contains(your);
                if (!contains){
                    check.addLast(your);
                }
            }else {
                check.addLast(your);
            }
        }
    }


}
