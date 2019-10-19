import sys
from omniORB import CORBA, PortableServer
import EncryptDecrypt, EncryptDecrypt__POA

class Container(EncryptDecrypt__POA.EDString):
    def echoString(self, msg):
        print msg
        return msg
    



