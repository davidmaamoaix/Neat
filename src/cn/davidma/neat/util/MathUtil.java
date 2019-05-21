package cn.davidma.neat.util;

import javafx.scene.effect.ColorAdjust;

/**
 * This class does math. Wadda u expect?
 * 
 * @author David Ma
 */
public class MathUtil {
	
	/**
	 * Maps a value into an oscillating pattern between the min and max.
	 * 
	 * @param time The value to be mapped.
	 * @param min The minimum bound for the oscillation.
	 * @param max The maximum bound for the oscillation.
	 * @return The mapped value.
	 */
	public static double oscillate(double time, double min, double max) {
		return min + (Math.sin(time) + 1) / 2 * (max - min);
	}
	
	/**
	 * Maps a value to another interval.
	 * 
	 * @param value The value to be mapped.
	 * @param initialStart The start of the initial interval.
	 * @param initialEnd The end of the initial interval.
	 * @param targetStart The start of the target interval.
	 * @param targetEnd The end of the target interval.
	 * @return The value after map.
	 */
	public static double map(double value, double initialStart, double initialEnd, double targetStart, double targetEnd) {
		return targetStart + (targetEnd - targetStart) * (value - initialStart) / (initialEnd - initialStart);
	}
	
	/**
	 * Calculates the hue needed to change a white color to a target color.
	 * 
	 * @param targetHue The hue of the target color [0, 360).
	 * @return The resulting hue.
	 */
	public static double convHue(double targetHue) {
		return map((targetHue + 180) % 360, 0, 360, -1, 1);
	}
	
	/**
	 * Calculates the saturation needed to change a white color to a target color.
	 * 
	 * @param targetSaturation The saturation of the target color [0, 100].
	 * @return The resulting saturation.
	 */
	public static double convSaturation(double targetSaturation) {
		return targetSaturation / 100;
	}
	
	/**
	 * Calculates the brightness needed to change a white color to a target color.
	 * 
	 * @param targetBrightness The brightness of the target color [0, 100].
	 * @return The resulting brightness.
	 */
	public static double convBrightness(double targetBrightness) {
		return map(targetBrightness, 0, 100, -1, 0);
	}
	
	/**
	 * Calculates the final color to change a white color to.
	 * 
	 * @param targetHue  The hue of the target color [0, 360).
	 * @param targetSaturation The saturation of the target color [0, 100].
	 * @param targetBrightness The brightness of the target color [0, 100].
	 * @param contrast The contrast of the color.
	 * @return The ColorAdjust object of the target color.
	 */
	public static ColorAdjust convColorAdjust(double targetHue, double targetSaturation, double targetBrightness,
			double contrast) {
		ColorAdjust result = new ColorAdjust();
		result.setHue(convHue(targetHue));
		result.setSaturation(convSaturation(targetSaturation));
		result.setBrightness(convBrightness(targetBrightness));
		result.setContrast(contrast);
		return result;
	}
	
	/**
	 * Determines whether the two interval overlaps (inclusive) with each other.
	 * 
	 * @param firstStart The start of the first interval (inclusive).
	 * @param firstEnd The end of the first interval (inclusive).
	 * @param secondStart The start of the second interval (inclusive).
	 * @param secondEnd The end of the second interval (inclusive).
	 * @return
	 */
	public static boolean rangeOverlap(double firstStart, double firstEnd, double secondStart, double secondEnd) {
		return !(firstStart > secondEnd || firstEnd < secondStart);
	}
}
