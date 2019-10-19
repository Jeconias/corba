import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExtHelper;

public class Client {
    public static void main(String[] args) {

        String inpuString = (args.length > 1) ? args[1] : "Default Message";

        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            org.omg.CosNaming.NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            EncryptDecrypt.EDString olaobjeto = (EncryptDecrypt.EDString) EncryptDecrypt.EDStringHelper
                    .narrow(ncRef.resolve_str("ABC"));
            String s = olaobjeto.echoString(inpuString);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}