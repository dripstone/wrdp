package org.zhiyan.testjar;

import java.math.BigDecimal;

public class Calculate {
    // 判断是否为操作符号
    public static boolean isOperator(Object operator) {
        if ("+".equals(operator) || "-".equals(operator) || "*".equals(operator)
                || "/".equals(operator) || "(".equals(operator)
                || ")".equals(operator) || "&&".equals(operator)
                || "||".equals(operator) || ">".equals(operator)
                || ">=".equals(operator) || "=".equals(operator)
                || "<=".equals(operator) || "<".equals(operator)
                || "%".equals(operator))
            return true;
        else
            return false;
    }

    // 判断是否为关系操作符号
    public static boolean isNexusOperator(Object operator) {
        if (">".equals(operator) || ">=".equals(operator)
                || "=".equals(operator) || "<=".equals(operator)
                || "<".equals(operator))
            return true;
        else
            return false;
    }

    // 设置操作符号的优先级别
    public static int priority(Object operator) {
        if ("+".equals(operator) || "-".equals(operator)
                || "(".equals(operator))
            return 4;
        else if ("*".equals(operator) || "/".equals(operator)
                || "%".equals(operator))
            return 5;
        else if ("||".equals(operator))
            return 1;
        else if ("&&".equals(operator))
            return 2;
        else if (">".equals(operator) || ">=".equals(operator)
                || "=".equals(operator) || "<=".equals(operator)
                || "<".equals(operator))
            return 3;
        else
            return 0;
    }

    // 做2值之间的计算
    public static Object twoResult(Object operator, Object a, Object b) {
        try {
            Object op = operator;
            BigDecimal x = new BigDecimal(0);
            BigDecimal y = new BigDecimal(0);
            Boolean left = false;
            Boolean right = false;
            if (op.equals("+") || op.equals("-") || op.equals("*")
                    || op.equals("/") || op.equals("%") || op.equals(">")
                    || op.equals(">=") || op.equals("<=") || op.equals("<")) {
                x = new BigDecimal(b.toString());
                y = new BigDecimal(a.toString());
            } else if (op.equals("=")) {
                String leftValue = a.toString();
                String rightValue = b.toString();
                if ("0".equals(leftValue))
                    leftValue = "0.0";
                if ("0".equals(rightValue))
                    rightValue = "0.0";
                boolean z = leftValue.equals(rightValue);
                if (z)
                    return new Boolean("true");
                else
                    return new Boolean("false");
            } else if (op.equals("!=")) {
                String leftValue = a.toString();
                String rightValue = b.toString();
                if ("0".equals(leftValue))
                    leftValue = "0.0";
                if ("0".equals(rightValue))
                    rightValue = "0.0";
                boolean z = leftValue.equals(rightValue);
                if (!z)
                    return new Boolean("true");
                else
                    return new Boolean("false");
            } else if (op.equals("&&") || op.equals("||")) {
                left = Boolean.valueOf(b.toString());
                right = Boolean.valueOf(a.toString());
            }
            if (op.equals("+"))
                return x.add(y).toString();
            else if (op.equals("-"))
                return x.subtract(y).toString();
            else if (op.equals("*"))
                return x.multiply(y).toString();
            else if (op.equals("/"))
                return x.divide(y, BigDecimal.ROUND_HALF_DOWN).toString();
            else if (op.equals("%"))
                return x.doubleValue() % y.doubleValue();
            else if (op.equals("&&"))
                return String.valueOf(left && right);
            else if (op.equals("||"))
                return String.valueOf(left || right);
            else if (op.equals(">")) {
                int z = x.compareTo(y);
                if (z == 1)
                    return new Boolean("true");
                else
                    return new Boolean("false");
            } else if (op.equals(">=")) {
                int z = x.compareTo(y);
                if (z != -1)
                    return new Boolean("true");
                else
                    return new Boolean("false");
            } else if (op.equals("<=")) {
                int z = x.compareTo(y);
                if (z != 1)
                    return new Boolean("true");
                else
                    return new Boolean("false");
            } else if (op.equals("<")) {
                int z = x.compareTo(y);
                if (z == -1)
                    return new Boolean("true");
                else
                    return new Boolean("false");
            }
            return "Error";
        } catch (NumberFormatException e) {
            return "Error";
        }
    }
}
