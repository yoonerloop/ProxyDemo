package demo.proxy.com.motionProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import demo.proxy.com.staticproxy.Buy;

/**
 * date：2018/1/25 on 14:38
 * description: 动态代理
 */

public class ProxyBuyer2 implements InvocationHandler {

    //动态代理中持有被代理对象
    private Buy buy;

    public ProxyBuyer2(Buy buy) {
        this.buy = buy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("buyHouse")){
            //如果是买房子的方法的话，取出第一个参数money，这个money为接口中定义的参数，为已知数据
            long money = (long) args[0];
            System.out.println("中介费："+money*0.02);
            return method.invoke(buy,args);
        }
        return null;
    }
}
