package com.dusk.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 路面情况
 * @TableName road_info
 */
@TableName(value ="road_info")
@Data
public class RoadInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String adress;

    /**
     * 凹凸
     */
    private Integer concaveVex;

    /**
     * 积水
     */
    private Integer ponding;

    /**
     * 裂纹
     */
    private Integer creckle;

    /**
     * 承重
     */
    private Integer bearing;

    /**
     * 
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RoadInfo other = (RoadInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAdress() == null ? other.getAdress() == null : this.getAdress().equals(other.getAdress()))
            && (this.getConcaveVex() == null ? other.getConcaveVex() == null : this.getConcaveVex().equals(other.getConcaveVex()))
            && (this.getPonding() == null ? other.getPonding() == null : this.getPonding().equals(other.getPonding()))
            && (this.getCreckle() == null ? other.getCreckle() == null : this.getCreckle().equals(other.getCreckle()))
            && (this.getBearing() == null ? other.getBearing() == null : this.getBearing().equals(other.getBearing()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAdress() == null) ? 0 : getAdress().hashCode());
        result = prime * result + ((getConcaveVex() == null) ? 0 : getConcaveVex().hashCode());
        result = prime * result + ((getPonding() == null) ? 0 : getPonding().hashCode());
        result = prime * result + ((getCreckle() == null) ? 0 : getCreckle().hashCode());
        result = prime * result + ((getBearing() == null) ? 0 : getBearing().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adress=").append(adress);
        sb.append(", concaveVex=").append(concaveVex);
        sb.append(", ponding=").append(ponding);
        sb.append(", creckle=").append(creckle);
        sb.append(", bearing=").append(bearing);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}