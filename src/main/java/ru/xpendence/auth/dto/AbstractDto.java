package ru.xpendence.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 09.09.18
 * Time: 22:20
 * e-mail: 2262288@gmail.com
 */
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class AbstractDto implements Serializable {

    private Long id;
}
