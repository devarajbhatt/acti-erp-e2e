package com.acti.erp.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)

/**
 * This will Set the test script creator name as QA
 */
public @interface TestCase {
	String Author() default "QA";

} // will be retained at runtime
