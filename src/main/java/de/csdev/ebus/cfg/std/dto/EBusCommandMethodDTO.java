/**
 * Copyright (c) 2016-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package de.csdev.ebus.cfg.std.dto;

import java.util.List;

/**
 * @author Christian Sowada - Initial contribution
 *
 */
public class EBusCommandMethodDTO {

    private String command;

    private List<EBusValueDTO> master;

    private List<EBusValueDTO> slave;

    private String type;

    public String getCommand() {
        return command;
    }

    public List<EBusValueDTO> getMaster() {
        return master;
    }

    public List<EBusValueDTO> getSlave() {
        return slave;
    }

    public String getType() {
        return type;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setMaster(List<EBusValueDTO> master) {
        this.master = master;
    }

    public void setSlave(List<EBusValueDTO> slave) {
        this.slave = slave;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "EBusCommandMethodDTO [" + (command != null ? "command=" + command + ", " : "")
                + (master != null ? "master=" + master + ", " : "") + (slave != null ? "slave=" + slave + ", " : "")
                + (type != null ? "type=" + type : "") + "]";
    }

}
