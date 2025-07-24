package Chapter6;

public class Task16 {

    interface Animal {
        boolean feed(boolean timeToEat);
        void groom();
        void pet();
    }

    static class Gorilla implements Animal {

        @Override
        public boolean feed(boolean timeToEat) {
            if (timeToEat) {
                System.out.println("Feeding the gorilla...");
                return true;
            } else {
                System.out.println("Gorilla is not hungry right now.");
                return false;
            }
        }

        @Override
        public void groom() {
            System.out.println("Grooming gorilla: lather, rinse, repeat.");
        }

        @Override
        public void pet() {
            System.out.println("Petting gorilla: pet at your own risk!");
        }
    }

    public static void main(String[] args) {
        Gorilla g = new Gorilla();
        g.feed(true);
        g.groom();
        g.pet();
    }
}
