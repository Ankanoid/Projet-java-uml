package model;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Class which allow to play a wav song using a new Thread
 * 
 * @author Group 5
 * 
 */
public class SoundClip extends Thread {
 
	/**
	 * String filename containing the path to the wav file
	 */
    private String filename;
    private Position curPosition;
    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb
    enum Position {LEFT, RIGHT, NORMAL};
    
	/**
	 * Instantiates a new SoundClip.
	 *
	 * @param wavfile
	 *          the path to the wavfile
	 */
    public SoundClip(String wavfile) {
        filename = wavfile;
        curPosition = Position.NORMAL;
    }
    
    public static void playThis(String sound)
    {
    	if(sound == "COINS")
    	{
    		Thread playWave=new SoundClip("C:/Users/Thomas/git/Projet-java-uml/sprite/coins.wav");
    		playWave.start();
    	}
    	
    	if(sound == "DEATH_MONSTER")
    	{
    		Thread playWave=new SoundClip("C:/Users/Thomas/git/Projet-java-uml/sprite/death_monster.wav");
    		playWave.start();
    	}
    	
    	if(sound == "DEATH_PLAYER")
    	{
    		Thread playWave=new SoundClip("C:/Users/Thomas/git/Projet-java-uml/sprite/death_player.wav");
    		playWave.start();
    	}
    	
    	if(sound == "DOOR")
    	{
    		Thread playWave=new SoundClip("C:/Users/Thomas/git/Projet-java-uml/sprite/door.wav");
    		playWave.start();
    	}
    	
    	if(sound == "ENERGY")
    	{
    		Thread playWave=new SoundClip("C:/Users/Thomas/git/Projet-java-uml/sprite/energy_ball.wav");
    		playWave.start();
    	}
    	
    	if(sound == "FIREBALL_B")
    	{
    		Thread playWave=new SoundClip("C:/Users/Thomas/git/Projet-java-uml/sprite/fireball_back.wav");
    		playWave.start();
    	}
    	
    	if(sound == "FIREBALL_O")
    	{
    		Thread playWave=new SoundClip("C:/Users/Thomas/git/Projet-java-uml/sprite/fireball_on.wav");
    		playWave.start();
    	}
    	
    	if(sound == "P_M_LEVEL")
    	{
    		Thread playWave=new SoundClip("C:/Users/Thomas/git/Projet-java-uml/sprite/plus_minus_level.wav");
    		playWave.start();
    	}
    }
 
    /**
     * Function which will be running on the background
     */
    public void run() {
        File soundFile = new File(filename);
        if (!soundFile.exists()) {
            System.err.println("Wave file not found: " + filename);
            return;
        }
 
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
            return;
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }
 
        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
 
        try {
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
 
        if (auline.isControlSupported(FloatControl.Type.PAN)) {
            FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
            if (curPosition == Position.RIGHT) {
                pan.setValue(1.0f);
            } else if (curPosition == Position.LEFT) {
                pan.setValue(-1.0f);
            }
        }
 
        auline.start();
        int nBytesRead = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
 
        try {
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) {
                    auline.write(abData, 0, nBytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            auline.drain();
            auline.close();
        }
    }
} 