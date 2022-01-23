package com.github.marshalcn.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface TripleFunction<O, T, U, R>{

    /**
     * Applies this function to the given arguments.
     *
     * @param o the first function argument
     * @param t the second function argument
     * @param u the third function argument
     * @return the function result
     */
    R apply(O o, T t, U u);

    default <V> TripleFunction<O, T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (O o, T t, U u) -> after.apply(apply(o, t, u));
    }
}
