package com.chenjh.mapper.book;

import com.chenjh.entity.book.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select(" select t_id bookID, t_name bookName" +
            " from t_books")
    List<Book> select();
}
