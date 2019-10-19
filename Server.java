import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import java.util.Properties;

import EncryptDecrypt.EDStringHelper;

public class Server {
    public static void main(String[] args) {

        // Properties props = new Properties();
        // props.put("org.omg.CORBA.ORBInitialHost", "atv");
        // props.put("org.omg.CORBA.ORBInitialPort", "901");

        try {
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            Container container = new Container();
            container.setORB(orb);

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(container);
            EncryptDecrypt.EDString href = EDStringHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            org.omg.CosNaming.NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            org.omg.CosNaming.NameComponent path[] = ncRef.to_name("ABC");
            ncRef.rebind(path, href);
            System.out.println("Servidor pronto e esperando...");
            for (;;)
                orb.run();
        } catch (Exception e) {
        }
    }
}