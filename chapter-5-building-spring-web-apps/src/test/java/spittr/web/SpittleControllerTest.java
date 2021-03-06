package spittr.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Long.MAX_VALUE;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        final List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(MAX_VALUE, 20)).thenReturn(expectedSpittles);

        final SpittleController spittleController = new SpittleController(mockRepository);

        final MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                                                                  .build();

        mockMvc.perform(get("/spittles"))
               .andExpect(view().name("spittles"))
               .andExpect(model().attributeExists
                       ("spittleList"))
               .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));

    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        final List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(238900, 50)).thenReturn(expectedSpittles);

        final SpittleController spittleController = new SpittleController(mockRepository);

        final MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                                                                  .build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
               .andExpect(view().name("spittles"))
               .andExpect(model().attributeExists
                       ("spittleList"))
               .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void testSpittle() throws Exception {
        final Spittle expectedSpittle = new Spittle("Hello", new Date());
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);

        final SpittleController spittleController = new SpittleController(mockRepository);

        final MockMvc mockMvc = standaloneSetup(spittleController).build();

        mockMvc.perform(get("/spittles/12345"))
               .andExpect(view().name("spittle"))
               .andExpect(model().attributeExists
                       ("spittle"))
               .andExpect(model().attribute("spittle", expectedSpittle));
    }

    private List<Spittle> createSpittleList(int count) {
        final List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }

        return spittles;
    }
}