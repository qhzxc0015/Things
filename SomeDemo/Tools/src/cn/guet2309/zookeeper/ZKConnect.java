package cn.guet2309.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZKConnect {
	private CountDownLatch latch = new CountDownLatch(1);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZooKeeper zk = new ZKConnect().connectZooKeeperServer();

	}

	public ZooKeeper connectZooKeeperServer(){
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper("202.193.59.200:2181", 5000,new Watcher() {
				@Override
				public void process(WatchedEvent event) {
					if (event.getState() == Event.KeeperState.SyncConnected) {
			            latch.countDown(); // 唤醒当前正在执行的线程
			        }
				}
			});
			latch.await(); // 使当前线程处于等待状态
		} catch (IOException | InterruptedException e) {
			//LOGGER.error("", e);
			e.printStackTrace();
		}
		return zk;
	}
}
