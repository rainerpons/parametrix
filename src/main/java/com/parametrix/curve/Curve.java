package com.parametrix.curve;

import processing.core.PApplet;

public abstract class Curve {
	PApplet parent;
	final float X0;
	final float Y0;

	public Curve(PApplet parent) {
		this.parent = parent;
		X0 = parent.width / 2f;
		Y0 = parent.height / 2f;
	}

	public abstract float x(float t);

	public abstract float y(float t);

	public abstract void update();

	public abstract void display();
}