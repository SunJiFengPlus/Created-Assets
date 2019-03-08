package top.realdoer.dao;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.lang.Assert;
import top.realdoer.dao.CommentMapper;
import top.realdoer.entity.Comment;

/**
 * @author 孙继峰
 * @date 2018/12/01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
@Transactional
@Rollback
public class CommentMapperTest {
    // TODO: 边界测试
    @Autowired
    CommentMapper mapper;
    
    @Test
    public void testSave() throws IOException {
        Comment comment = new Comment();
        comment.setItemId(10000);
        comment.setContent("TestSave");
        comment.setUserId(10000);
        mapper.save(comment);
        
        List<Comment> list = mapper.list(10000);
        Assert.notNull(comment.getCommentId());
        Assert.isTrue(list.size() == 1);
        Assert.isTrue(list.get(0).getContent().equals("TestSave"));
        Assert.isTrue(list.get(0).getItemId().equals(10000));
        Assert.isTrue(list.get(0).getUserId().equals(10000));
        
    }
    
    @Test
    public void testList() throws IOException {
        Comment comment = new Comment();
        comment.setItemId(10000);
        comment.setContent("TestSave");
        comment.setUserId(10000);
        mapper.save(comment);
        mapper.save(comment);
        
        List<Comment> comments = mapper.list(10000);
        Assert.notNull(comment.getCommentId());
        Assert.isTrue(comments.size() == 2);
        Assert.isTrue(comments.get(0).getContent().equals("TestSave"));
        Assert.isTrue(comments.get(0).getItemId().equals(10000));
        Assert.isTrue(comments.get(0).getUserId().equals(10000));
        Assert.notNull(comments.get(0).getCommentId());
        Assert.isTrue(comments.get(1).getContent().equals("TestSave"));
        Assert.isTrue(comments.get(1).getItemId().equals(10000));
        Assert.isTrue(comments.get(1).getUserId().equals(10000));
        Assert.notNull(comments.get(1).getCommentId());
    }
    
    @Test
    public void testCount() throws Exception {
        Comment comment = new Comment();
        comment.setItemId(10000);
        comment.setContent("TestSave");
        comment.setUserId(10000);
        mapper.save(comment);
        mapper.save(comment);
        
        Assert.isTrue(mapper.count(10000) == 2);
    }
    
    @Test
    public void testRemove() {
        Comment comment = new Comment();
        comment.setItemId(10000);
        comment.setContent("TestSave");
        comment.setUserId(10000);
        mapper.save(comment);
        
        List<Comment> list = mapper.list(10000);
        Assert.isTrue(mapper.count(10000) == 1);
        Assert.notNull(list.get(0));
        Assert.notNull(list.get(0).getCommentId());
        
        Integer rs = mapper.remove(comment.getCommentId());
        Assert.isTrue(rs == 1);
        Assert.isTrue(mapper.count(10000) == 0);
    }
    
    @Test
    public void testCheckBelong() {
        Comment comment = new Comment();
        comment.setItemId(10000);
        comment.setContent("TestSave");
        comment.setUserId(10000);
        mapper.save(comment);
        
        Assert.notNull(comment.getCommentId());
        Boolean rs = mapper.checkBelong(comment.getCommentId(), 10000);
        Assert.isTrue(rs);
        rs = mapper.checkBelong(comment.getCommentId(), 10001);
        Assert.isTrue(!rs);
    }
}
