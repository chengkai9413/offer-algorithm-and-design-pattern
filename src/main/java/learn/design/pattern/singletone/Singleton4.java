package learn.design.pattern.singletone;

/**
 * 饿汉模式，类加载时完成实例初始化
 * 线程安全
 * <p>
 * 优点：饿汉模式天生是线程安全的，使用时没有延迟。
 * 缺点：启动时即创建实例，启动慢，有可能造成资源浪费。
 */
public class Singleton4 {


    private static Singleton4 instance = new Singleton4();
    // 也可以放在 static{ instance = new Singleton4(); } 中实现。


    private Singleton4() {

    }


    public static Singleton4 getInstance() {
        return instance;
    }
}
