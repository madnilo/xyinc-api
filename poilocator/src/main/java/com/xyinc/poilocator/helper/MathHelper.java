package com.xyinc.poilocator.helper;

import com.xyinc.poilocator.model.PointOfInterest;

public class MathHelper {

	public static double distanceBetweenTwoPoints(PointOfInterest a, PointOfInterest b) {

		return Math.sqrt(
				((a.getX() - b.getX()) * (a.getX() - b.getX())) + ((a.getY() - b.getY()) * (a.getY() - b.getY())));
	}

}
