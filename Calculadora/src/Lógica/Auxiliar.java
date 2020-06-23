package Lógica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auxiliar {

    public static boolean regexExpresiónAritmética (String sb){
        String regex1 = "-?[1-9][0-9]*";
        String regex2 = regex1 + "[-\\+\\*/]";
        String regex3 = regex2 + "[1-9][0-9]*";
        return sb.matches(regex1 + "|" + regex2 + "|" + regex3);
    }

    public static boolean comprobarParaIgual (String sb){
        return sb.matches("-?[1-9][0-9]*[-\\+\\*/][1-9][0-9]*");
    }

    public static String getOperacion(String operacion){
        String pattern = "(-?[1-9][0-9]*)([-\\+\\*/])([1-9][0-9]*)";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(operacion);
        int numero1 = 0;
        int numero2 = 0;
        char operando = ' ';
        if (matcher.find()){
            numero1 = Integer.parseInt(matcher.group(1));
            numero2 = Integer.parseInt(matcher.group(3));
            operando = matcher.group(2).charAt(0);
        }
        switch (operando){
            case '+':
                return numero1 + numero2 + "";
            case '-':
                return numero1 - numero2 + "";
            case '*':
                return numero1 * numero2 + "";
            case '/':
                return numero1 / numero2 + "";
            default:
                return 0 + "";
        }
    }
}
