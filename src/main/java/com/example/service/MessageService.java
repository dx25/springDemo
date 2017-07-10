package com.example.service;

import com.example.bean.Message;
import com.example.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by silence on 2017/7/10.
 */
@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public Message save(Message message){
        int id = messageMapper.insertSelective(message);
        return messageMapper.selectByPrimaryKey(id);
    }


}
