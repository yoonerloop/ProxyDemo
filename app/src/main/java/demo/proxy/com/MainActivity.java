package demo.proxy.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.reflect.Proxy;

import demo.proxy.com.motionProxy.ProxyBuyer2;
import demo.proxy.com.staticproxy.Buy;
import demo.proxy.com.staticproxy.Buyer;
import demo.proxy.com.staticproxy.ProxyBuyer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 静态代理测试
     * @param view
     */
    public void staticProxy(View view){
        System.out.println("----------------静态代理-----------------");
        Buy buyer = new Buyer();
        ProxyBuyer proxyBuyer = new ProxyBuyer(buyer);
        proxyBuyer.buyHouse(500000);
    }

    /**
     * 动态代理测试
     */
    public void motionProxy(View view){
        System.out.println("----------------动态代理-----------------");
        Buy buyer = new Buyer();
        ProxyBuyer2 proxyBuyer2 = new ProxyBuyer2(buyer);
        Buy proxy = (Buy) Proxy.newProxyInstance(buyer.getClass().getClassLoader(),buyer.getClass().getInterfaces(),proxyBuyer2);
        proxy.buyHouse(500000);
    }
}
