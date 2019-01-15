package com.zuehlke.testing.junit5.examples.mixingversions;

import org.junit.Assert;

public class VintageTestsDemo {


    @org.junit.Test
    public void junit4Test() {
        Assert.assertEquals(2, 1+1);
    }
}
