package ios.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class HelloWorldClient {

	private WebResource service;
	
	
	public HelloWorldClient() {
		Client client = Client.create(new DefaultClientConfig());
		this.service = client.resource("http://localhost:8080/jersey-helloworld-server/webresources/myresource");
	}
	
	
	public HelloCoteClient callHello() {
		return this.service.path("/hello").accept(MediaType.APPLICATION_JSON).get(HelloCoteClient.class);
		//indique le chemin supplémentaire à ajouter à l'URL où se trouve le service pour appeler une méthode donnée
		//indique qu'on attendend en retour de l'appel du JSON
	}
	
	public HelloCoteClient callsSayHello() {
		return this.service.path("/sayhello").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(HelloCoteClient.class);
		//indique le chemin supplémentaire à ajouter à l'URL où se trouve le service pour appeler une méthode donnée
		//indique qu'on attendend en retour de l'appel du JSON	
		//indique qu'on envoie les parametres au format JSON
	}
	
	
	public static void main(String[] args) {
		HelloWorldClient clientHelloWorld = new HelloWorldClient();
		System.out.println(clientHelloWorld.callHello());
		//System.out.println(clientHelloWorld.callsSayHello());
	}
}
