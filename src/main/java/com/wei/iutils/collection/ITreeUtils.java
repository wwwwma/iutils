package com.wei.iutils.collection;

import com.wei.iutils.collection.vo.ITreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * 对继承ITreeNode的类构建树
 */
public class ITreeUtils {

    /**
     * 将参数构建成树
     * @param data 数据
     * @param parentId 指定 顶点parentId 只构建在最顶点值下的树
     * @param <T> 标识的类型
     * @return 树
     */
    public static <T extends Comparable<T>> List<ITreeNode<T>> buildTree(List<ITreeNode<T>> data,T parentId){
        //进行一次排序
        data.sort(Comparator.comparing(ITreeNode::getId));
        List<ITreeNode<T>> res= new ArrayList<>();
        for (ITreeNode<T> item : data) {
            if (item.getParentId().compareTo(parentId) == 0) res.add(build(item,data));
        }
        return res;
    }

    /**
     * 获取指定节点下的树
     * @param data 数据
     * @param id 指定节点 如果找到该节点将返回null
     * @param <T> 标识的类型
     * @return 树
     */
    public static <T extends Comparable<T>> ITreeNode<T> subTree(List<ITreeNode<T>> data,T id){
        for (ITreeNode<T> item : data) {
            if (item.getId().compareTo(id) == 0){
                data.sort(Comparator.comparing(ITreeNode::getId));
                return build(item, data);
            }
        }
        return null;
    }

    private static  <T extends Comparable<T>> ITreeNode<T> build(ITreeNode<T> root, List<ITreeNode<T>> data){
        List<ITreeNode<T>> children = null;
        for (ITreeNode<T> item : data) {
            if (item.getParentId().compareTo(root.getId()) == 0){
                if (null == (children = root.getChildren())){
                    root.setChildren(new ArrayList<>());
                    children = root.getChildren();
                }
                children.add(item);
            }
        }
        if (null != children && children.size()>0){
            for (ITreeNode<T> child : children) {
                build(child,data);
            }
        }
        return root;
    }
}
