package org.apache.commons.mail;

import junit.framework.TestCase;
import org.junit.Test;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import static org.apache.commons.mail.EmailConstants.*;
import static org.mockito.Mockito.*;

public class EmailTest extends TestCase{
	Email testEmail;
	Collection<InternetAddress> addressCollection;
	String[] recipientList;

	public void setUp() throws EmailException, AddressException {
		testEmail = new SimpleEmail();

		recipientList = new String[]{"MaryJones@gmail.com", "DezerelGraham@yahoo.com", "Seal@g.com", "123456@email.com"};
		addressCollection = new ArrayList<>();
		addressCollection.add(InternetAddress.parse("to@to.com")[0]);

		testEmail.setMsg("This is a test email.");
		testEmail.setHostName("hostName");
		testEmail.setSubject("Test Subject");
	}

	public void testAddBcc() throws EmailException {
		testEmail.addBcc(recipientList);
		assertEquals("MaryJones@gmail.com", testEmail.getBccAddresses().get(0).toString());
	}

	public void testAddCc() throws EmailException {
		testEmail.addCc("a@b.com");
		assertEquals("a@b.com", testEmail.getCcAddresses().get(0).toString());
		assertEquals("a@b.com", testEmail.getCcAddresses().get(0).toString());
	}
}
