package com.wan.entity;

import java.io.Serializable;

/**
 * 封装查询条件
 */
public class QueryPageBean implements Serializable {
    private Integer current;//页码
    private Integer size;//每页记录数
    private String search;//查询条件

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "QueryPageBean{" +
                "current=" + current +
                ", size=" + size +
                ", search='" + search + '\'' +
                '}';
    }
}