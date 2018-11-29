package designpattern.callback;

// 回调模式可在指定任务完成后被通知（类A调用类B的方法，在该方法执行完后再回调类A的方法）

/**
 * 回调接口
 */
interface CallbackListener {

    /**
     * 回调通知函数
     */
    void callbackNotify(String msg);

}

/**
 * 通知者(Notifier)(负责回调)
 */
class Answerer {

    public void execute(Asker asker, String question) {
        if ("1+1".equals(question)) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CallbackListener callbackListener = asker.getCallbackListener();
            if (callbackListener != null) {
                // 回调
                callbackListener.callbackNotify("answer:2");
            }
        }
    }

}

/**
 * 调用者(Caller)
 */
class Asker {

    private CallbackListener callbackListener;

    public void ask(Answerer answerer, String question) {
        // 异步执行
        new Thread() {
            @Override
            public void run() {
                // 在内部类中调用当前外部类对象引用---外部类类名.this
                answerer.execute(Asker.this, question);
            }
        }.start();
    }

    public CallbackListener getCallbackListener() {
        return callbackListener;
    }

    public void setCallbackListener(CallbackListener callbackListener) {
        this.callbackListener = callbackListener;
    }

}


class Client {

    public static void main(String[] args) {
        Asker asker = new Asker();
        // 定义回调通知函数
        asker.setCallbackListener(new CallbackListener() {
            @Override
            public void callbackNotify(String msg) {
                System.out.println(msg);
            }
        });
        asker.ask(new Answerer(), "1+1");
        System.out.println("ask:1+1");
    }

}
