package single;

public class Single02 {
    private static Single02 instance ;
    private Single02(){

    }

    /**
     *存在的问题就是，如果一个线程new的时候，但是还没有完全创建好对象，此时CPU的执行权被别的线程抢走了，
     * 那么就会导致，不是单例模式，解决的方法就是加锁
     */
    public static Single02 getInstance() {
        if(instance == null){
            instance = new Single02();
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[1000000];
        for(int i = 0 ; i < 1000000;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Single02 instance = Single02.getInstance();
                    System.out.println(instance);
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
