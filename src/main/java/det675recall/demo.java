package det675recall;

import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
 
import java.net.URI; 
import java.math.BigDecimal;

public class demo {
	// Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "AC61739450a3f87beb25967a6a2a1f4059"; 
    public static final String AUTH_TOKEN = "e88558ab2b56435cce3a931900f5174a"; 
    public static final String from = "+14054448434";
 
    public static void main(String[] args) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("+19186933278"),   
                new com.twilio.type.PhoneNumber(from),
                "If this works I'm going to be really surprised.")      
            .create();  
 
        System.out.println(message.getSid()); 
    } 
}
