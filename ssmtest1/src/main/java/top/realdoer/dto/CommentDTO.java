package top.realdoer.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CommentDTO {
    
    private Integer commentId;
    private String userName;
    private String avatar;
    private String content;
    private Date date;
    private CommentDTO parent;
}
