package org.apache.commons.mail;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleEmailTest extends TestCase {
    Email testEmail;
    String msg;

    public void setUp() {
        testEmail = new SimpleEmail();
        msg = "This is a test email";
    }

    @Test
    public void testSetMsg() throws EmailException {
        Email email = testEmail.setMsg(msg);
        assertEquals("msg", email.content.toString());
        assertTrue(true);
    }
}
