package com.example.util;

import java.util.List;

/**
 * Created by dingxy on 2018/3/1.
 */
public class Pagination<T> {
  private List<T> result;
  private int page;
  private int size;
  private int totalPage;
  private int total;

  public Pagination() {
    if (size < 1) {
      size = 1;
    }
    if (page < 1) {
      page = 1;
    }
  }

  public List<T> getResult() {
    return result;
  }

  public void setResult(List<T> result) {
    this.result = result;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getTotalPage() {
    return (total - 1) / size + 1;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }
}
