package com.mercateo.demo.feature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;

import org.junit.Test;

import com.mercateo.common.rest.schemagen.link.CallScope;

public class SimpleFeatureChecker0Test {

	private Object nullField;

	private SimpleFeatureChecker uut = new SimpleFeatureChecker();

	@Test
	public void testHasFeature_for_null() throws Exception {

		assertTrue(uut.hasFeature((Feature) null));
		assertTrue(uut.hasFeature(this.getClass().getDeclaredField("nullField")));
		CallScope callScope = new CallScope(this.getClass(), this.getClass().getMethod("testHasFeature_for_null"),
				new Object[0], null);
		assertTrue(uut.hasFeature(callScope));
	}

	@Test
	public void testHasFeature_for_knownFeatures() throws Exception {
		for (KnownFeatureId knownFeatureId : KnownFeatureId.values()) {
			assertEquals("for " + knownFeatureId.name(), SimpleFeatureChecker.featureStore.get(knownFeatureId),
					uut.hasFeature(new Feature() {

						@Override
						public Class<? extends Annotation> annotationType() {
							return Feature.class;
						}

						@Override
						public KnownFeatureId value() {
							return knownFeatureId;
						}
					}));
		}
	}

}
