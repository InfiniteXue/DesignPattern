package designpattern.chainofresponsibility;

// 责任链模式将多个Handler组成一条链并按照它们的顺序判断到底由谁来负责处理，从而弱化请求方和处理方之间的关联关系

/**
 * 抽象处理器(Handler)
 */
abstract class Handler {

    /**
     * 下一个处理器
     */
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    /**
     * 抽象处理方法
     */
    protected abstract void execute(String str);

}

/**
 * 具体处理器(ConcreteHandler)
 */
class NumberHandler extends Handler {

    @Override
    protected void execute(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("非法参数");
            return;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                System.out.println("非数字");
                return;
            }
        }
        if (this.getNext() != null) {
            this.getNext().execute(str);
        }
    }

}

/**
 * 具体处理器(ConcreteHandler)
 */
class OddHandler extends Handler {

    @Override
    protected void execute(String str) {
        Integer i = Integer.parseInt(str);
        if (i % 2 != 0) {
            System.out.println("奇数");
            return;
        }
        if (this.getNext() != null) {
            this.getNext().execute(str);
        }
    }

}

/**
 * 具体处理器(ConcreteHandler)
 */
class EvenHandler extends Handler {

    @Override
    protected void execute(String str) {
        Integer i = Integer.parseInt(str);
        if (i % 2 == 0) {
            System.out.println("偶数");
            return;
        }
        if (this.getNext() != null) {
            this.getNext().execute(str);
        }
    }

}


class Client {

    public static void main(String[] args) {
        Handler numberHandler = new NumberHandler();
        Handler oddHandler = new OddHandler();
        Handler evenHandler = new EvenHandler();
        // 组装责任链
        numberHandler.setNext(oddHandler).setNext(evenHandler);
        // 传入请求
        numberHandler.execute("a");
        numberHandler.execute("1");
        numberHandler.execute("2");
    }

}