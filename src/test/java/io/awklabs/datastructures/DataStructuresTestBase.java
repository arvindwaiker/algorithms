package io.awklabs.datastructures;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public abstract class DataStructuresTestBase {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    protected Integer[] data;

    @Before
    public void before() {
        data = new Integer[]{5, 6, 7, 1, 2, 8, 3, 10, 4, 9};
    }
}
