package com.osi.ftpapplication.ftpservers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class ServerToServerFTP {

	 public static void main(String[] args)
	    {
	        String server1, username1, password1, file1;
	        String server2, username2, password2, file2;
	        String [] parts;
	        int port1=0, port2=0;
	        FTPClient ftp1, ftp2;
	        ProtocolCommandListener listener;
 if (args.length < 8)
	        {
	            System.err.println(
	                "Usage: ftp <host1> <user1> <pass1> <file1> <host2> <user2> <pass2> <file2>"
	            );
	            System.exit(1);
	        }

	        server1 = args[0];
	        parts = server1.split(":");
	        if (parts.length == 2) {
	            server1=parts[0];
	            port1 = Integer.parseInt(parts[1]);
	        }
	        username1 = args[1];
	        password1 = args[2];
	        file1 = args[3];
	        server2 = args[4];
	        parts = server2.split(":");
	        if (parts.length == 2) {
	            server2=parts[0];
	            port2 = Integer.parseInt(parts[1]);
	        }
	        username2 = args[5];
	        password2 = args[6];
	        file2 = args[7];

	        listener = new PrintCommandListener(new PrintWriter(System.out), true);
	        ftp1 = new FTPClient();
	        ftp1.addProtocolCommandListener(listener);
	        ftp2 = new FTPClient();
	        ftp2.addProtocolCommandListener(listener);

	        try
	        {
	            int reply;
	            if (port1 > 0) 
	                ftp1.connect(server1, port1);
	             else 
	                ftp1.connect(server1);
	            
	            System.out.println("Connected to " + server1 + ".");

	            reply = ftp1.getReplyCode();

	            if (!FTPReply.isPositiveCompletion(reply))
	            {
	                ftp1.disconnect();
	                System.err.println("FTP server1 refused connection.");
	                System.exit(1);
	            }
	        }
	        catch (IOException e)
	        {
	            if (ftp1.isConnected())
	            {
	                try
	                {
	                    ftp1.disconnect();
	                }
	                catch (IOException f)
	                {
	                    // do nothing
	                }
	            }
	            System.err.println("Could not connect to server1.");
	            e.printStackTrace();
	            System.exit(1);
	        }

	        try
	        {
	            int reply;
	            if (port2 > 0) {
	                ftp2.connect(server2, port2);
	            } else {
	                ftp2.connect(server2);
	            }
	            System.out.println("Connected to " + server2 + ".");

	            reply = ftp2.getReplyCode();

	            if (!FTPReply.isPositiveCompletion(reply))
	            {
	                ftp2.disconnect();
	                System.err.println("FTP server2 refused connection.");
	                System.exit(1);
	            }
	        }
	        catch (IOException e)
	        {
	            if (ftp2.isConnected())
	            {
	                try
	                {
	                    ftp2.disconnect();
	                }
	                catch (IOException f)
	                {
	                    // do nothing
	                }
	            }
	            System.err.println("Could not connect to server2.");
	            e.printStackTrace();
	            System.exit(1);
	        }

	__main:
	        try
	        {
	            if (!ftp1.login(username1, password1))
	            {
	                System.err.println("Could not login to " + server1);
	                break __main;
	            }

	            if (!ftp2.login(username2, password2))
	            {
	                System.err.println("Could not login to " + server2);
	                break __main;
	            }

	           
	            ftp2.enterRemotePassiveMode();

	            ftp1.enterRemoteActiveMode(InetAddress.getByName(ftp2.getPassiveHost()),
	                                       ftp2.getPassivePort());
	            if (ftp1.remoteRetrieve(file1) && ftp2.remoteStoreUnique(file2))
	            {
	               
	                ftp1.completePendingCommand();
	                ftp2.completePendingCommand();
	            }
	            else
	            {
	                System.err.println(
	                    "Couldn't initiate transfer.  Check that filenames are valid.");
	                break __main;
	            }

	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	            System.exit(1);
	        }
	        finally
	        {
	            try
	            {
	                if (ftp1.isConnected())
	                {
	                    ftp1.logout();
	                    ftp1.disconnect();
	                }
	            }
	            catch (IOException e)
	            {
	                // do nothing
	            }

	            try
	            {
	                if (ftp2.isConnected())
	                {
	                    ftp2.logout();
	                    ftp2.disconnect();
	                }
	            }
	            catch (IOException e)
	            {
	                // do nothing
	            }
	        }
	    }

}
