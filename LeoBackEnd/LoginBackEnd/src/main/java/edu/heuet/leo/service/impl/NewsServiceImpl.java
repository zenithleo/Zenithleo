package edu.heuet.leo.service.impl;

import edu.heuet.leo.dao.NewsDOMapper;
import edu.heuet.leo.dataobject.NewsDO;
import edu.heuet.leo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDOMapper newsDOMapper;

    @Override
    public NewsDO selectDetailById(long id) {
        return newsDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NewsDO> selectDetailByTitle(String title) {
        return newsDOMapper.selectByTitle(title);
    }

    @Override
    public List<NewsDO> selectAll() {
        return newsDOMapper.selectAll();
    }
}
