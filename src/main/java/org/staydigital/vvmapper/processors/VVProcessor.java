package org.staydigital.vvmapper.processors;

public abstract class VVProcessor<D, S> extends SingleProcessor<D, S> {

    public S transformBack(final D candidate) {
        return null;
    }

    public S processBack(final D candidate) {
        return transformBack(candidate);
    }

}
