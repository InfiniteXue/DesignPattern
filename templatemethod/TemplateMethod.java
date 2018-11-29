package designpattern.templatemethod;

// 模版模式在父类中定义一套处理流程，在子类中实现各处理逻辑

/**
 * 抽象模版类(Template)
 */
abstract class Display {

    protected abstract void start();

    protected abstract void print();

    protected abstract void end();

    /**
     * 模版方法(TemplateMethod)
     */
    public void display() {
        start();
        print();
        end();
    }

}

/**
 * 具体模版类(ConcreteTemplate)
 */
class CharDisplay extends Display {

    private char c;

    public CharDisplay(char c) {
        this.c = c;
    }

    @Override
    protected void start() {
        System.out.print("<<");
    }

    @Override
    protected void print() {
        System.out.print(c);
    }

    @Override
    protected void end() {
        System.out.println(">>");
    }

}

/**
 * 具体模板类(ConcreteTemplate)
 */
class StringDisplay extends Display {

    private String str;

    public StringDisplay(String str) {
        this.str = str;
    }

    @Override
    protected void start() {
        System.out.print("++");
    }

    @Override
    protected void print() {
        System.out.print(str);
    }

    @Override
    protected void end() {
        System.out.println("++");
    }

}


class Client {

    public static void main(String[] args) {
        Display charDisplay = new CharDisplay('A');
        charDisplay.display();
        Display stringDisplay = new StringDisplay("String");
        stringDisplay.display();
    }

}
