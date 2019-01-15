package com.zuehlke.testing.coverage.example;

import java.time.LocalTime;

/**
 * We have a Shop that is open every day from 9:00 to 19:00.
 * 
 * However, if you are a VIP, then the store is always open.
 *
 */
public class CoverageExampleFromSlide {

	public boolean isShopOpen(LocalTime localTime, boolean vip) {
		boolean open = false;
		if (isOpen(localTime) || vip) {
			open = true;
		}
		return open;
	}

	private boolean isOpen(LocalTime localTime) {
		return localTime.getHour() >= 9 && localTime.getHour() <= 18;
	}

}
