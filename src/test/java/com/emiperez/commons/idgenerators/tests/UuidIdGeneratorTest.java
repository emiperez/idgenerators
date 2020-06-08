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
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.emiperez.commons.idgenerators.IdGenerator;
import com.emiperez.commons.idgenerators.UuidIdGenerator;

class UuidIdGeneratorTest {

	@Test
	void testGetId() {
		IdGenerator<UUID> idGenerator = new UuidIdGenerator();
		UUID id = idGenerator.getId();

		assertEquals(id, UUID.fromString(id.toString())); // this checks that a correct UUID has been generated

		assertNotEquals(id, idGenerator.getId()); // this checks that the same id has not been generated twice
	}

}
