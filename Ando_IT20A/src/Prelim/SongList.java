
package Prelim;

import java.util.LinkedList;

public class SongList {
    public static void main(String[] args) {
        
        LinkedList <String> playlist = new LinkedList<>();
        
        playlist.add("Song A");
        playlist.add("Song B");
        playlist.add("Song C");
        
        playlist.addFirst("Intro song");
        
        playlist.addFirst("Ending song");
        
        playlist.remove("Song A");
        playlist.removeLast();
        
        System.out.print(playlist.getFirst());
        
        System.out.print(playlist);
        
    }
    
}
