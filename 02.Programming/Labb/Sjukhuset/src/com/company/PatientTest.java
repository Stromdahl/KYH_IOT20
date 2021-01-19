package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    Patient patient = new Patient("pelle", "förkylning");
    Patient patient2 = new Patient("åsa", null);

    @Test
    @DisplayName("Testing getName")
    void testGetName(){
        assertEquals("pelle", patient.getName());
        assertNotEquals("åsa", patient.getName());
        assertNotNull(patient.getName());
    }

    @Test
    @DisplayName("Testing getSickness")
    void testGetSickness(){
        assertEquals("förkylning", patient.getSickness());
        assertNotNull(patient.getName());
        assertNull(patient2.getSickness());
    }

    @Test
    @DisplayName("Testing isSick")
    void testIsSick(){
        assertTrue(patient.isSick());
        assertFalse(patient2.isSick());
    }

}

