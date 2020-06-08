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

package com.emiperez.commons.idgenerators.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.emiperez.commons.idgenerators.ConstantIdGenerator;
import com.emiperez.commons.idgenerators.IdGenerator;

class ConstantIdGeneratorTest {

	@Test
	void getIdTest() {
		IdGenerator<String> idGenerator = new ConstantIdGenerator<String>("idGenerator");
		assertEquals("idGenerator", idGenerator.getId());
	}

}
