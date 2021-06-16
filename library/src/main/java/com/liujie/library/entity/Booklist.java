package com.liujie.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * <p>
 *
 * </p>
 *
 * @author 刘比
 * @since 2021-05-26
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Booklist implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "booklist_id", type = IdType.AUTO)
    private Integer booklistId;

    @TableField("ISBN")
    private String isbn;

    private String bname;

    private String publisher;

    private String writer;

    private LocalDate ptime;

    private Integer number;

    private Integer operator;

    private Integer isPopular;


}
