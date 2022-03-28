public class Client { 
    public static void main(String args[]){ 
        try { // initialize the ORB
            CORBA.ORB orb = CORBA.ORB.init();
            // bind to the Count server object, using the Count_var class generated from IDL
            Exponential.Exp counter = Exponential.Exp.bind("My Exp"); // get ref. to remote obj.
            System.out.println(counter.exp(2, 3)); 
        }
        catch (CORBA.SystemException e) {
            e.printStackTrace();
        }
    }
}
