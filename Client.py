import sys
from omniORB import CORBA
import EncryptDecrypt


orb = CORBA.ORB_init(sys.argv, CORBA.ORB_ID)

ior = sys.argv[1]
obj = orb.string_to_object(ior)

eo = obj._narrow(EncryptDecrypt.EDString)

if eo is None:
    print "Object reference is not an EncryptDecrypt::EchoString"
    sys.exit(1)

message = "Message to send."
result  = eo.echoString(message)

print "I said '%s'. The object said '%s'." % (message,result)