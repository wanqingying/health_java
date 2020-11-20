package com.wan.pojo;

import java.io.Serializable;

public class TCheckgroupCheckitem implements Serializable {
    private Integer checkgroupId;

    private Integer checkitemId;

    private static final long serialVersionUID = 1L;

    public Integer getCheckgroupId() {
        return checkgroupId;
    }

    public void setCheckgroupId(Integer checkgroupId) {
        this.checkgroupId = checkgroupId;
    }

    public Integer getCheckitemId() {
        return checkitemId;
    }

    public void setCheckitemId(Integer checkitemId) {
        this.checkitemId = checkitemId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", checkgroupId=").append(checkgroupId);
        sb.append(", checkitemId=").append(checkitemId);
        sb.append("]");
        return sb.toString();
    }
}