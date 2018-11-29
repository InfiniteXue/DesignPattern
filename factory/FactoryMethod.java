package designpattern.factory;

// 工厂方法模式提供一个用于创建对象的接口（一个产品等级结构），并将类的实例化延迟到子类

/**
 * 具体产品类(ConcreteProduct)
 */
class HpMouseA implements Mouse {
}

class HpMouseB implements Mouse {
}

class DellMouseA implements Mouse {
}

class DellMouseB implements Mouse {
}

/**
 * 抽象工厂接口(Factory)
 */
interface MouseFactory {

    Mouse createMouse(String type);

}

/**
 * 具体工厂类(ConcreteFactory)
 */
class HpMouseFactory implements MouseFactory {

    @Override
    public Mouse createMouse(String type) {
        if ("A".equals(type)) {
            return new HpMouseA();
        } else if ("B".equals(type)) {
            return new HpMouseB();
        } else {
            return null;
        }
    }

}

/**
 * 具体工厂类(ConcreteFactory)
 */
class DellMouseFactory implements MouseFactory {

    @Override
    public Mouse createMouse(String type) {
        if ("A".equals(type)) {
            return new DellMouseA();
        } else if ("B".equals(type)) {
            return new DellMouseB();
        } else {
            return null;
        }
    }

}


class FactoryMethodClient {

    public static void main(String[] args) {
        MouseFactory hpMouseFactory = new HpMouseFactory();
        Mouse hpMouseA = hpMouseFactory.createMouse("A");
        MouseFactory dellMouseFactory = new DellMouseFactory();
        Mouse dellMouseB = dellMouseFactory.createMouse("B");
    }

}
