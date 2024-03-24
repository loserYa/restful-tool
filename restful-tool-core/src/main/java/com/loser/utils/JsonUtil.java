package com.loser.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.TypeReference;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

    private static final Map<String, Field> FIELD_MAP = new HashMap<>();

    static {
        try {
            Field resolveTasks = JSONReader.class.getDeclaredField("resolveTasks");
            resolveTasks.setAccessible(true);
            Field ch = JSONReader.class.getDeclaredField("ch");
            ch.setAccessible(true);
            FIELD_MAP.put("resolveTasks", resolveTasks);
            FIELD_MAP.put("ch", ch);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private JsonUtil() {
    }

    /**
     * modify by
     * 替换 TypeReference 为 type
     *
     * @see JSON#parseObject(String, TypeReference, JSONReader.Feature...)
     */
    public static <T> T parse(String text, Type type, JSONReader.Feature... features) throws Throwable {

        if (text == null || text.isEmpty()) {
            return null;
        }
        JSONReader reader = JSONReader.of(text);
        T res;
        try {
            JSONReader.Context context = reader.getContext();
            context.config(features);
            boolean fieldBased = (context.getFeatures() & JSONReader.Feature.FieldBased.mask) != 0L;
            ObjectReaderProvider provider = context.getProvider();
            ObjectReader<T> objectReader = provider.getObjectReader(type, fieldBased);
            T object = objectReader.readObject(reader, type, null, 0L);
            Field declaredField = FIELD_MAP.get("resolveTasks");
            if (declaredField.get(reader) != null) {
                reader.handleResolveTasks(object);
            }
            Field ch = FIELD_MAP.get("ch");
            if ((char) ch.get(reader) != 26 && ((context.getFeatures() & JSONReader.Feature.IgnoreCheckClose.mask) == 0L)) {
                throw new JSONException(reader.info("input not end"));
            }
            res = object;
        } catch (Throwable e) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Throwable throwable) {
                    throw new RuntimeException(throwable);
                }
            }
            throw e;
        }
        reader.close();
        return res;

    }

}
