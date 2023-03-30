package single;

public class Single01 {
    private static final Single01 instance = new Single01();
    private Single01(){

    }
    public static Single01 getInstance(){
        return  instance;
    }

    public static void main(String[] args) {
        Single01 instance = Single01.getInstance();
        Single01 instance2 = Single01.getInstance();
        System.out.println(instance == instance2);
    }
}
