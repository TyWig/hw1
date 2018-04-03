package window;

//FactoryMethod(107).ConcreteCreator
//AbstractFactory(87).ConcreteFactory

class AwtWindowFactory extends WindowFactory {

    private AwtWindowFactory() { }

    static WindowFactory instance() {
        return new AwtWindowFactory();
    }

    @Override
    WindowImp createWindow(String title, Window window) {
        return new AwtWindow(title, window);
    }
}
