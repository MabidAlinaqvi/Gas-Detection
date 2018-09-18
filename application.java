import javax.swing.*; 

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;

import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class application{
	public static JButton R1;
	public static JButton R2;
	public static JButton R3;
	public static JButton R4;
	public static JFrame frame;
	public static JFrame frame2;
	public static JFrame frame3;
	public static JFrame frame4;
	public static JFrame frame5;
	public static JTextArea textArea;
	public static JTextArea textArea2;
	public static JTextArea textArea3;
	public static JTextArea textArea4;
	public static int count1=0,count2=0,count3=0,count4=0;
	public static void main(String[] args) throws SQLException{

		//main frame//
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		JLabel title = new JLabel("Developers Gas Sensor");
		title.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 24));
		title.setBounds(86, 11, 323, 43);
		frame.add(title);
		R1 = new JButton("Room_1");
		R1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		R1.setBounds(0, 110, 94, 30);
		frame.add(R1);
		

		R2 = new JButton("Room_2");
		R2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		R2.setBounds(110, 110, 94, 30);
		frame.add(R2);
	    
		R3 = new JButton("Room_3");
		R3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		R3.setBounds(220, 110, 94, 30);
		frame.add(R3);
		
		R4 = new JButton("Room_4");
		R4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		R4.setBounds(330, 110, 94, 30);
		frame.add(R4);
		
		frame.setVisible(true);
		//retrieving data from database//

		
	//	ResultSetMetaData resultmeta=(ResultSetMetaData) result.getMetaData();
	//	System.out.println(resultmeta.getColumnCount());
		// Second frame //	

		frame2 = new JFrame();
		frame2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLayout(null);	
		JLabel value = new JLabel("Sensing Values");
		value.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 24));
		value.setBounds(177, 11, 200, 44);
		frame2.add(value);
		
		String url="jdbc:mysql://localhost/iot";
		Connection conn=(Connection) DriverManager.getConnection(url,"root","");
		Statement state=conn.createStatement();
		ScrollPane s1 = new ScrollPane();
		//text area 1
		textArea = new JTextArea();
		s1.setBounds(111, 53, 300, 200);
		s1.add(textArea);
		frame2.add(s1);
		

		
		//text area 3
		
//		ScrollPane s3 = new ScrollPane();
//		textArea3 = new JTextArea();
//		s3.setBounds(111, 53, 300, 200);
//		s3.add(textArea3);
//		frame2.add(s3);
		
		//text area 4
		
//		ScrollPane s4 = new ScrollPane();
//		textArea4 = new JTextArea();
//		s4.setBounds(111, 53, 300, 200);
//		s4.add(textArea4);
//		frame2.add(s4);
		
		
		//button 1 starts from here
		R1.addActionListener(new ActionListener() {
			@Override public void actionPerformed (ActionEvent e) {
				if(e.getSource()==R1){
					
					String sql="Select * FROM room1";
					frame.setVisible(false);
					frame2.setVisible(true);
					if(count1<1)
					{
					textArea.append("value"+"      "+"   time   "+"      "+"    date"+"      "+"\n");
					try{
						state.executeQuery(sql);
						ResultSet result=state.getResultSet();
					while(result.next())
					{
						String values=result.getString("value");
						String time=result.getString("time");
						String date=result.getString("date");

						textArea.append(values+"      ");
						textArea.append(time+"      ");
						textArea.append(date+"\n");
						count1++;
						//\n
						//textArea.setText("naqvi");
					}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					}
				}
					}

		 
			
	
		});
		//end button1
		
		
		
		frame3 = new JFrame();
		frame3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		frame3.setBounds(100, 100, 450, 300);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setLayout(null);	
		JLabel value2 = new JLabel("Sensing Values");
		value2.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 24));
		value2.setBounds(177, 11, 200, 44);
		frame3.add(value2);
		//text area 2
		ScrollPane s2 = new ScrollPane();
		textArea2 = new JTextArea();
		s2.setBounds(111, 53, 300, 200);
		s2.add(textArea2);
		frame3.add(s2);
		//button 2 starts from here
	//	textArea2.append("value"+"      "+"   time   "+"      "+"    date"+"      "+"\n");
		R2.addActionListener(new ActionListener() {
			@Override public void actionPerformed (ActionEvent e2) {
				if(e2.getSource()==R2){
					
					String sql="Select * FROM room2";
					frame.setVisible(false);
					frame3.setVisible(true);
					//textArea2.setText("naqvi");
					if(count2<1)
					{
					textArea2.append("value"+"      "+"   time   "+"      "+"    date"+"      "+"\n");
					try{
						state.executeQuery(sql);
						ResultSet result=state.getResultSet();
					while(result.next())
					{ //System.out.println("yes");
						String values=result.getString("value");
						String time=result.getString("time");
						String date=result.getString("date");
						//textArea.setText(values+"\n");
						//System.out.println();

						textArea2.append(values+"      ");
						textArea2.append(time+"      ");
						textArea2.append(date+"\n");
						count2++;
						//\n
						//textArea.setText("naqvi");
					}
				
					
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					}
					
				}
					}

		 
			
	
		});
		//end button2
		
		frame4 = new JFrame();
		frame4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		frame4.setBounds(100, 100, 450, 300);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setLayout(null);	
		JLabel value3 = new JLabel("Sensing Values");
		value3.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 24));
		value3.setBounds(177, 11, 200, 44);
		frame4.add(value3);
		//text area 2
		ScrollPane s3 = new ScrollPane();
		textArea3 = new JTextArea();
		s3.setBounds(111, 53, 300, 200);
		s3.add(textArea3);
		frame4.add(s3);
		
		
		//button 2 starts from here
		//	textArea2.append("value"+"      "+"   time   "+"      "+"    date"+"      "+"\n");
			R3.addActionListener(new ActionListener() {
				@Override public void actionPerformed (ActionEvent e4) {
					if(e4.getSource()==R3){
						
						String sql="Select * FROM room3";
						frame.setVisible(false);
						frame4.setVisible(true);
						//textArea2.setText("naqvi");
						if(count3<1)
						{
						textArea3.append("value"+"      "+"   time   "+"      "+"    date"+"      "+"\n");
						try{
							state.executeQuery(sql);
							ResultSet result=state.getResultSet();
						while(result.next())
						{ //System.out.println("yes");
							String values=result.getString("value");
							String time=result.getString("time");
							String date=result.getString("date");
							//textArea.setText(values+"\n");
							//System.out.println();

							textArea3.append(values+"      ");
							textArea3.append(time+"      ");
							textArea3.append(date+"\n");
							count3++;
							//\n
							//textArea.setText("naqvi");
						}
					
						
						} catch (SQLException e5) {
							// TODO Auto-generated catch block
							e5.printStackTrace();
						}
						}
					
					}
						}

			 
				
		
			});
			//end button3
			//start button 4
			frame5 = new JFrame();
			frame5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
			frame5.setBounds(100, 100, 450, 300);
			frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame5.setLayout(null);	
			JLabel value4 = new JLabel("Sensing Values");
			value4.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 24));
			value4.setBounds(177, 11, 200, 44);
			frame5.add(value4);
			//text area 2
			ScrollPane s4 = new ScrollPane();
			textArea4 = new JTextArea();
			s4.setBounds(111, 53, 300, 200);
			s4.add(textArea4);
			frame5.add(s4);
			
			
			//button 2 starts from here
			//	textArea2.append("value"+"      "+"   time   "+"      "+"    date"+"      "+"\n");
				R4.addActionListener(new ActionListener() {
					@Override public void actionPerformed (ActionEvent e4) {
						if(e4.getSource()==R4){
							
							String sql="Select * FROM room4";
							frame.setVisible(false);
							frame5.setVisible(true);
							//textArea2.setText("naqvi");
							if(count4<1)
							{
							textArea4.append("value"+"      "+"   time   "+"      "+"    date"+"      "+"\n");
							try{
								state.executeQuery(sql);
								ResultSet result=state.getResultSet();
							while(result.next())
							{ //System.out.println("yes");
								String values=result.getString("value");
								String time=result.getString("time");
								String date=result.getString("date");
								//textArea.setText(values+"\n");
								//System.out.println();
								
								textArea4.append(values+"      ");
								textArea4.append(time+"      ");
								textArea4.append(date+"\n");
								count4++;
								
								//\n
								//textArea.setText("naqvi");
							}
							
							
							} 
							catch (SQLException e5) {
								e5.printStackTrace();
							}
							}
							
							}
						}
							

				 
					
			
				});
				//end button4
			
		
		
		//home 1
		JButton home1 = new JButton("Home");
		home1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame2.setVisible(false);
				frame.setVisible(true);
			
			//	Statement 
			}
		});
		home1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		home1.setBounds(20, 20, 89, 23);
		frame2.add(home1);
	//	frame3.add(home);
		
		//home 2
		
		JButton home2 = new JButton("Home");
		home2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame3.setVisible(false);
				frame.setVisible(true);
			
			//	Statement 
			}
		});
		home2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		home2.setBounds(20, 20, 89, 23);
		frame3.add(home2);
		
		//home 3
		
		JButton home3 = new JButton("Home");
		home3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame4.setVisible(false);
				frame.setVisible(true);
			
			//	Statement 
			}
		});
		home3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		home3.setBounds(20, 20, 89, 23);
		frame4.add(home3);
	
		
		//home 4
		
		JButton home4 = new JButton("Home");
		home4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame4.setVisible(false);
				frame.setVisible(true);
			
			//	Statement 
			}
		});
		home4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		home4.setBounds(20, 20, 89, 23);
		frame5.add(home4);
	}
}
