package com.emiperez.commons.idgenerators.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.emiperez.commons.idgenerators.DateTimeIdGenerator;
import com.emiperez.commons.idgenerators.IdGenerator;

class DateTimeIdGeneratorTest {

	private static final Logger log = Logger.getGlobal();
	
	@Test
	void testGetId() {
		IdGenerator<String> dateTimeIdGenerator = new DateTimeIdGenerator();
		String id = dateTimeIdGenerator.getId();
		log.info(id);
		
		int length = id.length(); //usual length of ids
		int currentLength = length;
		long millis = System.currentTimeMillis();
		
		//generate id-s for 1,2 seconds
		while ((System.currentTimeMillis() - millis) < 1200) {
			String newId = dateTimeIdGenerator.getId();
			assertNotEquals(newId, id);
			int newLength = newId.length();
			
			if (newLength > length) { //counter appended
				if (currentLength == length) { //same second as last id, reset counter
					assertEquals(LocalDateTime.parse(newId.substring(0, length)), LocalDateTime.parse(id));
					assertEquals(newId.substring(length), "-1");
					log.info(newId);
				} else { //same second as last id, increment counter
					assertEquals(Integer.valueOf(newId.substring(length + 1)), Integer.valueOf(id.substring(length + 1)) + 1);
				}
			}
			
			if (newLength == length) { //one second more than last id
				assertEquals(LocalDateTime.parse(newId), LocalDateTime.parse(id.substring(0, length)).plusSeconds(1));
			}
			
			currentLength = newLength;
			id = newId;
		}
	}

}
