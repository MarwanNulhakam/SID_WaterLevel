/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Wind Raider Zero
 */
public class MainConsole {
    public static void main(String[]args){
        String jsonURL = "https://raw.githubusercontent.com/onaio/ona-tech/master/data/water_points.json";
        dataLoader.Loader engine = new dataLoader.Loader(jsonURL);
        engine.viewResult();
    }
}
