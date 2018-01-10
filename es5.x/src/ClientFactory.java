
import java.net.InetAddress;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
//连接es
public class ClientFactory {

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
						 System.out.println("es succeed");


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

	private Client client;
}