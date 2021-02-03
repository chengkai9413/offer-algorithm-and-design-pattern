import learn.design.pattern.singletone.Singleton5;

public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Singleton5.TEST_MEMBER);

        System.out.println("=================");
        Thread.sleep(2000);

        Singleton5 s = Singleton5.getInstance();

    }
}
