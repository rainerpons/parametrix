package com.parametrix.curve;

import processing.core.PApplet;

import static processing.core.PApplet.cos;
import static processing.core.PApplet.exp;
import static processing.core.PApplet.pow;
import static processing.core.PApplet.sin;

public class ButterflyCurve extends Curve {
	static final float SCALE = 64f;
	float x;
	float y;
	float t;

	public ButterflyCurve(PApplet parent) {
		super(parent);
	}

	@Override
	public float x(float t) {
		return sin(6 * t) * exp(cos(6 * t)) - 2 * cos(24 * t) - pow(sin(t / 2), 5);
	}

	@Override
	public float y(float t) {
		return cos(6 * t) * exp(cos(6 * t)) - 2 * cos(24 * t) - pow(sin(t / 2), 5);
	}

	@Override
	public void update() {
		t = (float)((double)parent.frameCount / 2);
		x = X0 + SCALE * x(t);
		y = Y0 + SCALE * y(t);
	}

	@Override
	public void display() {
		parent.point(x, y);
	}
}