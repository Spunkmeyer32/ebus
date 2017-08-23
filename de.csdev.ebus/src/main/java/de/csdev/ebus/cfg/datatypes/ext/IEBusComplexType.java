/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package de.csdev.ebus.cfg.datatypes.ext;

import de.csdev.ebus.cfg.datatypes.EBusTypeException;

/**
 * @author Christian Sowada - Initial contribution
 *
 */
public interface IEBusComplexType {

    public <T> T decodeComplex(byte[] rawData, int pos) throws EBusTypeException;

    public byte[] encodeComplex(Object data) throws EBusTypeException;
}
