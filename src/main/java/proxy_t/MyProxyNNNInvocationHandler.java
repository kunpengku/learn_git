package proxy_t;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fupeng on 2017/5/11.
 */
public class MyProxyNNNInvocationHandler implements InvocationHandler {

    private Object target;

    MyProxyNNNInvocationHandler(Object target){
        super();
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");

        Object result = method.invoke(target, args);

        System.out.println("end");
        return result;

    }


    public Object getProxy(){

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),  target.getClass().getInterfaces(),  this);
    }

}
