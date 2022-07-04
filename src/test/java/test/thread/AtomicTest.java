package com.cr.util.thread;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AtomicTest {

    @Test
    public void test() {
        AtomicInteger i = new AtomicInteger();
        i.set(11);
        i.decrementAndGet();
    }
}
