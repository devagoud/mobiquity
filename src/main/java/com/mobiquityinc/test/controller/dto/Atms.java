package com.mobiquityinc.test.controller.dto;

import com.mobiquityinc.test.domain.Atm;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Atms {
    List<Atm> atms=new ArrayList<>();
}
