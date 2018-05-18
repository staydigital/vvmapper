import org.junit.Assert;
import org.junit.Test;
import org.staydigital.vvmapper.processors.ChainProcessor;
import org.staydigital.vvmapper.processors.Processor;
import org.staydigital.vvmapper.processors.SingleProcessor;
import org.staydigital.vvmapper.processors.VVProcessor;

public class PlaygroundTest {

    private static VVProcessor<Integer, String> getConvertProcessor() {
        return new VVProcessor<Integer, String>() {
            @Override
            public Integer transform(String candidate) {
                return new Integer(candidate);
            }

            @Override
            public String transformBack(Integer candidate) {
                return candidate.toString();
            }
        };
    }

    private static Processor<Integer, Integer> getMultiply10Processor() {
        return new SingleProcessor<Integer, Integer>() {
            @Override
            public Integer transform(Integer candidate) {
                return candidate * 10;
            }
        };
    }

    private static Processor<Integer, Integer> getDivide2Processor() {
        return new SingleProcessor<Integer, Integer>() {
            @Override
            public Integer transform(Integer candidate) {
                return candidate / 2;
            }
        };
    }

    @Test
    public void shouldMapFromStringToIntegerAndVV() {
        VVProcessor<Integer, String> processor = getConvertProcessor();
        Assert.assertEquals((Integer) 123, processor.process("123"));

        Assert.assertEquals("123", (processor.processBack(123)));
    }

    @Test
    public void multipleProcessorCanBeChained() {
        Processor<Integer, String> chainProcessor = new ChainProcessor<>(
                getDivide2Processor(),
                new ChainProcessor<>(getMultiply10Processor(), getConvertProcessor()));
        Assert.assertEquals((Integer) 615, chainProcessor.process("123"));
    }
}
