package com.company;

import java.util.Scanner;

public class Game {
    private Room currentRoom;

    public Game(){
        createRooms();
    }

    private void createRooms(){
        Room outside, lobby, pub, study, bedroom;

        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");

        //初始化房间出口
        outside.setExits(null, lobby, study, pub);
        lobby.setExits(null, null ,null, outside);
        pub.setExits(null, outside, null, null);
        study.setExits(outside, bedroom, null, null);
        bedroom.setExits(null, null,null, study);

        currentRoom = outside;
    }

    private void printWelcome(){
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入'help'。");
        System.out.println();
        System.out.println("现在你在"+currentRoom);
        if (currentRoom.northExit !=null)
            System.out.print("north ");
        if (currentRoom.eastExit != null)
            System.out.print("east ");
        if (currentRoom.southExit != null)
            System.out.print("south ");
        if (currentRoom.westExit != null)
            System.out.print("west ");
        System.out.println();
    }

    //下为用户命令

    private void printHelp(){
        System.out.print("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如\t go east");
    }

    private void goRoom(String direction){
        Room nextRoom = null;
        if(direction.equals("north")){
            nextRoom = currentRoom.northExit;
        }
        if (direction.equals("east")){
            nextRoom = currentRoom.eastExit;
        }
        if (direction.equals("west")){
            nextRoom = currentRoom.westExit;
        }
        if (direction.equals("south")){
            nextRoom = currentRoom.southExit;
        }
        if (nextRoom == null){
            System.out.println("那里没有门");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("你在"+ currentRoom);
            System.out.println("出口有：");
            if (currentRoom.northExit != null)
                System.out.print("north ");
            if (currentRoom.eastExit != null)
                System.out.print("east ");
            if (currentRoom.southExit != null)
                System.out.print("south ");
            if (currentRoom.westExit != null)
                System.out.print("west ");
            System.out.println();

        }
    }
    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        Game game = new Game();
        game.printWelcome();

        while (true){
            String line = in.nextLine();
            String[] words = line.split(" ");
            if (words[0].equals("help")){
                game.printHelp();
            }
            else if (words[0].equals("go")){
                game.goRoom(words[1]);
            }
            else if (words[0].equals("bye")){
                break;
            }
        }

        System.out.println("感谢光临，再见");
        in.close();
    }
}
