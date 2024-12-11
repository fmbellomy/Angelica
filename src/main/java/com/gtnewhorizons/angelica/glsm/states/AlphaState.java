package com.gtnewhorizons.angelica.glsm.states;

import lombok.Getter;
import lombok.Setter;
import me.eigenraven.lwjgl3ify.api.Lwjgl3Aware;
import org.lwjgl.opengl.GL11;

@Lwjgl3Aware
@Getter
public class AlphaState implements ISettableState<AlphaState> {
    @Setter protected int function = GL11.GL_ALWAYS;
    @Setter protected float reference = -1.0F;

    @Override
    public AlphaState set(AlphaState state) {
        this.function = state.function;
        this.reference = state.reference;
        return this;
    }

    @Override
    public boolean sameAs(Object state) {
        if (this == state) return true;
        if (!(state instanceof AlphaState alphaState)) return false;
        return function == alphaState.function && Float.compare(alphaState.reference, reference) == 0;
    }

    @Override
    public AlphaState copy() {
        return new AlphaState().set(this);
    }
}
