package com.conson.daydream.vo.specs_package_vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author 康森
 * @date 2020/5/4 14 : 14 : 14
 * @description
 */
@Data
public class ShopSpecsVo {
    @JsonProperty("id")
    private Integer specsId;
    @JsonProperty("name")
    private String specsName;
    @JsonProperty("imgUrl")
    private String specsIcon;
    @JsonProperty("previewImgUrl")
    private String specsPreview;

}
