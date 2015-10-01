package org.zhiyan.testjar;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Expression implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3864504127703419435L;

    private ArrayList<String> expression;// 存储中序表达式

    private ArrayList<String> right;// 存储右序表达式

    // 将中序表达式转换为右序表达式
    private void toRight() {
        right = new ArrayList<String>();
        Stacks aStack = new Stacks();
        String operator;
        int position = 0;
        while (true) {
            if (Calculate.isOperator(expression.get(position))) {
                if (aStack.top == -1
                        || (expression.get(position)).equals("(")) {
                    aStack.push(expression.get(position));
                } else {
                    if ((expression.get(position)).equals(")")) {
                        if (!(aStack.top()).equals("(")) {
                            operator = String.valueOf(aStack.pop());
                            right.add(operator);
                        }
                    } else {
                        while (aStack.top != -1 && Calculate
                                .priority(expression.get(position)) <= Calculate
                                        .priority(aStack.top())) {
                            operator = (String) aStack.top();
                            if (!operator.equals("("))
                                right.add(aStack.pop().toString());
                        }
                        aStack.push(expression.get(position));
                    }
                }
            } else
                right.add(expression.get(position));
            position++;
            if (position >= expression.size())
                break;
        }
        while (aStack.top != -1) {
            operator = (String) aStack.pop();
            if (!operator.equals("("))
                right.add(operator);
        }
        aStack = null;
    }

    // 对右序表达式进行求值
    public Object getResult(String input) {
        expression = new ArrayList<String>();
        String[] tempStr = input.split("#");
        for (int i = 0; i < tempStr.length; i++) {
            expression.add(tempStr[i]);
        }
        this.toRight();
        Stacks aStack = new Stacks();
        Object op1, op2, is = null;
        Iterator<String> it = right.iterator();
        while (it.hasNext()) {
            is = it.next();
            if (Calculate.isOperator(is)) {
                op1 = aStack.pop();
                op2 = aStack.pop();
                aStack.push(Calculate.twoResult(is, op1, op2));
            } else {
                aStack.push(is);
            }
        }
        String o = aStack.pop().toString();
        aStack = null;
        return o;
    }

    public Object getValue(String input) {
        expression = new ArrayList<String>();
        String[] tempStr = input.split("#");
        String operator;
        Boolean inLeft = true;
        if ("X".equals(tempStr[0]))
            operator = tempStr[1];
        else {
            operator = tempStr[tempStr.length - 2];
            inLeft = false;
        }
        StringBuffer in = new StringBuffer("");
        if (inLeft) {
            for (int i = 2; i < tempStr.length; i++) {
                in.append(tempStr[i]).append("#");
            }
            Object value = this.getResult(in.toString());
            Map<String, String> map = new HashMap<String, String>();
            if (">".equals(operator)) {
                map.put("Max", null);
                map.put("Min", new BigDecimal(value.toString())
                        .add(new BigDecimal(1)).toString());
            } else if (">=".equals(operator)) {
                map.put("Max", null);
                map.put("Min", new BigDecimal(value.toString()).toString());
            } else if ("=".equals(operator)) {
                return value.toString();
            } else if ("<=".equals(operator)) {
                map.put("Max", new BigDecimal(value.toString()).toString());
                map.put("Min", null);
            } else if ("<".equals(operator)) {
                map.put("Max", new BigDecimal(value.toString())
                        .subtract(new BigDecimal(1)).toString());
                map.put("Min", null);
            }
            return map;
        } else {
            for (int i = 0; i < tempStr.length - 2; i++) {
                in.append(tempStr[i]).append("#");
            }
            Object value = this.getResult(in.toString());
            Map<String, String> map = new HashMap<String, String>();
            if (">".equals(operator)) {
                map.put("Min", null);
                map.put("Max", new BigDecimal(value.toString())
                        .add(new BigDecimal(1)).toString());
            } else if (">=".equals(operator)) {
                map.put("Min", null);
                map.put("Max", new BigDecimal(value.toString()).toString());
            } else if ("=".equals(operator)) {
                return value.toString();
            } else if ("<=".equals(operator)) {
                map.put("Min", new BigDecimal(value.toString()).toString());
                map.put("Max", null);
            } else if ("<".equals(operator)) {
                map.put("Min", new BigDecimal(value.toString())
                        .subtract(new BigDecimal(1)).toString());
                map.put("Max", null);
            }
            return map;
        }
    }

    public static void main(String[] args) {
        Expression eval = new Expression();

        // System.out.println("输入公式");
        // String s = SavitchIn.readLine();
        // s=s+"#";
        Object result = eval.getResult("6#-#1#-#8");
        System.out.println(result);

    }
}
