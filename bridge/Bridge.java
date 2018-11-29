package designpattern.bridge;

// 桥梁模式在功能层次结构和实现层次结构之间搭建桥梁，从而将功能部分与实现部分分离，使它们都可以独立变化（是在策略模式上的进一步抽象）

/**
 * 抽象实现接口(Implementor)(实现层次基于策略模式)
 */
interface Pen {

    String draw();

}

/**
 * 具体实现类(ConcreteImplementor)
 */
class RedPen implements Pen {

    @Override
    public String draw() {
        return "红色";
    }

}

/**
 * 具体实现类(ConcreteImplementor)
 */
class BluePen implements Pen {

    @Override
    public String draw() {
        return "蓝色";
    }

}

/**
 * 抽象功能类(Function)
 */
abstract class Shape {

    /**
     * 通过聚合抽象实现接口搭建桥梁
     */
    protected Pen pen;

    public Shape(Pen pen) {
        this.pen = pen;
    }

    protected abstract void draw();

}

/**
 * 具体功能类(ConcreteFunction)
 */
class Circle extends Shape {

    public Circle(Pen pen) {
        super(pen);
    }

    @Override
    protected void draw() {
        System.out.println("圆形" + "---" + pen.draw());
    }

}

/**
 * 具体功能类(ConcreteFunction)
 */
class Rectangle extends Shape {

    public Rectangle(Pen pen) {
        super(pen);
    }

    @Override
    protected void draw() {
        System.out.println("长方形" + "---" + pen.draw());
    }

}


class Client {

    public static void main(String[] args) {
        Shape circleRed = new Circle(new RedPen());
        circleRed.draw();
        Shape circleBlue = new Circle(new BluePen());
        circleBlue.draw();
        Shape rectangleBlue = new Rectangle(new BluePen());
        rectangleBlue.draw();
    }

}
