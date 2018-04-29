package sonidos;

import javax.sound.sampled.*;

public class SoundLoader {
    private static SoundLoader instance;

    public static SoundLoader getInstance(){
        if(instance==null)
            instance = new SoundLoader();
        return instance;
    }

    public Clip loadClip(String path){

        Clip c = null;
        try{
            AudioInputStream stream = AudioSystem.getAudioInputStream(getClass().getResource(path));
            c = AudioSystem.getClip();
            c.open(stream);
            stream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return c;
    }
}
