package org.staydigital.vvmapper.processors;

public abstract class SingleProcessor<D, S> implements Processor<D, S> {

    public abstract D transform(final S candidate);

    public D process(final S candidate) {
        return transform(candidate);
    }


}
