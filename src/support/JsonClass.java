/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *
 * @author Wind Raider Zero
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonClass {
    
    @JsonProperty("communities_villages")
    private String communities_villages;
    
    @JsonProperty("water_functioning")
    private String water_functioning;
    
    public void setCommunitiesVillages(String value){
        communities_villages = value;
    }
    
    public void setWaterFunctioning(String value){
        water_functioning = value;
    }
    
    public String getCommunitiesVillages(){
        return communities_villages;
    }
    
    public String getWaterFunctioning(){
        return water_functioning;
    }
   
}

