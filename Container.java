import org.omg.CORBA.ORB;
import EncryptDecrypt.EDStringPOA;

public class Container extends EDStringPOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public String echoString(String msg) {
        System.out.println(msg);
        return msg;
    }
}