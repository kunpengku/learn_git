package learn_mybatis;

/**
 * Created by fupeng on 2017/4/11.
 */
public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int id;
    private String NAME;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", age=" + age +
                '}';
    }
}
