package br.com.climb.commons.model;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DiscoveryRequestObject implements DiscoveryRequest {

    private String ipAddress;
    private String port;
    private Map<String, Set<Long>> reservedWords;

    private Map<String, Set<String>> urls;

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setUrls(Map<String, Set<String>> urls) {
        this.urls = urls;
    }

    public void setReservedWords(Map<String, Set<Long>> reservedWords) {
        this.reservedWords = reservedWords;
    }

    @Override
    public Map<String, Set<Long>> getReservedWords() {
        return reservedWords;
    }

    @Override
    public Map<String, Set<String>> getUrls() {
        return urls;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String getPort() {
        return port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscoveryRequestObject object = (DiscoveryRequestObject) o;
        return Objects.equals(ipAddress, object.ipAddress) &&
                Objects.equals(port, object.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, port);
    }

    @Override
    public String toString() {
        return "DiscoveryRequestObject{" +
                "ipAddress='" + ipAddress + '\'' +
                ", port='" + port + '\'' +
                ", reservedWords=" + reservedWords +
                ", urls=" + urls +
                '}';
    }
}
