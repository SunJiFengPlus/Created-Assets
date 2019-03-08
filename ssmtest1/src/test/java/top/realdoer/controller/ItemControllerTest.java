package top.realdoer.controller;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/DispatcherServlet-servlet.xml"})
public class ItemControllerTest {
    @Autowired
    ItemController handler;
    @Autowired
    ServletContext context;
    
    MockMvc mockMvc;
    
    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(handler).build();
    }
    
    @Test
    public void listPortfolioTest() throws Exception {
        // Param
        String authorId = "1000";
        
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/listPortfolio/" + authorId));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println(result);
    }
}
