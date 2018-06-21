package com.ibook.www.Service;

import com.ibook.www.mapper.ChannelMapper;
import com.ibook.www.model.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/19
 */
@Service
public class ChannelService {

    @Autowired
    private ChannelMapper channelMapper;

    public int save(Channel channel){

        if(channel == null){
            return -1;
        }
        return channelMapper.insert(channel);
    }
}
