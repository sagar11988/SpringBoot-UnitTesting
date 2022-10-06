package com.sds.unitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ HelloControllerTest.class, ProductControllerTest.class, ProductServiceTest.class })
public class ProductServiceSuite {

}
