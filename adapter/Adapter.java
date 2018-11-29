package designpattern.adapter;

// 适配器模式通过适配器使原有类能够适配目标接口（从而可以在不改变原有类逻辑的前提下适配目标接口）

/**
 * 原有类(Adaptee)(被适配类)
 */
class Banner {

    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

}

/**
 * 目标接口(Target)
 */
interface Print {

    void printWeak();

}

/**
 * 类适配器(Adapter)(继承原有类)
 */
class ExtendAdapter extends Banner implements Print {

    public ExtendAdapter(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        // 适配相应的方法
        super.showWithParen();
    }

}

/**
 * 对象适配器(Adapter)(包含原有类对象)
 */
class ObjectAdapter implements Print {

    private Banner banner;

    public ObjectAdapter(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

}


class Client {

    public static void main(String[] args) {
        Print extendAdapter = new ExtendAdapter("string");
        extendAdapter.printWeak();
        Print objectAdapter = new ObjectAdapter("string");
        objectAdapter.printWeak();
    }

}
