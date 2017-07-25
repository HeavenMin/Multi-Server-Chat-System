package myServer2;

/*
 * AUTHOR : Min Gao
 * Project1-Multi-Server Chat System
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {

	BlockingQueue<ClientMessage> messageQueue;
	private static MessageQueue instance;

	private MessageQueue() {
		messageQueue = new LinkedBlockingQueue<>();
	}

	public static MessageQueue getInstance() {
		if (instance == null) {
			instance = new MessageQueue();
		}
		return instance;
	}

	public void add(ClientMessage msg) {
		messageQueue.add(msg);
	}

	public ClientMessage take() throws InterruptedException {
		return messageQueue.take();
	}

}
