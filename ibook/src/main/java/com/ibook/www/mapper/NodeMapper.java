package com.ibook.www.mapper;

import com.ibook.www.model.Content;
import com.ibook.www.model.Node;

/**
 * @author fanmingxin
 * @description
 * @Date 2018/6/19
 */
public interface NodeMapper {

    int insert(Node node);
    int insertContent(Content node);
}
