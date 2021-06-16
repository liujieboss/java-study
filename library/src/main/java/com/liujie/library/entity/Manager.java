package com.liujie.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Manager implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "manager_id", type = IdType.AUTO)
      private Integer managerId;

    private String passWd;

    private String mname;


}
