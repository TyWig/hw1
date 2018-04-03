package window;

//FactoryMethod(107).ConcreteCreator
//AbstractFactory(87).ConcreteFactory

class AwtWindowFactory extends WindowImpFactory {

    private AwtWindowFactory() { }

    static WindowImpFactory instance() {
        return new AwtWindowFactory();
    }

    @Override
    WindowImp createWindow(String title, Window window) {
        return new AwtWindow(title, window);
    }
}
