package org.staydigital.vvmapper.processors;

import org.junit.Assert;
import org.junit.Test;

import static helper.Processors.*;

public class ChainProcessorTest {

    @Test
    public void multipleProcessorCanBeChained() {
        Processor<Integer, String> chainProcessor = new ChainProcessor<>(
                getDivide2Processor(),
                new ChainProcessor<>(getMultiply10Processor(), getConvertProcessor()));
        Assert.assertEquals((Integer) 615, chainProcessor.process("123"));
    }
}
