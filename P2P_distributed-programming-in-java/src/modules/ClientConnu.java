package modules;

/**
 * This class is used to store the knowed list
 */
public class ClientConnu {
    public String host;
    public String port;

    public ClientConnu() {
    }

    public ClientConnu(String host, String port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    /**
     * this method convert the toString method to show a designed format of the knowed list
     */
    @Override
    public String toString() {
        return host + ":" + port;
    }
    
    
}
