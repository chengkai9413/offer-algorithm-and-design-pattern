package learn.design.pattern.singletone;

/**
 * 懒汉模式，线程安全
 */
@Deprecated
public class Singleton2 {
    private static Singleton2 instance = null;

    private Singleton2(){

    }

    // 加了同步锁，线程安全，但是每次获取实例时都需要加锁，性能不好
    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}
