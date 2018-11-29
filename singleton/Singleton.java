package designpattern.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 饿汉式
 */
class HungrySingleton {

    /**
     * static成员变量在类加载-链接(准备)阶段分配内存并赋初始值，在类加载-初始化阶段赋声明值（类加载过程确保线程安全）
     */
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

    private HungrySingleton() {
    }

}

/**
 * 懒汉式
 */
class LazySingleton {

    /**
     * instance = new LazySingleton();  // 1.申请内存空间 2.实例成员变量赋默认值 3.执行声明的赋值语句 4.将对象引用赋值给instance变量
     * instance变量添加volatile修饰符为避免上述步骤3和步骤4过程中发生重排序，保证构造函数执行结束后才将此对象引用赋值给instance变量（防止其他线程使用不完整状态的对象）
     */
    private static volatile LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    private LazySingleton() {
    }

}

/**
 * 静态内部类式
 */
class InnerClassSingleton {

    /**
     * InnerClass在执行getInstance()方法的InnerClass.INSTANCE语句时才会进行类加载（当一个外部类被加载或实例化时，其内部类并不会被加载）
     */
    private static class InnerClass {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return InnerClass.INSTANCE;
    }

    private InnerClassSingleton() {
    }

}

/**
 * 枚举式
 */
enum EnumSingleton {

    /**
     * 枚举类的构造器默认为private
     * 反编译后
     *      enum EnumSingleton --> final class EnumSingleton extends java.lang.Enum<EnumSingleton>
     *      INSTANCE --> public static final EnumSingleton INSTANCE
     */
    INSTANCE;

}

/**
 * CAS式
 */
class CASSingleton {

    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

    public static CASSingleton getInstance() {
        for (; ; ) {
            CASSingleton singleton = INSTANCE.get();
            if (singleton != null) {
                return singleton;
            }
            singleton = new CASSingleton();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }

    private CASSingleton() {
    }

}


class Client {

    public static void main(String[] args) {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        LazySingleton lazySingleton = LazySingleton.getInstance();
        InnerClassSingleton innerClassSingleton = InnerClassSingleton.getInstance();
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        CASSingleton casSingleton = CASSingleton.getInstance();
    }

}
