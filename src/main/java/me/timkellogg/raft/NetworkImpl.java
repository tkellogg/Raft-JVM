package me.timkellogg.raft;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: tim
 * Date: 5/26/13
 * Time: 8:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class NetworkImpl implements Network {
    private int port;
    private final ConcurrentHashMap<SocketAddress, NetworkResponseHandler> requests =
            new ConcurrentHashMap<SocketAddress, NetworkResponseHandler>();
    private final DatagramSocket socket;

    private Thread listenThread = new Thread() {
        @Override
        public void run() {

        }
    };

    public NetworkImpl(int port) throws SocketException {
        this.port = port;
        socket = new DatagramSocket(port);
        socket.bind(socket.getLocalSocketAddress());
        listenThread.start();
    }

    @Override
    public void send(NetworkMessage message, SocketAddress[] addresses, NetworkResponseHandler handler) throws IOException {
        byte[] bytes = message.getMessage();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, addresses[0]);
        socket.send(packet);
    }

    public void close() {
        listenThread.stop();
    }
}
