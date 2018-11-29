package designpattern.decorator;

// 装饰模式可在接口不变的前提下在运行期向其增加功能

/**
 * 待增加功能的抽象接口(Component)
 */
interface Beverage {

    String description();

    double cost();

}

/**
 * 实现类(ConcreteComponent)
 */
class RedTea implements Beverage {

    @Override
    public String description() {
        return "红茶";
    }

    @Override
    public double cost() {
        return 10;
    }

}

/**
 * 抽象装饰类(Decorator)
 */
abstract class Optional implements Beverage {

    protected Beverage beverage;

    public Optional(Beverage beverage) {
        this.beverage = beverage;
    }

}

/**
 * 具体装饰类(ConcreteDecorator)
 */
class Lemon extends Optional {

    public Lemon(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + "+柠檬";
    }

    @Override
    public double cost() {
        return beverage.cost() + 2;
    }

}

/**
 * 具体装饰类(ConcreteDecorator)
 */
class Mango extends Optional {

    public Mango(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description() + "+芒果";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3;
    }

}


class Client {

    public static void main(String[] args) {
        // 红茶
        Beverage redTea = new RedTea();
        System.out.println(redTea.description() + "---" + redTea.cost() + "元");
        /** 在运行期可通过不同的装饰类增加功能 */
        // 红茶+柠檬
        Beverage redTeaLemon = new Lemon(redTea);
        System.out.println(redTeaLemon.description() + "---" + redTeaLemon.cost() + "元");
        // 红茶+柠檬+芒果
        Beverage redTeaLemonMango = new Mango(redTeaLemon);
        System.out.println(redTeaLemonMango.description() + "---" + redTeaLemonMango.cost() + "元");
    }

}
