import org.omg.*;

class Server
{ 
    static public void main(String[] args)
    { 
        try { // Initialize the ORB
            CORBA.ORB orb = CORBA.ORB.init();
            // Initialize the Object Adapter
            CORBA.BOA boa = orb.BOA_init();
            // Create the count object
            ExponentialTemp count = new ExponentialTemp("My Exp");
            // Export to the ORB the newly created object
            boa.obj_is_ready(count);
            // Ready to service requests
            boa.impl_is_ready();
        } catch (CORBA.SystemException e){}
    }
}