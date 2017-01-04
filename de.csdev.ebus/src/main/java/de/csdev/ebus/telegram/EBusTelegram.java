/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package de.csdev.ebus.telegram;

import java.nio.ByteBuffer;

import de.csdev.ebus.utils.EBusUtils;

/**
 * Represent a valid ebus telegram structure.
 * 
 * @author Christian Sowada
 */
public class EBusTelegram {

    /** The SYN byte */
    public final static byte SYN = (byte) 0xAA;

    /** The ACK OK answer byte */
    public final static byte ACK_OK = (byte) 0x00;

    /** The ACK FAIL answer byte */
    public final static byte ACK_FAIL = (byte) 0xFF;

    /** The Broadcast address */
    public final static byte BROADCAST_ADDRESS = (byte) 0xFE;

    public enum TYPE {
    	
    	/** Telegram type broadcast */
    	BROADCAST,
    	
    	/** Telegram type Master-Slave */
    	MASTER_SLAVE,
    	
    	/** Telegram type Master-Master */
    	MASTER_MASTER
    }

    /** internal raw data */
    private ByteBuffer data;

    /**
     * Constructor
     * 
     * @param data An eBus telegram as ByteBuffer
     */
    public EBusTelegram(ByteBuffer data) {
        this.data = data;
    }

    /**
     * Constructor
     * 
     * @param data An eBus telegram as byte array
     */
    public EBusTelegram(byte[] data) {
        this.data = ByteBuffer.wrap(data);
    }

    /**
     * Get source id
     * 
     * @return
     */
    public byte getSource() {
        return data.get(0);
    }

    /**
     * Get destionation id
     * 
     * @return
     */
    public byte getDestination() {
        return data.get(1);
    }

    /**
     * Get command
     * 
     * @return
     */
    public byte[] getCommand() {
    	byte[] buffer = new byte[2];
    	System.out.println("EBusTelegram.getCommand() > " + EBusUtils.toHexDumpString(data));
    	data.position(2);
    	data.get(buffer);
        return buffer;
    }

    /**
     * Get the master data len
     * 
     * @return
     */
    public int getDataLen() {
        return data.get(4);
    }

    /**
     * Get master crc
     * 
     * @return
     */
    public byte getCRC() {
        return data.get(getDataLen() + 5);
    }

    /**
     * Get the telegram type
     * 
     * @return
     * @see EBusTelegramConfiguration.BROADCAST
     * @see EBusTelegramConfiguration.MASTER_SLAVE
     * @see EBusTelegramConfiguration.MASTER_MASTER
     */
    public TYPE getType() {
        int pos = getDataLen() + 6;
        byte b = data.get(pos);
        if (b == SYN) {
            return TYPE.BROADCAST;
        } else if (b == ACK_OK && data.get(pos + 1) == SYN) {
            return TYPE.MASTER_MASTER;
        }

        return TYPE.MASTER_SLAVE;
    }

    /**
     * Get master data as read only ByteBuffer
     * 
     * @return
     */
    public ByteBuffer getBuffer() {
        return data.asReadOnlyBuffer();
    }

    /**
     * Get master data as byte array
     * 
     * @return
     */
    public byte[] getData() {
        int l = getDataLen();
        byte[] buffer = new byte[l];
        data.position(5);
        data.get(buffer);

        return buffer;
    }

    /**
     * Get slave data len
     * 
     * @return
     */
    public int getSlaveDataLen() {
        if (getType() == TYPE.MASTER_SLAVE) {
            return data.get(getDataLen() + 7);
        }
        return -1;
    }

    /**
     * Get slave crc
     * 
     * @return
     */
    public int getSlaveCRC() {
        if (getType() == TYPE.MASTER_SLAVE) {
            return data.get(data.position() - 3);
        }
        return -1;
    }

    /**
     * Get slave data byte array
     * 
     * @return
     */
    public byte[] getSlaveData() {
        int l = getSlaveDataLen();

        if (l == -1) {
            return new byte[0];
        }

        byte[] buffer = new byte[l];
        data.position(getDataLen() + 8);
        data.get(buffer);
        
        return buffer;
    }
    
//    public ByteBuffer asExpandedByteBuffer() {
//    	
//    	ByteBuffer buffer = ByteBuffer.allocate(40);
//
//    	buffer.put(getSource());
//    	buffer.put(getDestination());
//    	buffer.put(getCommand());
//    	buffer.put((byte) getDataLen());
//
//    	if(getDataLen() > 0) {
//    		byte[] masterData = getData();
//    		buffer.put(EBusUtils.encodeEBusData(masterData));
//    	}
//    	
//    	buffer.put(EBusUtils.encodeEBusData(getCRC()));
//    	
//
//    	return  buffer;
//    }
}
