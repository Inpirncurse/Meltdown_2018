package sonidos;

import javax.sound.sampled.Clip;
public class Clipi implements Runnable{
    private Clip c;

    public Clipi(String path){
        c = SoundLoader.getInstance().loadClip(path);
    }

    public void play(){
        (new Thread(this)).start();
    }

    @Override
    public void run() {
        if(c.isRunning()){
            c.stop();
            c.setFramePosition(0);
        }
        c.start();
    }
}
