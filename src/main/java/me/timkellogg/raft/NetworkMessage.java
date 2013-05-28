package me.timkellogg.raft;

import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tim
 * Date: 5/26/13
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class NetworkMessage {
    private final byte[] message;
    private final UUID messageId = UUID.randomUUID();

    public NetworkMessage(byte[] message) {

        byte[] encodedMessage = new byte[message.length + 16];
        System.arraycopy(getBytes(messageId), 0, encodedMessage, 0, 16);
        System.arraycopy(message, 0, encodedMessage, 16, message.length);
        this.message = encodedMessage;
    }

    private static byte[] getBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    public byte[] getMessage() {
        return message;
    }

    public UUID getMessageId() {
        return messageId;
    }

    public static UUID parseMessageId(byte[] buffer) {
        ByteBuffer bb = ByteBuffer.wrap(buffer);
        LongBuffer longs = bb.asLongBuffer();
        return new UUID(longs.get(), longs.get());
    }
}
