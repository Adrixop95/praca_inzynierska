/*

Created by Adrian Rupala 2017

*/

import java.io.IOException;
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
    public static void main(String[] args) throws UnknownHostException, SocketException, Exception {

        int timeout=110;
        int port = 1234;
        
        String ip_addr = "";
        
        Set<String> HostAddresses = new HashSet<>();
            try {
                for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (!ni.isLoopback() && ni.isUp() && !ni.isVirtual() && ni.getHardwareAddress() != null) {
                        for (InterfaceAddress ia : ni.getInterfaceAddresses()) {
                            if (ia.getBroadcast() != null) {
                                    HostAddresses.add(ia.getAddress().getHostAddress());
                                    ip_addr = HostAddresses.toString();
                                    System.out.println(ip_addr);
                            }
                        }
                    }
                }
            } catch (SocketException e) { }
        
            for (String s : HostAddresses){
                try {
                    int index = ip_addr.indexOf(" ");

                    System.out.println(s);

                    s = s.substring(0);
                    String subnet = getSubnet(s);
                    System.out.println("subnet: " + subnet);

                    for (int i=1;i<254;i++){

                        String host = subnet + i;
                        System.out.println("Checking :" + host);

                            if (InetAddress.getByName(host).isReachable(timeout)){
                                System.out.println(host + " is reachable");
                                try {
                                    Socket connected = new Socket(subnet, port);
                                }
                                catch (IOException x) { }
                            }
                        }
                    }
        catch(IOException e){ }

    }
}

public static String getSubnet(String firststring) {
        int firstSeparator = firststring.lastIndexOf("/");
        int lastSeparator = firststring.lastIndexOf(".");
        return firststring.substring(firstSeparator+1, lastSeparator+1);
    }
}


