/*
 * package com.sds.ProductManagement;
 * 
 * import static org.hamcrest.CoreMatchers.anything; import static
 * org.mockito.Mockito.when; import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import java.sql.Date; import java.text.DateFormat; import
 * java.text.SimpleDateFormat;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.MvcResult; import
 * org.springframework.test.web.servlet.RequestBuilder; import
 * org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
 * import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 * import org.w3c.dom.stylesheets.MediaList;
 * 
 * import com.fasterxml.jackson.core.JsonProcessingException; import
 * com.fasterxml.jackson.databind.ObjectMapper; import
 * com.jayway.jsonpath.DocumentContext; import com.jayway.jsonpath.JsonPath;
 * import com.sds.ProductManagement.controller.ProductController; import
 * com.sds.ProductManagement.entity.Product; import
 * com.sds.ProductManagement.entity.ProductKey; import
 * com.sds.ProductManagement.service.ProductService;
 * 
 * @RunWith(SpringRunner.class)
 * @WebMvcTest(controllers = ProductController.class) 
 * public class  ProductControllerTest {
 * 
 * 
 * @Autowired 
 * private MockMvc mockMvc;
 * 
 * 
 * @MockBean 
 * ProductService mockproductservice;
 * 
 * 
 * Product product;
 * 
 * 
 * @Before 
 * public void setup() {
 * 
 * ProductKey key=new ProductKey(11988, 1);
 * 
 * product=new Product(key, "Cycle", 15000, 5, new
 * Date(System.currentTimeMillis()), true);
 * 
 * 
 * }
 * 
 * protected String mapToJson(Object obj) throws JsonProcessingException {
 * ObjectMapper objectMapper = new ObjectMapper();
 * 
 * DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
 * objectMapper.setDateFormat(df);
 * System.out.println("objectMapper.writeValueAsString(obj)"+objectMapper.
 * writeValueAsString(obj)); return objectMapper.writeValueAsString(obj); 
 * }
 * 
 * @Test 
 * public void testgetproductinfo() throws Exception { 
 * 
 * when(mockproductservice.findByProductKey(product.getId())).thenReturn(product);
 * 
 * 
 * 
 * RequestBuilder request = MockMvcRequestBuilders.get("/products/11988/1")
 * .accept(org.springframework.http.MediaType.APPLICATION_JSON);
 * 
 * MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
 * .andExpect(content().json(mapToJson(product), false)) .andReturn();
 * 
 * System.out.println("result==>"+result.getResponse().getContentAsString());
 * 
 * DocumentContext response =
 * JsonPath.parse(result.getResponse().getContentAsString());
 * 
 * 
 * 
 * System.out.println("sagar---->"+response.read("$..productName").toString());
 * 
 * }
 * 
 * }
 */