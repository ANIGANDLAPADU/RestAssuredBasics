package serializationanddeserialization;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {
	// Approach 1
	@Test
	public void seralization() throws JsonProcessingException {
		HttpPojo httppojo = new HttpPojo();
		httppojo.setName("karanam");
		httppojo.setAddress("anigandladpu");
		ObjectMapper objmapper = new ObjectMapper();
		String json = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(httppojo);
		System.out.println(json);
	}

	// Approach 2
	@Test
	public void seralizationtwo() throws JsonProcessingException {
		HashMap httppojo = new HashMap();
		httppojo.put("name", "karanam");
		httppojo.put("address", "anigandlapadu");
		ObjectMapper objmapper = new ObjectMapper();
		String json = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(httppojo);
		System.out.println(json);
	}
}