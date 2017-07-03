package de.csdev.ebus.cfg.datatypes;

import java.util.Map;

public class EBusTypeString extends EBusTypeGeneric {

    public static String STRING = "string";

    private static String[] supportedTypes = new String[] { STRING };

    private Integer length = 1;

    public String[] getSupportedTypes() {
        return supportedTypes;
    }

    @SuppressWarnings("unchecked")
    public <T> T decode(byte[] data) {
        return (T) new String(data);
    }

    public byte[] encode(Object data) {

        byte[] b = new byte[length];
        System.arraycopy(data.toString().getBytes(), 0, b, 0, b.length);

        return b;
    }

    @Override
    public int getTypeLenght() {
        return length;
    }

    @Override
    public IEBusType getInstance(Map<String, Object> properties) {

        if (properties.containsKey("length")) {
            EBusTypeString x = new EBusTypeString();
            x.types = this.types;
            x.length = (Integer) properties.get("length");
            return x;
        }

        return this;
    }
}
