package pers.li.mk;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2023/6/6 16:50
 * @Description :
 */
public class sss {

    public static void main(String[] args) {
        A a = new A();
        Class aClass = a.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        List<String> filedNames = new ArrayList<>();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Type genericType = declaredField.getGenericType();
//            System.err.println(genericType.getTypeName());
            String name = declaredField.getName();
            if(genericType.getTypeName().equals("java.math.BigDecimal")){
                filedNames.add(name);
            }
//            System.err.println(name);
        }


        BigDecimal bigDecimal = new BigDecimal("3.141");
        bigDecimal.setScale(2, RoundingMode.HALF_UP);

        System.err.println(filedNames);
    }
}

class A {
    private String d;
    private BigDecimal c;
}
