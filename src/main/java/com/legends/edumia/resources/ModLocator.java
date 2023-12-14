package com.legends.edumia.resources;

import net.minecraftforge.forgespi.locating.IModFile;

import javax.xml.xpath.XPath;
import java.nio.file.Path;

public interface ModLocator {

    Path findPath(IModFile modFile, String... path);
}
