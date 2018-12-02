package io.loadkit;

/**
 * ANT风格路径过滤器
 *
 * @author Payne 646742615@qq.com
 * 2018/12/2 11:40
 */
public class AntFilter extends RegexFilter implements Filter {

    public AntFilter(String ant) {
        super(convert(ant));
    }

    /**
     * 将ANT风格路径表达式转换成正则表达式
     *
     * @param ant ANT风格路径表达式
     * @return 正则表达式
     */
    private static String convert(String ant) {
        String regex = ant;
        regex = regex.replace("**", ".{0,}");
        regex = regex.replace("*", "[^/]{0,}");
        regex = regex.replace("?", ".{1}");
        while (regex.startsWith("/")) regex = regex.substring(1);
        while (regex.endsWith("/")) regex = regex.substring(0, regex.length() - 1);
        return regex;
    }

}