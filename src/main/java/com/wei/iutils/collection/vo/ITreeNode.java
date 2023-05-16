package com.wei.iutils.collection.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 继承这个类以使用ITreeUtils创建树树表
 * @param <T> 标识的类型
 */
public abstract class ITreeNode<T extends Comparable<T>> implements Serializable {
    /**
     * 父级id
     */
    private T parentId;
    /**
     * 自身id
     */
    private T id;
    /**
     * 子节点
     */
    private List<ITreeNode<T>> children;

    public T getParentId() {
        return parentId;
    }

    public void setParentId(T parentId) {
        this.parentId = parentId;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public List<ITreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<ITreeNode<T>> children) {
        this.children = children;
    }
}
