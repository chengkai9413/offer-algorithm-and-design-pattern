package learn.design.pattern.singletone;

/**
 * holder模式。将静态初始化放在Holder内部类中进行。
 * 加载Singleton5 而未获取实例的时候，不会调用SingletonHolder
 * 将懒加载和线程安全完美结合的一种方式（无锁）
 */
public class Singleton5 {
    public static final String TEST_MEMBER = "12345";

    private static SingletonHolder holder = null;

    private Singleton5() {
        System.out.println("init singleton!!");
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.ins;
    }


    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder {
        private static Singleton5 ins = new Singleton5();
    }
}
