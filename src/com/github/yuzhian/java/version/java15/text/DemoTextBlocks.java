package com.github.yuzhian.java.version.java15.text;

/**
 * 文本块和格式化操作
 *
 * @author yuzhian
 */
public class DemoTextBlocks {
    public static void main(String[] args) {
        // 文本块
        String letter = """
                Dear Red,
                If you're reading this, you've gotten out. And if you've come this far, maybe you're willing to come a 
                little further. You remember the name of the town, don't you? I could use a good man to help me get my 
                project on wheels. I'll keep an eye out for you and the chessboard ready. Remember, Red. Hope is a good
                thing, maybe the best of things, and no good thing ever dies. I will be hoping that this letter finds 
                you, and finds you well. 
                Your friend,
                Andy.
                """;
        System.out.println(letter);

        // 字符串格式化, 嵌入式表达式
        String xml = """
                <author>
                  <name>%s</name>
                  <email>%s</email>
                  <location>%s</location>
                </author>
                """.formatted("yuzhian", "yu97@live.com", "Jinan, China");
        System.out.println(xml);
    }
}
