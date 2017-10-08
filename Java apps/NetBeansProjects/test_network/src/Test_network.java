import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Test_network {
    public static void main(String[] args) throws UnknownHostException, SocketException {

        int timeout=500;
        int port = 1234;
        String ip_addr = "";
        
        Set<String> HostAddresses = new HashSet<>();
            try {
                for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (!ni.isLoopback() && ni.isUp() && ni.getHardwareAddress() != null) {
                        for (InterfaceAddress ia : ni.getInterfaceAddresses()) {
                            if (ia.getBroadcast() != null) {  //If limited to IPV4
                                HostAddresses.add(ia.getAddress().getHostAddress());
                                ip_addr = HostAddresses.toString();
                            }
                        }
                    }
                }
            } catch (SocketException e) { }
        
        try {
            ip_addr = ip_addr.substring(1);
            String subnet = getSubnet(ip_addr);
            //System.out.println("subnet: " + subnet);

            for (int i=1;i<254;i++){

                String host = subnet + i;
                //System.out.println("Checking :" + host);

                if (InetAddress.getByName(host).isReachable(timeout)){
                    //System.out.println(host + " is reachable");
                    try {
                        Socket connected = new Socket(subnet, port);
                    }
                    catch (Exception s) {
                        //System.out.println(s);
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static String getSubnet(String ip_addr) {
        int firstSeparator = ip_addr.lastIndexOf("/");
        int lastSeparator = ip_addr.lastIndexOf(".");
        return ip_addr.substring(firstSeparator+1, lastSeparator+1);
    }
}


