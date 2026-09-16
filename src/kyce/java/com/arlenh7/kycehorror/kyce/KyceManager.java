package com.arlenh7.kycehorror.kyce;

import com.arlenh7.kycehorror.resource.Resource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class KyceManager {
    public <T extends Entity> EntityType<T> register(KyceEntity<T> kyce) {
        ResourceLocation id = kyce.id;
        if (Registry.ENTITY_TYPE.getValue(id).isPresent()) throw new IllegalArgumentException("kyce already registered: " + id);
        return Registry.register(Registry.ENTITY_TYPE, id, EntityType.Builder.create(kyce.factory, kyce.classification).size(kyce.width, kyce.height).build(id.toString()));
    }

    public EntityType<?> get(String name) {
        return Registry.ENTITY_TYPE.getValue(Resource.location(name)).orElse(null);
    }
}
