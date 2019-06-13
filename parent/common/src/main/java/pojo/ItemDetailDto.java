package pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品添加 返回实体
 */
public class ItemDetailDto implements Serializable {

    private String title;

    private String sellPoint;

    private Long price;

    private Integer num;

    private String barcode;

    private String image;

    private Long cid;

    private String desc;

    private static final long serialVersionUID = 1L;


    public String getTitle() {
        return title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getNum() {
        return num;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getImage() {
        return image;
    }

    public Long getCid() {
        return cid;
    }

    public String getDesc() {
        return desc;
    }
}
