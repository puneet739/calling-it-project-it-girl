/**
 * 
 */
package com.fairdeal.core.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.fairdeal.core.test.regressiontests.*;

/**
 * @author puneetb
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	AgentFactoryTest.class,
	HibernateUtilTest.class,
	
})
public class FDTestSuite {
}
