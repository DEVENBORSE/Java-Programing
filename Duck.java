
interface Workable {
    void work();
}

interface Swimmable {
    void swim();
}


class Duck implements Workable, Swimmable {
    public void work() {
        System.out.println("Duck is working (e.g., building a nest).");
    }

    public void swim() {
        System.out.println("Duck is swimming in the pond.");
    }

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.work();
        duck.swim();
    }
}
