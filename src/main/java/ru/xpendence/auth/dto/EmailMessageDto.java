package ru.xpendence.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 17.09.19
 * Time: 19:55
 * e-mail: v.chernyshov@pflb.ru
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailMessageDto implements Serializable {

    private String to;
    private String from;
    private String subject;
    private String text;
}
