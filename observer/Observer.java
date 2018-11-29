package designpattern.observer;

// 观察者模式可在订阅主题发生变化时进行通知

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题类(Subject)
 */
abstract class Subject {

    /**
     * 订阅当前主题的观察者队列
     */
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}

/**
 * 具体主题类(ConcreteSubject)
 */
class LoginSubject extends Subject {

    public void execute() {
        // 触发通知
        notifyObservers();
    }

}

/**
 * 抽象观察者接口(Observer)
 */
interface Observer {

    /**
     * 被通知时逻辑处理抽象方法
     */
    void update(Subject subject);

}

/**
 * 具体观察者(ConcreteObserver)
 */
class EmailObserver implements Observer {

    @Override
    public void update(Subject subject) {
        System.out.println("发送邮件");
    }

}

/**
 * 具体观察者(ConcreteObserver)
 */
class SmsObserver implements Observer {

    @Override
    public void update(Subject subject) {
        System.out.println("发送短信");
    }

}


class Client {

    public static void main(String[] args) {
        // 主题
        LoginSubject loginSubject = new LoginSubject();
        // 观察者
        Observer emailObserver = new EmailObserver();
        Observer smsObserver = new SmsObserver();
        // 添加观察者
        loginSubject.addObserver(emailObserver);
        loginSubject.addObserver(smsObserver);
        // 触发通知
        loginSubject.execute();
    }

}
