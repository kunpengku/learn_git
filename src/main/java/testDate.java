import java.util.Date;

/**
 * Created by yuan on 2017/3/20.
 */
public class testDate {
    public static void main(String[] args) {
        Date d = new Date();
        long timeStamp = d.getTime();
        System.out.println(d);
        System.out.println(timeStamp);
    }
}
