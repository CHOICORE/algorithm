class Solution {
	fun solution(cipher: String, code: Int): String {
		val answer = StringBuilder()
		var i = code
		while (i <= cipher.length) {
			answer.append(cipher[i - 1])
			i += code
		}
		return answer.toString()
	}
}