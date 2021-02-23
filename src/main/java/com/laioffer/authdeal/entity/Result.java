package com.laioffer.authdeal.entity;

import java.util.Objects;

public class Result<T> {

  //返回信息
  private String msg;

  //数据是否正常请求
  private boolean success;

  //具体返回的数据
  private T detail;

  public Result() {
  }

  public Result(String msg, boolean success, T detail) {
    this.msg = msg;
    this.success = success;
    this.detail = detail;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public T getDetail() {
    return detail;
  }

  public void setDetail(T detail) {
    this.detail = detail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Result)) {
      return false;
    }
    Result<?> result = (Result<?>) o;
    return isSuccess() == result.isSuccess() &&
        Objects.equals(getMsg(), result.getMsg()) &&
        Objects.equals(getDetail(), result.getDetail());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getMsg(), isSuccess(), getDetail());
  }

  @Override
  public String toString() {
    return "Result{" +
        "msg='" + msg + '\'' +
        ", success=" + success +
        ", detail=" + detail +
        '}';
  }
}
