package com.arlenh7.kycehorror.kyce;

import com.arlenh7.kycehorror.resource.Resource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;

import java.util.Objects;

public abstract class KyceEntity<T extends Entity> {
    final ResourceLocation id;
    final EntityType.IFactory<T> factory;
    final EntityClassification classification;
    final float width;
    final float height;

    protected KyceEntity(String name, EntityType.IFactory<T> factory, EntityClassification classification, float width, float height) {
        this.id = Resource.location(name);
        this.factory = Objects.requireNonNull(factory, "factory");
        this.classification = Objects.requireNonNull(classification, "classification");
        if (width <= 0.0F || height <= 0.0F) throw new IllegalArgumentException("idiot");
        this.width = width;
        this.height = height;
    }
}
