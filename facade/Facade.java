package designpattern.facade;

// 门面模式提供一个高层次接口供客户端调用，从而不必关心服务的具体实现

/**
 * 模块类(Module)
 */
class CPU {

    public void start() {
        System.out.println("CPU启动");
    }

    public void close() {
        System.out.println("CPU关闭");
    }

}

/**
 * 模块类(Module)
 */
class Disk {

    public void spin() {
        System.out.println("硬盘启动");
    }

    public void stop() {
        System.out.println("硬盘关闭");
    }

}

/**
 * 门面类(Facade)
 */
class Computer {

    private CPU cpu;
    private Disk disk;

    public Computer() {
        this.cpu = new CPU();
        this.disk = new Disk();
    }

    public void boot() {
        cpu.start();
        disk.spin();
    }

    public void shutdown() {
        cpu.close();
        disk.stop();
    }

}


class Client {

    public static void main(String[] args) {
        // 使用门面类
        Computer computer = new Computer();
        // 门面类API（高层次接口，其具体逻辑发生变化时不影响客户端调用）
        computer.boot();
        computer.shutdown();
    }

}
