package window;

//FactoryMethod(107).ConcreteCreator
//AbstractFactory(87).ConcreteFactory

class SwingWindowFactory extends WindowImpFactory {

    private SwingWindowFactory() { }

    static WindowImpFactory instance() {
        return new SwingWindowFactory();
    }

    @Override
    WindowImp createWindow(String title, Window window) {
        return new SwingWindow(title, window);
    }
}
