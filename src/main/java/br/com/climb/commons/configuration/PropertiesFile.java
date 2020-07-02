package br.com.climb.commons.configuration;

import br.com.climb.commons.execptions.ConfigFileException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile extends ConfigFileBean implements ConfigFile {

    protected InputStream getInputStream(final String fileName) throws ConfigFileException {

        InputStream inputStream = PropertiesFile.class.getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new ConfigFileException("configuration file not found in resource");
        }

        return inputStream;
    }

    protected Properties loadProperties(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

    protected void generateConfigData(Properties properties) {
        super.setPackge(properties.getProperty("framework.package.url"));
        super.setSecurityUrl(properties.getProperty("framework.security.url"));
        super.setGatewayIp(properties.getProperty("framework.gateway.ip"));
        super.setGatewayPort(properties.getProperty("framework.gateway.port"));
        super.setLocalIp(properties.getProperty("framework.local.ip"));
        super.setLocalPort(properties.getProperty("framework.local.port"));
        super.setMessageIp(properties.getProperty("framework.message.ip"));
        super.setMessagePort(properties.getProperty("framework.message.port"));
    }

    public PropertiesFile(String fileName) throws ConfigFileException, IOException {
        generateConfigData(loadProperties(getInputStream(fileName)));
    }
}