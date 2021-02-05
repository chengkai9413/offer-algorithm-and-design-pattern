package learn.sword.to.offer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 要求:在原字符串上做修改，类型StringBuffer
 */
public class Solution5StringReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        int oldLen = str.length();
        // 先扩充长度，O(n)
        int spaceCnt = 0;
        for (int i = 0; i < oldLen; i++) {
            if (str.charAt(i) == ' ') spaceCnt++;
        }
        int newLen = oldLen + 2 * spaceCnt;
        str.setLength(newLen);


        // 从后往前遍历
        int tmpIdx = newLen - 1;
        for (int i = oldLen - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == ' ') {
                str.setCharAt(tmpIdx--, '0');
                str.setCharAt(tmpIdx--, '2');
                str.setCharAt(tmpIdx--, '%');
            } else {
                str.setCharAt(tmpIdx--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Solution5StringReplaceSpace s = new Solution5StringReplaceSpace();
        StringBuffer ss = new StringBuffer();
        ss.append("i have a SSSS 123");
        s.replaceSpace(ss);
        System.out.println(ss);
    }
}
