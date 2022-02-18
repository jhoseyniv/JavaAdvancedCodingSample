package designpattern.Behavioral.Logger;

public class ConsolLogger extends AbstractLogger{
    public ConsolLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
