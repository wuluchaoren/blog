package com.su.blog.service;

import com.su.blog.dao.BloggerDao;
import com.su.blog.entity.Blogger;
import com.su.blog.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Description: blogger业务逻辑
 *
 * @author Tianyu Su
 * @date 23:04 2019/01/22
 */

@Service
public class BloggerService {
    @Autowired
    private BloggerDao bloggerDao;


    /**
     * Description: blogger获取个人信息
     *
     * @author Tianyu Su
     * @date 2019/01/31
     */
    public Blogger getBloggerById(int id) throws MyException{
        return bloggerDao.getBloggerById(id);
    }

    /**
     * Description: blogger修改密码
     *
     * @author Tianyu Su
     * @date 23:04 2019/01/31
     */
    public boolean alterPassword(Blogger blogger) throws MyException{
        if(blogger.getId()==0){
            throw new MyException("id不能为空", MyException.ERROR);
        }
        if(blogger.getPassword()==null){
            throw new MyException("密码不能为空", MyException.ERROR);
        }
        return bloggerDao.alterPasswordById(blogger);
    }

    /**
     * Description: blogger修改密码
     *
     * @author Tianyu Su
     * @date 23:04 2019/01/31
     */
    public boolean alterProfile(Blogger blogger) throws MyException{
        if(blogger.getId()==0){
            throw new MyException("id不能为空", MyException.ERROR);
        }
        return bloggerDao.alterProfileById(blogger);
    }

}
