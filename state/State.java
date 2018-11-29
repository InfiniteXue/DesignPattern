package designpattern.state;

// 状态模式包含多个状态对象和一个聚合状态对象的上下文对象（每一种状态的行为交由状态对象处理，从而让上下文对象不必关心）

/**
 * 上下文(Context)
 */
class Context {

    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}

/**
 * 抽象状态接口(State)
 */
interface State {

    /**
     * 状态切换
     */
    void doAction(Context context);

}

/**
 * 具体状态类(ConcreteState)
 */
class OpenState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("切换为Open状态");
        context.setState(this);
    }

}

/**
 * 具体状态类(ConcreteState)
 */
class CloseState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("切换为Close状态");
        context.setState(this);
    }

}


class Client {

    public static void main(String[] args) {
        State openState = new OpenState();
        State closeState = new CloseState();
        Context context = new Context();
        // 将context切换为open状态
        openState.doAction(context);
        // 将context切换为close状态
        closeState.doAction(context);
    }

}
