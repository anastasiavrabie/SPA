
package models;




import POJO.SPAPackages.ClassPackage;
import POJO.SPAPackages.Classic;
import POJO.SPAPackages.Gold;
import POJO.SPAPackages.Platinum;
import POJO.SPAPackages.Silver;
import java.io.Serializable;

/**
 *
 * @author User
 */
public class User implements Serializable
{

    private static final long serialVersionUID = 1L;
    

    static int generateID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private String clientName;
    
    private String userMail;
    private String userCard;
    private int userCVV;
    private static int userID = 0;
    private  ClassPackage userPackage;
    
    
    private eWallet userWallet;
   
    
    public User(String clientName, String userCard, String userPackage, int userID)
    {
        
        this.clientName = clientName;
        this.userCard = userCard;
       
        this.userPackage = ChoosePackage(userPackage);
        this.userWallet = new eWallet();        
    }
        
    public ClassPackage ChoosePackage(String userPackage)
    {
       if(userPackage.equals("Platinum"))
       {
           Platinum platinum = new Platinum();
           this.userPackage = platinum;
          // this.userID = platinum.codeGenerator();
       }
      
       if(userPackage.equals("Gold"))
       {
           Gold gold = new Gold();
           this.userPackage = gold;
          // this.userID = gold.codeGenerator();
       }
       
       if(userPackage.equals("Silver"))
       {
           Silver silver = new Silver();
           this.userPackage = silver;
           //this.userID = silver.codeGenerator();
       }
       
       if(userPackage.equals("Classic"))
       {
           Classic classic = new Classic();
           this.userPackage = classic;
          // this.userID = classic.codeGenerator();
       }
       return this.userPackage;
    }
   
//    public int generateUserID(User user)
//    {
//        if(user.getUserPackage().equals(Platinum))
//       {
//           Platinum platinum = new Platinum();  
//           this.userID = platinum.codeGenerator();
//       }
//      
//       if(userPackage.equals("Gold"))
//       {
//           Gold gold = new Gold();
//           this.userPackage = gold;
//          // this.userID = gold.codeGenerator();
//       }
//       
//       if(userPackage.equals("Silver"))
//       {
//           Silver silver = new Silver();
//           this.userPackage = silver;
//           //this.userID = silver.codeGenerator();
//       }
//       
//       if(userPackage.equals("Classic"))
//       {
//           Classic classic = new Classic();
//           this.userPackage = classic;
//          // thi
//       }
//        return userID;
//       
//    }
       
    public User()
    {
      
        this.clientName = getClientName();
        this.userID = getUserID();
        this.userMail = getUserMail();
        this.userPackage = getUserPackage();
    }
     
     
  

   public void accesZone(String zone, int clientID) 
    {
        if(clientID <= 1000)
        {
            Platinum platinum = new Platinum();
            platinum.accesZone(zone, clientID);
        }
        
        if (clientID > 1000 && clientID <= 2000)
        {
            Gold gold = new Gold();
            gold.accesZone(zone, clientID);
        }
        
        if (clientID > 2000 && clientID <= 3000)
        {
            Silver silver = new Silver();
            silver.accesZone(zone, clientID);
        }
    }

    
   

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getUserMail() { return userMail; }
    public void setUserMail(String userMail) { this.userMail = userMail; }

    /**
     *
     * @return
     */
    public static int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
    
    public ClassPackage getUserPackage() { return userPackage; }
    public void setUserPackage(ClassPackage userPackage) { this.userPackage = userPackage; }
    
   
    public String printUserInfoByID(int ID)
    {
        //TODO insert query to get user's info
        return "Name: " + clientName + "\nMail: " + userMail + "\nID" + userID  ;
    }

    private ClassPackage ChosePackage(String userPackage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

     
  
   

