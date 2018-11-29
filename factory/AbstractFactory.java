package designpattern.factory;

// 抽象工厂模式提供一个用于创建一系列相关或依赖对象的接口（即由不同产品等级结构构成的一个产品族）
// 当产品只有一个时，抽象工厂模式即简化为工厂方法模式
// 抽象工厂模式易于增加具体的工厂，但难以增加生产的产品

/**
 * 抽象产品接口(Product)
 */
interface Keyboard {
}

/**
 * 具体产品类(ConcreteProduct)
 */
class HpKeyboard implements Keyboard {
}

class DellKeyboard implements Keyboard {
}

/**
 * 抽象工厂接口(Factory)
 */
interface PcFactory {

    Mouse createMouse();

    Keyboard createKeyboard();

}

/**
 * 具体工厂类(ConcreteFactory)
 */
class HpPcFactory implements PcFactory {

    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new HpKeyboard();
    }

}

/**
 * 具体工厂类(ConcreteFactory)
 */
class DellPcFactory implements PcFactory {

    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new DellKeyboard();
    }

}


class AbstractFactoryClient {

    public static void main(String[] args) {
        PcFactory hpPcFactory = new HpPcFactory();
        hpPcFactory.createMouse();
        hpPcFactory.createKeyboard();
        PcFactory dellPcFactory = new DellPcFactory();
        dellPcFactory.createMouse();
        dellPcFactory.createKeyboard();
    }

}
