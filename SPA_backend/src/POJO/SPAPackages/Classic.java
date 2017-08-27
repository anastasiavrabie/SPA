package POJO.SPAPackages;

import POJO.Zones.Body;
import POJO.Zones.Makeup;
import POJO.Zones.Massage;
import models.User;

public class Classic extends ClassPackage
{

    private static final long serialVersionUID = 1L;
    private Body body;
    private Makeup makeup;
    private Massage massage;
    private String packageName;
        
    public Classic ()
    {
        super();
        this.setPackagePrice(290); //warning
        this.setMinRange(3001);
        this.setMaxRange(4000);    
        
    }
    
    public int codeGenerator ()
    {
        Boolean [] range = new Boolean[1000];
        
        for (int i = 0; i < range.length; i++)
        {
            if (!range[i])
            {    
                user.setUserID(i + super.getMinRange()); 
                return user.getUserID();
            }
        }
        return -1;
    }
     
    public void accesBody (int userID)
    {
        makeup.searchUser(userID);
        massage.searchUser(userID);
        body.addUser(userID);
    }
    
    public void accesMakeup(int userID)
    {
        body.searchUser(userID);
        massage.searchUser(userID);
        makeup.addUser(userID);
    }
    
    public void accesMassage (int userID)
    {
        body.searchUser(userID);
        makeup.searchUser(userID);
        massage.addUser(userID);
    }
    
    @Override
    public void accesZone(String zone, int userID)
    {
        if (zone.equals("Body")) { accesBody(userID); }
        
        if (zone.equals("Makeuo")) { accesMakeup(userID); }
        
        if(zone.equals("Massage")) { accesMassage(userID); }
    }

}
