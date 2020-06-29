package br.com.climb.commons.reqrespmodel;

import java.io.Serializable;

public interface Response extends Serializable {

    byte[] getBody();
    Integer getStatus();
    String getCharacterEncoding();
    String getContentType();

}
