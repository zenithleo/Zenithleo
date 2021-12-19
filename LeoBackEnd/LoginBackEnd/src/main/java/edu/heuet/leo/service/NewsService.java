package edu.heuet.leo.service;

import edu.heuet.leo.dataobject.NewsDO;

import java.util.List;

public interface NewsService {
    NewsDO selectDetailById(long id);

    List<NewsDO> selectDetailByTitle(String title);

    List<NewsDO> selectAll();
}
