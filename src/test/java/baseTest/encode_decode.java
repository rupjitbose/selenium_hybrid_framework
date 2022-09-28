package baseTest;

import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;

public class encode_decode {

	
	@Test
	public void encode() {
		
		String a="I234567a";
		byte[] encoding=Base64.encodeBase64(a.getBytes());
		System.out.println(new String(encoding));
		//String encoded=new String(encoding);
	}
	
	@Test
	public String decode(String s) {
		byte[] decoding=Base64.decodeBase64(s.getBytes());
		System.out.println(new String(decoding));
		return new String(decoding);
		 
		
	}
}
