package de.csdev.ebus.cfg.datatypes;

import java.math.BigDecimal;

import de.csdev.ebus.utils.NumberUtils;

public class EBusTypeKWCrc extends EBusTypeGeneric {

    public static String KW_CRC = "kw-crc";

    private static String[] supportedTypes = new String[] { KW_CRC };

    @Override
    public String[] getSupportedTypes() {
        return supportedTypes;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T decode(byte[] data) {
        return (T) BigDecimal.valueOf(data[0] & 0xFF);
    }

    @Override
    public byte[] encode(Object data) {
        BigDecimal b = NumberUtils.toBigDecimal(data);

        if (b == null) {
            return new byte[] { 0x00 };
        }

        return new byte[] { (byte) b.intValue() };
    }

}
