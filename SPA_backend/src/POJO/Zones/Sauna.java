/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO.Zones;

import models.User;

/**
 *
 * @author User
 */
public class Sauna extends Zone
{
     public void addUser(int userID)
    {
        usersIDList.add(userID);
        countUsers++;
        
    }
    
    public void searchUser(int userID)
    {
        for (int i = 0; i < usersIDList.size(); i++)
            if (usersIDList.get(i) == userID)
            {
                usersIDList.remove(userID);
                countUsers--;
            }
    }
    public void hasAccess(int userID)
    {
       if(userID <= 2000 ) 
       {
           System.out.println("You can come in");
       } 
       else 
           System.out.print("We are sorry but you do not have access in this zone");
           
      
    }
    
}
