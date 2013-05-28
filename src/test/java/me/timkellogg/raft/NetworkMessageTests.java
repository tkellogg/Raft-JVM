package me.timkellogg.raft;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tim
 * Date: 5/26/13
 * Time: 9:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class NetworkMessageTests {
    @Test
    public void testEncodingAndDecodingId() throws UnsupportedEncodingException {
        String msg = "This is flipping awesome";
        NetworkMessage message = new NetworkMessage(msg.getBytes("utf8"), new SocketAddress[]{InetSocketAddress.createUnresolved("localhost", 55555)});

        UUID expectedId = message.getMessageId();
        UUID id = NetworkMessage.parseMessageId(message.getMessage());
        assertEquals(expectedId, id);
    }
}
