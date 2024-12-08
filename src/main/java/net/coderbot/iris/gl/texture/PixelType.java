package net.coderbot.iris.gl.texture;

import net.coderbot.iris.gl.GlVersion;
import org.lwjglx.opengl.GL11;
import org.lwjglx.opengl.GL12;
import org.lwjglx.opengl.GL30;

import java.util.Optional;

public enum PixelType {
	BYTE(GL11.GL_BYTE, GlVersion.GL_11),
	SHORT(GL11.GL_SHORT, GlVersion.GL_11),
	INT(GL11.GL_INT, GlVersion.GL_11),
	HALF_FLOAT(GL30.GL_HALF_FLOAT, GlVersion.GL_30),
	FLOAT(GL11.GL_FLOAT, GlVersion.GL_11),
	UNSIGNED_BYTE(GL11.GL_UNSIGNED_BYTE, GlVersion.GL_11),
	UNSIGNED_BYTE_3_3_2(GL12.GL_UNSIGNED_BYTE_3_3_2, GlVersion.GL_12),
	UNSIGNED_BYTE_2_3_3_REV(GL12.GL_UNSIGNED_BYTE_2_3_3_REV, GlVersion.GL_12),
	UNSIGNED_SHORT(GL11.GL_UNSIGNED_SHORT, GlVersion.GL_11),
	UNSIGNED_SHORT_5_6_5(GL12.GL_UNSIGNED_SHORT_5_6_5, GlVersion.GL_12),
	UNSIGNED_SHORT_5_6_5_REV(GL12.GL_UNSIGNED_SHORT_5_6_5_REV, GlVersion.GL_12),
	UNSIGNED_SHORT_4_4_4_4(GL12.GL_UNSIGNED_SHORT_4_4_4_4, GlVersion.GL_12),
	UNSIGNED_SHORT_4_4_4_4_REV(GL12.GL_UNSIGNED_SHORT_4_4_4_4_REV, GlVersion.GL_12),
	UNSIGNED_SHORT_5_5_5_1(GL12.GL_UNSIGNED_SHORT_5_5_5_1, GlVersion.GL_12),
	UNSIGNED_SHORT_1_5_5_5_REV(GL12.GL_UNSIGNED_SHORT_1_5_5_5_REV, GlVersion.GL_12),
	UNSIGNED_INT(GL11.GL_UNSIGNED_BYTE, GlVersion.GL_11),
	UNSIGNED_INT_8_8_8_8(GL12.GL_UNSIGNED_INT_8_8_8_8, GlVersion.GL_12),
	UNSIGNED_INT_8_8_8_8_REV(GL12.GL_UNSIGNED_INT_8_8_8_8_REV, GlVersion.GL_12),
	UNSIGNED_INT_10_10_10_2(GL12.GL_UNSIGNED_INT_10_10_10_2, GlVersion.GL_12),
	UNSIGNED_INT_2_10_10_10_REV(GL12.GL_UNSIGNED_INT_2_10_10_10_REV, GlVersion.GL_12);

	private final int glFormat;
	private final GlVersion minimumGlVersion;

	PixelType(int glFormat, GlVersion minimumGlVersion) {
		this.glFormat = glFormat;
		this.minimumGlVersion = minimumGlVersion;
	}

	public static Optional<PixelType> fromString(String name) {
		try {
			return Optional.of(PixelType.valueOf(name));
		} catch (IllegalArgumentException e) {
			return Optional.empty();
		}
	}

	public int getGlFormat() {
		return glFormat;
	}

	public GlVersion getMinimumGlVersion() {
		return minimumGlVersion;
	}
}
