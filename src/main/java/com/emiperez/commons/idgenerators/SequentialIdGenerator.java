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

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p> A thread safe {@linkplain IdGenerator} based on {@linkplain AtomicInteger}.
 * 
 * <p> This IdGenerator does not persist its value so it will begin with 1
 * every time an application starts.
 */

public class SequentialIdGenerator implements IdGenerator<Integer> {

	private AtomicInteger id = new AtomicInteger();

	public Integer getId() {
		return id.incrementAndGet();
	}
}
