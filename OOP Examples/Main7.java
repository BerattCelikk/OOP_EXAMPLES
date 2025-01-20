/*
Question 7: Interface + Polymorphism
Define an interface Playable with a play() method.
Create a VideoGame class that implements Playable and prints "Playing video game...".
Create a MusicTrack class that implements Playable and prints "Playing music track...".

Main Requirement:

Create instances of VideoGame and MusicTrack. Call their play() methods directly
*/
interface Playable{
    void play();
}
class VideoGame implements Playable{
    @Override
    public void play(){
        System.out.println("Playing video game...");
    }
}
class MusicTrack implements Playable{
    @Override
    public void play(){
        System.out.println("Playing music Track... ");
    }
}
public class Main7 {
    public static void main(String[] args) {
        VideoGame game = new VideoGame();
        MusicTrack track = new MusicTrack();

        game.play();
        track.play();
    }
}
