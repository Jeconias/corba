import sys
from omniORB import CORBA, PortableServer
from Container import Container;
import CosNaming, EncryptDecrypt, EncryptDecrypt__POA

orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)
poa = orb.resolve_initial_references("RootPOA")

ei = Container()
eo = ei._this()

obj = orb.resolve_initial_references("NameService")
rootContext = obj._narrow(obj)

print orb.object_to_string(eo)

poaManager = poa._get_the_POAManager()

poaManager.activate()

orb.run()


    



