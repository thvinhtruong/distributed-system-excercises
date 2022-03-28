import org.omg.CORBA.*;
class ExponentialTemp extends Exponential._sk_Exp implements Exponential.Exp
{
    private String name;
    public ExponentialTemp(String name) {
        this.name = name;
    }
    // increment sum
    public int exponential(int a, int b) throws CORBA.SystemException{
        for (int i=1; i<=b; i++) {
            a = a * a;
        }
        return a;
    }
}