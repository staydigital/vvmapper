package helper;

import org.staydigital.vvmapper.processors.Processor;
import org.staydigital.vvmapper.processors.SingleProcessor;
import org.staydigital.vvmapper.processors.VVProcessor;

public class Processors {

    public static VVProcessor<Integer, String> getConvertProcessor() {
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

    public static Processor<Integer, Integer> getMultiply10Processor() {
        return new SingleProcessor<Integer, Integer>() {
            @Override
            public Integer transform(Integer candidate) {
                return candidate * 10;
            }
        };
    }

    public static Processor<Integer, Integer> getDivide2Processor() {
        return new SingleProcessor<Integer, Integer>() {
            @Override
            public Integer transform(Integer candidate) {
                return candidate / 2;
            }
        };
    }
}
