import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
public class Zadachi5 {
    public static void main(String[] args) {
        System.out.println(numToLang(17, "семнадцать"));
    }

    //1 задача
    public static int[] encrypt(String str) {
        int[] code = new int [str.length()];
        code[0] = (int)str.charAt(0);
        for (int i = 1; i <str.length(); i++) {
            code[i] = (int)str.charAt(i) - (int)str.charAt(i - 1);
        }
        return code;
    }
   public static String decrypt(int[] mas) {
        int a= mas[0];
        String res = Character.toString((char) a);
        for (int i = 1; i < mas.length; i++) {
            a +=mas[i];
            String element = Character.toString((char) a);
            res +=element;
        }
        return res;
    }
    public static String arrayToString(int[] array) {
        return Arrays.toString(array);
    }
    //2 задача
    public static boolean canMove(String figure, String position, String futurePosition) {
        int letter = "ABCDEFGH".indexOf(position.charAt(0)) + 1;
        int number = Character.getNumericValue(position.charAt(1));
        int fLetter = "ABCDEFGH".indexOf(futurePosition.charAt(0)) + 1;
        int fNumber = Character.getNumericValue(futurePosition.charAt(1));
        boolean horizontal;
        boolean vertical;
        boolean diagonal;
        boolean stop;
        switch (figure) {
            case "Ферзь":
                diagonal = fLetter - letter == fNumber - number;
                horizontal = Math.abs(fLetter - letter) > 0;
                vertical = Math.abs(fNumber - number) > 0;
                stop = fLetter < 9 && fNumber < 9;
                return ((horizontal ^ vertical) || diagonal) && stop;
            case "Король":
                diagonal = (Math.abs(fLetter - letter) == 1) && (Math.abs(fNumber - number) == 1);
                horizontal = Math.abs(fLetter - letter) == 1;
                vertical = Math.abs(fNumber - number) == 1;
                stop = fLetter < 9 && fNumber < 9;
                return ((horizontal && vertical) || diagonal) && stop;
            case "Пешка":
                horizontal = fLetter - letter == 0;
                vertical = fNumber - number == 1;
                stop = fNumber < 9;
                return horizontal && vertical && stop;
            case "Конь":
                int first = Math.abs(fLetter - letter);
                int second = Math.abs(fNumber - number);
                diagonal = (first == 1 && second == 2) ^ (first == 2 && second == 1);
                stop = fLetter < 9 && fNumber < 9;
                return diagonal && stop;
            case "Слон":
                diagonal = Math.abs(fLetter - letter) == Math.abs(fNumber - number);
                stop = fLetter < 9 && fNumber < 9;
                return diagonal && stop;
            case "Ладья":
                horizontal = Math.abs(fLetter - letter) > 0;
                vertical = Math.abs(fNumber - number) > 0;
                stop = fLetter < 9 && fNumber < 9;
                return (horizontal ^ vertical) && stop;

        }
        return false;
    }
    //3 задача
    public static boolean canComplete(String str, String line) {
        for (int i = 0; i < line.length(); i++) {
            if (str.length() == 0) {
                return false;
            }
            if (str.substring(0, 1).equals(line.substring(i, i + 1))) {
                str =str.substring(1);
            }
        }
        if (str.length() != 0) {
            return false;
        }
        return true;
    }
//4 задача
    public static int sumDigProd(int ... num) {
        int res= 0;
        for (int i = 0; i <num.length; i++) {
            res+= num[i];
        }
        while (String.valueOf(res).length() > 1) {
            int num1 = 1;
            for (int i = 0; i < String.valueOf(res).length(); i++) {
                num1= num1*Character.getNumericValue(String.valueOf(res).charAt(i));
            }
            res =num1;
        }
        return res;
    }
    public static String Vowels(String str) {
        String vowels = "";
        for (int i = 0; i <str.length();i++) {
            if ("AEIOUaeiou".contains(str.substring(i, i + 1))) {
                vowels +=str.substring(i, i + 1);
            }
        }
        return vowels;
    }
    //5 задача
    public static String listToString(ArrayList<String> linkedList) {
        String value = "[ ";
        for(int i = 0; i < linkedList.size();i++) {
            value += (String) linkedList.get(i) + " ";
        }
        return value + "]";
    }
    public static String sameVowelGroup(String[] masStr) {
        ArrayList<String> arrayList = new ArrayList<>();
        String vowels = Vowels(masStr[0]);
        for (int i = 0; i < masStr.length;i++) {
            String wordVowels = Vowels(masStr[i]);
            if (vowels.equals(wordVowels)) {
                arrayList.add(masStr[i]);
            }
        }
        return listToString(arrayList);
    }
    //6 задача
    public static boolean validateCard(String card) {
        if (card.length() < 14 || card.length() > 19) {
            return false;
        }
        int c = Integer.parseInt(card.substring(card.length() - 1));
        card = card.substring(0, card.length() - 1);
        String result = "";
        // 2
        for (int i = card.length() - 1; i >= 0; i--) {
            result += card.substring(i, i + 1);
        }
        // 3-4
        int summa = 0;
        for (int i = 0; i < result.length(); i++) {
            if (i % 2 == 1) {
                int doubleFigure = Integer.parseInt(result.substring(i, i + 1)) * 2;
                if (doubleFigure > 9) {
                    int first = Integer.parseInt(String.valueOf(doubleFigure).substring(0, 1));
                    int second = Integer.parseInt(String.valueOf(doubleFigure).substring(1, 2));
                    doubleFigure = first + second;
                }
                summa += doubleFigure;
            } else {
                summa += Integer.parseInt(result.substring(i, i + 1));
            }
        }
        // 4
        String summer = String.valueOf(summa);
        if (10 - Character.getNumericValue(summer.charAt(summer.length() - 1)) == c) {
            return true;
        }
        return false;
    }
    public static String figureToLang(String num, String lang) {
        switch (num) {
            case "1":
                return lang == "ru" ? "один" : "one";
            case "2":
                return lang == "ru" ? "два" : "two";
            case "3":
                return lang == "ru" ? "три" : "three";
            case "4":
                return lang == "ru" ? "четыре" : "four";
            case "5":
                return lang == "ru" ? "пять" : "five";
            case "6":
                return lang == "ru" ? "шесть" : "six";
            case "7":
                return lang == "ru" ? "семь" : "seven";
            case "8":
                return lang == "ru" ? "восемь" : "eight";
            case "9":
                return lang == "ru" ? "девять" : "nine";
            default:
                return "";
        }
    }
    public  static String tenToLang(String num, String lang) {
        switch (num) {
            case "2":
                return lang == "ru" ? "двадцать" : "twenty";
            case "3":
                return lang == "ru" ? "тридцать" : "thirty";
            case "4":
                return lang == "ru" ? "сорок" : "forty";
            case "5":
                return lang == "ru" ? "пятьдесят" : "fifty";
            case "6":
                return lang == "ru" ? "шестьдесят" : "sixty";
            case "7":
                return lang == "ru" ? "семьдесят" : "seventy";
            case "8":
                return lang == "ru" ? "восемьдесят" : "eighty";
            case "9":
                return lang == "ru" ? "девяность" : "ninety";
            default:
                return "";
        }
    }
    //7 задача
    public static String numToLang(int num, String lang) {
        if (num == 0) {
            return lang == "ru" ? "ноль" : "zero";
        }
        if (num > 9 && num < 20) {
            switch (num) {
                case 10:
                    return lang == "ru" ? "десять" : "ten";
                case 11:
                    return lang == "ru" ? "одиннадцать" : "eleven";
                case 12:
                    return lang == "ru" ? "двенадцать" : "twelve";
                case 13:
                    return lang == "ru" ? "тринадцать" : "thirteen";
                case 14:
                    return lang == "ru" ? "четырнадцать" : "fourteen";
                case 15:
                    return lang == "ru" ? "пятнадцать" : "fifteen";
                case 16:
                    return lang == "ru" ? "шестнадцать" : "sixteen";
                case 17:
                    return lang == "ru" ? "семнадцать" : "seventeen";
                case 18:
                    return lang == "ru" ? "восемнадцать" : "eighteen";
                case 19:
                    return lang == "ru" ? "девятнадцать" : "nineteen";
                default:
                    break;
            }
        }
        String res = "";
        String numberS = String.valueOf(num);
        if (num > 99) {
            if (lang == "ru") {
                switch (numberS.substring(0, 1)) {
                    case "1":
                        res += "сто ";
                        break;
                    case "2":
                        res += "двести ";
                        break;
                    case "3":
                        res += "триста ";
                        break;
                    case "4":
                        res += "четыреста ";
                        break;
                    case "5":
                        res += "пятьсот ";
                        break;
                    case "6":
                        res+= "шестьсот ";
                        break;
                    case "7":
                        res += "семьсот ";
                        break;
                    case "8":
                        res += "восемьсот ";
                        break;
                    case "9":
                        res += "девятьсот ";
                        break;
                    default:
                        res += "";
                }
            } else {
                res = figureToLang(numberS.substring(0, 1), "en") + " hundred ";
            }
            numberS = numberS.substring(1);
        }
        if (num > 9) {
            res+= tenToLang(numberS.substring(0, 1), lang) + " ";
            numberS = numberS.substring(1);
        }
        res += figureToLang(numberS, lang);
        return res;
    }
    //8 задача
    public static String getSha256Hash(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] futHash = digest.digest(str.getBytes("UTF-8"));
            String Str1 = new String();
            for (int i = 0; i < futHash.length; i++) {
                String line = Integer.toHexString(0xff & futHash[i]);
                if(line.length() == 1) Str1 += "0";
                Str1 +=line;
            }
            return Str1;
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    //9 задача
    public static String correctTitle(String str){
        String[] result = str.split(" ");
        str = "";
        for (int i = 0; i < result.length; i++){
            if (i == 0 || i == 1 || i == 2 || i == result.length - 1) {
                result[i] = result[i].substring(0, 1).toUpperCase() + result[i].substring(1).toLowerCase();
                str += result[i] + " ";
            }
            else str += result[i].toLowerCase() + " ";
        }
        return str;
    }
    //10 задача
    public static String hexLattice(int num){
        double n = (3 + Math.sqrt(12 * num - 3)) / 6;
        int max = (int) Math.floor(num / n);
        if (max % 2 == 0) max--;
        String res = "";
        boolean check = false;
        if (n % 1 == 0) {
            int max1 = max;
            int min1 = (int) n;
            for (int j = 0; j < max1; j++) {
                for (int i = 0; i < max1 -min1; i++) res += " ";
                for (int i = 0; i <min1; i++) res += "o ";
                res += "\n";
                if (min1 == max1) check = true;
                if (check)min1--;
                else min1++;
            }
        }
        else res += "Invalid";
        return res;
    }
}




