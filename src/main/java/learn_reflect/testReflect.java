package learn_reflect;

import learn_list.testArrayList;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by yuan on 2017/3/23.
 */
public class testReflect {

    public static void main(String[] args) {
        Class cl = testArrayList.class;
        String  modifiers = Modifier.toString(cl.getModifiers());

        System.out.println(modifiers);
        System.out.println(cl.getName());
        Method [] ms = cl.getDeclaredMethods();
        for(Method m : ms){
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.println(retType.getName() + " " + name);
        }

    }
}
