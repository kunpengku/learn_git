package static_l;

/**
 * Created by fupeng on 2017/5/19.
 */
public class Eat {
    public static void print(){
        System.out.println("eat");
    }

    public static void main(String[] args) {
        Eat e = new EatImpl();

        e.print();
    }
}
