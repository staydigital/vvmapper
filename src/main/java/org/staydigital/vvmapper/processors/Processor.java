package org.staydigital.vvmapper.processors;

public interface Processor<D, S> {
    D process(final S input);
}
