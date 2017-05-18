package proxy_t;

/**
 * Created by fupeng on 2017/5/11.
 */
public class Main {
    public static void main(String[] args) {

        UserService u = new UserServiceImpl();

        MyProxyNNNInvocationHandler invo = new MyProxyNNNInvocationHandler(u);


        UserService proxy = (UserService)invo.getProxy();

        proxy.add();
    }



}
