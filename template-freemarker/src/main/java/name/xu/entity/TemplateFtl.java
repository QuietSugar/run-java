package name.xu.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * freemarker 的模板
 *
 * @author huoxu
 */
@ToString
@Entity
@Table(name = "template_ftl")
@Setter
@Getter
public class TemplateFtl implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    /**
     * 编码
     */
    @Column(name = "code", nullable = false, columnDefinition = "varchar(32) unique  comment '编码'")
    private String code;
    /**
     * 名字
     */
    @Column(name = "name", nullable = false, columnDefinition = "varchar(32) unique  comment '名字'")
    private String name;
    /**
     * 模板内容
     */
    @Column(name = "content", nullable = false, columnDefinition = "text  comment '模板内容'")
    private String content;
}
