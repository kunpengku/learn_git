package learn_serialization;

import java.io.*;

/**
 * Created by yuan on 2017/3/30.
 */

class Employee implements Serializable{
    private int age;
    private String name;
    Employee(int age, String name){
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Serial_T {
    public static void main(String[] args) throws ClassNotFoundException {
        Employee m = new Employee(20,"Dool");
        System.out.println(m);
        ObjectOutputStream out = null;
        try {
            // 将序列化后的 打印到  屏幕
//            out = new ObjectOutputStream(System.out);
            // 将序列化后的 输出到文件
//            out = new ObjectOutputStream(new FileOutputStream("e.out"));

            //to redis
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            out = new ObjectOutputStream(baos);
            byte [] data = baos.toByteArray();
            // 现在可以把data 中的 数据存入 redis了。

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.writeObject(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读出
        try {
            ObjectInputStream inn = new ObjectInputStream(new FileInputStream("e.out"));
            Employee x = (Employee) inn.readObject();
            System.out.println(x);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
