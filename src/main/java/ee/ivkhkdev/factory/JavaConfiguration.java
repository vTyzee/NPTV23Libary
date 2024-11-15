package ee.ivkhkdev.factory;


import java.util.HashMap;
import java.util.Map;

public class JavaConfiguration implements Configuration {
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Map<String, Object> getMap() {
        return Map.of();
    }
}
