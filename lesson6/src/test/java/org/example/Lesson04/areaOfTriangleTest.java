package org.example.Lesson04;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class areaOfTriangleTest {

    @Test
    @DisplayName("Расчет треуголника")
    public void giveParamToFunction(){
        double S = areaOfTriangle.calculateT(3, 4 , 5);
        assertEquals(6.0, S);
    }

}