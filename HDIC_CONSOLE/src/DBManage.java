

import java.sql.*;
import java.util.ArrayList;

public class DBManage {
    Connection con;
    Statement st;

     public void createConn(){
        String url = "jdbc:mysql://localhost:3306/HDIC"; // Database details
        String username = "root"; // MySQL credentials
        String password = "1234";

        try{ 
            Class.forName("com.mysql.cj.jdbc.Driver"); //driver install
            // Establish connection
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");
            // Create a statement
            st = con.createStatement();
        }catch(Exception e){
            System.out.println("Exception : "+e);
        }
    }

    public ArrayList<UserInfos>  getUserInfo(String accId,String pinNo){//refer
        ArrayList<UserInfos> lUserInfos =new ArrayList<>();//refer
     
        String q1= "Select * from HDIC where accID = '"+accId+"' and pinNo = "+pinNo;
        //getting cx details from database by accid and pinno
        try{
            createConn(); 
            ResultSet rs=st.executeQuery(q1);
            while (rs.next()){
               UserInfos ui=new UserInfos(
            		   rs.getString("accID"),
            		   rs.getString("name"), 
            		   rs.getInt("availAmt"));
                lUserInfos.add(ui);     
            }
        }catch(Exception e){
            System.out.println("Error : "+e);
        }
        return lUserInfos;
    }

    public Boolean setUserInfos(String accId,String gPinNo,String userName,String Phno,String mailId,int availAmt){
        String q1="insert into HDIC values(?,?,?,?,?,?);";
        try{ 
            createConn();
            PreparedStatement ps=con.prepareStatement(q1);

            ps.setString(1, accId);
            ps.setString(2, gPinNo);
            ps.setString(3, userName);
            ps.setString(4, Phno);
            ps.setString(5, mailId);
            ps.setInt(6, availAmt);
            ps.executeUpdate();

            return true;
        }catch(Exception e){
            System.out.println("Error : "+e);
        }
        return false;
    }

    public Boolean setAvailAmt(int availAmt,String accId){
        String q1="update HDIC set availAmt = ? where accId =? ;";
        try{ 
            createConn();
            PreparedStatement ps=con.prepareStatement(q1);
            ps.setInt(1, availAmt);
            ps.setString(2,accId);
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println("Error : "+e);
        }
        return false;
    }
}
