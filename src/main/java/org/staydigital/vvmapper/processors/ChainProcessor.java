package org.staydigital.vvmapper.processors;

public class ChainProcessor<D, S> implements Processor<D, S> {

    private Processor secondProcessor;
    private Processor firstProcessor;

    public static ChainProcessor chain(final Processor secondProcessor, final Processor firstProcessor) {
        return new ChainProcessor(secondProcessor, firstProcessor);
    }

    public ChainProcessor(final Processor secondProcessor, final Processor firstProcessor) {
        this.firstProcessor = firstProcessor;
        this.secondProcessor = secondProcessor;
    }

    @Override
    public D process(S input) {
        return (D) secondProcessor.process(firstProcessor.process(input));
    }
}
