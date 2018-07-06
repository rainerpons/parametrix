package com.parametrix.curve;

import java.util.Random;

import processing.core.PApplet;

import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;

public class RoseCurve extends Curve {
	final float SCALE = 3f * parent.width / 8;
	final float K;
	float x;
	float y;
	float t;

	public RoseCurve(PApplet parent) {
		super(parent);
		Random random = new Random();
		K = 13 * random.nextFloat();
	}

	@Override
	public float x(float t) {
		return cos(K * t) * cos(t);
	}

	@Override
	public float y(float t) {
		return cos(K * t) * sin(t);
	}

	@Override
	public void update() {
		t = parent.frameCount / 2f;
		x = X0 + SCALE * x(t);
		y = Y0 + SCALE * y(t);
	}

	@Override
	public void display() {
		parent.point(x, y);
	}
}