package org.lambda.net;


/**
 * 构造方法的引用
 * 一般我们需要声明接口，该接口作为对象的生成器，通过 类名::new 的方式来实例化对象，然后调用方法返回对象。
 *
 * @author code
 * @Title: Exe2
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2020/5/2614:41
 */
public class Exe2 {

    interface ItemCreatorBlankConstruct {
        Item getItem123();
    }

    interface ItemCreatorParamContruct {
        Item getItem(int id, String name, double price);
    }

    /**
     * lambda 表达式创建线程
     */
    private static void exeThread(){
        Thread thread = new Thread(()->{
            for (int i=0;i<10;i++){
                System.out.println(2 + ":" + i);
            }
        });
        thread.start();
    }



    public static void main(String[] args) {
//        exeLambdaContruct();
        exeThread();
    }

    private static void exeLambdaContruct() {
        ItemCreatorBlankConstruct creator = () -> new Item();
        Item item = creator.getItem123();

        ItemCreatorBlankConstruct creator2 = Item::new;
        Item item1 = creator2.getItem123();

        ItemCreatorParamContruct creator3 = Item::new;
        Item item2 = creator3.getItem(12, "param", 12.32);

    }
}
