
public class TextProcessor implements Observable{

    private static final int MAX_OBSERVERS_COUNT = 5;

    private String text;

    private Observer observers[];
    private int observersCount;

    public TextProcessor(String text) {

    }

    void process(String text) {
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        if (observersCount < MAX_OBSERVERS_COUNT) {
            this.observers[observersCount] = observer;
            observersCount++;
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observersCount; i++) {
            observers[i].handleEvent(this.text);
        }
    }
}
