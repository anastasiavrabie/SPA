/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO.SPAPackages;

import POJO.Zones.Body;
import POJO.Zones.NailCaring;
import POJO.Zones.Sauna;

public class Platinum extends ClassPackage
{

    private static final long serialVersionUID = 1L;
    private NailCaring nailCaring;
    private Sauna sauna;
    private Body body;
   
   public Platinum()
   {
       super();
       this.setPackagePrice(520);
       this.setMinRange(1);
       this.setMaxRange(1000);
    }
   
   public int codeGenerator()
   {
        Boolean[] range = new Boolean[1000];

        for(int i = 1; i < range.length; i++) 
        {
            if(!range[i]) 
            { 
                user.setUserID(i + super.getMinRange()); 
                return user.getUserID(); 
            }
        }
        return -1;
   }
   
   public void accesNailCaring(int userID)
   {
       sauna.searchUser(userID);
       body.searchUser(userID);
       nailCaring.addUser(userID);
   }

    public void accesSauna(int userID)
    {
        nailCaring.searchUser(userID);
        body.searchUser(userID);
        sauna.addUser(userID);
    }

    public void accesBody(int userID)
    {
        nailCaring.searchUser(userID);
        sauna.searchUser(userID);
        body.addUser(userID);
    }
    
    @Override
    public void accesZone(String zone, int userID)
    {
        if (zone.equals("Nail Caring")) { accesNailCaring(userID); }
        
        if (zone.equals("Sauna")) { accesSauna(userID); }
        
        if(zone.equals("Body")) { accesBody(userID); }
    }
}
