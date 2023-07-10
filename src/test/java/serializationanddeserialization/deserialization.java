package serializationanddeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class deserialization {
	@Test
	public void deserializatin() throws JsonMappingException, JsonProcessingException {
		String json ="{\r\n" + 
				"  \"name\" : \"karanam\",\r\n" + 
				"  \"address\" : \"anigandladpu\"\r\n" + 
				"}";
		ObjectMapper objmapper = new ObjectMapper();
		 HttpPojo pojo=objmapper.readValue(json, HttpPojo.class);
		System.out.println(pojo.getAddress());
		System.out.println(pojo.getName());
		  
	}
}
