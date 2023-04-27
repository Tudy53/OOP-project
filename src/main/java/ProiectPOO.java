import Application.Application;

public class ProiectPOO {

    public static void main(String[] args) {
        if(args == null) {
            System.out.println("Nothing to read here");
            return;
        }

        if (args.length < 4) {
            System.out.println("Not enough files to read from!\n");
            return;
        }

        Application application = new Application();
        application.start(args[0], args[1], args[2], args[3]);
    }
}
