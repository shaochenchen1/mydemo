package com.example.scc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @ClassName testMockMVC
 * @Description TODO
 * @Author Administrator
 * @DATE 2022/4/25 0025 22:10
 * @VERSION 1.0
 **/
@SpringBootTest
@AutoConfigureMockMvc
public class testMockMVC {
    @Autowired
    MockMvc mockMvc;
    @Test
    void testMockMVC() throws Exception {
        //发起一个请求不依赖于网络，不依赖于服务，不需要启动web应用
      /*  mockMvc.perform(
                MockMvcRequestBuilders.get("/user/{id}",1) //发送get请求
                .accept(MediaType.APPLICATION_JSON_UTF8) //设置响应的文本类型

        )
                //响应断言
                .andExpect(MockMvcResultMatchers.status().isOk())//判断状态码为200
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.username").value("zhangsan1"))
                .andDo(MockMvcResultHandlers.print());*/
        //language=JSON
        String userJson="{\n" +
                "  \"username\": \"邵晨晨\",\n" +
                "  \"address\": \"fewr\"\n" +
                "}";
        mockMvc.perform(
                MockMvcRequestBuilders.post("/user/add")
                        .accept(MediaType.APPLICATION_JSON_UTF8) //设置响应的文本类型
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(userJson)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
}
