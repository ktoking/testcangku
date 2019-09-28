package com.fehead;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest 
{


    @Autowired
    WebApplicationContext applicationContext;
    MockMvc mockMvc;
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }




    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );

    }

    @Test
    public void findAllListByUserId() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/1/SUSTDelivery/view/user/1/myLists")
                        .param("page","1")
                        .param("pagesize","1")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void publishItem() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/1/SUSTDelivery/view/user/1/commit")
                        .param("destination","我佳佳家里")
                        .param("deadline","Fri Aug 23 11:26:12 CST 2019")
                        .param("type","1")
                        .param("fee","2.5")
                        .param("remark","带一瓶可乐")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }


    @Test
    public void whenPutOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.put("/api/1/SUSTDelivery/view/user/1/theirLists/2")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }
    /**
     * 通过id查找用户
     * @throws Exception
     */
    @Test
    public void whenGetUser() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/1/SUSTDelivery/view/user/2/info")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
    /**
     * 查找该用户所有接受的订单
     * @throws Exception
     */
    @Test
    public void whenGetAllTheirList() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/1/SUSTDelivery/view/user/1/theirList")
                        .param("page","1")
                        .param("pagesize","1")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }
    /**
     * 删除未接状态订单
     * @throws Exception
     */
    @Test
    public void whenDeleteOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/1/SUSTDelivery/view/user/2/myLists/1")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }
    /**
     * @PutMapping("/user/{id}/theirLists/{order_id}")
     * 接订单
     */
    @Test
    public void whenGetOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.put("/api/1/SUSTDelivery/view/user/1/theirLists/6")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * @GetMapping("/order")
     * 获取详细订单信息
     */
    @Test
    public void getDetailOrder() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/1/SUSTDelivery/view/order/lists/2/info")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

}
