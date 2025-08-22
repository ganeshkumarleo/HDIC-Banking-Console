


public class Home {

    void options(){//functions
        System.out.println("Enter\n1 for Login\n2 for Register");

        int op=Input.getInt();

        if(op==1){
            new Login().validate();//function authentication            
        }else if (op==2) {
            new Register();
            
            options();
        } else {
            System.out.println("Invalid input");            
        }
    }
    public static void main(String[] args) throws Exception {
        
        new Home().options();//calling (options) function
    }
}