package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DataStructureTest.class, StacksAndQueuesTest.class,
		StringTests.class, ListsAndArraysTest.class, RecursionTests.class, SortingTests.class })
public class AllTests {

}
