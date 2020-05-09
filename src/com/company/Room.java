package com.company;

/**
 * @description:
 * @author: MSI-NB
 * @date: Created in 2020/4/16 11:18
 * @version: ${VERSION}
 * @modified By:
 */
public class Room {
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    public Room(String description){
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west){
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if (south != null)
            southExit = south;
        if (west != null)
            westExit = west;
    }

    @Override
    public String toString(){
        return description;
    }
}
