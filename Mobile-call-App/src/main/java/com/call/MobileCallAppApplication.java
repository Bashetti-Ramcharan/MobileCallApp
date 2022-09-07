package com.call;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class MobileCallAppApplication implements ApplicationRunner 
{
	
	private final static String SID_ACCOUNT = "AC4cf45840b6a3eb5782859fdedfbee3e6";
	private final static String AUTH_ID = "6122346cd5566a158ec2409dde4453f9";
	private final static String FROM_NUMBER="+19286288013";
	private final static String TO_NUMBER ="+918466014824";
		
	static {
		Twilio.init(SID_ACCOUNT, AUTH_ID);
		}
	
	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				   new URI("http://demo.twilio.com/docs/voice.xml")).create();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(MobileCallAppApplication.class, args);
	}

	

}
