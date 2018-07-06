package com.parametrix.curve;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PConstants;

import static processing.core.PApplet.sin;

public class LissajousCurve extends Curve {
	final float DELTA = PConstants.PI / 2;
	final float SCALE = 3f * parent.width / 8;
	final float A;
	final float B;
	float x;
	float y;
	float t;

	public LissajousCurve(PApplet parent) {
		super(parent);
		Random random = new Random();
		A = random.nextInt(13);
		B = random.nextInt(13);
	}

	@Override
	public float x(float t) {
		return sin(A * t + DELTA);
	}

	@Override
	public float y(float t) {
		return sin(B * t);
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