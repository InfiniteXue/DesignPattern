package designpattern.strategy;

// 策略模式用于算法的整体替换，从而可以使用不同算法解决同一个问题

/**
 * 抽象策略类(Strategy)
 */
interface Pen {

    /**
     * 抽象策略方法(strategyMethod)
     */
    void draw();

}

/**
 * 具体策略类(ConcreteStrategy)
 */
class RedPen implements Pen {

    @Override
    public void draw() {
        System.out.println("红笔");
    }

}

/**
 * 具体策略类(ConcreteStrategy)
 */
class BluePen implements Pen {

    @Override
    public void draw() {
        System.out.println("蓝笔");
    }

}

/**
 * 策略使用者
 */
class Context {

    /**
     * 注入具体策略
     */
    private Pen pen;

    public Context(Pen pen) {
        this.pen = pen;
    }

    public void executeDraw() {
        pen.draw();
    }

}


class Client {

    public static void main(String[] args) {
        // 使用RedPen
        Context redContext = new Context(new RedPen());
        redContext.executeDraw();
        // 使用BluePen
        Context blueContext = new Context(new BluePen());
        blueContext.executeDraw();
    }

}
