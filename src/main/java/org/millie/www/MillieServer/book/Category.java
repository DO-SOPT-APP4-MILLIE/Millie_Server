package org.millie.www.MillieServer.book;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Category {
    경영("경영"), 자기계발("자기계발");

    private String value;

}
