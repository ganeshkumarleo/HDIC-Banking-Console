


public class Login {//class name
    private String accId;//variable
    private String pinNo;
    
    public Login(){//constructors getting  values from user.
        System.out.println("Enter Account ID : ");
        accId = Input.getString();
        System.out.println("Enter Account Pin");
        pinNo = Input.getString();
        System.out.println(accId+ " "+pinNo);//refer 
    }

    public void validate(){//function 
        if(accId.length()==12 && pinNo.length()==4){
            DBManage db=new DBManage();
            new Portal().getUserInfo((db.getUserInfo(accId, pinNo)));//refer
        }
        else{
            System.out.println("Invalid user Data");
        }
    }
}