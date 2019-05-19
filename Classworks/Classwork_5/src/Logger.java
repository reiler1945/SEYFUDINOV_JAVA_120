public class Logger {

    private final static Logger instance;

    //инициализация статических полей
    static{
        instance = new Logger();
    }

    private Logger() {

    }

    public static Logger getLogger() {
        return instance;
    }

    // здесь и ниже поля и поведение нашего единственного instance
    private String prefix = "MESSAGE";

    public void log(String text) {
        System.out.println(this.prefix + " " + text);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
