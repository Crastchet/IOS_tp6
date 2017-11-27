package ios.client.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HelloCoteClient {

	private String string;
	
	
	public HelloCoteClient() {}
	
	public HelloCoteClient(String string) {
		this.string = string;
	}
	
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	@Override
	public String toString() {
		return this.string;
	}
}
