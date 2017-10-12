package com.pts.justsurvive;

import com.pts.justsurvive.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = JustSurviveProxy.MODID, version = JustSurviveProxy.VERSION)
public class JustSurviveProxy
{
    public static final String MODID = "justsurvive";
    public static final String VERSION = "1.0";

    @Mod.Instance
    public static JustSurviveProxy instance;

    @SidedProxy(clientSide = "com.pts.justsurvive.proxy.ClientProxy", serverSide = "com.pts.justsurvive.proxy.ServerProxy")
    public static CommonProxy proxy;
}
