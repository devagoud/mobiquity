package com.mobiquityinc.test.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OpeningHour {
    private float dayOfWeek;
    private List<Hour> hours=new ArrayList();
}
