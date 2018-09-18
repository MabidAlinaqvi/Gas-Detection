import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class Server{
	public static void main(String[] args){

		try {
			@SuppressWarnings("resource")
			ServerSocket serversocket=new ServerSocket(3345); 
			System.out.println("Server is waiting for client");
			String url="jdbc:mysql://localhost/iot";
			java.util.Date date = new java.util.Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

			while(true){
				System.out.println("Waiting");
				Socket socket = serversocket.accept();
				System.out.println("connected!");
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//	System.out.print(br.readLine()+"\n");
				String value=br.readLine();
				
                 if(value.toLowerCase().startsWith("room1")==true)
                 {
				value=value.replaceAll("room1", "");
			//	String y=value;
				Double x=Double.parseDouble(value);
		//		System.out.println(y+"naqvi");
		//		int x=Integer.parseInt(y);
//				if(x>=150)
//				{
//					sendSMS1();
//				}
//				else
//				{
//					sendSMS();
//				}
				sendSMS();
				System.out.println(value);
				Connection myconn=DriverManager.getConnection(url,"root","");
				Statement mystate=myconn.createStatement();
				//				if(value.toLowerCase().startsWith("room2"))
				//				{
				String sql = "INSERT INTO room1(value,time,date) VALUES ('"+value+"','"+LocalTime.now()+"','"+LocalDateTime.now()+"')";

				mystate.executeUpdate(sql);
				//			}
				//				else
				//				{
				//					System.out.println("wrong input");
				//				}
				//			System.out.println("hello");
				mystate.close();
				myconn.close();
                 }
                 else if(value.toLowerCase().startsWith("room2")==true)
                 {
                	 value=value.replaceAll("room2", "");
                	 String y=value;
     				int x=Integer.parseInt(y);
    				if(x>=150)
    				{
    					sendSMS1();
    				}
    				else
    				{
    					sendSMS();
    				}
     				System.out.println(value);
     				Connection myconn=DriverManager.getConnection(url,"root","");
     				Statement mystate=myconn.createStatement();
     				//				if(value.toLowerCase().startsWith("room2"))
     				//				{
     				String sql = "INSERT INTO room2(value,time,date) VALUES ('"+value+"','"+sdf.format(date)+"','"+LocalDateTime.now()+"')";

     				mystate.executeUpdate(sql);
     				//			}
     				//				else
     				//				{
     				//					System.out.println("wrong input");
     				//				}
     				//			System.out.println("hello");
     				mystate.close();
     				myconn.close();
                 }
                 else if(value.toLowerCase().startsWith("room3")==true)
                 {
                	 value=value.replaceAll("room3", "");
                	 String y=value;
                	 System.out.println(y+"naqvi");
//     				int x=Integer.par
//    				if(x>=150)
//    				{
//    					sendSMS1();
//    				}
//    				else
//    				{
//    					sendSMS();
//    				}
     				System.out.println(value);
     				Connection myconn=DriverManager.getConnection(url,"root","");
     				Statement mystate=myconn.createStatement();
     				//				if(value.toLowerCase().startsWith("room2"))
     				//				{
     				String sql = "INSERT INTO room3(value,time,date) VALUES ('"+value+"','"+sdf.format(date)+"','"+LocalDateTime.now()+"')";

     				mystate.executeUpdate(sql);
     				//			}
     				//				else
     				//				{
     				//					System.out.println("wrong input");
     				//				}
     				//			System.out.println("hello");
     				mystate.close();
     				myconn.close();
                 }
                 else
                 {
                	 value=value.replaceAll("room4", "");
                	 String y=value;
     				int x=Integer.parseInt(y);
    				if(x>=150)
    				{
    					sendSMS1();
    				}
    				else
    				{
    					sendSMS();
    				}
      				System.out.println(value);
      				Connection myconn=DriverManager.getConnection(url,"root","");
      				Statement mystate=myconn.createStatement();
      				//				if(value.toLowerCase().startsWith("room2"))
      				//				{
      				String sql = "INSERT INTO room4(value,time,date) VALUES ('"+value+"','"+sdf.format(date)+"','"+LocalDateTime.now()+"')";

      				mystate.executeUpdate(sql);
      				//			}
      				//				else
      				//				{
      				//					System.out.println("wrong input");
      				//				}
      				//			System.out.println("hello");
      				mystate.close();
      				myconn.close();
                 }


				//	break;
                 socket.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
			//System.out.println("there is problem in server");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("There is problem in database");
		} 


	}
	public static void sendSMS() {
        try {
                String recipient = "+923439901331";
                String message = "gas is in normal state!";
                String username = "admin";
                String password = "123456789";
                String originator = "06201234567";

                String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
    "username=" + URLEncoder.encode(username, "UTF-8") +
    "&password=" + URLEncoder.encode(password, "UTF-8") +
    "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
    "&messagetype=SMS:TEXT" +
    "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
    "&originator=" + URLEncoder.encode(originator, "UTF-8") +
    "&serviceprovider=telenor" +
    "&responseformat=html";



                URL url = new URL(requestUrl);
                HttpURLConnection uc = (HttpURLConnection)url.openConnection();

                System.out.println(uc.getResponseMessage());

                uc.disconnect();

        } catch(Exception ex) {
                System.out.println(ex.getMessage());

        }
} 
	public static void sendSMS1() {
        try {
                String recipient = "+923439901331";
                String message = "danger state!";
                String username = "admin";
                String password = "123456789";
                String originator = "06201234567";

                String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
    "username=" + URLEncoder.encode(username, "UTF-8") +
    "&password=" + URLEncoder.encode(password, "UTF-8") +
    "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
    "&messagetype=SMS:TEXT" +
    "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
    "&originator=" + URLEncoder.encode(originator, "UTF-8") +
    "&serviceprovider=telenor" +
    "&responseformat=html";



                URL url = new URL(requestUrl);
                HttpURLConnection uc = (HttpURLConnection)url.openConnection();

                System.out.println(uc.getResponseMessage());

                uc.disconnect();

        } catch(Exception ex) {
                System.out.println(ex.getMessage());

        }
} 

}
