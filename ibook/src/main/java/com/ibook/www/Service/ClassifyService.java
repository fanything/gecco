package com.ibook.www.Service;

import com.ibook.www.mapper.ClassifyMapper;
import com.ibook.www.model.Classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/19
 */
@Service
public class ClassifyService {

    @Autowired
    private ClassifyMapper classifyMapper;

    public int save(Classify classify){

        if(classify == null){
            return -1;
        }
        return classifyMapper.insert(classify);
    }
}
