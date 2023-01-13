import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album = new Album("Album1" , "AC/DC");
        album.addSongToAlbum("TNT" , 4.5);
        album.addSongToAlbum("Highway to hell" , 3.5);
        album.addSongToAlbum("ThunderStruck" , 5.0);
        albums.add(album);

        album = new Album("Album2", "Eminem");
        album.addSongToAlbum("Rap god" , 4.5);
        album.addSongToAlbum("Not Afraid" , 3.5);
        album.addSongToAlbum("Lose yourself" , 4.5);

        albums.add(album);

        LinkedList<Song> playList1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT" , playList1); //1st album
        albums.get(0).addToPlayList("Highway to hell", playList1);
        albums.get(1).addToPlayList("Rap god" , playList1); //2nd album
        albums.get(1).addToPlayList("Lose yourself" , playList1);

        play(playList1);
    }

    public static void play(LinkedList<Song> playList){
        printMenu();

        ListIterator<Song> listIterator = playList.listIterator();
        boolean forward = true; //This is one step ahead already

        if(playList.size() > 0){
            System.out.println("Playing the first song " + listIterator.next().toString());

        }else{
            System.out.println("PlayList is empty");
            return;
        }

        System.out.println("Enter your option");
        boolean quit = false;
        Scanner sc = new Scanner(System.in);

        while(!quit){
            int option = sc.nextInt();
            switch (option){
                case 0 :
                    quit = true;
                    break;
                case 1 :
                    if(!forward){
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Next Song " + listIterator.next().toString());
                        forward = true;
                    }else{
                        System.out.println("You are at a last Song");
                        forward = false;
                    }
                    break;
                case 2 :
                    if(forward){
                        listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Previous Song " + listIterator.previous().toString());
                        forward = false;
                    }else{
                        System.out.println("You are at the First Song");
                        forward = true;
                    }
                    break;
                case 3 :
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Repeating the song " + listIterator.previous().toString());
                            forward = false;
                        }
//                        else{
//                            System.out.println("You are at the start of playlist");
//                        }
                    }else{ //forward = false
                        if(listIterator.hasNext()){
                            System.out.println("Repeating the song " + listIterator.next().toString());
                            forward = true;
                        }
                    }
                    break;
                case 4 :
                    System.out.println("Printing all the songs");
                    printSongs(playList);
                    break;
                case 5 :
                    printMenu();
                    break;

            }
        }

    }

    public static void printSongs(LinkedList<Song> playList){
        for(Song song : playList){
            System.out.println(song.toString() + " ");
        }
    }

    private static void printMenu(){
        System.out.println("Available options \n press");
        System.out.println("0 - to quit \n " +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - List of all songs\n" +
                "5 - print all available options\n" +
                "6 - delete current song");
    }
}
/*
* ArrayList , LinkedList ,List , Queue all can work with ListIterator
* li.next() => 1. Print the next element, 2. Move
* */