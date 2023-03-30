package single;

public class Single03 {
    private static Single03 instance ;
    private Single03(){

    }

    /**
     * double check 的原因就是，在多线程的环境下，第一个if的时候 有可能放进来多个线程，此时一个线程获的锁资源对
     * instance执行了new操作，但是之前进入第一个if的其他线程并不知道，所以就会导致多线程的环境下
     * 可能得不到单例的instance对象
     *
     * 存在的问题：
     * 对象的创建过程可能会被重新排序，导致，先将对象的地址赋值个引用，然后在去初始化对象。当一个线程真正创建对象
     * 但是还没有完全被创建出来的时候，其他的线程执行了第一个if的条件判断，因为此时引用已经指向了一个非空的地址
     * 所以就会直接返回instance对象，但是此时的对象是没有被初始化的
     *
     * 解决的方式：
     * 使用volition关键字
     */
    public static Single03 getInstance() {
        if(instance == null){
            synchronized (Single03.class){
                if(instance == null){
                    instance = new Single03();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[1000000];
        for(int i = 0 ; i < 1000000;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Single03 instance = Single03.getInstance();
                    System.out.println(instance);
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
