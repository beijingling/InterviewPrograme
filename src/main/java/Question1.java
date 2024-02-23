import java.util.ArrayList;
import java.util.List;

/**
 * 不能使用语言的基本分割组合函数(如Java的 String.splite,php de explode he implode)
 */
class Question1 {

	/**
	 * 字符串拆分成数组如“ab&&2”通过“&&”做分割符，分割得到字符串数组["ab","2"]
	 * 
	 * @param originStr
	 * @return
	 */
	public static List<String> spliteString(String originStr) {
		char dalas = '&';
		List<String> ret = new ArrayList<>();
		int length = originStr.length();
		if (length < 1)
			return ret;
		int offset = length - 1;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		boolean isDouble = false;
		for (; i < offset; i++) {
			char c = originStr.charAt(i);

			if (c == dalas) {
				// 判断第二个是否也是 &
				if (originStr.charAt(i + 1) == dalas) {
					ret.add(sb.toString());// 保存字符串
					i++;// 向后移动一个位置
					sb.setLength(0);// 清除字符串
					isDouble = true;
				} else {
					sb.append(c);// 单个的继续添加
					isDouble = false;
				}

			} else {
				sb.append(c);
			}
		}
		if (!isDouble) {
			sb.append(originStr.charAt(offset));
		}
		ret.add(sb.toString());
		return ret;
	}

	public static void main(String[] args) {
		String origin1 = "&&&asdf&& asd && s &  & 23i&";
		List<String> ret = spliteString(origin1);
		for (String item : ret) {
			System.out.println(item);
		}
		// by command line
		String result[] = origin1.split("&&");
		for (String item : result) {
			System.out.println(item);
		}

		String compositStr = joinString(ret);
		System.out.println(compositStr);
	}

	/**
	 * 实现字符串组合，如["ab","2"]通过"&&"风格符，组合成字符串"ab&&2"
	 * 
	 * @param listStr
	 * @return
	 */
	public static String joinString(List<String> listStr) {
		StringBuilder sb = new StringBuilder();
		if (listStr.size() < 1)
			return "";
		for (String item : listStr) {
			sb.append(item);
			sb.append("&&");
		}
		sb.setLength(sb.length() - 2);
		return sb.toString();

	}
}