
///this class stores data in sql database

import java.util.ArrayList;//

public class Portal {

    String accId;
    String usrName;
    int availAmt;

    void getUserInfo(ArrayList<UserInfos> lUserInfos){
        for(UserInfos ui:lUserInfos){
            this.accId=ui.accId;
            this.usrName=ui.usrName;
            this.availAmt=ui.availAmt;
        }
        displayInfo();
    }

    void displayInfo(){
        System.out.println("Account Number : "+accId);
        System.out.println("User Name : "+usrName);
        System.out.println("Available Balance : "+availAmt);

        System.out.println("Enter 1 for Deposit and 2 for withdraw | 3 for Exit : ");

        int op2=Input.getInt();
        int amt;
        if(op2==1){
            System.out.println("Enter amount to deposit");
            int depAmt=Input.getInt();
            amt = availAmt+depAmt;
            if(new DBManage().setAvailAmt(amt,accId)){
                System.out.println("Deposit Successful");
                availAmt=amt;
            }else{
                System.out.println("Deposit Unsuccess..");
            }        
            displayInfo();
        }else if(op2==2){
            System.out.println("Enter amount to withdraw");
            int withAmt=Input.getInt();
            if(withAmt<availAmt){
                amt=availAmt-withAmt;
                if(new DBManage().setAvailAmt(amt,accId)){
                    System.out.println("Withdraw Successful");
                    availAmt=amt;
                }else{
                    System.out.println("Server error | cannot withdraw");
                }
            }else{
                System.out.println("YOu don't have sufficient AMount");
            }
            displayInfo();
        }else if(op2==3) {
            System.out.println("Thanks for Visiting");
            ///new Home().options();
        }
        else{
            System.out.println("Invalid option Entered");
        }
    }
    
}