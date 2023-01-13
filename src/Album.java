import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String name, artistName;
    ArrayList<Song> songs;

    public Album(String name, String artistName) {
        this.name = name;
        this.artistName = artistName;
        this.songs = new ArrayList<>(); //People forget to initialize list else null pointer exception can happen
    }

    public boolean findSong(String title){
        for(Song song : songs ){
            if(song.getTitle().equals(title)){ //.equal does content comparison & == does object comparison
                return true;
            }
        }
        return false;
    }

    public void addSongToAlbum(String title , double duration){
        if(!findSong(title)){
            Song newSong = new Song(title , duration);
            songs.add(newSong);
            System.out.println(newSong.getTitle() + " has been added :)");
        }else{
            System.out.println("Song Already Exist in Album !!! ");
        }
    }

    public void addToPlayList(int trackNo , LinkedList<Song> playList){
        int index = trackNo - 1;
        if(index >=0 && index <songs.size()){
            Song s = this.songs.get(index);
            playList.add(s);
        }

    }

    public void addToPlayList(String title , LinkedList<Song> playList){
        for(Song song : this.songs){ //Iterating over the songs
            if(song.getTitle().equals(title)){ //Found song object
                playList.add(song);
            }
        }
    }
}
