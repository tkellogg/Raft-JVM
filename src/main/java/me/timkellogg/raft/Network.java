package me.timkellogg.raft;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * User: tim
 * Date: 5/28/13
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Network {
    void send(NetworkMessage message, SocketAddress[] addresses, NetworkResponseHandler handler) throws IOException;
}
