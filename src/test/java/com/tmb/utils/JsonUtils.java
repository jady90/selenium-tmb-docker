package com.tmb.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmb.tests.vendorportal.modal.VendorPortalTestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {

    private static Logger log = LoggerFactory.getLogger(JsonUtils.class);
    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T getTestData(String path, Class<T> type){
        try(InputStream stream = ResourceLoader.getResource(path)) {
            return mapper.readValue(stream, type);
        } catch (IOException e) {
            log.error("unable to read test data {}", path, e);
        }
        return null;
    }

}
