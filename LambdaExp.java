package Java8;

public class LambdaExp implements music{
    @Override
    public void play() {
        System.out.println("Playing music mehtod implemented from interface..");
    }

    public void playy(){
        System.out.println("This is not implemenented method from interface");
    }


    public static void main(String[] args) {
        LambdaExp le = new LambdaExp();
        le.play();

//        PunjabiSongs ps = new PunjabiSongs() {
//            @Override
//            public void play() {
//                System.out.println("Playing punjabi songs");
//            }
//
//            @Override
//            public void stop() {
//                System.out.println("Player has stopped playing punjabi songs");
//            }
//        };


    }
}
interface PunjabiSongs{
    void play();
    void stop();
}
@FunctionalInterface
interface music{
    void play();

}
