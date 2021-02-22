package com.wani.springwebmvclocaldatetimetutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringWebMvcLocaldatetimeTutorialApplicationTests {


    @Autowired
    private MockMvc mockMvc;


    @Test
    void ModelAttribute의_LocalDate는_변환된다() throws Exception {
        //given
        String url = "/get?name=jojoldu&requestDateTime=2018-12-15T10:00:00";

        //when
        ResultActions resultActions = this.mockMvc.perform(get(url));


        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("get 성공")));
    }

    @Test
    void requestParameter의_LoacalDate는_변환된다() throws Exception {
        //given
        String url = "/requestParameter?requestDateTime=2018-12-15T10:00:00";

        //when
        ResultActions resultActions = this.mockMvc.perform(get(url));

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("requestParameter 성공")));
    }

    @Test
    void post요청시_requestBody의_LocalDate는_변환된다() throws Exception {
        //given
        String url = "/post";

        //when
        ResultActions resultActions = this.mockMvc.perform(
                post(url)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("{\"name\":\"jojoldu\", \"requestDateTime\":\"2018-12-15T10:00:00\"}"));

        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("post 성공")));

    }


    @Test
    public void responseModel의_LocalDate는_변환된다() throws Exception {
        //given
        String url = "/response";

        //when
        ResultActions resultActions = this.mockMvc.perform(get(url));

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"wani\", \"requestDateTime\":\"2018-12-15T10:00:00\"}"));

    }
}


