package transport.server;

import transport.logic.*;
import java.rmi.*;

public class Server {
	Server(int port) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			ArtistFactory_Impl af = new ArtistFactory_Impl();
			Naming.rebind("//abhorrence:"+port+"/ArtistFactory", af);

			CarFactory_Impl cf = new CarFactory_Impl();
			Naming.rebind("//abhorrence:"+port+"/CarFactory", cf);

			FunctionaryFactory_Impl ff = new FunctionaryFactory_Impl();
			Naming.rebind("//abhorrence:"+port+"/FunctionaryFactory", ff);
			
			PlaceFactory_Impl pf = new PlaceFactory_Impl();
			Naming.rebind("//abhorrence:"+port+"/PlaceFactory", pf);

			MobilePhoneFactory_Impl mpf = new MobilePhoneFactory_Impl();
			Naming.rebind("//abhorrence:"+port+"/MobilePhoneFactory", mpf);
			
			RoleFactory_Impl rf = new RoleFactory_Impl();
			Naming.rebind("//abhorrence:"+port+"/RoleFactory", rf);
			
			TransportFactory_Impl tf = new TransportFactory_Impl();
			Naming.rebind("//abhorrence:"+port+"/TransportFactory", tf);
		} catch (Exception e) {
			System.out.println("Server err: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Server s=new Server(2003);
	}
}

