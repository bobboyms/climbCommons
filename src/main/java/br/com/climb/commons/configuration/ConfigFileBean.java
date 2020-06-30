package br.com.climb.commons.configuration;

public abstract class ConfigFileBean {

    private String packge;
    private String securityUrl;
    private String gatewayIp;
    private String gatewayPort;
    private String localIp;
    private String localPort;

    public void setGatewayIp(String gatewayIp) {
        this.gatewayIp = gatewayIp;
    }

    public void setGatewayPort(String gatewayPort) {
        this.gatewayPort = gatewayPort;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public void setLocalPort(String localPort) {
        this.localPort = localPort;
    }

    public String getGatewayIp() {
        return gatewayIp;
    }

    public String getGatewayPort() {
        return gatewayPort;
    }

    public String getLocalIp() {
        return localIp;
    }

    public String getLocalPort() {
        return localPort;
    }

    public String getPackage(){
        return packge;
    }

    public void setPackge(String packge) {
        this.packge = packge;
    }

    public String getSecurityUrl() {
        return securityUrl;
    }

    public void setSecurityUrl(String securityUrl) {
        this.securityUrl = securityUrl;
    }
}
