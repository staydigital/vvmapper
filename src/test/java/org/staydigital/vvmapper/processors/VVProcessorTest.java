package org.staydigital.vvmapper.processors;

import org.junit.Assert;
import org.junit.Test;

import static helper.Processors.getConvertProcessor;

public class VVProcessorTest {

    @Test
    public void shouldMapFromStringToIntegerAndVV() {
        Assert.assertEquals((Integer) 123, getConvertProcessor().process("123"));
        Assert.assertEquals("123", (getConvertProcessor().processBack(123)));
    }
}
