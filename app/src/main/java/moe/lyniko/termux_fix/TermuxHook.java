package moe.lyniko.termux_fix;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import android.view.KeyEvent;

public class TermuxHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        if ("com.termux".equals(lpparam.packageName)) {
            try {
                XposedHelpers.findAndHookMethod("com.termux.view.TerminalView", lpparam.classLoader, "onKeyDown", new XC_MethodReplacement() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        int pa1 = (int)(param.args[0]);
                        KeyEvent pa2 = (KeyEvent)(param.args[1]);
                        if (pa1 == 0 && pa2.getScanCode() == 115) {
                            param.setResult(true); // 跳过原方法，并且禁止event向下传播
                        }
                    }
                });
            } catch (Throwable t) {
                XposedBridge.log(t);
            }
        }

    }

}