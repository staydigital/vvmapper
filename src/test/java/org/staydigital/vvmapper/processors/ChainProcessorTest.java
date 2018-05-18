package org.staydigital.vvmapper.processors;

import org.junit.Assert;
import org.junit.Test;

import static helper.Processors.*;
import static org.staydigital.vvmapper.processors.ChainProcessor.chain;

public class ChainProcessorTest {

    @Test
    public void multipleProcessorCanBeChained() {
        Processor<Integer, String> chainProcessor = chain(
                getDivide2Processor(),
                chain(getMultiply10Processor(), getConvertProcessor()));
        Assert.assertEquals((Integer) 615, chainProcessor.process("123"));
    }
}
