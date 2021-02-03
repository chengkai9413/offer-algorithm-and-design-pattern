package learn.design.pattern.singletone;

/**
 * 懒汉模式（需要时才生成实例）
 * 线程不安全，在高并发多线程场景下避免使用
 */
@Deprecated
public class Singleton1 {
    private Singleton1(){
    }

    private static Singleton1 instance = null;

    // 多线程下，
    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}
