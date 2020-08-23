package domain.consumer;

public class Radio implements ElectricityConsumer {

    public void playMusic() {
        System.out.println("Radio plays");
    }

    @Override
    public void electricityOn() {
        playMusic();
    }
}
