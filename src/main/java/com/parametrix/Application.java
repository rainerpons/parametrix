package com.parametrix;

import java.util.Random;

import processing.core.PApplet;

import com.parametrix.curve.ButterflyCurve;
import com.parametrix.curve.Curve;
import com.parametrix.curve.LissajousCurve;
import com.parametrix.curve.RoseCurve;

public class Application extends PApplet {
	Curve curve;

	@Override
	public void settings() {
		size(640, 640);
	}

	@Override
	public void setup() {
		frameRate(120);
		background(53, 58, 62); // #353A3E
		stroke(255);
		curve = randomCurve();
	}

	@Override
	public void draw() {
		curve.update();
		curve.display();
	}

	private Curve randomCurve() {
		Random random = new Random();
		Curve result = null;
		switch (random.nextInt(3)) {
			case 0:
				result = new ButterflyCurve(this);
				break;
			case 1:
				result = new LissajousCurve(this);
				break;
			case 2:
				result = new RoseCurve(this);
				break;
			default:
				return result;
		}
		return result;
	}

	public static void main(String[] args) {
		PApplet.main("com.parametrix.Application");
	}
}