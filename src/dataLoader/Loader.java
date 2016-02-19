/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLoader;

import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Wind Raider Zero
 */
public class Loader {
    private List<support.JsonClass> record;
    private List<support.GroupData> communityGroup;
    
    public Loader(String jsonURL){
        try{
            URL url = new URL(jsonURL);
            ObjectMapper mapper = new ObjectMapper();    
            record = mapper.readValue(url, mapper.getTypeFactory().constructCollectionType(List.class, support.JsonClass.class));
            //System.out.println("size of record copied from url : "+record.size());
            communityGroup = summary(record);
        }catch(java.io.IOException e){
            System.out.println(e.toString());
        }
    }
    
    public List<support.GroupData> summary(List<support.JsonClass> data){
        List<support.GroupData> community = new ArrayList<>();
        List<String> log = new ArrayList<>();
        support.GroupData temp;
        for(int i=0;i<data.size();i++){
            if(log.contains(data.get(i).getCommunitiesVillages())){
                temp = community.get(log.indexOf(data.get(i).getCommunitiesVillages()));
                temp.entityIncrease();
            }else{
                log.add(data.get(i).getCommunitiesVillages());
                temp = new support.GroupData(data.get(i).getCommunitiesVillages());
                community.add(temp);
            }
            
            if (!data.get(i).getWaterFunctioning().equalsIgnoreCase("yes"))
                temp.unusableIncrease();
            else
                temp.usableIncrease();
        }
        
        return community;
    }
    
    public void viewResult(){
        //System.out.println("community group size = "+communityGroup.size()+" group\n");
        if(!communityGroup.isEmpty()){
            int total = 0, unused = 0, functional = 0;
            
            for(int i=0;i<communityGroup.size();i++){
                functional+=communityGroup.get(i).getNumberOfUsable();
            }
            System.out.println("\n\ntotal functional water source = "+functional);
            
            System.out.println("number of water point per community :");
            for(int i=0;i<communityGroup.size();i++){
                System.out.println(communityGroup.get(i).getGroupName() + " : " +communityGroup.get(i).getNumberOfEntity());
                total+=communityGroup.get(i).getNumberOfEntity();
                unused+=communityGroup.get(i).getNumberOfUnusable();
            }
            
            System.out.println("\n\npercentage of unused water source :");
            double temps;
            for(int i=0;i<communityGroup.size();i++){
                temps = (((double)communityGroup.get(i).getNumberOfUnusable()/communityGroup.get(i).getNumberOfEntity())*100);
                System.out.println(communityGroup.get(i).getGroupName()+" : "+ 
                        (new DecimalFormat((double)(temps-(int)temps)>0? "#0.00" : "#0.0").format(temps)));
            }
            
        }
    }
    
}
