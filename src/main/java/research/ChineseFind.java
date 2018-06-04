package research;

import java.util.regex.Pattern;

public class ChineseFind {

	public static void main(String[] args) {

		//算法 先if isChineseByREG 是不是中文
//		            如果不是  再if  isChinesePunctuation  有没有中文标点
		//如果即不是中文 也没有中文标点 则认为他不是中文   
		//验证中文可用这个逻辑
		
		boolean isFind = isChineseByREG("SOCIÉTÉ MEDITERRANEENNE DE PROMOTION");
		//boolean isFind = isChinesePunctuation("SOCIÉTÉ MEDITERRANEENNE DE PROMOTION");
		System.out.println(isFind);

	}

	// 只能判断部分CJK字符（CJK统一汉字）
	public static boolean isChineseByREG(String str) {
		if (str == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
		return pattern.matcher(str.trim()).find();
	}

	// 根据UnicodeBlock方法判断中文标点符号
	public static boolean isChinesePunctuation(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION 
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
				|| ub == Character.UnicodeBlock.VERTICAL_FORMS) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isChinesePunctuation(String str){
				
		for(char c : str.toCharArray()){			
			if(isChinesePunctuation(c)){
				return true;
			}
		}
		
		return false;
	}
}
