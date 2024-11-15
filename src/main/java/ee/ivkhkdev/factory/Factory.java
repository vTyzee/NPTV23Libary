package ee.ivkhkdev.factory;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    private static Factory instance = null;
    private static Map<String, Object> map = new HashMap<>();

    private Factory() {
    }

    public static Factory getInstance(Configuration configuration) {
        if (instance == null) {
            Factory.instance = new Factory();
        }
        return Factory.instance;
    }

    public static Object getObject(String name) {
        try {
            return map.get(name);
        } catch (Exception e) {
            return null;
        }
    }
}
