package fan;

/**
 * Created by fupeng on 2017/4/17.
 */

interface Apple{
    void eat();
}

class Me implements Apple{

    public void eat() {
        System.out.println("eat");
    }
}

public class autopackage {

    public static void main(String[] args) {
        int i=0;
        Integer j = new Integer(0);
        System.out.println(i==j);
        System.out.println(j.equals(i));


        Me a = new Me();

        a.eat();
    }

}
