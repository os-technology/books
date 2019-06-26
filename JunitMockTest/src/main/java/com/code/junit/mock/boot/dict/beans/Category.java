package com.code.junit.mock.boot.dict.beans;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


/**
* category
*/
@Data
public class Category implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3492783040803760563L;

	public Category() {
    }

    
    /**
    * 品类编号
    */
    private String id;
    
    /**
    * 父编号
    */
    private String pId;
    
    /**
    * 品类名称
    */
    @NotBlank( message = "类目名称不能为空")
    private String categoryName;
    /**
     * 品类分类
     */
    private String categoryCode;

    /**
    * 品类图片
    */
    private String imgUrl;
    /**
     * 1:标品品类 2:到家服务品类
     */
    private Integer type;
    
    /**
    * 状态 1:可用 0:不可用
    */
    private Integer status;
    
    /**
    * 排序值
    */
    @NotNull( message = "排序值不能为空")
    private Integer sort;
    
    /**
     * 品类级别 1一级2二级3三级
     */
    private Integer level;
    /**
     * 是否是末级
     */
    private Integer isLast ;
    
    /**
    * 创建时间
    */
    private Date createAt;
    
    /**
    * 更新时间
    */
    private Date updateAt;
    
    /**
    * 创建者
    */
    private String createBy;
    
    /**
    * 更新者
    */
    private String updateBy;
    

    
}