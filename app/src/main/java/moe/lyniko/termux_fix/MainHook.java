package moe.lyniko.termux_fix;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XposedBridge;
public class MainHook implements IXposedHookLoadPackage, IXposedHookZygoteInit {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
//        XposedBridge.log("Init.Current pkg: " + lpparam.packageName);
        if ("com.termux".equals(lpparam.packageName)) {
            new TermuxHook().handleLoadPackage(lpparam);
        }
    }
    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {}
}
