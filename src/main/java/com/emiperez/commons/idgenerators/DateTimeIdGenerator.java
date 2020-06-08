/*
 * Copyright (c) 2020 Emilio Perez. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code)
 */

package com.emiperez.commons.idgenerators;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * This {@linkplain IdGenerator} returns a String build by the Date and Time
 * and, if there already was another id at the same time, a sequential number
 * appended.
 * 
 * <p>
 * Example: {@code "2020-06-08T04:25:59-1"}
 */
public class DateTimeIdGenerator implements IdGenerator<String> {

	private static final int INITIAL_COUNTER = 1;
	private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss");
	
	private AtomicInteger count = new AtomicInteger(INITIAL_COUNTER);
	private String currentDateTime = null;

	public String getId() {
		String newDateTime = LocalDateTime.now().format(format);

		if (currentDateTime == null) {
			currentDateTime = newDateTime;
			return newDateTime;
		}

		if (currentDateTime.equals(newDateTime)) {
			return newDateTime + "-" + count.getAndIncrement();
		} else {
			count.set(INITIAL_COUNTER);
			currentDateTime = newDateTime;
		}
		return newDateTime;
	}

}
