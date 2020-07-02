package br.com.climb.commons.configuration;

public interface ConfigFile {

    String getPackage();
    String getSecurityUrl();
    String getGatewayIp();
    String getGatewayPort();
    String getLocalIp();
    String getLocalPort();
    String getMessageIp();
    String getMessagePort();

}
