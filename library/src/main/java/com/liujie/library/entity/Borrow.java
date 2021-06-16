package com.liujie.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Borrow implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "borrow_id", type = IdType.AUTO)
      private Integer borrowId;

    private Integer bookId;

    private Integer userId;

    private LocalDateTime btime;

    private LocalDateTime deadline;

    private LocalDateTime rtime;

    private Integer operator;


}
