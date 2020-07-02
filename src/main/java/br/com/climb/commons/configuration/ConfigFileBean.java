package br.com.climb.commons.configuration;

public abstract class ConfigFileBean {

    private String packge;
    private String securityUrl;
    private String gatewayIp;
    private String gatewayPort;
    private String localIp;
    private String localPort;
    private String messageIp;
    private String messagePort;


//    framework.message.ip=127.0.0.1
//    framework.message.port=8585


    public void setMessageIp(String messageIp) {
        this.messageIp = messageIp;
    }

    public void setMessagePort(String messagePort) {
        this.messagePort = messagePort;
    }

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

    public String getMessageIp() {
        return messageIp;
    }

    public String getMessagePort() {
        return messagePort;
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
