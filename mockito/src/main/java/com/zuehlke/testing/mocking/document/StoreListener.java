package com.zuehlke.testing.mocking.document;

public interface StoreListener {

	boolean shouldSumSizes();

	void documentAdded(String name);

	void bytesAdded(int bytes);

}
