package ios.server;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hello {

	private String string;
	
	public Hello() {}
	
	public Hello(String string) {
		this.string = string;
	}

	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
}
