package window;

//AbstractFactory(87).AbstractFactory
//FactoryMethod(107).Creator
//Singleton(127).Singleton

public abstract class WindowImpFactory {
    private static WindowImpFactory instance;

    public static WindowImpFactory getInstance() {
        if(instance == null)
            instance = initializeInstance();
        return instance;
    }

    private static WindowImpFactory initializeInstance() {
        String s = System.getenv("LexiWindow");
        if (s == null)
            return SwingWindowFactory.instance();
        switch (s) {
            case "Awt":
                return AwtWindowFactory.instance();
            case "Swing":
                return SwingWindowFactory.instance();
            default:
                return AwtWindowFactory.instance();
        }
    }

    abstract WindowImp createWindow(String title, Window window);
}
