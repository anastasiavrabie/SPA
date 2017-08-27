
package POJO.SPAPackages;

import POJO.Zones.Massage;
import POJO.Zones.NailCaring;
import POJO.Zones.Sauna;

public class Gold extends ClassPackage
{

    private static final long serialVersionUID = 1L;
    private Massage massage;
    private NailCaring nailCaring;
    private Sauna sauna;

    public Gold()
    {
        super();
        this.setPackagePrice(450);
        this.setMinRange(1001);
        this.setMaxRange(2000);
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

    public void accesMassage(int userID)
    {
        nailCaring.searchUser(userID);
        sauna.searchUser(userID);
        massage.addUser(userID);
    }
    
    public void accesNailCaring(int userID)
    {
        massage.searchUser(userID);
        sauna.searchUser(userID);
        nailCaring.addUser(userID);
    }
    public void accesSauna(int userID)
    {
        massage.searchUser(userID);
        nailCaring.searchUser(userID);
        sauna.addUser(userID);
    }
    
    @Override
    public void accesZone(String zone, int userID)
    {
        if (zone.equals("Massage")) { accesMassage(userID); }
        
        if (zone.equals("Nail Caring")) { accesNailCaring(userID); }
        
        if(zone.equals("Sauna")) { accesSauna(userID); }
    }
}
