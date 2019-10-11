package com.example.basketballcounterapp;

public class Player_info {
    String name = "";
    int Three_pointer = 0;
    int Two_points = 0;
    int Free_throws = 0;
    int foul=0;


    static Player_info player_info[] = new Player_info[12];
    static Player_info player_info1[]=new Player_info[12];


    public void Player_info_creat() {

        for(int i = 0; i < player_info.length; i++)
        {
            player_info[i] = new Player_info(); //make the object so we can access it
            player_info1[i] = new Player_info(); //make the object so we can access it
        }

    }




}