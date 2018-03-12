package com.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpNetListener implements ServletContextListener {
    private final static String TAG = "UdpNetListener";
    private UdpNetThread udpNetThread;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(TAG+":contextInitialized");
        if(null == udpNetThread){
            udpNetThread = new UdpNetThread();
            udpNetThread.start();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(TAG+":contextDestroyed");
        if(null != udpNetThread){
            udpNetThread.interrupt();
        }
    }

    private final class UdpNetThread extends Thread{

        @Override
        public void run() {
            super.run();
            while (true){
                try {
                    // 1.创建服务器端DatagramSocket，指定端口
                    DatagramSocket socket = new DatagramSocket(23023);
                    // 2.创建数据报，用于接收客户端发送的数据
                    byte[] data = new byte[1024];// 创建字节数组，指定接收的数据包的大小
                    DatagramPacket packet = new DatagramPacket(data, data.length);
                    // 3.接收客户端发送的数据
                    System.out.println("****服务器端已经启动，等待客户端发送数据");
                    socket.receive(packet);// 此方法在接收到数据报之前会一直阻塞
                    // 4.读取数据
                    String info = new String(data, 0, packet.getLength());
                    System.out.println("我是服务器，客户端说：" + info);

                    /*
                     * 向客户端响应数据
                     */
                    // 1.定义客户端的地址、端口号、数据
                    InetAddress address = packet.getAddress();
                    int port = packet.getPort();
                    byte[] data2 = "欢迎您!".getBytes();
                    // 2.创建数据报，包含响应的数据信息
                    DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
                    // 3.响应客户端
                    socket.send(packet2);
                    // 4.关闭资源
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
