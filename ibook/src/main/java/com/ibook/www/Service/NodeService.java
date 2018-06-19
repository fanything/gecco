package com.ibook.www.Service;

import com.ibook.www.mapper.NodeMapper;
import com.ibook.www.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/19
 */
@Service
public class NodeService {

    @Autowired
    private NodeMapper nodeMapper;

    public int save(Node node){

        if(node == null){
            return -1;
        }
        node.setCreateTime(new Date());
        return nodeMapper.insert(node);
    }
}
