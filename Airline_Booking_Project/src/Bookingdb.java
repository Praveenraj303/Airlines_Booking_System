import java.sql.*;
import java.util.Scanner;
public class Bookingdb {
	public static Connection con=null;
	public static Scanner scanner=new Scanner(System.in);
public static void main(String args[]) throws Exception{
	Bookingdb book=new Bookingdb();
	String url="jdbc:mysql://localhost:3306/Airline";
	String user="root";
	String pass="savi512";
	con=DriverManager.getConnection(url,user,pass);
	System.out.println("Enter choice");
	System.out.println("1.Insert record");
	System.out.println("2.Select individual record");
	System.out.println("3.Select All the record");
	System.out.println("4.Delete individual record");
	System.out.println("5.update individual record");
	int choice= Integer.parseInt(scanner.nextLine());
	switch(choice) {
	case 1:
		book.insertRecord();
		break;
	case 2:
		book.selectRecord();
		break;
	case 3:
		book.selectAll();
		break;
	case 4:
		book.deleteRecord();
		break;
	case 5:
		book.updateRecord();
		break;
	default:
		break;
	}
}
public void insertRecord() throws Exception{
	String sql="insert into customer(customer_id,name,passport_id,Flight_Name,source,departure,date,Arrival_time,Departure_time,Flight_charges) values(?,?,?,?,?,?,?,?,?,?)";
	
	PreparedStatement pst=con.prepareStatement(sql);
	
	System.out.println("Enter customer id:");
	pst.setString(1, scanner.nextLine());
	System.out.println("Enter customer Name:");
	pst.setString(2, scanner.nextLine());
	System.out.println("Enter passport id:");
	pst.setString(3, scanner.nextLine());
	System.out.println("Enter customer Flight Name:");
	pst.setString(4, scanner.nextLine());
	System.out.println("Enter Source:");
	pst.setString(5, scanner.nextLine());
	System.out.println("Enter Departure:");
	pst.setString(6, scanner.nextLine());
	System.out.println("Enter Date:");
	pst.setString(7, scanner.nextLine());
	System.out.println("Enter Arrival Time:");
	pst.setString(8, scanner.nextLine());
	System.out.println("Enter Departure Time:");
	pst.setString(9, scanner.nextLine());
	System.out.println("Enter Flight charges:");
	pst.setDouble(10, Double.parseDouble(scanner.nextLine()));
	int rows=pst.executeUpdate();
	if(rows>0) {
		System.out.println("Record inserted successfully");
	}
}

public void selectRecord() throws Exception{
	System.out.println("Enter customer Id to find result");
	int number=Integer.parseInt(scanner.nextLine());
	String sql="select * from customer where customer_id="+number;
	
	Statement smt=con.createStatement();
	ResultSet rs=smt.executeQuery(sql);
	
	if(rs.next()) {
		
		int cs_id=rs.getInt("customer_id");
		String cs_name=rs.getString("name");
		int ps_id=rs.getInt("passport_id");
		String fl_name=rs.getString("Flight_Name");
		String source1=rs.getString("source");
		String dep=rs.getString("departure");
		String date1=rs.getString("date");
		String Arl=rs.getString("Arrival_time");
		String deptime=rs.getString("Departure_time");
		String charge=rs.getString("Flight_charges");
		System.out.println("Customer id:"+cs_id);
		System.out.println("Customer name:"+cs_name);
		System.out.println("Passport id:"+ps_id);
		System.out.println("Flight name:"+fl_name);
		System.out.println("source:"+source1);
		System.out.println("Departure:"+dep);
		System.out.println("Date:"+date1);
		System.out.println("Arrival Time:"+Arl);
		System.out.println("Departure Time:"+deptime);
		System.out.println("Flight charges:"+charge);
	}
	else {
		System.out.println("No recors found");
	}
}
public static void selectAll() throws Exception{
	String query="select * from customer";
	Statement smt=con.createStatement();
	ResultSet rs=smt.executeQuery(query);
	while(rs.next()){
		System.out.println("Customer id:"+rs.getInt(1));
		System.out.println("Customer name:"+rs.getString(2));
		System.out.println("Passport id:"+rs.getInt(3));
		System.out.println("Flight name:"+rs.getString(4));
		System.out.println("source:"+rs.getString(5));
		System.out.println("Departure:"+rs.getString(6));
		System.out.println("Date:"+rs.getString(7));
		System.out.println("Arrival Time:"+rs.getString(8));
		System.out.println("Departure Time:"+rs.getString(9));
		System.out.println("Flight charges:"+rs.getString(10));
		System.out.println();
	}
}
public void deleteRecord() throws Exception{
	System.out.println("Enter customer Id to Delete Data");
	int number=Integer.parseInt(scanner.nextLine());
	String sql="delete from customer where customer_id="+number;
	
	PreparedStatement pst=con.prepareStatement(sql);
	int rows=pst.executeUpdate();
	
	if(rows>0) {
		System.out.println("Successfully Deleted");
	}
	else {
		System.out.println("Enter valid Id");
	}
}
public void updateRecord() throws Exception{
	System.out.println("Enter customer Id to update Data");
	int number=Integer.parseInt(scanner.nextLine());
	String sql="update customer set Flight_charges=4850 where customer_id="+number;
	PreparedStatement pst=con.prepareStatement(sql);
	int rows=pst.executeUpdate();
	
	if(rows>0) {
		System.out.println("Successfully updated");
	}
	else {
		System.out.println("Enter valid Id");
	}
}
}