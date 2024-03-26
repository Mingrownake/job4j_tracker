package ru.job4j.ood.dip;

/* происходит нарушение принципа DIP  :
* 1. Есть зависимость самого от консольного вывода,
* 2. Зависимость от классов Recorder, MusicPlayer, MusicGuesser, т.е. Music может работать только с ними
* 3. Зависимость от класса Song, т.е. Music, Recorder, MusicPlayer, MusicGuesser может работать только с Song
* 4. Поле allMusic - зависимость от реализации map
* */

import java.util.HashMap;
import java.util.Map;

public class Music {

    private Map<Integer, Song> allMusic = new HashMap<>();

    private Song song;

    private Recorder recorder;

    private MusicPlayer musicPlayer;

    private MusicGuesser musicGuesser;

    private void recordMusic(Song song) {
        recorder.record(song);
        System.out.println("Recording " + song);
    }

    private void playMusic(Song song) {
        musicPlayer.play(song);
        System.out.println("Playing " + song);
    }

    private void guessMusic(Song song) {
        musicGuesser.guess(song);
        System.out.println("Trying to guess " + song);
    }

}

class Recorder {
    void record(Song song) {

    }
}

class MusicPlayer {
    void play(Song song) {

    }
}

class MusicGuesser {
    void guess(Song song) {

    }
}

class Song {

}