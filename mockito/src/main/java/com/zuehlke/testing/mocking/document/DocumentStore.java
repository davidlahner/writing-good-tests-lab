package com.zuehlke.testing.mocking.document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentStore {

	private Map<String, byte[]> documents = new HashMap<>();
	private List<StoreListener> listeners = new ArrayList<>();

	public void addDocument(String name, byte[] content) {
		documents.put(name, content);
		listeners.forEach(listener -> notifyListener(listener, name, content.length));

	}

	private void notifyListener(StoreListener listener, String name, int bytes) {
		listener.documentAdded(name);
		if (listener.shouldSumSizes()) {
			listener.bytesAdded(bytes);
		}
	}

	public boolean isEmpty() {
		return documents.isEmpty();
	}

	public void addListener(StoreListener listener) {
		listeners.add(listener);
	}
}
