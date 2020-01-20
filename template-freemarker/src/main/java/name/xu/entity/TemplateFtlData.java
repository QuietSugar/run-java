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
 * 模板数据的关联表
 *
 * @author huoxu
 */
@ToString
@Entity
@Table(name = "temp_data")
@Setter
@Getter
public class TemplateFtlData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 模板编码
     */
    @Column(name = "temp_code", nullable = false, columnDefinition = "varchar(32) unique  comment '模板编码'")
    private String tempCode;
    /**
     * 数据编码
     */
    @Column(name = "data_code", nullable = false, columnDefinition = "varchar(32) unique  comment '数据编码'")
    private String dataCode;

}
