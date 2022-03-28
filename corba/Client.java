public class Client { 
    public static void main(String args[]){ 
        try { // initialize the ORB
            CORBA.ORB orb = CORBA.ORB.init();
            // bind to the Count server object, using the Count_var class generated from IDL
            Counter.Count counter = Counter.Count_var.bind("My Exp"); // get ref. to remote obj.
            counter.exp(2, 3); 
        }
        catch (CORBA.SystemException e) {
            e.printStackTrace();
        }
    }
}
