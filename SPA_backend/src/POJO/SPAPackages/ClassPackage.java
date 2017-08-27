/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO.SPAPackages;

import models.User;

public class ClassPackage extends User
{

    private static final long serialVersionUID = 1L;

    User user;
    public int minRange;
    public int maxRange;
    public int packagePrice;

   
    public int getMinRange() {return minRange;}  
    public void setMinRange(int minRange) { this.minRange = minRange;}

    public int getMaxRange() { return maxRange; }
    public void setMaxRange(int maxRange) { this.maxRange = maxRange; }

    public int getPackagePrice() { return packagePrice; }
    public void setPackagePrice(int packagePrice) { this.packagePrice = packagePrice;}

}
