package designpattern.factory;

/**
 * 抽象产品接口(Product)
 */
interface Mouse {
}

/**
 * 具体产品类(ConcreteProduct)
 */
class HpMouse implements Mouse {
}

/**
 * 具体产品类(ConcreteProduct)
 */
class DellMouse implements Mouse {
}

/**
 * 简单工厂类(SimpleFactory)
 */
class SimpleFactory {

    public static Mouse createMouse(String mouse) {
        if ("hpMouse".equals(mouse)) {
            return new HpMouse();
        } else if ("dellMouse".equals(mouse)) {
            return new DellMouse();
        } else {
            return null;
        }
    }

}


class SimpleFactoryClient {

    public static void main(String[] args) {
        Mouse hpMouse = SimpleFactory.createMouse("hpMouse");
        Mouse dellMouse = SimpleFactory.createMouse("dellMouse");
    }

}
