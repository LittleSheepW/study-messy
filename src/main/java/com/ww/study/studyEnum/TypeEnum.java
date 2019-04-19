package com.ww.study.studyEnum;


/**
 * @author sun
 * 类型枚举
 */
public enum TypeEnum {
    /**
     * 火墙
     */
    FIREWALL("firewall"),
    /**
     * 秘密
     */
    SECRET("secretMac"),
    /**
     * 平衡
     */
    BALANCE("f5");

    private String typeName;

    TypeEnum(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 根据类型的typeName，返回类型的枚举实例。
     *
     * @param typeName 类型名称
     */
    public static TypeEnum getTypeByTypeName(String typeName) {
        for (TypeEnum type : TypeEnum.values()) {
            if (type.getTypeName().equals(typeName)) {
                return type;
            }
        }
        return null;
    }

    public String getTypeName() {
        return this.typeName;
    }
}