/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

/**
 *
 * @author Wind Raider Zero
 */
public class GroupData {
    private String groupName;
    private int numberOfEntity;
    private int numberOfUnusable;
    private int numberOfUsable;
    
    public GroupData(){
        numberOfEntity=1;
        numberOfUnusable=0;
        numberOfUsable=0;
    }
    
    public GroupData(String groupName){
        this();
        this.groupName = groupName;
    }
    
    public void setGroupName(String data){
       groupName = data;
    }
    
    public void setNumberOfEntity(int data){
        numberOfEntity = data;
    }
    
    public void setNumberOfUnusable(int data){
        numberOfUnusable = data;
    }
    
    public void setNumberOfUsable(int data){
        numberOfUsable = data;
    }
    
    public String getGroupName(){
        return groupName;
    }

    public int getNumberOfEntity(){
        return numberOfEntity;
    }

    public int getNumberOfUnusable(){
        return numberOfUnusable;
    }
    
    public int getNumberOfUsable(){
        return numberOfUsable;
    }
    
    public void entityIncrease(){
        numberOfEntity++;
    }
    
    public void unusableIncrease(){
        numberOfUnusable++;
    }
    
    public void usableIncrease(){
        numberOfUsable++;
    }
    
}
