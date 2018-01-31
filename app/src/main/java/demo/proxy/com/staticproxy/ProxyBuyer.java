package demo.proxy.com.staticproxy;

/**
 * date：2018/1/25 on 11:27
 * description: 中介，相当于代理
 */

public class ProxyBuyer implements Buy {

    //被代理类(客户)，代理类持有被代理的对象，即Buyer
    private Buy buy;

    public ProxyBuyer(Buy buy) {
        this.buy = buy;
    }

    @Override
    public void buyHouse(long money) {
        buy.buyHouse(money);
        System.out.println("中介费：" + money*0.02 + "元");
    }
}
