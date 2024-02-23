import java.util.ArrayList;
import java.util.List;

/**
 * 有26个字母a-z,找出所有字母的组合，a,b,c,ab,abc,a^z都是一个组合(顺序无关)
 */
class Question5 {
	static char alpha[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	static List<String> allComposit() {
		StringBuilder sb = new StringBuilder();
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < 26; i++) {
			sb.setLength(0);
			for (int j = i; j < 26; j++) {
				sb.append(alpha[j]);
				ret.add(sb.toString());
				// System.out.println(sb.toString());
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		List<String> strArray = allComposit();
		for (String str : strArray) {
			System.out.println(str);
		}
	}
}