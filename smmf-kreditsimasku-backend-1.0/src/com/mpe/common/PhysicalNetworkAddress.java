/*
 * Created on Apr 3, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.mpe.common;

import java.net.InetAddress;
import java.net.NetworkInterface;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Agung Hadiwaluyo
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PhysicalNetworkAddress {
	static Log log = LogFactory.getFactory().getInstance("PhysicalNetworkAddress");
	
	public static boolean isValidHardwareAddress() throws Exception {
		String string = "0 - 1e - b - ffffffbf - 39 - 14";
		String string2 = "";
		boolean b = false;
		InetAddress a = InetAddress.getLocalHost();
		NetworkInterface ni = NetworkInterface.getByInetAddress(a);
        byte[] hwAddrByte = ni.getHardwareAddress();
        for(int i=0; i<hwAddrByte.length; i++) {
            string2 = string2 + (Integer.toHexString(hwAddrByte[i]));
            if (i != (hwAddrByte.length - 1)) string2 = string2 + (" - ");
        }
        if (string.equalsIgnoreCase(string2)) b = true;
		return b;
	}
	

    public static void main(String[] args) {
        try {
        	InetAddress a = InetAddress.getLocalHost();
    		NetworkInterface ni = NetworkInterface.getByInetAddress(a);
            byte[] hwAddrByte = ni.getHardwareAddress();
            for(int i=0; i<hwAddrByte.length; i++) {
            }
        } catch (Throwable e) {
        }
    }
}
