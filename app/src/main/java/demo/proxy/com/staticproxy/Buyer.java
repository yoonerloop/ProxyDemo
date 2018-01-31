package demo.proxy.com.staticproxy;

/**
 * date：2018/1/25 on 11:25
 * description: 购买者，买房子
 */

public class Buyer implements Buy{

    @Override
    public void buyHouse(long money) {
        System.out.println("买房子花了："+money+"元---");
    }
}
