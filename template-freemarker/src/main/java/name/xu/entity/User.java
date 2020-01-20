package name.xu.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Created by HuoXu
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 名称
     */
    @Column(name = "name", nullable = false, columnDefinition = "varchar(128)  comment '名称'")
    private String name;
    /**
     * 年龄
     */
    @Column(name = "age", columnDefinition = "int comment '年龄'")
    private int age;

    /**
     * uuid
     * 唯一标识,不可重复
     */
    @Column(name = "uuid", columnDefinition = "varchar(128) unique  comment '唯一标识'")
    private String uuid;
}
