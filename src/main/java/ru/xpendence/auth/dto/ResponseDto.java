package ru.xpendence.auth.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.09.19
 * Time: 21:05
 * e-mail: v.chernyshov@pflb.ru
 */
@Data
public class ResponseDto implements Serializable {

    private Boolean success;
}
