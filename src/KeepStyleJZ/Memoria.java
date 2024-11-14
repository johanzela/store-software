package KeepStyleJZ;

import java.util.HashMap;
import java.util.Map;

public class Memoria {
    //String - ADMIN
    //Object - "JOHAN"
    private static Map<String, Object> datos;

    static {
        datos = new HashMap<>();
    }

    private Memoria() {
    }

    public static Object get(String key) {
        return datos.get(key);
    }

    public static void put(String key, Object value) {
        datos.put(key, value);
    }
}
