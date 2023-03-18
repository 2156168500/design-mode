package stategy.example1;

public class NormalCharge extends Cost{
    public NormalCharge(){

    }
    @Override
    public double collectFees(double price) {
        return price;
    }
}
