package spittr.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import spittr.config.WebConfig;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class })
@WebAppConfiguration
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        final HomeController homeController = new HomeController();
        final MockMvc mockMvc = standaloneSetup(homeController).build();

        mockMvc.perform(get("/"))
               .andExpect(view().name("home"));
    }
}