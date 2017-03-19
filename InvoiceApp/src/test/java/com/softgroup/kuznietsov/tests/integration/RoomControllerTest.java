package com.softgroup.kuznietsov.tests.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.softgroup.kuznietsov.api.AddRoomRequest;
import com.softgroup.kuznietsov.api.RoomInfo;
import com.softgroup.kuznietsov.api.RoomListReply;
import com.softgroup.kuznietsov.utils.EntityIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by User on 08.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RoomControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findRoomTest() throws Exception {
        this.mockMvc.perform(get("/room/byid/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"retcode\":0,\"apiVer\":\"0.0.1\",\"error_message\":null,\"roomInfoList\":[{\"id\":2,\"owner\":\"testOwner\",\"guests\":1,\"area\":1.0}]}")));
    }

    @Test
    public void addRoomTest() throws Exception{
        Long room_id = EntityIdGenerator.random();
        AddRoomRequest roomRequest = new AddRoomRequest();
        roomRequest.roomInfo = new RoomInfo();
        roomRequest.roomInfo.id = room_id.toString();
        roomRequest.roomInfo.guests = 1;
        roomRequest.roomInfo.area = 1f;
        roomRequest.roomInfo.owner ="Test1Owner";

        ObjectMapper om = new ObjectMapper();
        String content = om.writeValueAsString(roomRequest);

        MvcResult result = mockMvc.perform(post("/room/add")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content)
        )
                .andExpect(status().isOk())
                .andReturn();

        String reply = result.getResponse().getContentAsString();
        RoomListReply roomListReply = om.readValue(reply, RoomListReply.class);
        assertEquals("Reurn code in not 0",roomListReply.retcode.longValue(), 0L);
        if(roomListReply.retcode==0){
            mockMvc.perform(get("/room/del/"+roomListReply.roomInfoList.get(0).id)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
            )
                    .andExpect(status().isOk());


        }
    }
}
