package com.wwx.myo2o.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by geely
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;
}
