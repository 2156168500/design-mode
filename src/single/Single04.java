package single;

public class Single04 {
    private volatile static Single04 instance ;
    private Single04(){

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
     * 使用volatile关键字
     *
     * volatile 关键字可以宝保证可见性和有序性
     * 可见性就是指，每一个线程都有自己的工作空间，当前线程要读取一个数据就会在自己的工作空间中先读取。
     * 写入的时候也是要写在自己的工作空间中，那么就会导致，多线程的环境下，一个线程多一个数据的修改，多其他
     * 线程是不可见的 ，加上volatile关键字后，线程读取数据的时候。就会直接去内存中读取，写入数据的时候也会直接
     * 写在内存里。就可以避免线程直接不可见的问题了
     *
     *
     * 有序性是指：在单线程，不改变最后执行结果的情况下，操作系统为了提高效率而做的操作。
     * 加上volatile关键字后，就会在变量的前后增加内存屏障，内存屏障前的指令执行完才可以执行当前指令，
     * 也就解决了单例模式下返回未初始化的对象的问题
     */
    public static Single04 getInstance() {
        if(instance == null){
            synchronized (Single04.class){
                if(instance == null){
                    instance = new Single04();
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
                    Single04 instance = Single04.getInstance();
                    System.out.println(instance);
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
