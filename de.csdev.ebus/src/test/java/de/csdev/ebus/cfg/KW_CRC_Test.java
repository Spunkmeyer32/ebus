package de.csdev.ebus.cfg;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.csdev.ebus.cfg.datatypes.EBusTypeException;
import de.csdev.ebus.cfg.datatypes.EBusTypes;
import de.csdev.ebus.command.EBusCommandRegistry;
import de.csdev.ebus.command.EBusCommandUtils;
import de.csdev.ebus.command.IEBusCommandMethod;
import de.csdev.ebus.utils.EBusUtils;

public class KW_CRC_Test {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(KW_CRC_Test.class);

    EBusTypes types;
    EBusCommandRegistry commandRegistry;

    @Before
    public void before() throws IOException, ConfigurationReaderException {

        types = new EBusTypes();

        InputStream inputStream = ConfigurationReader.class
                .getResourceAsStream("/commands/wolf-cgb2-configuration.json");

        if (inputStream == null) {
            throw new RuntimeException("Unable to load json file ...");
        }

        ConfigurationReader cfg = new ConfigurationReader();
        cfg.setEBusTypes(types);

        commandRegistry = new EBusCommandRegistry();
        commandRegistry.addTelegramConfigurationList(cfg.loadConfiguration(inputStream));
    }

    @Test
    public void xxx() throws EBusTypeException {
        IEBusCommandMethod commandChannel = commandRegistry.getConfigurationById("heating.program_heating_circuit",
                IEBusCommandMethod.Method.GET);
        ByteBuffer buffer = EBusCommandUtils.buildMasterTelegram(commandChannel, (byte) 0x00, (byte) 0x0FF, null);

        System.out.println(EBusUtils.toHexDumpString(buffer).toString());
    }
}
