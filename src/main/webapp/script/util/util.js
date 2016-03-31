/**
 * Utilities
 * @author feipt
 */
/**
 * 邮箱地址校验
 * @parameter mailAddr 邮箱地址
 */
function mailAddrValidate(mailAddr) {
	var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	var result = re.test(userName);
	return result;
}