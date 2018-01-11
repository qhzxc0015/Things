
import java.net.InetAddress;
import java.util.List;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
//连接es
public class ClientFactory {
    private TransportClient client;
//private Client client;
	public Client getClient() {
		if (client == null) {
			synchronized (ClientFactory.class) {
				if (client == null) {
					Settings settings = Settings.builder()
							.put("cluster.name", "my-application").build();
					try {
						TransportClient client = new PreBuiltTransportClient(settings)
						.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("202.193.74.70"),9300))
						//.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.1.3"),9300))
//								.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("202.193.74.204"),9300))
//								.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("202.193.74.39"),9300))
								;
						this.client = client;
//						 System.out.println("es succeed");
						   /**
					     * 查看集群信息
					     */
						 List<DiscoveryNode> nodes = client.connectedNodes();
					        for (DiscoveryNode node : nodes) {
					        	 System.out.println("节点信息："+node.getHostAddress());
					        }
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("es failed");
					}
				}
				return client;
			}
		} else
			return client;
	}	
}