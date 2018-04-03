package window;

//FactoryMethod(107).ConcreteCreator
//AbstractFactory(87).ConcreteFactory

class SwingWindowFactory extends WindowFactory {

    private SwingWindowFactory() { }

    static WindowFactory instance() {
        return new SwingWindowFactory();
    }

    @Override
    WindowImp createWindow(String title, Window window) {
        return new SwingWindow(title, window);
    }
}
