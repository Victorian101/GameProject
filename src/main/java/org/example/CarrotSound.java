package org.example;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class CarrotSound {
    private Clip clip;

    public CarrotSound() {
        try {
            URL url = Objects.requireNonNull(
                    getClass().getResource("/sounds/carrot.wav"),
                    "Missing /sounds/carrot.wav"
            );
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);

        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void play(){
        if(clip == null) return;
        if(clip.isRunning()){
            clip.stop();
        }
        clip.setFramePosition(0);
        clip.start();
    }
}
