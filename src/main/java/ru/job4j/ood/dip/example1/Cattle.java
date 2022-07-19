package ru.job4j.ood.dip.example1;

/**public interface Cattle {
    String makeFoodFor();
}
*/
class Cow {  /** implements Cattle {

 */
    public String makeFoodFor() {
        return null;
    }
}

class CattleFarm {
    private Cow cow;

    public CattleFarm(Cow cow) {
        this.cow = cow;
    }
}
/**
 * Класс CattleFarm завязан только на коров. Грамотнее сделать интерфейс,
 * его имплиментит корова. И его употребить в CattleFarm.
 */