package me.timkellogg.raft;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: tim
 * Date: 5/26/13
 * Time: 8:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Network {
    private int port;
    private final ConcurrentHashMap<SocketAddress, NetworkResponseHandler> requests =
            new ConcurrentHashMap<SocketAddress, NetworkResponseHandler>();
    private final DatagramSocket socket;

    private Thread listenThread = new Thread() {
        @Override
        public void run() {

        }
    };

    public Network(int port) throws SocketException {
        this.port = port;
        socket = new DatagramSocket(port);
        socket.bind(socket.getLocalSocketAddress());
        listenThread.start();
    }

    public void send(NetworkMessage message) {

    }
}
