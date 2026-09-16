package com.arlenh7.kycehorror.resource;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.IResource;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class Resource {
    public static IResource get(String path) throws IOException {
        return Minecraft.getInstance().getResourceManager().getResource(new ResourceLocation("kyce", path.startsWith("/") ? path.substring(1) : path));
    }
}
