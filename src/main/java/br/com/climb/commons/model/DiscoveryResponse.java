package br.com.climb.commons.model;

import java.io.Serializable;

public interface DiscoveryResponse extends Serializable {

    static final int OK = 200;

    Integer getStatusCode();

}
