package com.gtnewhorizons.angelica.transform;

import com.gtnewhorizons.angelica.loading.AngelicaTweaker;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

public class ATAtHome implements IClassTransformer {
    private static final String TARGET = "net.minecraftforge.event.terraingen.BiomeEvent$BiomeColor";
    private static final String TARGET_FIELD = "originalColor";

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (basicClass == null || !TARGET.equals(transformedName)) return basicClass;

        final ClassReader cr = new ClassReader(basicClass);
        final ClassNode cn = new ClassNode();
        cr.accept(cn, 0);
        for (var field : cn.fields) {
            if (!field.name.equals(TARGET_FIELD)) continue;
            field.access &= ~Opcodes.ACC_FINAL;
        }
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cn.accept(cw);
        final byte[] bytes = cw.toByteArray();
        AngelicaTweaker.dumpClass(transformedName, basicClass, bytes, this);
        return bytes;
    }
}
