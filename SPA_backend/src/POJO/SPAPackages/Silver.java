package POJO.SPAPackages;

import POJO.Zones.Makeup;
import POJO.Zones.Massage;
import POJO.Zones.NailCaring;


public class Silver extends ClassPackage 
{
    private static final long serialVersionUID = 1L;
    private Makeup makeup;
    private Massage massage;
    private NailCaring nailCaring;
    
    public Silver ()
    {
        super();
        this.setPackagePrice(380);
        this.setMinRange(2001);
        this.setMaxRange(3000);
    }
    
     public int codeGenerator()
    {
        Boolean[] range = new Boolean[1000];

        for(int i = 0; i < range.length; i++) 
        {
            if(!range[i]) 
            { 
                user.setUserID(i + super.getMinRange()); 
                return user.getUserID(); 
            }
        }
        return -1;
    }
     
     public void accesMakeup(int userID)
    {
        massage.searchUser(userID);
        nailCaring.searchUser(userID);
        makeup.addUser(userID);
    }

    public void accesMassage(int userID)
    {
        makeup.searchUser(userID);
        nailCaring.searchUser(userID);
        massage.addUser(userID);
    }

    public void accesNailCaring(int userID)
    {
        makeup.searchUser(userID);
        massage.searchUser(userID);
        nailCaring.addUser(userID);
    } 
    
    @Override
    public void accesZone(String zone, int userID)
    {
        if (zone.equals("Makeup")) { accesMakeup(userID);}
        
        if (zone.equals("Massage")) { accesMassage(userID); }
        
        if(zone.equals("Nail Caring")) { accesNailCaring(userID); }
    }
}
