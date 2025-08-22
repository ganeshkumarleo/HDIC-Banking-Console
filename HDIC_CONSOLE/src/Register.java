
import java.util.Random;
import java.util.*;

public class Register {//class name
    private String userName;
    private String phno;
    private String mailId;
    private String accId;
    private String gPinNo;
    private String rPinNo;
    private int inDeposit;


    public Register(){//constructors for initialization
       Scanner sc =new Scanner(System.in);//obj create 

        System.out.println("Enter your Name : ");
        userName = sc.nextLine();
        
        phno=getPhno();
        mailId=getMailId();
        
        System.out.println("Enter Initial Deposit amount : ");
        inDeposit = sc.nextInt();

        accId = generateNo(8);
        System.out.println("Generated Account ID : "+accId);

        gPinNo = generateNo(4);
        System.out.println("Generated Pin : "+gPinNo);
        sc.nextLine();
        
        System.out.println("RETYPE the PIN : ");
        rPinNo= sc.nextLine();

        if(gPinNo.equals(rPinNo)){//pin validate
            Boolean isOk=new DBManage().setUserInfos(accId, gPinNo, userName, phno,mailId, inDeposit);
            //sending data to setuserinfos method in dbmanage class
			if(isOk){//true stored in sql data)
                System.out.println("Account Registration Successfull.. pls Login..");

            }else{
                System.out.println("REGISTER Failed | server error");
            }

        }else{
            System.out.println("Account Registration Failed");
        }

    }
    
    private String getPhno() {
    	Scanner sc =new Scanner(System.in);
    	System.out.println("Enter Phone Number : ");
        String phno = sc.nextLine();
        String phnoregex = "^(\\+91[-\\s]?|91[-\\s]?|0)?[6-9]\\d{9}$";
        if (!phno.matches(phnoregex)) {
        	System.out.println("Invalid Phno.. Re-enter the details again..\n");
        	getPhno();//if details wrong call the function again to get phno 
        }
        return phno;
    }
    
    private String getMailId() {
    	Scanner sc =new Scanner(System.in);
    	System.out.println("Enter MailId : ");
        String mailid = sc.nextLine();
        String mailidregex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";//;
        if (!mailid.matches(mailidregex)) {
        	System.out.println("Invaid Mail Id.. Re-enter the details again..\n");
        	getMailId();//if details wrong call the function again to get mailid
        }
        return mailid;
    }

    private String generateNo(int len){//method with parameter
        String nums="123456890";
        Random random = new Random();
        String result = "";
        
        if(len==8) {
        	result="HDIC";	
        }
        for(int i=0;i<len;i++){
            int index = random.nextInt(nums.length());
            result+=nums.charAt(index);//eg:if random number 5 then 5 will printed
            }
        return result;
    }    
    
}