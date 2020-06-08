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

/**
 *  This {@linkplain IdGenerator} always returns the same id, which is defined on the 
 * constructor. 
 */
public class ConstantIdGenerator<T> implements IdGenerator<T>{

	private final T id;
		
	public ConstantIdGenerator(T id) {
		this.id = id;
	}

	public T getId() {
		return id;
	}

}
