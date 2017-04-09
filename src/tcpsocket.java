/**
 * Created by Murat Demirtaş on 9.04.2017.
 * simple tcp socket example.
 */

import java.net.*;
import java.io.*;

public class tcpsocket
{

    private static final String IP_ADDR = "google.com";
    private static final int   PORT_NUM = 80;

    public static void main(String argv[]) throws Exception
    {
        String responseMessage = "HELLO SERVER";
        Socket tcpsocket = new Socket(IP_ADDR,PORT_NUM);

        if(tcpsocket.isConnected())
            System.out.println("CONNECTED TO TCP SERVER,");

        else {
            System.out.println("CANNOT CONNECT TO TCP SERVER,EXITING WITH 1");
            System.exit(1);
        }

        DataOutputStream sendMessageChannel = new DataOutputStream(tcpsocket.getOutputStream());
        sendMessageChannel.writeBytes("GET /imghp?hl=tr&tab=wi&ei=W6nqWITVFcm4swHkiY-oAw&ved=0EKouCBQoAQ\n");

        BufferedReader readChannelFromServer = new BufferedReader(new InputStreamReader(tcpsocket.getInputStream()));
        responseMessage = readChannelFromServer.readLine();
        System.out.println( "RECEIVED FROM SERVER: " + responseMessage);

        tcpsocket.close();
        System.exit(0);
    }
}
