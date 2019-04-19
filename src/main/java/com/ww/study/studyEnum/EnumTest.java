package com.ww.study.studyEnum;

/**
 * 学习Java枚举类
 * 枚举类和class差不多，有属性、构造方法、get/set方法、但是一般都是使用构造器进行传递参数，不为其设置set方法
 * 以逗号隔开的，最后以分号结尾的这部分叫做这个枚举的<p>实例</p>。也可以理解为，class new 出来的实例对象。
 * 只是class new对象，可以自己随便new，想几个就几个，而这个enum关键字他就不行，他的实例对象只能在这个enum里面体现。（定义时限定死）
 * 也就是说他对应的实例是有限的。这也就是枚举的好处了，限制了某些东西的范围。
 */
public class EnumTest {
    public static void main(String[] args) {
         useEnum();
        // getTypeByTypeName();
        // testSwitchCaseByEnum();
        // testEnumEqual();
    }
 
    /**
     * 循环枚举,输出枚举中的属性内容
     * 枚举类中有两个自带的属性：name ordinal
     * name属性和枚举类中的枚举常量命名一致
     */
    private static void useEnum() {
        System.out.println("------------------");
        // 输出SimpleEnum枚举中的ordinal属性(最简单的枚举类)
        for (SeasonEnum simpleEnum : SeasonEnum.values()) {
            System.out.println(simpleEnum + "  ordinal  " + simpleEnum.ordinal());
        }
        System.out.println("------------------");
        // 输出TypeEnum中的name,typeName,ordinal属性
        for (TypeEnum type : TypeEnum.values()) {
            System.out.println("type = " + type + "    type.name = " + type.name() + "   typeName = " + type.getTypeName() + "   ordinal = " + type.ordinal());
        }
    }

    /**
     * 通过typeName获取type
     */
    private static void getTypeByTypeName() {
        for (TypeEnum type : TypeEnum.values()) {
            System.out.println(type + "---" + type.getTypeName());
        }
        String typeName = "f5";
        TypeEnum type = TypeEnum.getTypeByTypeName(typeName);
        if (TypeEnum.BALANCE.equals(type)) {
            System.out.println("根据字符串获得的枚举类型实例跟枚举常量一致");
        } else {
            System.out.println("code error");
        }
    }


    /**
     * 使用switch测试ENUM
     */
    private static void testSwitchCaseByEnum() {
        // 三选一，测试效果。
         String typeName = "f5";
        // String typeName = "firewall";
        // String typeName = "secretMac";
        TypeEnum typeEnum = TypeEnum.getTypeByTypeName(typeName);
        if (typeEnum == null) {
            return;
        }
        switch (typeEnum) {
            case FIREWALL:
                soutResult(typeEnum);
                break;
            case SECRET:
                soutResult(typeEnum);
                break;
            case BALANCE:
                soutResult(typeEnum);
                break;
            default:
                System.out.println("default");
        }
    }

    private static void soutResult(TypeEnum typeEnum) {
        System.out.println("枚举名称(即默认自带的属性 name 的值)是：" + typeEnum.name());
        System.out.println("排序值(默认自带的属性 ordinal 的值)是：" + typeEnum.ordinal());
        System.out.println("枚举的自定义属性 typeName 的值是：" + typeEnum.getTypeName());
    }

    /**
     * 测试枚举类比较是否可以使用==
     * 测试结果：是可以使用==来进行比较的
     * s1 == s2：true
     * s1.equals(s2)：true
     * s1 == ss1：false
     * s1.equals(ss1)：false
     */
    private static void testEnumEqual() {
        SeasonEnum s1 = SeasonEnum.SPRING;
        SeasonEnum s2 = SeasonEnum.SPRING;
        SeasonEnum ss1 = SeasonEnum.SPRING;
        System.out.println("s1 == s2：" + (s1 == s2));
        System.out.println("s1.equals(s2)：" + (s1.equals(s2)));

        System.out.println("s1 == ss1：" + (s1 == ss1));
        System.out.println("s1.equals(ss1)：" + (s1.equals(ss1)));
    }
}