# From [CorePatch](https://github.com/coderstory/CorePatch)

用于屏蔽Termux中的异常按键事件，
适用于按键自动按下且更改了kl文件的人

注意，按键代码被硬编码在[这里](https://github.com/Young-Lord/Xposed-TermuxFix/blob/master/app/src/main/java/moe/lyniko/termux_fix/TermuxHook.java#L25)，
你可能需要改成适用于自己设备的，
也就是你注释掉的那一行的数字

（备忘：kl指`/system/usr/keylayout/*.kl`）
