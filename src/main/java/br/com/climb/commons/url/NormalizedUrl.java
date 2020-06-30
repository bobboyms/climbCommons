package br.com.climb.commons.url;

import br.com.climb.commons.reqrespmodel.Request;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

public interface NormalizedUrl {
    String getNormalizedUrl(String value, Method method);

//    boolean isReservedWord(String key, Long position, Map<String, Set<Long>> reservedWords);

    String getNormalizedUrl(Request request, Map<String, Set<Long>> reservedWords);

    boolean isLocalReservedWord(String key, Long position, Map<String, Set<Long>> reservedWords);

    String getNormalizedUrl(Request request);
}
