package br.com.climb.commons.url;

import br.com.climb.commons.annotations.param.PathVariable;
import br.com.climb.commons.reqrespmodel.Request;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;
import java.util.Set;
import java.util.stream.LongStream;

import static br.com.climb.commons.url.Methods.isReservedWord;
import static br.com.climb.commons.utils.ReflectionUtils.*;

public class NormalizedUrlManager implements NormalizedUrl {

    @Override
    public String getNormalizedUrl(String value, Method method) {

        final Parameter[] parameters = method.getParameters();

        for (Parameter parameter : parameters) {

            PathVariable pathVariable = parameter.getAnnotation(PathVariable.class);

            if (pathVariable == null) {
                continue;
            }

            value = value.replace( "{" +pathVariable.value() + "}", getTypeClimbString(parameter.getType()));
        }

        return value;
    }

    @Override
    public String getNormalizedUrl(Request request) {

        final String[] arrUrl = request.getPathInfo().split("/");

        final StringBuilder builder = new StringBuilder();
        builder.append("/");

        LongStream.range(1, arrUrl.length).forEach(index -> {
            final String word = arrUrl[(int) index].trim();
            if (isReservedWord(word, index)) {
                builder.append(word+"/");
            } else
            if (isNumeric(word)) {
                builder.append(CLIMB_TYPE_NUMBER + "/");
            } else
            if (word.equals("true") || word.equals("false")) {
                builder.append(JAVA_TYPE_BOOLEAN+"/");
            } else {
                builder.append(JAVA_TYPE_STRING+"/");
            }
        });

        return builder.toString();

    }

    @Override
    public String getNormalizedUrl(Request request, Map<String, Set<Long>> reservedWords) {

        final String[] arrUrl = request.getPathInfo().split("/");

        final StringBuilder builder = new StringBuilder();
        builder.append("/");

        LongStream.range(1, arrUrl.length).forEach(index -> {
            final String word = arrUrl[(int) index].trim();
            if (isLocalReservedWord(word, index, reservedWords)) {
                builder.append(word+"/");
            } else
            if (isNumeric(word)) {
                builder.append(CLIMB_TYPE_NUMBER + "/");
            } else
            if (word.equals("true") || word.equals("false")) {
                builder.append(JAVA_TYPE_BOOLEAN+"/");
            } else {
                builder.append(JAVA_TYPE_STRING+"/");
            }
        });

        return builder.toString();

    }

    @Override
    public boolean isLocalReservedWord(String key, Long position, Map<String, Set<Long>> reservedWords) {

        Set<Long> positions = reservedWords.get(key);

        if (positions != null) {
            for (Long pos : positions) {
                if (pos.equals(position)) {
                    return true;
                }
            }
        }
        return false;
    }

}
