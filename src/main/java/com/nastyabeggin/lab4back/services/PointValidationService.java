package com.nastyabeggin.lab4back.services;

import org.springframework.stereotype.Service;
import com.nastyabeggin.lab4back.beans.PointBean;

@Service
public class PointValidationService {

    public boolean isValid(PointBean point) {
        if (point.getX() == null || point.getY() == null || point.getR() == null) {
            return false;
        }
        return isXValid(point.getX()) && isYValid(point.getY()) && isRValid(point.getR());
    }

    private boolean isXValid(double x) {
        return x >= -5 && x <= 5;
    }

    private boolean isYValid(double y) {
        return y >= -5 && y <= 5;
    }

    private boolean isRValid(double r) {
        return r >= -5 && r <= 5;
    }

}
