package de.csdev.ebus.cfg.datatypes;

import java.math.BigDecimal;

import de.csdev.ebus.utils.NumberUtils;

public class EBusTypeBCD extends EBusTypeGeneric {

    public static String BCD = "bcd";

    private static String[] supportedTypes = new String[] { BCD };

    public String[] getSupportedTypes() {
        return supportedTypes;
    }

    @SuppressWarnings("unchecked")
    public <T> T decode(byte[] data) {
        return (T) BigDecimal.valueOf((byte) ((data[0] >> 4) * 10 + (data[0] & (byte) 0x0F)));
    }

    public byte[] encode(Object data) {
        BigDecimal b = NumberUtils.toBigDecimal(data);
        return new byte[] { (byte) (((b.intValue() / 10) << 4) | b.intValue() % 10) };
    }

}
