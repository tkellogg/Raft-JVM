package me.timkellogg.raft;

/**
 * Created with IntelliJ IDEA.
 * User: tim
 * Date: 5/26/13
 * Time: 9:29 AM
 * To change this template use File | Settings | File Templates.
 */
public interface NetworkResponseHandler {
    public void handle(byte[] message);
}
