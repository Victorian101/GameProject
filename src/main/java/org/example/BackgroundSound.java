package org.example;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class BackgroundSound {
    private Clip clip;
    private FloatControl volume;

    public BackgroundSound() {
        try {
            URL url = Objects.requireNonNull(
                    getClass().getResource("/sounds/מעליות.wav"),
                    "Missing resource: /sounds/מעליות.wav"
            );
            AudioInputStream in = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(in);
            if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            }

        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void loop() {
        if (clip == null) return;
        clip.stop();
        clip.setFramePosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
        }
    }

    public void close() {
        if (clip != null) clip.close();
    }

    public void setVolumeDb(float db) {
        if (volume == null) return;
        float min = volume.getMinimum();
        float max = volume.getMaximum();
        float clamped = Math.max(min, Math.min(max, db));
        volume.setValue(clamped);
    }

    public boolean isPlaying() {
        return clip != null && clip.isActive();
    }

}
